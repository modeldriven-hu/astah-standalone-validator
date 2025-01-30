package hu.modeldriven.astah.validation.api;

public interface ValidationRule {

    String name();

    String message();

    Severity severity();

    ValidationResult validate(ModelElement element) throws ValidationFailedException;

    enum Severity {
        INFO, WARNING, ERROR
    }

    enum ValidationResult {
        VALID, INVALID, SKIPPED
    }

}
