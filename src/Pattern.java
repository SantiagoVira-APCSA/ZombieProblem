import java.util.ArrayList;

public class Pattern {
    private static final int WIN_TIME = 20;
    private ArrayList<PersonGroup> moves;
    private PersonGroup people;

    @Override
    public String toString() {
        String result = "Moves: ";
        for (PersonGroup p : moves) {
            result += "       \n" + Color.ANSI_GREEN + p + Color.ANSI_RESET;
        }
        return result;
    }

    public Pattern() {
        moves = new ArrayList<PersonGroup>();
        people = new PersonGroup();
    }

    public Pattern(Pattern old) {
        people = new PersonGroup(old.people);
        moves = new ArrayList<PersonGroup>();

        for (PersonGroup p : old.moves) {
            addMove(new PersonGroup(p));
        }
    }

    public Pattern(PersonGroup pg) {
        moves = new ArrayList<PersonGroup>();
        people = new PersonGroup(pg);
    }

    public void addPerson(Person p) {
        people.addPerson(p);
    }

    public void addPerson(String name, int crossTime) {
        people.addPerson(name, crossTime);
    }

    public void addGroup(PersonGroup pg) {
        people.addGroup(pg);
    }

    public void addMove(PersonGroup pg) {
        moves.add(pg);
    }

    public boolean doesSolve() {
        if (!isValid()) {
            System.out.println(this);
            System.out.println("Illegal moves");
            return false;
        }
        int sum = 0;
        for (PersonGroup move : moves) {
            sum += move.getCrossTime();
        }
        return sum <= WIN_TIME;
    }

    public boolean isValid() {
        PersonGroup left = new PersonGroup(people);
        PersonGroup right = new PersonGroup();
        for (int i = 0; i < moves.size(); i++) {
            PersonGroup move = moves.get(i);
            if (i % 2 == 0) {
                // Moving Right
                if (!left.containsAll(move)) {
                    System.out.println("Wrong moving right, " + i);
                    System.out.println(left);
                    System.out.println(right);
                    return false;
                }
                left.removeGroup(move);
                right.addGroup(move);
            } else {
                // Moving Left
                if (!right.containsAll(move)) {
                    System.out.println("moving left triggered");
                    System.out.println(left);
                    System.out.println(right);
                    return false;
                }
                right.removeGroup(move);
                left.addGroup(move);
            }
        }
        return true;
    }

    public boolean patternStringIsValid(String pattern) {
        String[] patternMoves = pattern.split(";");
        for (String move : patternMoves) {
            String[] movePeople = move.split(",");
            for (String personName : movePeople) {
                if (people.getByName(personName) == null) return false;
            }
        }
        return true;
    }

    public void usePatternString(String pattern) {
        // Format:
        // Bob,Jay;Bob;Bob,Fei;Fei;

        if (!patternStringIsValid(pattern)) {
            System.out.println("Invalid pattern string");
            return;
        }

        String[] patternMoves = pattern.split(";");
        for (String move : patternMoves) {
            String[] movePeople = move.split(",");
            PersonGroup pgMove = new PersonGroup();
            for (String personName : movePeople) {
                if (people.getByName(personName) != null) pgMove.addPerson(people.getByName(personName));
            }
            moves.add(pgMove);
        }
    }

    public int getSize() {
        return moves.size();
    }

    public boolean movingRight() {
        return moves.size() % 2 == 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pattern p)) return false;
        for (int i = 0; i < p.getSize(); i++) {
            PersonGroup thisMove = moves.get(i);
            PersonGroup move = p.moves.get(i);
            if (!move.equals(thisMove)) return false;
        }
        return true;
    }
}
