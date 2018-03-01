import java.util.Scanner;

/**
 * @author Dennord
 * @date 3/1/2018
 */
public class Age implements Comparable<Age> {
    private int y, m, d;

    public Age(int y, int m, int d) {
        this.y = y;
        this.m = m;
        this.d = d;
    }

    public Age() {
        this.y = 0;
        this.m = 0;
        this.d = 0;
    }

    @Override
    public int compareTo(Age o) {
        if (this.y == o.y)
            if (this.m == o.m)
                return this.d - o.d;
        else
            return this.m - o.m;
        return this.y - o.y;
    }

    public static Age create() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Age:");

        System.out.println("- Years:");
        int y = scanner.nextInt();

        System.out.println("- Months:");
        int m = scanner.nextInt();

        System.out.println("- Days:");
        int d = scanner.nextInt();

        return new Age(y, m, d);
    }
}
