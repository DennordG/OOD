import java.util.Scanner;

public class ClassicalAge implements Age {
    public int y, m, d;

    public ClassicalAge(int y, int m, int d) {
        this.y = y;
        this.m = m;
        this.d = d;
    }

    public ClassicalAge() {
        this.y = 0;
        this.m = 0;
        this.d = 0;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getM() {
        return m;
    }

    @Override
    public int getD() {
        return d;
    }

    @Override
    public int compareTo(Age o) {
        return this.getAbsoluteValue().realCompareTo(o.getAbsoluteValue());
    }

    @Override
    public int realCompareTo(Age o) {
        if (this.getY() == o.getY())
            if (this.getM() == o.getM())
                return this.getD() - o.getD();
            else
                return this.getM() - o.getM();
        else
            return this.getD() - o.getD();
    }

    @Override
    public Age getRelativeValue() {
        return this;
    }

    @Override
    public Age getAbsoluteValue() {
        return this;
    }

    public static Age create() {
        System.out.println("Insert Age:");

        Scanner scanner = new Scanner(System.in);
        System.out.println("- Years:");
        int y = scanner.nextInt();

        System.out.println("- Months:");
        int m = scanner.nextInt();

        System.out.println("- Days:");
        int d = scanner.nextInt();

        return new ClassicalAge(y, m, d);
    }
}