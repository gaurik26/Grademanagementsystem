import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String grade;
    private String className;

    public Student(String name, int rollNumber, String grade, String className) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Roll Number: " + rollNumber + ", Name: " + name + ", Grade: " + grade + ", Class: " + className;
    }
}

public class StudentGradeCalculator {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nStudent Grade Management System");
            System.out.println("1. Insert Student Data");
            System.out.println("2. Edit Student Data");
            System.out.println("3. Delete Student Data");
            System.out.println("4. View All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    insertStudent();
                    break;
                case 2:
                    editStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    viewAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Insert student data
    public static void insertStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();

        System.out.print("Enter class: ");
        String className = scanner.nextLine();

        // Create and add the student to the list
        Student student = new Student(name, rollNumber, grade, className);
        students.add(student);
        System.out.println("Student added successfully!");
    }

    // Edit student data
    public static void editStudent() {
        System.out.print("Enter the roll number of the student to edit: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        Student student = findStudentByRollNumber(rollNumber);
        if (student != null) {
            // Update the student's information
            System.out.print("Enter new name: ");
            student.setName(scanner.nextLine());

            System.out.print("Enter new grade: ");
            student.setGrade(scanner.nextLine());

            System.out.print("Enter new class: ");
            student.setClassName(scanner.nextLine());

            System.out.println("Student data updated successfully!");
        } else {
            System.out.println("Student with roll number " + rollNumber + " not found.");
        }
    }

    // Delete student data
    public static void deleteStudent() {
        System.out.print("Enter the roll number of the student to delete: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        Student student = findStudentByRollNumber(rollNumber);
        if (student != null) {
            students.remove(student);
            System.out.println("Student with roll number " + rollNumber + " has been deleted.");
        } else {
            System.out.println("Student with roll number " + rollNumber + " not found.");
        }
    }

    // View all students
    public static void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            System.out.println("\nList of all students:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    // Find student by roll number
    private static Student findStudentByRollNumber(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null; // Student not found
    }
}
