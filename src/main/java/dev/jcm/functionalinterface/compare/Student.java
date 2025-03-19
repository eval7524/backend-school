package dev.jcm.functionalinterface.compare;


// Comparable
// Comparator
public class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // CompareTo
    @Override
    public int compareTo(Student o) {
        return Integer.compare(score, o.score);
    }

    // Getter
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    // toString
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
