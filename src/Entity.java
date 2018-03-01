/**
 * @author Dennord
 * @date 3/1/2018
 */
public class Entity implements Comparable<Entity> {
    protected Age age;
    protected String ID;

    public Entity(Age age) {
        this.age = age;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    @Override
    public int compareTo(Entity o) {
        return this.age.compareTo(o.age);
    }
}
