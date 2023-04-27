import java.util.ArrayList;

public class Main {
    private static ArrayList<Pattern> solutions;

    public static void main(String[] args) {
        solutions = new ArrayList<Pattern>();
        PersonGroup pg = new PersonGroup();
        pg.addPerson("A", 1);
        pg.addPerson("B", 2);
        pg.addPerson("C", 5);
        pg.addPerson("D", 10);
        pg.addPerson("E", 1);

        Solver s = new Solver(pg);
        s.solve();
    }


}