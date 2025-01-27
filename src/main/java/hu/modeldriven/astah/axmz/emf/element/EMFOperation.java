package hu.modeldriven.astah.axmz.emf.element;

import com.change_vision.jude.api.inf.exception.InvalidEditingException;
import com.change_vision.jude.api.inf.model.IClass;
import com.change_vision.jude.api.inf.model.IOperation;
import com.change_vision.jude.api.inf.model.IParameter;
import org.eclipse.uml2.uml.Operation;

public class EMFOperation extends EMFNamedElement implements IOperation {

    private final Operation operation;

    public EMFOperation(Operation operation) {
        super(operation);
        this.operation = operation;
    }

    @Override
    public IParameter[] getParameters() {
        return operation.getOwnedParameters().stream().map(EMFParameter::new).toArray(IParameter[]::new);
    }

    @Override
    public IClass getReturnType() {
        throw new NotImplementedException();
    }

    @Override
    public void setReturnType(IClass iClass) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public String getReturnTypeExpression() {
        throw new NotImplementedException();
    }

    @Override
    public void setReturnTypeExpression(String s) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public String getQualifiedReturnTypeExpression() {
        throw new NotImplementedException();
    }

    @Override
    public void setQualifiedReturnTypeExpression(String s) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public boolean isLeaf() {
        return operation.isLeaf();
    }

    @Override
    public void setLeaf(boolean b) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public boolean isAbstract() {
        return operation.isAbstract();
    }

    @Override
    public void setAbstract(boolean b) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public boolean isStatic() {
        return operation.isStatic();
    }

    @Override
    public void setStatic(boolean b) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public void addParameter(IParameter[] iParameters) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public void removeParameter(IParameter[] iParameters) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public void addPreCondition(String s) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public String[] getPreConditions() {
        throw new NotImplementedException();
    }

    @Override
    public void removePreCondition(String s) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public void addPostCondition(String s) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public String[] getPostConditions() {
        throw new NotImplementedException();
    }

    @Override
    public void removePostCondition(String s) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public String getBodyCondition() {
        throw new NotImplementedException();
    }

    @Override
    public void setBodyCondition(String s) throws InvalidEditingException {
        throw new NotImplementedException();
    }
}
