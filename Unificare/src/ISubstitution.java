/**
 * @author Dennord
 * Created on 5/29/2018
 */
public interface ISubstitution {
    void add(ITerm first, ITerm second);
    ITerm otherTerm(ITerm term);

    void print();
}
