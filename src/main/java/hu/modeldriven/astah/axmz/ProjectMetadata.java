package hu.modeldriven.astah.axmz;

import java.time.OffsetDateTime;

public interface ProjectMetadata {

    String projectId();

    String modelProducer();

    String modelVersion();

    OffsetDateTime lastModified();

}
