package hu.modeldriven.astah.axmz.emf.element;

import com.change_vision.jude.api.inf.exception.InvalidEditingException;
import com.change_vision.jude.api.inf.model.IClass;
import com.change_vision.jude.api.inf.model.IObjectNode;
import org.eclipse.uml2.uml.NamedElement;

public class EMFObjectNode extends EMFActivityNode implements IObjectNode {

    public EMFObjectNode(NamedElement namedElement) {
        super(namedElement);
    }

    @Override
    public String getInState() {
        throw new NotImplementedException();
    }

    @Override
    public void setInState(String s) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public IClass getBase() {
        throw new NotImplementedException();
    }

    @Override
    public void setBase(IClass iClass) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public String getOrdering() {
        throw new NotImplementedException();
    }

    @Override
    public void setOrdering(String s) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public String getUpperBound() {
        throw new NotImplementedException();
    }

    @Override
    public void setUpperBound(String s) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public boolean isControl() {
        throw new NotImplementedException();
    }

    @Override
    public void setControl(boolean b) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public String getEffect() {
        throw new NotImplementedException();
    }

    @Override
    public void setEffect(String s) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public boolean isException() {
        throw new NotImplementedException();
    }

    @Override
    public void setException(boolean b) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public String getStream() {
        throw new NotImplementedException();
    }

    @Override
    public void setStream(String s) throws InvalidEditingException {
        throw new NotImplementedException();
    }
}
