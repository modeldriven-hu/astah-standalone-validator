package hu.modeldriven.astah.axmz.emf.element;

import com.change_vision.jude.api.inf.exception.InvalidEditingException;
import com.change_vision.jude.api.inf.model.*;
import org.eclipse.uml2.uml.Type;

public class EMFType extends EMFNamedElement implements IClass {

    private final Type type;

    public EMFType(Type type) {
        super(type);
        this.type = type;
    }

    @Override
    public boolean isAbstract() {
        throw new NotImplementedException();
    }

    @Override
    public void setAbstract(boolean b) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public boolean isLeaf() {
        throw new NotImplementedException();
    }

    @Override
    public void setLeaf(boolean b) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public boolean isActive() {
        throw new NotImplementedException();
    }

    @Override
    public void setActive(boolean b) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public IAttribute[] getAttributes() {
        throw new NotImplementedException();
    }

    @Override
    public IOperation[] getOperations() {
        throw new NotImplementedException();
    }

    @Override
    public IClass[] getNestedClasses() {
        throw new NotImplementedException();
    }

    @Override
    public IGeneralization[] getGeneralizations() {
        throw new NotImplementedException();
    }

    @Override
    public IGeneralization[] getSpecializations() {
        throw new NotImplementedException();
    }

    @Override
    public IClassifierTemplateParameter[] getTemplateParameters() {
        throw new NotImplementedException();
    }

    @Override
    public ITemplateBinding[] getTemplateBindings() {
        throw new NotImplementedException();
    }

    @Override
    public IPort[] getPorts() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isPrimitiveType() {
        throw new NotImplementedException();
    }
}
