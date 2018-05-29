import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Dennord
 * Created on 2/28/2018
 */
public class Menu {
    private Scanner scanner;
    private ArrayList<String> options;
    private ArrayList<String> acro;
    private MyList entList;

    private static void print(String str) {
        System.out.println(str);
    }

    private void loadPersonOptions() {
        options.add("Add person");
        acro.add("ADDP");
        options.add("Find person with max age");
        acro.add("MAXP");
        options.add("Find all persons with age above a specified one");
        acro.add("ALLP");
    }

    private void loadBuildingOptions() {
        options.add("Add building");
        acro.add("ADDB");
        options.add("Find building with max age");
        acro.add("MAXB");
        options.add("Find all buildings with age above a specified one");
        acro.add("ALLB");
    }

    private void loadDogOptions() {
        options.add("Add dog");
        acro.add("ADDD");
        options.add("Find dog with max age");
        acro.add("MAXD");
        options.add("Find all dogs with age above a specified one");
        acro.add("ALLD");
    }

    private void loadEntityOptions() {
        options.add("Find entity with max age");
        acro.add("MAXE");
        options.add("Find all entities with age above a specified one");
        acro.add("ALLE");
    }

    public Menu() {
        scanner = new Scanner(System.in);

        options = new ArrayList<>();
        options.add("Exit");

        acro = new ArrayList<>();
        acro.add("EXIT");

        loadPersonOptions();
        loadBuildingOptions();
        loadDogOptions();
        loadEntityOptions();

        entList = new MyList();
    }

    private void judge(String option) {
        switch (option) {
            case "EXIT":
                System.exit(0);
            case "ADDP":
                entList.add(Person.create());
                break;
            case "MAXP":
                print(entList.getPersonWithMaxAge().getID());
                break;
            case "ALLP":
                entList.printAllPersonsWithAge(ClassicalAge.create());
                break;
            case "ADDB":
                entList.add(Building.create());
                break;
            case "MAXB":
                print(entList.getBuildingWithMaxAge().getID());
                break;
            case "ALLB":
                entList.printAllBuildingsWithAge(ClassicalAge.create());
                break;
            case "ADDD":
                entList.add(Dog.create());
                break;
            case "MAXD":
                print(entList.getDogWithMaxAge().getID());
                break;
            case "ALLD":
                entList.printAllDogsWithAge(DogAge.create());
                break;
            case "MAXE":
                print(entList.getEntityWithMaxAge().getID());
                break;
            case "ALLE":
                entList.printAllEntitiesWithAge(ClassicalAge.create());
                break;
        }
    }

    private void show() {
        for (int idx = 0; idx < options.size(); ++idx)
            print(idx + ". " + options.get(idx));

        print("Choose option:");
        int option = scanner.nextInt();

        while (option < 0 || option >= options.size()) {
            print("Please choose a valid option:");
            option = scanner.nextInt();
        }

        judge(acro.get(option));
    }

    public void go() {
        while (true) {
            show();
        }
    }
}
