import java.util.Scanner;

/**
 * @author Dennord
 * @date 3/1/2018
 */
public class Person extends Entity implements Comparable<Entity> {
    public Person(Age age, String name) {
        super(age);
        this.ID = name;
    }

    public static Person create() {
        Scanner scanner = new Scanner(System.in);

        Age age = Age.create();
        String name;

        System.out.println("Insert name of person:");
        name = scanner.nextLine();

        return new Person(age, name);
    }
}
