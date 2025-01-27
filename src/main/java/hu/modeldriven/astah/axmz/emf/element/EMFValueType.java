package hu.modeldriven.astah.axmz.emf.element;

import com.change_vision.jude.api.inf.exception.InvalidEditingException;
import com.change_vision.jude.api.inf.model.IQuantityKind;
import com.change_vision.jude.api.inf.model.IUnit;
import com.change_vision.jude.api.inf.model.IValueType;
import com.change_vision.jude.api.inf.model.IValueTypeProperty;

public class EMFValueType extends EMFDataType implements IValueType {

    public EMFValueType(org.eclipse.uml2.uml.DataType dataType) {
        super(dataType);
    }

    @Override
    public IUnit getUnit() {
        throw new NotImplementedException();
    }

    @Override
    public void setUnit(IUnit iUnit) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public IQuantityKind getQuantityKind() {
        throw new NotImplementedException();
    }

    @Override
    public void setQuantityKind(IQuantityKind iQuantityKind) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public IValueTypeProperty[] getProperties() {
        throw new NotImplementedException();
    }
}
