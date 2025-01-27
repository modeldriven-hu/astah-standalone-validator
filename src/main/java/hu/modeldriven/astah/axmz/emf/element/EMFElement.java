package hu.modeldriven.astah.axmz.emf.element;

import com.change_vision.jude.api.inf.exception.InvalidEditingException;
import com.change_vision.jude.api.inf.exception.InvalidUsingException;
import com.change_vision.jude.api.inf.model.IComment;
import com.change_vision.jude.api.inf.model.IElement;
import com.change_vision.jude.api.inf.model.ITaggedValue;
import com.change_vision.jude.api.inf.presentation.IPresentation;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;

public class EMFElement implements IElement {

    private final NamedElement element;

    public EMFElement(NamedElement element) {
        this.element = element;
    }

    @Override
    public String getId() {
        if (element.eResource() instanceof XMLResource resource) {
            return resource.getID(element);
        }

        throw new NotImplementedException();
    }

    @Override
    public IElement getOwner() {
        throw new NotImplementedException();
    }

    @Override
    public IElement getContainer() {
        throw new NotImplementedException();
    }

    @Override
    public IElement[] getContainers() {
        throw new NotImplementedException();
    }

    @Override
    public IComment[] getComments() {
        throw new NotImplementedException();
    }

    @Override
    public String[] getStereotypes() {
        return element.getApplicableStereotypes().stream().map(Stereotype::getName).toList().toArray(new String[0]);
    }

    @Override
    public boolean hasStereotype(String s) {
        return element.getApplicableStereotypes().stream().anyMatch(stereotype -> stereotype.getName().equals(s));
    }

    @Override
    public void removeStereotype(String s) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public void addStereotype(String s) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public ITaggedValue[] getTaggedValues() {
        throw new NotImplementedException();
    }

    @Override
    public String getTaggedValue(String s) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isReadOnly() {
        throw new NotImplementedException();
    }

    @Override
    public String getTypeModifier() {
        throw new NotImplementedException();
    }

    @Override
    public void setTypeModifier(String s) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public IPresentation[] getPresentations() throws InvalidUsingException {
        throw new NotImplementedException();
    }


}
