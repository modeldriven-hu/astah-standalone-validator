package hu.modeldriven.astah.axmz.emf.element;

import com.change_vision.jude.api.inf.exception.InvalidEditingException;
import com.change_vision.jude.api.inf.model.IMultiplicityRange;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.ValueSpecification;

public class EMFMultiplicityRange implements IMultiplicityRange {

    private final ValueSpecification lower;
    private final ValueSpecification upper;

    public EMFMultiplicityRange(ValueSpecification lower, ValueSpecification upper) {
        this.lower = lower;
        this.upper = upper;
    }

    @Override
    public int getLower() {
        return lower == null ? IMultiplicityRange.UNDEFINED : lower.integerValue();
    }

    @Override
    public void setLower(int i) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public int getUpper() {
        if (upper == null) {
            return IMultiplicityRange.UNDEFINED;
        }

        if (upper instanceof LiteralUnlimitedNatural && upper.unlimitedValue() == -1) {
            return IMultiplicityRange.UNLIMITED;
        }

        return upper.unlimitedValue();
    }

    @Override
    public void setUpper(int i) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public String getLowerString() {
        throw new NotImplementedException();
    }

    @Override
    public void setLowerString(String s) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public String getUpperString() {
        throw new NotImplementedException();
    }

    @Override
    public void setUpperString(String s) throws InvalidEditingException {
        throw new NotImplementedException();
    }
}
