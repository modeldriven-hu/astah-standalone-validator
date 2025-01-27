package hu.modeldriven.astah.axmz.emf;

public class ModelParseException extends RuntimeException {

    public ModelParseException(Exception e) {
        super(e);
    }

    public ModelParseException(String s) {
        super(s);
    }
}
