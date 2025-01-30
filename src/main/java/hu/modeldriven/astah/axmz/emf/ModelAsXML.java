package hu.modeldriven.astah.axmz.emf;

import org.eclipse.uml2.uml.NamedElement;
import org.w3c.dom.Document;

import javax.xml.xpath.XPathFactory;

public class ModelAsXML {

    private static ModelAsXML instance = null;
    private Document document;

    public static ModelAsXML getInstance() {
        if (instance == null) {
            instance = new ModelAsXML();
        }
        return instance;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public String getDefinition(NamedElement element) {

        var id = element.eResource().getURIFragment(element);

        try {
            var xpath = XPathFactory.newInstance().newXPath();

            // XPath to find the corresponding <xmi:Extension> containing the definition
            var expression = String.format(
                    "//*[@id='%s']/Extension/contents/@definition", id
            );

            var xPathExpression = xpath.compile(expression);
            return xPathExpression.evaluate(document);
        } catch (Exception e) {
            return null;
        }
    }

}
