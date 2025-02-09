package hu.modeldriven.astah.axmz.emf;

import net.astah.sysml15.sysml.impl.SysMLPackageImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;
import org.w3c.dom.Document;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;

public class ModelFromXMI {

    private final String path;

    public ModelFromXMI(String xmiFilePath) {
        this.path = xmiFilePath;
    }

    public ModelContent contents() {
        return new ModelContent(xmlParsedModel(), emfParsedModel());
    }

    private Document xmlParsedModel() {
        try {
            var factory = DocumentBuilderFactory.newInstance();
            factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            var builder = factory.newDocumentBuilder();
            var document = builder.parse(new File(this.path));
            document.getDocumentElement().normalize();
            return document;
        } catch (Exception e) {
            throw new ModelParseException(e);
        }
    }

    private EList<EObject> emfParsedModel() {
        var resourceSet = new ResourceSetImpl();

        UMLResourcesUtil.init(resourceSet);

        var registry = Resource.Factory.Registry.INSTANCE;
        var m = registry.getExtensionToFactoryMap();
        m.put("xmi", new XMIResourceFactoryImpl());
        m.put("auml", new XMIResourceFactoryImpl());

        SysMLPackageImpl.init();

        var resource = resourceSet.createResource(URI.createFileURI(this.path));

        try {
            var options = new HashMap<>();
            options.put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
            options.put(XMLResource.OPTION_EXTENDED_META_DATA, new SysMLExtendedMetaData(EPackage.Registry.INSTANCE));

            resource.load(options);
            return resource.getContents();
        } catch (Exception e) {
            throw new ModelParseException(e);
        }
    }
}
