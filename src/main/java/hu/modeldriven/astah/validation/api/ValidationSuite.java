package hu.modeldriven.astah.validation.api;

import java.util.List;

public interface ValidationSuite {

    String name();

    List<ValidationRule> validatorRules();

}
