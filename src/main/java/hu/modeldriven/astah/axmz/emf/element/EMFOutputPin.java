package hu.modeldriven.astah.axmz.emf.element;

import com.change_vision.jude.api.inf.model.IOutputPin;
import org.eclipse.uml2.uml.Pin;

public class EMFOutputPin extends EMFPin implements IOutputPin {

    public EMFOutputPin(Pin pin) {
        super(pin);
    }
}
