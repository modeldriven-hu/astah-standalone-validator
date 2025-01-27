package hu.modeldriven.astah.axmz.emf.element;

import com.change_vision.jude.api.inf.model.IEnumerationLiteral;
import org.eclipse.uml2.uml.EnumerationLiteral;

public class EMFEnumerationLiteral extends EMFInstanceSpecification implements IEnumerationLiteral {

    public EMFEnumerationLiteral(EnumerationLiteral literal) {
        super(literal);
    }
}
