package hu.modeldriven.astah.validation.core;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import hu.modeldriven.astah.axmz.emf.StandardAstahModelFile;
import hu.modeldriven.astah.validation.api.*;
import hu.modeldriven.astah.validation.core.yaml.YAMLValidationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Set;

public class AstahModelValidator {

    private final File modelFile;
    private final File repoFile;
    private final File outputFile;
    private final File idFile;

    Logger logger = LoggerFactory.getLogger(AstahModelValidator.class);

    public AstahModelValidator(File modelFile, File repoFile, File outputFile, File idFile) {
        this.modelFile = modelFile;
        this.repoFile = repoFile;
        this.outputFile = outputFile;
        this.idFile = idFile;
    }

    public void validate() {
        try {

            logger.info("Validation started.");

            var model = new StandardAstahModelFile(modelFile).project().model();
            var repository = new YAMLValidationRepository(repoFile);

            var root = new JsonObject();
            var results = new JsonArray();

            validate(new AstahPackageableElement(model), repository, results, idFile == null ? null : filteredIds(idFile));

            root.put("results", results);

            try (var fileWriter = new FileWriter(outputFile)) {
                var serializedJson = Jsoner.serialize(root);
                Jsoner.prettyPrint(new StringReader(serializedJson), fileWriter, "\t", "\r\n");
            }

            logger.info("Validation finished, result written to {}", outputFile.getAbsolutePath());


        } catch (Exception e) {
            logger.error("Exception during validation", e);
        }
    }

    private Set<String> filteredIds(File idFile) throws IOException {
        return new HashSet<>(Files.readAllLines(idFile.toPath()));
    }

    private void validate(ModelPackage rootPackage, ValidationRepository repository, JsonArray results, Set<String> filteredIds) throws ValidationFailedException {
        for (var modelElement : rootPackage.children()) {

            if (modelElement instanceof ModelPackage subPackage) {
                validate(subPackage, repository, results, filteredIds);
            }

            if (filteredIds != null && !filteredIds.contains(modelElement.id())) {
                logger.trace("Skipping id = '{}', name = '{}', type = '{}'", modelElement.id(), modelElement.name(), modelElement.type());
                continue;
            }

            validateModelElement(repository, modelElement, results);

            for (var attribute : modelElement.attributes()) {
                validateModelElement(repository, attribute, results);
            }

        }
    }

    private void validateModelElement(ValidationRepository repository, ModelElement modelElement, JsonArray results) throws ValidationFailedException {
        logger.trace("Validating id = '{}', name = '{}', type = '{}'", modelElement.id(), modelElement.name(), modelElement.type());

        for (var suite : repository.validationSuites()) {
            for (var rule : suite.validatorRules()) {
                switch (rule.validate(modelElement)) {
                    case INVALID:
                        logger.trace("[{}] '{}' failed", rule.severity().name(), rule.name());
                        handleValidationError(rule, modelElement, results);
                        break;

                    case VALID:
                        logger.trace("[{}] '{}' passed", rule.severity().name(), rule.name());
                        break;

                    case SKIPPED:
                        logger.trace("[{}] '{}' skipped", rule.severity().name(), rule.name());
                }
            }
        }
    }

    private void handleValidationError(ValidationRule rule, ModelElement modelElement, JsonArray results) {
        var message = rule.message();
        var severity = rule.severity();
        var name = rule.name();

        var result = new JsonObject();
        result.put("element-id", modelElement.id());
        result.put("element-name", modelElement.name());
        result.put("element-type", modelElement.type());
        result.put("rule-name", name);
        result.put("rule-severity", severity.name());
        result.put("rule-message", message);

        results.add(result);
    }

}
