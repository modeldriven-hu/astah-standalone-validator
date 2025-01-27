package hu.modeldriven.astah.axmz.emf;

import hu.modeldriven.astah.axmz.AstahModelFile;
import hu.modeldriven.astah.axmz.AstahProject;

import java.io.File;

public class StandardAstahModelFile implements AstahModelFile {

    private final File modelFile;

    public StandardAstahModelFile(File modelFile) {
        this.modelFile = modelFile;
    }

    @Override
    public AstahProject project() {
        return new ProjectFromAstahModel(modelFile);
    }

}
