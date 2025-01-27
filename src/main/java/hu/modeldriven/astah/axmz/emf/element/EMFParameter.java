package hu.modeldriven.astah.axmz.emf.element;

import com.change_vision.jude.api.inf.exception.InvalidEditingException;
import com.change_vision.jude.api.inf.model.IClass;
import com.change_vision.jude.api.inf.model.IParameter;
import org.eclipse.uml2.uml.Parameter;

public class EMFParameter extends EMFNamedElement implements IParameter {

    private final Parameter parameter;

    public EMFParameter(Parameter parameter) {
        super(parameter);
        this.parameter = parameter;
    }

    @Override
    public IClass getType() {
        return new EMFType(parameter.getType());
    }

    @Override
    public void setType(IClass iClass) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public String getTypeExpression() {
        throw new NotImplementedException();
    }

    @Override
    public void setTypeExpression(String s) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public String getQualifiedTypeExpression() {
        throw new NotImplementedException();
    }

    @Override
    public void setQualifiedTypeExpression(String s) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public String getDirection() {
        return parameter.getDirection().getLiteral();
    }

    @Override
    public void setDirection(String s) throws InvalidEditingException {
        throw new NotImplementedException();
    }
}
