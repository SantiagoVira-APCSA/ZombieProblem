import java.util.ArrayList;

public class PersonGroup {
    private ArrayList<Person> people;

    @Override
    public String toString() {
        return "People: " + people +
                ", crossTime = " + getCrossTime();
    }

    public PersonGroup() {
        people = new ArrayList<Person>();
    }

    public PersonGroup(Person p1) {
        people = new ArrayList<Person>();
        people.add(p1);
    }

    public PersonGroup(Person p1, Person p2) {
        people = new ArrayList<Person>();
        people.add(p1);
        people.add(p2);
    }

    public PersonGroup(PersonGroup pg) {
        people = new ArrayList<Person>();

        for (Person p : pg.people) {
            addPerson(p.getName(), p.getCrossTime());
        }
    }

    public int getCrossTime() {
        int crossTime = 0;
        for (Person p : people) {
            if (p.getCrossTime() > crossTime) crossTime = p.getCrossTime();
        }
        return crossTime;
    }

    public void addPerson(Person p) {
        people.add(p);
    }

    public void addPerson(String name, int crossTime) {
        people.add(new Person(name, crossTime));
    }

    public void addGroup(PersonGroup pg) {
        for (Person p : pg.people) {
            addPerson(p);
        }
    }

    public void removePerson(Person p) {
        if (contains(p)) {
            people.remove(p);
        }
    }

    public Person removePerson(int i) {
        return people.remove(i);
    }

    public void removeGroup(PersonGroup pg) {
        for (Person p : pg.people) {
            removePerson(p);
        }
    }

    public boolean contains(Person target) {
        for (Person p : people) {
            if (p.equals(target))
                return true;
        }
        return false;
    }

    public boolean containsAll(PersonGroup target) {
        for (Person p : target.people) {
            if (!contains(p)) return false;
        }
        return true;
    }

    public Person getByName(String name) {
        for (Person p : people) {
            if (p.getName().equals(name)) return p;
        }
        return null;
    }

    public boolean isEmpty() {
        return people.size() == 0;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PersonGroup p)) return false;
        return containsAll(p);
    }
}
