public class Zombie {
    public static void main(String[] args) {

//        System.out.println(solutionChecker("YA,Y,PJ,A,YA")); //0
//        System.out.println(solutionChecker("PA,Y,PJ,A,YA")); //invalid
//        System.out.println(solutionChecker("YP,Y,YJ,Y,YA")); //-2

//        solver("YAJP", "", "", 0);
    }


//    private static void solver(String left, String right, String sequence, int numMoves) {
//        if (left.length() == 0 && solutionChecker(sequence)) System.out.println(sequence.substring(0, sequence.length() - 1));
//        else if(left.length() > 0) {
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
//                    for (int j = 0; j < right.length(); j++) {
//                        String p = right.substring(j, j + 1);
//                        String newRight = right.substring(0, j) + right.substring(j + 1);
//                        solver(left + p, newRight, sequence + p + ",", numMoves + 1);
//                    }
//            }
//        }
//    }
}
