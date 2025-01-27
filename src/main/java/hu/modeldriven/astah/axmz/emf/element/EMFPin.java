package hu.modeldriven.astah.axmz.emf.element;

import com.change_vision.jude.api.inf.model.IClass;
import com.change_vision.jude.api.inf.model.IPin;
import org.eclipse.uml2.uml.Pin;

public class EMFPin extends EMFObjectNode implements IPin {

    private final Pin pin;

    public EMFPin(Pin pin) {
        super(pin);
        this.pin = pin;
    }

    @Override
    public IClass getBase() {

        if (pin.getType() == null) {
            return null;
        }

        return new EMFType(pin.getType());
    }
}
