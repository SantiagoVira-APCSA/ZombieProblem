public class Zombie {
    public static void main(String[] args) {

//        System.out.println(solutionChecker("YA,Y,PJ,A,YA")); //0
//        System.out.println(solutionChecker("PA,Y,PJ,A,YA")); //invalid
//        System.out.println(solutionChecker("YP,Y,YJ,Y,YA")); //-2

        solver("YAJP", "", "", 0);
    }

    public static boolean solutionChecker(String pattern) {
        if (!isValid(pattern)) {
            System.out.println("Illegal moves");
            return false;
        }
        String[] moves = splitPattern(pattern);
        int sum = 0;
        for (String move : moves) {
            sum += determineCrossTime(move);
        }
        return sum <= 17;
    }

    public static boolean isValid(String pattern) {
        String[] moves = splitPattern(pattern);
        String left = "YAJP";
        String right = "";
        for (int i = 0; i < moves.length; i++) {
            String[] people = moves[i].split("");
            for (String p : people) {
                if (i % 2 == 0) {
                    if (!left.contains(p)) return false;
                    int idx = left.indexOf(p);
                    left = left.substring(0, idx) + left.substring(idx + 1);
                    right += p;
                } else {
                    if (!right.contains(p)) return false;
                    int idx = right.indexOf(p);
                    right = right.substring(0, idx) + right.substring(idx + 1);
                    left += p;
                }

            }
        }
        return true;
    }

    public static String[] splitPattern(String pattern) {
        return pattern.split(",");
    }

    private static int determineCrossTime(String peopleCrossing) {
        String[] people = peopleCrossing.split("");
        int[] times = {1, 2, 5, 10};
        int crossTime = 0;
        for (String p : people) {
            int time = times["YAJP".indexOf(p)];
            if (time > crossTime) crossTime = time;
        }
        return crossTime;
    }

    private static void solver(String left, String right, String sequence, int numMoves) {
        if (left.length() == 0 && solutionChecker(sequence)) System.out.println(sequence.substring(0, sequence.length() - 1));
        else if(left.length() > 0) {
            if (numMoves % 2 == 0) {
                // Moving to the right
                for (int i = 0; i < left.length(); i++) {
                    String p1 = left.substring(i, i + 1);
                    String remaining = left.substring(0, i) + left.substring(i + 1);
                    for (int j = 0; j < remaining.length(); j++) {
                        String p2 = remaining.substring(j, j + 1);
                        String newLeft = remaining.substring(0, j) + remaining.substring(j + 1);
                        solver(newLeft, right + p1 + p2, sequence + p1 + p2 + ",", numMoves + 1);
                    }
                }
            } else {
                // Moving back
                    for (int j = 0; j < right.length(); j++) {
                        String p = right.substring(j, j + 1);
                        String newRight = right.substring(0, j) + right.substring(j + 1);
                        solver(left + p, newRight, sequence + p + ",", numMoves + 1);
                    }
            }
        }
    }
}
