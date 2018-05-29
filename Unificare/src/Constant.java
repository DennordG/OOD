import java.util.List;

/**
 * @author Dennord
 * Created on 5/29/2018
 */
public class Constant implements ITerm, IConstant {
    private String name;
    private UnificationResultFactory factory;

    private void initialize() {
        factory = new UnificationResultFactory();
    }

    Constant() {
        initialize();
    }

    Constant(String name) {
        initialize();
        this.name = name;
    }

    @Override
    public IUnificationResult unify(ITerm secondTerm) {
        return secondTerm.unify((IConstant)this);
    }

    @Override
    public ITerm apply(ISubstitution substitution) {
        return substitution.otherTerm(this);
    }

    @Override
    public IUnificationResult unify(IPredicate iPredicate) {
        return factory.createNegativeResult();
    }

    @Override
    public IUnificationResult unify(IConstant iConstant) {
        if (iConstant.hasDifferentName(name)) {
            return factory.createNegativeResult();
        }
        else {
            IUnificationResult unif = factory.createSuccessfulResult();
            Substitution subst = new Substitution();
            subst.add(this, (ITerm)iConstant);
            unif.add(subst);
            return unif;
        }
    }

    @Override
    public IUnificationResult unify(IVariable iVariable) {
        return ((ITerm)iVariable).unify((IConstant)this);
    }

    @Override
    public void print() {
        System.out.print(name + " ");
    }

    @Override
    public boolean hasDifferentName(String otherName) {
        return name != otherName;
    }
}
