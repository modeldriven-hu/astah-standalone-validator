package hu.modeldriven.astah.axmz.emf;

import net.astah.sysml15.sysml.SysMLPackage;
import net.astah.sysml15.sysml.impl.SysMLPackageImpl;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.uml2.uml.resource.XMI2UMLExtendedMetaData;

import java.util.HashMap;
import java.util.Map;

public class SysMLExtendedMetaData extends XMI2UMLExtendedMetaData {

    private static final Map<String, EClassifier> cache = new HashMap<>();

    public SysMLExtendedMetaData(Registry registry) {
        super(registry);
    }

    @Override
    public EClassifier demandType(String namespace, String name) {

        var rootPackage = SysMLPackageImpl.init();

        if (rootPackage.getNsURI().equals(namespace)) {
            return findSysMLType(rootPackage, name);
        }

        return super.demandType(namespace, name);
    }

    /**
     * The issue is that Astah SysML XMI files only include the root namespace, omitting the sub-namespaces.
     * Interestingly, Cameo does exactly the same.
     * <p>
     * As a result, the Eclipse EMF library typically cannot locate elements within these sub-namespaces.
     * To address this, we iterate through each subpackage and its classifiers.
     * <p>
     * If a match is found, we return it; otherwise, we return null.
     * <p>
     * A very dumb cache is also implemented.
     * <p>
     * The code is kept as procedural as possible for debugging purposes.
     *
     * @param rootPackage
     * @param name
     * @return
     */
    private EClassifier findSysMLType(SysMLPackage rootPackage, String name) {

        if (cache.containsKey(name)) {
            return cache.get(name);
        }

        for (var pkg : rootPackage.getESubpackages()) {
            for (var classifier : pkg.getEClassifiers()) {
                if (classifier.getName().equals(name)) {
                    cache.put(name, classifier);
                    return classifier;
                }
            }
        }

        return null;
    }

}
