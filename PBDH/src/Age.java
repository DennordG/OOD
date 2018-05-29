/**
 * @author Dennord
 * Created on  3/1/2018
 */
public interface Age {
    int getY();
    int getM();
    int getD();
    int compareTo(Age o);
    int realCompareTo(Age o);
    Age getRelativeValue();
    Age getAbsoluteValue();
}
