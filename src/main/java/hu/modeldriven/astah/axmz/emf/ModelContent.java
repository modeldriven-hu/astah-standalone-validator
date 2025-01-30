package hu.modeldriven.astah.axmz.emf;

import hu.modeldriven.astah.axmz.emf.element.EMFModel;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.w3c.dom.Document;

public class ModelContent {

    private final Document document;
    private final EList<EObject> contents;

    public ModelContent(Document document, EList<EObject> contents) {
        this.document = document;
        this.contents = contents;
    }

    public Document document() {
        return document;
    }

    public EMFModel model() {
        if (!contents.isEmpty() && contents.get(0) instanceof org.eclipse.uml2.uml.Model model) {
            return new EMFModel(model);
        }

        throw new ModelParseException("Model not found in the AXMZ file.");
    }

}
