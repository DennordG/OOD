import java.util.ArrayList;
import java.util.List;

/**
 * @author Dennord
 * Created on 5/29/2018
 */
public class Substitution implements ISubstitution {
    List<ITerm> terms;

    public Substitution() {
        terms = new ArrayList();
    }

    @Override
    public void add(ITerm first, ITerm second) {
        terms.add(first);
        terms.add(second);
    }

    @Override
    public ITerm otherTerm(ITerm term) {
        if (terms.contains(term) == false) {
            return term;
        }

        int pos = terms.indexOf(term);
        return terms.get(1 - pos);
    }

    @Override
    public void print() {
        for (ITerm term: terms) {
            term.print();
        }
    }
}
