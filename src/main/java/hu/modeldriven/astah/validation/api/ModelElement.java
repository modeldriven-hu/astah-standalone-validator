package hu.modeldriven.astah.validation.api;

import java.util.List;

public interface ModelElement {

    List<? extends ModelElement> attributes();

    Object value();

    String id();

    String name();

    String type();

}
