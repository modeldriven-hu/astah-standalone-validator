package hu.modeldriven.astah.axmz.emf.element;

import com.change_vision.jude.api.inf.model.IActivityNode;
import com.change_vision.jude.api.inf.model.IFlow;
import org.eclipse.uml2.uml.NamedElement;

public class EMFActivityNode extends EMFNamedElement implements IActivityNode {

    public EMFActivityNode(NamedElement namedElement) {
        super(namedElement);
    }

    @Override
    public IFlow[] getIncomings() {
        return new IFlow[0];
    }

    @Override
    public IFlow[] getOutgoings() {
        return new IFlow[0];
    }
}
