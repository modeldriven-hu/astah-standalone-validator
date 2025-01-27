package hu.modeldriven.astah.validation.core.yaml;

import hu.modeldriven.astah.validation.api.ModelElement;
import hu.modeldriven.astah.validation.api.ValidationFailedException;
import hu.modeldriven.astah.validation.api.ValidationRule;
import hu.modeldriven.astah.validation.core.script.ScriptExecutorRepository;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class YAMLValidationRule implements ValidationRule {

    private final Map<String, Object> data;
    private final ScriptExecutorRepository scriptExecutorRepository;

    public YAMLValidationRule(Map<String, Object> data, ScriptExecutorRepository scriptExecutorRepository) {
        this.data = data;
        this.scriptExecutorRepository = scriptExecutorRepository;
    }

    private static Set<String> getAllImplementedInterfaces(Class<?> clazz) {
        return getAllImplementedInterfaces(clazz, new HashSet<>());
    }

    private static Set<String> getAllImplementedInterfaces(Class<?> clazz, Set<String> interfaces) {
        while (clazz != null) {
            for (var iFace : clazz.getInterfaces()) {
                interfaces.add(iFace.getSimpleName());
                interfaces.addAll(getAllImplementedInterfaces(iFace, interfaces));
            }
            clazz = clazz.getSuperclass();
        }

        return interfaces;
    }

    @Override
    public String name() {
        return this.data.getOrDefault("name", "").toString();
    }

    @Override
    public String message() {
        return this.data.getOrDefault("message", "").toString();
    }

    @Override
    public Severity severity() {
        return Severity.valueOf(this.data.getOrDefault("severity", "").toString().toUpperCase());
    }

    @Override
    public ValidationResult validate(ModelElement element) throws ValidationFailedException {

        // Skip validation if type is present and does not match the element to be validated
        if (data.containsKey("type")) {
            var type = this.data.get("type").toString();
            if (!getAllImplementedInterfaces(element.value().getClass()).contains(type)) {
                return ValidationResult.SKIPPED;
            }
        }

        try {
            var language = this.data.getOrDefault("language", "").toString();
            var script = this.data.getOrDefault("script", "").toString();

            var scriptExecutor = scriptExecutorRepository.getScriptExecutor(language);
            var result = scriptExecutor.execute(script, element.value());

            if (result instanceof Boolean) {
                if (Boolean.TRUE.equals(result)) {
                    return ValidationResult.VALID;
                } else {
                    return ValidationResult.INVALID;
                }
            } else {
                throw new ValidationFailedException("Invalid result type, expected Boolean");
            }

        } catch (Exception ex) {
            throw new ValidationFailedException(ex);
        }
    }

}
