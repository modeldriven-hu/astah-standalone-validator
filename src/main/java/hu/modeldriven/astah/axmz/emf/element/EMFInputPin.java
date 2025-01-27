package hu.modeldriven.astah.axmz.emf.element;

import com.change_vision.jude.api.inf.model.IInputPin;
import org.eclipse.uml2.uml.Pin;

public class EMFInputPin extends EMFPin implements IInputPin {

    public EMFInputPin(Pin pin) {
        super(pin);
    }

}
