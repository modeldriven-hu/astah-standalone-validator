package hu.modeldriven.astah.axmz.emf.element;

import com.change_vision.jude.api.inf.exception.InvalidEditingException;
import com.change_vision.jude.api.inf.model.*;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.VisibilityKind;

public class EMFNamedElement extends EMFElement implements INamedElement {

    private final NamedElement element;

    public EMFNamedElement(NamedElement element) {
        super(element);
        this.element = element;
    }

    @Override
    public String getName() {
        return element.getName();
    }

    @Override
    public void setName(String s) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public String getFullName(String s) {
        return element.getQualifiedName();
    }

    @Override
    public String getFullNamespace(String s) {
        return element.getNamespace().getQualifiedName();
    }

    @Override
    public IConstraint[] getConstraints() {
        throw new NotImplementedException();
    }

    @Override
    public IDependency[] getSupplierDependencies() {
        throw new NotImplementedException();
    }

    @Override
    public IDependency[] getClientDependencies() {
        throw new NotImplementedException();
    }

    @Override
    public IRealization[] getSupplierRealizations() {
        throw new NotImplementedException();
    }

    @Override
    public IRealization[] getClientRealizations() {
        throw new NotImplementedException();
    }

    @Override
    public IUsage[] getSupplierUsages() {
        throw new NotImplementedException();
    }

    @Override
    public IUsage[] getClientUsages() {
        throw new NotImplementedException();
    }

    @Override
    public String getDefinition() {
        throw new NotImplementedException();
    }

    @Override
    public void setDefinition(String s) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public boolean isPublicVisibility() {
        return element.getVisibility() == VisibilityKind.PUBLIC_LITERAL;
    }

    @Override
    public boolean isProtectedVisibility() {
        return element.getVisibility() == VisibilityKind.PROTECTED_LITERAL;
    }

    @Override
    public boolean isPrivateVisibility() {
        return element.getVisibility() == VisibilityKind.PRIVATE_LITERAL;
    }

    @Override
    public boolean isPackageVisibility() {
        return element.getVisibility() == VisibilityKind.PACKAGE_LITERAL;
    }

    @Override
    public IDiagram[] getDiagrams() {
        throw new NotImplementedException();
    }

    @Override
    public void setVisibility(String s) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public String getAlias1() {
        throw new NotImplementedException();
    }

    @Override
    public void setAlias1(String s) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public String getAlias2() {
        throw new NotImplementedException();
    }

    @Override
    public void setAlias2(String s) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public IHyperlink[] getHyperlinks() {
        throw new NotImplementedException();
    }

    @Override
    public IHyperlink createFileHyperlink(String s, String s1, String s2) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public IHyperlink createURLHyperlink(String s, String s1) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public IHyperlink createElementHyperlink(IElement iElement, String s) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public void deleteHyperlink(IHyperlink iHyperlink) throws InvalidEditingException {
        throw new NotImplementedException();
    }

}
