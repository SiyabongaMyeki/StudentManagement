import java.util.*;

class Student {
    String name;
    String studentId;
    ArrayList<Integer> grades = new ArrayList<>();

    Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    void addGrade(int grade) {
        grades.add(grade);
    }

    double averageGrade() {
        int total = 0;
        for (int grade : grades) total += grade;
        return grades.isEmpty() ? 0 : (double) total / grades.size();
    }

    boolean hasPassed() {
        return averageGrade() >= 50;
    }

    void displayGrades() {
        System.out.println(name + "'s grades: " + grades);
    }
}

public class StudentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.print("\nEnter name: ");
            String name = scanner.next();
            System.out.print("Enter student ID: ");
            String id = scanner.next();

            Student student = new Student(name, id);

            System.out.print("Enter number of grades: ");
            int gCount = scanner.nextInt();
            for (int j = 0; j < gCount; j++) {
                System.out.print("Enter grade " + (j + 1) + ": ");
                student.addGrade(scanner.nextInt());
            }

            students.add(student);
        }

        double classTotal = 0;
        for (Student s : students) {
            s.displayGrades();
            double avg = s.averageGrade();
            System.out.println("Average: " + avg);
            System.out.println("Status: " + (s.hasPassed() ? "Passed" : "Failed"));
            classTotal += avg;
        }

        System.out.println("\nClass Average: " + (classTotal / students.size()));
        scanner.close();
    }
}
