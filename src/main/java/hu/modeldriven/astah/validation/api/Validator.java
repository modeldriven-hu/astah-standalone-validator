package hu.modeldriven.astah.validation.api;

import com.change_vision.jude.api.inf.model.INamedElement;

public interface Validator {

    boolean isValid(INamedElement namedElement);

}
