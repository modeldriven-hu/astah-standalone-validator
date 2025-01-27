package hu.modeldriven.astah.validation.core.yaml;

import hu.modeldriven.astah.validation.api.ValidationRepository;
import hu.modeldriven.astah.validation.api.ValidationSuite;
import hu.modeldriven.astah.validation.core.CachedValidationSuite;
import hu.modeldriven.astah.validation.core.script.DefaultScriptExecutorRepository;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class YAMLValidationRepository implements ValidationRepository {

    private static final String SUITES_KEY = "suites";

    private final File file;

    public YAMLValidationRepository(File file) {
        this.file = file;
    }

    @Override
    public List<ValidationSuite> validationSuites() {

        var scriptRepository = DefaultScriptExecutorRepository.getInstance();

        try (var reader = new FileReader(this.file)) {

            var options = new LoaderOptions();
            options.setTagInspector(tag -> false);
            var yamlParser = new Yaml(options);

            var yamlData = (Map<String, Object>) yamlParser.load(reader);

            var result = new ArrayList<ValidationSuite>();

            if (yamlData.containsKey(SUITES_KEY) && yamlData.get(SUITES_KEY) instanceof List) {
                for (Map<String, Object> suite : (List<Map<String, Object>>) yamlData.get(SUITES_KEY)) {
                    result.add(new CachedValidationSuite(new YAMLValidationSuite(suite, scriptRepository)));
                }
            }

            return result;
        } catch (Exception ex) {
            throw new YAMLReadFailedException(ex);
        }
    }

}
