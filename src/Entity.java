/**
 * @author Dennord
 * Created on 3/1/2018
 */
public abstract class Entity implements Comparable<Entity> {
    protected Age age;
    protected String ID;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public int compareTo(Entity o) {
        return this.age.compareTo(o.age);
    }
}
