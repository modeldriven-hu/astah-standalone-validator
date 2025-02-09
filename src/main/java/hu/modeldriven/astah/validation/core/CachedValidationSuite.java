package hu.modeldriven.astah.validation.core;

import hu.modeldriven.astah.validation.api.ValidationRule;
import hu.modeldriven.astah.validation.api.ValidationSuite;

import java.util.ArrayList;
import java.util.List;

public class CachedValidationSuite implements ValidationSuite {

    private final ValidationSuite delegate;
    private final List<ValidationRule> cachedRules;

    public CachedValidationSuite(ValidationSuite delegate) {
        this.delegate = delegate;
        this.cachedRules = new ArrayList<>();
    }

    @Override
    public String name() {
        return delegate.name();
    }

    @Override
    public List<ValidationRule> validatorRules() {
        if (cachedRules.isEmpty()) {
            cachedRules.addAll(delegate.validatorRules());
        }
        return cachedRules;
    }
}
