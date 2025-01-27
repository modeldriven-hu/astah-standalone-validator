package hu.modeldriven.astah.validation.core.yaml;

public class YAMLReadFailedException extends RuntimeException {

    public YAMLReadFailedException(Exception e) {
        super(e);
    }

}
