package hu.modeldriven.astah.axmz.emf.element;

import com.change_vision.jude.api.inf.exception.InvalidEditingException;
import com.change_vision.jude.api.inf.model.IEnumerationLiteral;
import com.change_vision.jude.api.inf.model.IEnumerationValueType;
import org.eclipse.uml2.uml.Enumeration;

public class EMFEnumerationValueType extends EMFValueType implements IEnumerationValueType {

    private final Enumeration enumeration;

    public EMFEnumerationValueType(Enumeration enumeration) {
        super(enumeration);
        this.enumeration = enumeration;
    }

    @Override
    public IEnumerationLiteral[] getEnumerationLiterals() {
        return this.enumeration.getOwnedLiterals().stream().map(EMFEnumerationLiteral::new).toArray(IEnumerationLiteral[]::new);
    }

    @Override
    public IEnumerationLiteral createEnumerationLiteral(String s) throws InvalidEditingException {
        throw new NotImplementedException();
    }
}
