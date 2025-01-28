package hu.modeldriven.astah.validation.core;

import com.change_vision.jude.api.inf.model.IPackage;
import hu.modeldriven.astah.validation.api.ModelElement;
import hu.modeldriven.astah.validation.api.ModelPackage;

import java.util.ArrayList;
import java.util.List;

public class AstahPackageableElement implements ModelPackage {

    private final IPackage pkg;

    public AstahPackageableElement(IPackage pkg) {
        this.pkg = pkg;
    }

    @Override
    public Object value() {
        return this.pkg;
    }

    @Override
    public String id() {
        return pkg.getId();
    }

    @Override
    public String name() {
        return pkg.getName();
    }

    @Override
    public String type() {
        return pkg.getClass().getInterfaces()[0].getSimpleName();
    }

    @Override
    public List<ModelElement> children() {

        var list = new ArrayList<ModelElement>();

        for (var element : pkg.getOwnedElements()) {
            if (element instanceof IPackage childPackage) {
                list.add(new AstahPackageableElement(childPackage));
            } else {
                list.add(new AstahModelElement(element));
            }
        }

        return list;
    }

    @Override
    public List<? extends ModelElement> attributes() {
        return List.of();
    }
}
