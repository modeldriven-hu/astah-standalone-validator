package hu.modeldriven.astah.axmz.emf.element;

import com.change_vision.jude.api.inf.model.INamedElement;
import com.change_vision.jude.api.inf.model.IPackage;
import org.eclipse.uml2.uml.PackageableElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class EMFPackageableElement extends EMFNamedElement implements IPackage {

    private static final Logger logger = LoggerFactory.getLogger(EMFPackageableElement.class);

    private final PackageableElement packageableElement;

    public EMFPackageableElement(PackageableElement packageableElement) {
        super(packageableElement);
        this.packageableElement = packageableElement;
    }

    @Override
    public INamedElement[] getOwnedElements() {
        var retValue = new ArrayList<INamedElement>();

        for (var element : packageableElement.getOwnedElements()) {

            switch (element) {
                case org.eclipse.uml2.uml.Package packageElement ->
                        retValue.add(new EMFPackageableElement(packageElement));
                case org.eclipse.uml2.uml.Activity activityElement ->
                        retValue.add(new EMFPackageableElement(activityElement));
                case org.eclipse.uml2.uml.UseCase useCaseElement -> retValue.add(new EMFUseCase(useCaseElement));
                case org.eclipse.uml2.uml.Class classElement -> retValue.add(new EMFClass(classElement));
                case org.eclipse.uml2.uml.Action actionElement -> retValue.add(new EMFAction(actionElement));
                case org.eclipse.uml2.uml.Port portElement -> retValue.add(new EMFPort(portElement));
                case org.eclipse.uml2.uml.Pin pinElement -> retValue.add(new EMFPin(pinElement));
                case org.eclipse.uml2.uml.Enumeration enumerationElement ->
                        retValue.add(new EMFEnumerationValueType(enumerationElement));
                case org.eclipse.uml2.uml.DataType dataTypeElement -> retValue.add(new EMFValueType(dataTypeElement));
                case org.eclipse.uml2.uml.Type typeElement -> retValue.add(new EMFType(typeElement));
                case org.eclipse.uml2.uml.NamedElement namedElement -> retValue.add(new EMFNamedElement(namedElement));
                default -> logger.info("Unknown element type: {}, skipping.", element.getClass().getSimpleName());
            }

        }

        return retValue.toArray(new INamedElement[0]);
    }
}
