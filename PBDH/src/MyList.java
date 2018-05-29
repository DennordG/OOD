import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Dennord
 * Created on 3/1/2018
 */
public class MyList extends ArrayList<Entity> {
    public Entity getPersonWithMaxAge() {
        MyList persons = new MyList();

        for (Entity ent: this)
            if (ent instanceof Person)
                persons.add(ent);

        return Collections.max(persons);
    }

    public void printAllPersonsWithAge(Age specifiedAge) {
        for (Entity ent: this)
            if (ent instanceof Person && ent.age.compareTo(specifiedAge) > 0)
                System.out.println(ent.getID());
    }


    public Entity getBuildingWithMaxAge() {
        MyList buildings = new MyList();

        for (Entity ent: this)
            if (ent instanceof Building)
                buildings.add(ent);

        return Collections.max(buildings);
    }

    public void printAllBuildingsWithAge(Age specifiedAge) {
        for (Entity ent: this)
            if (ent instanceof Building && ent.age.compareTo(specifiedAge) > 0)
                System.out.println(ent.getID());
    }

    public Entity getDogWithMaxAge() {
        MyList dogs = new MyList();

        for (Entity ent: this)
            if (ent instanceof Dog)
                dogs.add(ent);

        return Collections.max(dogs);
    }

    public void printAllDogsWithAge(Age specifiedAge) {
        for (Entity ent: this)
            if (ent instanceof Dog && ent.age.compareTo(specifiedAge) > 0)
                System.out.println(ent.getID());
    }


    public Entity getEntityWithMaxAge() {
        return Collections.max(this);
    }

    public void printAllEntitiesWithAge(Age specificAge) {
        for (Entity ent: this)
            if (ent.age.compareTo(specificAge) > 0)
                System.out.println(ent.getID());
    }
}
