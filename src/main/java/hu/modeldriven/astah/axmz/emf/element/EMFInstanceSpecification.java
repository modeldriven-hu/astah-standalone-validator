package hu.modeldriven.astah.axmz.emf.element;

import com.change_vision.jude.api.inf.exception.InvalidEditingException;
import com.change_vision.jude.api.inf.model.IClass;
import com.change_vision.jude.api.inf.model.IInstanceSpecification;
import com.change_vision.jude.api.inf.model.ILinkEnd;
import com.change_vision.jude.api.inf.model.ISlot;
import org.eclipse.uml2.uml.NamedElement;

public class EMFInstanceSpecification extends EMFNamedElement implements IInstanceSpecification {

    public EMFInstanceSpecification(NamedElement element) {
        super(element);
    }

    @Override
    public IInstanceSpecification getContainer() {
        throw new NotImplementedException();
    }

    @Override
    public IInstanceSpecification[] getContainers() {
        throw new NotImplementedException();
    }

    @Override
    public IClass getClassifier() {
        throw new NotImplementedException();
    }

    @Override
    public void setClassifier(IClass iClass) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public ILinkEnd[] getLinkEnds() {
        throw new NotImplementedException();
    }

    @Override
    public ISlot[] getAllSlots() {
        throw new NotImplementedException();
    }

    @Override
    public ISlot getSlot(String s) {
        throw new NotImplementedException();
    }

    @Override
    public IInstanceSpecification[] getAllResidents() {
        throw new NotImplementedException();
    }
}
