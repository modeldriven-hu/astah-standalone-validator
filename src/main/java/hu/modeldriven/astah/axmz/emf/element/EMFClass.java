package hu.modeldriven.astah.axmz.emf.element;

import com.change_vision.jude.api.inf.exception.InvalidEditingException;
import com.change_vision.jude.api.inf.model.*;
import org.eclipse.uml2.uml.Class;

public class EMFClass extends EMFNamedElement implements IClass {

    private final Class clazz;

    public EMFClass(Class clazz) {
        super(clazz);
        this.clazz = clazz;
    }

    @Override
    public boolean isAbstract() {
        return clazz.isAbstract();
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
        return clazz.isActive();
    }

    @Override
    public void setActive(boolean b) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public IAttribute[] getAttributes() {
        return clazz.getAttributes().stream().map(EMFAttribute::new).toArray(IAttribute[]::new);
    }

    @Override
    public IOperation[] getOperations() {
        return clazz.getOperations().stream().map(EMFOperation::new).toArray(IOperation[]::new);
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
