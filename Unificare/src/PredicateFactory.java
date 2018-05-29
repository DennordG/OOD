import java.util.List; /**
 * @author Dennord
 * Created on 5/29/2018
 */
public class PredicateFactory {

    public Predicate create(String name, List substitutedTerms) {
        return new Predicate(name, substitutedTerms);
    }
}
