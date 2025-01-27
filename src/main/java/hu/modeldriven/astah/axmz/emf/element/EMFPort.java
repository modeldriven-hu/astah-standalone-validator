package hu.modeldriven.astah.axmz.emf.element;


import com.change_vision.jude.api.inf.exception.InvalidEditingException;
import com.change_vision.jude.api.inf.model.IClass;
import com.change_vision.jude.api.inf.model.IPort;
import org.eclipse.uml2.uml.Port;

public class EMFPort extends EMFAttribute implements IPort {

    private final Port port;

    public EMFPort(Port port) {
        super(port);
        this.port = port;
    }

    @Override
    public IClass getType() {
        if (port.getType() == null) {
            return null;
        }

        return new EMFType(port.getType());
    }

    @Override
    public boolean isService() {
        throw new NotImplementedException();
    }

    @Override
    public void setIsService(boolean b) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public boolean isBehavior() {
        throw new NotImplementedException();
    }

    @Override
    public void setIsBehavior(boolean b) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public IClass[] getRequiredInterfaces() {
        throw new NotImplementedException();
    }

    @Override
    public IClass[] getProvidedInterfaces() {
        throw new NotImplementedException();
    }
}
