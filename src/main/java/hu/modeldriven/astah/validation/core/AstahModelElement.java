package hu.modeldriven.astah.validation.core;

import com.change_vision.jude.api.inf.model.IClass;
import com.change_vision.jude.api.inf.model.INamedElement;
import hu.modeldriven.astah.validation.api.ModelElement;

import java.util.List;

public class AstahModelElement implements ModelElement {

    private final INamedElement element;

    public AstahModelElement(INamedElement element) {
        this.element = element;
    }

    @Override
    public List<? extends ModelElement> attributes() {
        if (element instanceof IClass clazz) {
            return List.of(clazz.getAttributes()).stream().map(AstahModelElement::new).toList();
        }

        return List.of();
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
