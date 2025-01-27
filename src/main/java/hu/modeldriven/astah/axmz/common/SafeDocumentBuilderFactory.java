package hu.modeldriven.astah.axmz.common;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class SafeDocumentBuilderFactory {

    private SafeDocumentBuilderFactory() {
    }

    public static DocumentBuilderFactory newInstance() throws ParserConfigurationException {
        var factory = DocumentBuilderFactory.newInstance();
        factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        return factory;
    }

}
