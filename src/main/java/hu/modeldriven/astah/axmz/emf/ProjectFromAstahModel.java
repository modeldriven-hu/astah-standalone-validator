package hu.modeldriven.astah.axmz.emf;

import com.change_vision.jude.api.inf.model.IModel;
import hu.modeldriven.astah.axmz.AstahProject;
import hu.modeldriven.astah.axmz.common.FileInZip;
import hu.modeldriven.astah.axmz.emf.element.EMFModel;
import org.eclipse.uml2.uml.Model;

import java.io.File;

public class ProjectFromAstahModel implements AstahProject {

    private final File modelFile;

    public ProjectFromAstahModel(File modelFile) {
        this.modelFile = modelFile;
    }

    @Override
    public IModel model() {
        var modelFromXmi = new ModelFromXMI(getModelPath());
        var contents = modelFromXmi.contents();

        if (!contents.isEmpty() && contents.getFirst() instanceof Model model) {
            return new EMFModel(model);
        }

        throw new ModelParseException("Model not found in the AXMZ file.");
    }

    private String getModelPath(){
        if (modelFile.getName().toLowerCase().endsWith(".axmz")) {
            var tempDir = new File(System.getProperty("java.io.tmpdir"));
            var file = new FileInZip(this.modelFile, "sysml-model.auml", tempDir);
            return file.file().getAbsolutePath();
        } else if (modelFile.getName().toLowerCase().endsWith(".auml")){
            return modelFile.getAbsolutePath(); 
        } else {
            throw new ModelParseException("Unsupported file type: " + modelFile.getName());
        }
    }

}
