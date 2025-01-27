package hu.modeldriven.astah.axmz.emf.element;

import com.change_vision.jude.api.inf.exception.InvalidEditingException;
import com.change_vision.jude.api.inf.model.IAction;
import com.change_vision.jude.api.inf.model.IActivity;
import com.change_vision.jude.api.inf.model.IInputPin;
import com.change_vision.jude.api.inf.model.IOutputPin;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.OpaqueAction;

import java.util.ArrayList;

public class EMFAction extends EMFActivityNode implements IAction {

    private final Action action;

    public EMFAction(Action action) {
        super(action);
        this.action = action;
    }

    @Override
    public String getName() {
        if (action instanceof OpaqueAction opaqueAction) {
            return opaqueAction.getBodies().get(0);
        }
        return action.getName();
    }

    @Override
    public IActivity getCallingActivity() {
        throw new NotImplementedException();
    }

    @Override
    public void setCallingActivity(IActivity iActivity) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public boolean isCallBehaviorAction() {
        throw new NotImplementedException();
    }

    @Override
    public IOutputPin[] getOutputs() {

        if (action.getOutputs() == null || action.getOutputs().isEmpty()) {
            return new IOutputPin[0];
        }

        var outputPins = new ArrayList<IOutputPin>();
        action.getOutputs().forEach(p -> outputPins.add(new EMFOutputPin(p)));
        return outputPins.toArray(new IOutputPin[0]);
    }

    @Override
    public IInputPin[] getInputs() {
        if (action.getInputs() == null || action.getInputs().isEmpty()) {
            return new IInputPin[0];
        }

        var inputPins = new ArrayList<IInputPin>();
        action.getInputs().forEach(p -> inputPins.add(new EMFInputPin(p)));
        return inputPins.toArray(new IInputPin[0]);
    }

    @Override
    public boolean isSendSignalAction() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isAcceptEventAction() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isAcceptTimeEventAction() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isProcess() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isConnector() {
        throw new NotImplementedException();
    }
}
