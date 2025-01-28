package hu.modeldriven.astah.axmz.emf.element;

import com.change_vision.jude.api.inf.exception.InvalidEditingException;
import com.change_vision.jude.api.inf.model.*;
import org.eclipse.uml2.uml.UseCase;

public class EMFUseCase extends EMFNamedElement implements IUseCase {

    private final UseCase useCase;

    public EMFUseCase(UseCase useCase) {
        super(useCase);
        this.useCase = useCase;
    }

    @Override
    public IExtentionPoint[] getExtensionPoints() {
        throw new NotImplementedException();
    }

    @Override
    public IInclude[] getIncludes() {
        throw new NotImplementedException();
    }

    @Override
    public IInclude[] getAdditionInvs() {
        throw new NotImplementedException();
    }

    @Override
    public IExtend[] getExtends() {
        throw new NotImplementedException();
    }

    @Override
    public IExtend[] getExtendedCaseInvs() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isAbstract() {
        return useCase.isAbstract();
    }

    @Override
    public void setAbstract(boolean b) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public boolean isLeaf() {
        throw new NotImplementedException();
    }

    @Override
    public void setLeaf(boolean b) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public boolean isActive() {
        throw new NotImplementedException();
    }

    @Override
    public void setActive(boolean b) throws InvalidEditingException {
        throw new NotImplementedException();
    }

    @Override
    public IAttribute[] getAttributes() {
        return new IAttribute[0];
    }

    @Override
    public IOperation[] getOperations() {
        throw new NotImplementedException();
    }

    @Override
    public IClass[] getNestedClasses() {
        throw new NotImplementedException();
    }

    @Override
    public IGeneralization[] getGeneralizations() {
        throw new NotImplementedException();
    }

    @Override
    public IGeneralization[] getSpecializations() {
        throw new NotImplementedException();
    }

    @Override
    public IClassifierTemplateParameter[] getTemplateParameters() {
        throw new NotImplementedException();
    }

    @Override
    public ITemplateBinding[] getTemplateBindings() {
        throw new NotImplementedException();
    }

    @Override
    public IPort[] getPorts() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isPrimitiveType() {
        throw new NotImplementedException();
    }
}
