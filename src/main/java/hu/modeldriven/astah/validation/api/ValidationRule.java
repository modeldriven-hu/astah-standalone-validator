package hu.modeldriven.astah.validation.api;

public interface ValidationRule {

    String name();

    String message();

    Severity severity();

    enum Severity {
        INFO, WARNING, ERROR
    }

    ValidationResult validate(ModelElement element) throws ValidationFailedException;

    enum ValidationResult {
        VALID, INVALID, SKIPPED
    }

}
