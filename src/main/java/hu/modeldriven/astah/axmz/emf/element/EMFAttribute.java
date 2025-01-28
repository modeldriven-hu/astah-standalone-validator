package hu.modeldriven.astah.axmz.emf.element;

import com.change_vision.jude.api.inf.exception.InvalidEditingException;
import com.change_vision.jude.api.inf.model.*;
import org.eclipse.uml2.uml.Property;

public class EMFAttribute extends EMFNamedElement implements IAttribute {

    private final Property property;

    public EMFAttribute(Property property) {
        super(property);
        this.property = property;
    }

    @Override
    public IClass getType() {
        return new EMFType(property.getType());
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
    public String getInitialValue() {
        throw new NotImplementedException();
    }

    @Override
    public void setInitialValue(String s) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public boolean isChangeable() {
        throw new NotImplementedException();
    }

    @Override
    public void setChangeable(boolean b) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public IAssociation getAssociation() {
        throw new NotImplementedException();
    }

    @Override
    public IAttribute[] getQualifiers() {
        throw new NotImplementedException();
    }

    @Override
    public IMultiplicityRange[] getMultiplicity() {
        return new EMFMultiplicityRange[]{new EMFMultiplicityRange(property.getLowerValue(), property.getUpperValue())};
    }

    @Override
    public void setMultiplicity(int[][] ints) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public boolean isDerived() {
        throw new NotImplementedException();
    }

    @Override
    public void setDerived(boolean b) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public boolean isComposite() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isAggregate() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isEnable() {
        throw new NotImplementedException();
    }

    @Override
    public void setEnable(boolean b) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public boolean isStatic() {
        throw new NotImplementedException();
    }

    @Override
    public void setStatic(boolean b) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public void setAggregation() throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public void setComposite() throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public void setAggregationKind(AggregationKind aggregationKind) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public void setMultiplicityStrings(String[][] strings) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public String getNavigability() {
        throw new NotImplementedException();
    }

    @Override
    public void setNavigability(String s) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public IConnector[] getConnectors() {
        throw new NotImplementedException();
    }
}
