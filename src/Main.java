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
//        Pattern p = new Pattern();
//        p.addGroup(pg);
//        p.usePatternString("A,B;A;C,D;B;A,B");
//        System.out.println(p);
//        System.out.println(p.doesSolve());

        Solver s = new Solver(pg);
        s.solve();
    }

//    private static void solver(String left, String right, String sequence, int numMoves) {
//        if (left.length() == 0 && solutionChecker(sequence))
//            System.out.println(sequence.substring(0, sequence.length() - 1));
//        else if (left.length() > 0) {
//            if (numMoves % 2 == 0) {
//                // Moving to the right
//                for (int i = 0; i < left.length(); i++) {
//                    String p1 = left.substring(i, i + 1);
//                    String remaining = left.substring(0, i) + left.substring(i + 1);
//                    for (int j = 0; j < remaining.length(); j++) {
//                        String p2 = remaining.substring(j, j + 1);
//                        String newLeft = remaining.substring(0, j) + remaining.substring(j + 1);
//                        solver(newLeft, right + p1 + p2, sequence + p1 + p2 + ",", numMoves + 1);
//                    }
//                }
//            } else {
//                // Moving back
//                for (int j = 0; j < right.length(); j++) {
//                    String p = right.substring(j, j + 1);
//                    String newRight = right.substring(0, j) + right.substring(j + 1);
//                    solver(left + p, newRight, sequence + p + ",", numMoves + 1);
//                }
//            }
//        }
//    }


}