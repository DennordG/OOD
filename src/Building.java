import java.util.Scanner;

/**
 * @author Dennord
 * @date 3/1/2018
 */
public class Building extends Entity {
    public Building(Age age, String address) {
        this.age = age;
        this.ID = address;
    }

    public static Building create() {
        Scanner scanner = new Scanner(System.in);

        Age age = ClassicalAge.create();
        String address;

        System.out.println("Insert address of building:");
        address = scanner.nextLine();

        return new Building(age, address);
    }
}
