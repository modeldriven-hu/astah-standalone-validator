# Astah Standalone Validator

The purpose of this project is to being able to validate and Astah 
model file as part of a CI/CD pipeline without the need of Astah SysML
modeling tool.

## Requirements to build

- Java 21
- Maven
- A locally installed Astah SysML (to have the astah-api.jar available)

# Building

To build the project, run the following command:

```mvn package```

## Legal context

## astah-api.jar

The project is using the astah-api.jar file from the Astah SysML 
product. The api specification is used for interoperability purposes so
that developers can access the model using the same API as they would
using Astah SysML.

This file is not part of the standalone model validator and 
has to be referenced externally according to the license agreement: 

See https://members.change-vision.com/javadoc/astah-api/10_0_0/api/en/doc/index.html
_Redistribution of astah-api.jar file is NOT allowed._

This implies that builds to the general public cannot be provided.

## net.astah.sysml15.jar

This file has to be generated from net.astah.sysml15.sysml-10.0.0.jar from the
Astah installation from the model folder. Use Eclipse to make a build from 
the genmodel file.

This file is needed for interoperability purposes.
