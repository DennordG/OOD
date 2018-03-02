/**
 * @author Dennord
 * @date 3/1/2018
 */
public interface Age {
    public int getY();
    public int getM();
    public int getD();
    public int compareTo(Age o);
    public int realCompareTo(Age o);
    public Age getRelativeValue();
    public Age getAbsoluteValue();
}
