import java.util.Scanner;

public class Dog extends Entity {
    public Dog(Age age, String name) {
        this.age = age;
        this.ID = name;
    }

    public static Dog create() {
        Scanner scanner = new Scanner(System.in);

        Age age = DogAge.create();
        String address;

        System.out.println("Insert name of dog:");
        address = scanner.nextLine();

        return new Dog(age, address);
    }
}
