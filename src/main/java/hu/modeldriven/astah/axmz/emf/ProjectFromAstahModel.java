package hu.modeldriven.astah.axmz.emf;

import com.change_vision.jude.api.inf.model.IModel;
import hu.modeldriven.astah.axmz.AstahProject;
import hu.modeldriven.astah.axmz.common.FileInZip;

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
        ModelAsXML.getInstance().setDocument(contents.document());
        return contents.model();
    }

    private String getModelPath() {
        if (modelFile.getName().toLowerCase().endsWith(".axmz")) {
            var tempDir = new File(System.getProperty("java.io.tmpdir"));
            var file = new FileInZip(this.modelFile, "sysml-model.auml", tempDir);
            return file.file().getAbsolutePath();
        } else if (modelFile.getName().toLowerCase().endsWith(".auml")) {
            return modelFile.getAbsolutePath();
        } else {
            throw new ModelParseException("Unsupported file type: " + modelFile.getName());
        }
    }

}
