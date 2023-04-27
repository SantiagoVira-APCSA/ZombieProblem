import java.util.ArrayList;

public class Solver {
    private PersonGroup people;
    private ArrayList<Pattern> solutions;

    public Solver(PersonGroup pg) {
        people = pg;
        solutions = new ArrayList<Pattern>();
    }

    public void solve() {
        solver(people, new PersonGroup(), new Pattern(people));
        for (Pattern solve : solutions) {
            System.out.println(solve);
        }
    }

    private void addSolution(Pattern newPattern) {
        for (Pattern p : solutions) {
            if (p.equals(newPattern)) return;
        }
        solutions.add(newPattern);
    }

    private void solver(PersonGroup left, PersonGroup right, Pattern sequence) {
        if (left.isEmpty()) {
            if (sequence.doesSolve()) addSolution(sequence);
        } else {
            if (sequence.movingRight()) {
                ArrayList<Person> people = left.getPeople();
                for (int i = 0; i < people.size(); i++) {

                    PersonGroup remaining = new PersonGroup(left);
                    Person p1 = remaining.removePerson(i);
                    ArrayList<Person> remainingPeople = remaining.getPeople();
                    for (int j = 0; j < remainingPeople.size(); j++) {
                        PersonGroup moving = new PersonGroup(p1);

                        PersonGroup newLeft = new PersonGroup(remaining);
                        moving.addPerson(newLeft.removePerson(j));


                        PersonGroup newRight = new PersonGroup(right);
                        newRight.addGroup(moving);

                        Pattern newSequence = new Pattern(sequence);
                        newSequence.addMove(moving);

                        solver(newLeft, newRight, newSequence);
                    }
                }
            } else {
                ArrayList<Person> people = right.getPeople();
                for (int i = 0; i < people.size(); i++) {
                    PersonGroup moving = new PersonGroup();
                    PersonGroup newRight = new PersonGroup(right);
                    moving.addPerson(newRight.removePerson(i));

                    PersonGroup newLeft = new PersonGroup(left);
                    newLeft.addGroup(moving);

                    Pattern newSequence = new Pattern(sequence);
                    newSequence.addMove(moving);

                    solver(newLeft, newRight, newSequence);
                }
            }
        }
    }
}
