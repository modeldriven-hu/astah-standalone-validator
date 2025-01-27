package hu.modeldriven.astah.axmz.emf.element;

import com.change_vision.jude.api.inf.model.IModel;
import org.eclipse.uml2.uml.Model;

public class EMFModel extends EMFPackageableElement implements IModel {

    public EMFModel(Model model) {
        super(model);
    }

}
