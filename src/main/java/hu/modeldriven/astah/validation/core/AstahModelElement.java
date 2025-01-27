package hu.modeldriven.astah.validation.core;

import com.change_vision.jude.api.inf.model.INamedElement;
import hu.modeldriven.astah.validation.api.ModelElement;

public class AstahModelElement implements ModelElement {

    private final INamedElement element;

    public AstahModelElement(INamedElement element) {
        this.element = element;
    }

    @Override
    public Object value() {
        return element;
    }

    @Override
    public String id() {
        return element.getId();
    }

    @Override
    public String name() {
        return element.getName();
    }

    @Override
    public String type() {
        return element.getClass().getInterfaces()[0].getSimpleName();
    }
}
