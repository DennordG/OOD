import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Dennord
 * @date 3/1/2018
 */
public class MyList<Entity> extends ArrayList<Entity> {
    public Person getPersonWithMaxAge() {
        MyList<Person> persons = new MyList<>();

        for (Entity ent: this)
            if (ent instanceof Person) persons.add((Person)ent);

        return Collections.max(persons);
    }

    public void printAllPersonsWithAge(Age specifiedAge) {
        for (Entity ent: this)
            if (ent instanceof Person && ((Person) ent).getAge().compareTo(specifiedAge) > 0)
                System.out.println(((Person) ent).getID());
    }


    public Building getBuildingWithMaxAge() {
        MyList<Building> buildings = new MyList<>();

        for (Entity ent: this)
            if (ent instanceof Building) buildings.add((Building)ent);

        return Collections.max(buildings);
    }

    public void printAllBuildingsWithAge(Age specifiedAge) {
        for (Entity ent: this)
            if (ent instanceof Building && ((Building) ent).getAge().compareTo(specifiedAge) > 0)
                System.out.println(((Building) ent).getID());
    }

    /*
    public Entity getEntityWithMaxAge() {
        Entity res;
        res = (Entity) new Person(new Age(), "");

        for (Entity ent: this)
            if (ent.getAge())
    }

    public void printAllEntitiesWithMaxAge() {
        for (Entity ent: this)
            if (ent.getAge())
    }
    */
}
