public class Person {
    private final String name;
    private final int crossTime;

    @Override
    public String toString() {
        return name +
                ": crossTime = " + crossTime;
    }

    public Person(String name, int crossTime) {
        this.name = name;
        this.crossTime = crossTime;
    }

    public int getCrossTime() {
        return crossTime;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person p)) return false;
        return name.equals(p.name) && crossTime == p.crossTime;
    }
}
