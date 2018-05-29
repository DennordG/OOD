import java.util.ArrayList;
import java.util.List;

/**
 * @author Dennord
 * Created on 5/29/2018
 */
public class UnificationResult implements IUnificationResult {
    private List<ISubstitution> substitutions;
    private ListFactory listFactory;

    public UnificationResult() {
        listFactory = new ListFactory();
        substitutions = listFactory.create();
    }

    @Override
    public void add(IUnificationResult partialUnificationResult) {
        partialUnificationResult.addTo(substitutions);
    }

    @Override
    public void add(ISubstitution iSubstitution) {
        substitutions.add(iSubstitution);
    }

    @Override
    public ITerm applySubstitutionsTo(ITerm firstTerm) {
        for (int i = 0; i < substitutions.size(); i++) {
            firstTerm = firstTerm.apply(substitutions.get(i));
        }

        return firstTerm;
    }

    @Override
    public void addTo(List<ISubstitution> otherSubstitutions) {
        for (ISubstitution substitution: substitutions) {
            otherSubstitutions.add(substitution);
        }
    }

    @Override
    public boolean wasNotSuccessful() {
        return substitutions.isEmpty();
    }

    @Override
    public void print() {
        for (ISubstitution iSubstitution: substitutions) {
            iSubstitution.print();
            System.out.println();
        }
    }
}
