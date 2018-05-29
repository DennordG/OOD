/**
 * @author Dennord
 * Created on 5/29/2018
 */
public class Variable implements ITerm, IVariable {
    private String name;
    private UnificationResultFactory factory;

    Variable(String name) {
        this.name = name;
        factory = new UnificationResultFactory();
    }

    @Override
    public IUnificationResult unify(ITerm secondTerm) {
        return secondTerm.unify((IVariable)this);
    }

    @Override
    public ITerm apply(ISubstitution substitution) {
        return substitution.otherTerm(this);
    }

    @Override
    public IUnificationResult unify(IPredicate iPredicate) {
        IUnificationResult substitutions = factory.createSuccessfulResult();
        Substitution subst = new Substitution();
        subst.add(this, (ITerm)iPredicate);
        substitutions.add(subst);

        return substitutions;
    }

    @Override
    public IUnificationResult unify(IConstant iConstant) {
        IUnificationResult substitutions = factory.createSuccessfulResult();
        Substitution subst = new Substitution();
        subst.add(this, (ITerm)iConstant);
        substitutions.add(subst);

        return substitutions;
    }

    @Override
    public IUnificationResult unify(IVariable iVariable) {
        IUnificationResult substitutions = factory.createSuccessfulResult();
        Substitution subst = new Substitution();
        subst.add(this, (ITerm)iVariable);
        substitutions.add(subst);

        return substitutions;
    }

    @Override
    public void print() {
        System.out.print(name + " ");
    }
}
