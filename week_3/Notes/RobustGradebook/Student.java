package week_3.Notes.RobustGradebook;

public class Student {

    String fullName = "";
    int[] grades;

    public Student(String fName, int[] grades) {
        this.fullName = fName;
        this.grades = grades;
    }

    public void describe() {
        System.out.println("Student: " + this.fullName);
        System.out.println("Grades:");
        for (int grade : this.grades) {
            System.out.println("\t" + grade + " ");
        }
        System.out.println();
    }

}
