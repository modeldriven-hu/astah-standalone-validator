package hu.modeldriven.astah.axmz.emf;

import hu.modeldriven.astah.validation.api.ModelElement;
import hu.modeldriven.astah.validation.api.ValidationFailedException;
import hu.modeldriven.astah.validation.api.ValidationRepository;
import hu.modeldriven.astah.validation.api.ValidationRule;
import hu.modeldriven.astah.validation.core.yaml.YAMLValidationRepository;
import hu.modeldriven.astah.validation.core.AstahPackageableElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URISyntaxException;

class TestEMFAxmzFile {

    @Test
    void testLoadBlocks() throws URISyntaxException, ValidationFailedException {

        var modelUrl = getClass().getClassLoader().getResource("suite001.axmz");

        var axmzFile = new StandardAstahModelFile(new File(modelUrl.toURI()));
        var project = axmzFile.project();
        var model = project.model();

        var suiteUrl = getClass().getClassLoader().getResource("suite001.yaml");
        var repository = new YAMLValidationRepository(new File(suiteUrl.toURI()));

        validate(new AstahPackageableElement(model), repository);

        Assertions.assertNotNull(model);
    }

    private void validate(AstahPackageableElement rootPackage, ValidationRepository repository) throws ValidationFailedException {
        for (var modelElement : rootPackage.children()) {

            for (var suite : repository.validationSuites()) {
                for (var rule : suite.validatorRules()) {
                    var result = rule.validate(modelElement);
                    if (result == ValidationRule.ValidationResult.INVALID) {
                        handleValidationError(rule, modelElement);
                    }
                }
            }

            if (modelElement instanceof AstahPackageableElement subPackage) {
                validate(subPackage, repository);
            }
        }
    }

    private void handleValidationError(ValidationRule rule, ModelElement modelElement) {
        var message = rule.message();
        var severity = rule.severity();
        var name = rule.name();
        System.out.println("Validation failed: " + name + " - " + message + " - " + severity + " on " + modelElement.name());
    }

}
