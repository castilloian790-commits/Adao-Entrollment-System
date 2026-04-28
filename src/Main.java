import entities.Course;
import entities.Department;
import entities.Instructor;
import entities.Section;
import entities.Student;
import entities.TuitionFeePayment;
import exceptions.SectionFullException;
import impl.CourseServiceImpl;
import impl.EnrollmentServiceImpl;
import impl.InstructorServiceImpl;
import impl.StudentServiceImpl;
import impl.TuitionServiceImpl;
import services.ICourseService;
import services.IEnrollmentService;
import services.IInstructorService;
import services.IStudentService;
import services.ITuitionService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static final IStudentService studentService = new StudentServiceImpl();
    private static final IInstructorService instructorService = new InstructorServiceImpl();
    private static final ICourseService courseService = new CourseServiceImpl();
    private static final ITuitionService tuitionService = new TuitionServiceImpl();
    private static final IEnrollmentService enrollmentService = new EnrollmentServiceImpl();

    private static final ArrayList<Department> departmentList = new ArrayList<>();
    private static final HashMap<String, TuitionFeePayment> tuitionRecords = new HashMap<>();

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        seedSampleData();
        runMainMenu();
    }

    private static void seedSampleData() {
        Department ccs = new Department("College of Computer Studies");
        departmentList.add(ccs);

        Section bsit1A = new Section("BSIT-1A", 30);
        Section bsit1B = new Section("BSIT-1B", 30);
        ccs.getSections().add(bsit1A);
        ccs.getSections().add(bsit1B);

        courseService.addCourse(new Course("C001", "Integrative Programming", "Information Technology", 3));
        courseService.addCourse(new Course("C002", "Data Structures", "Information Technology", 3));
        courseService.addCourse(new Course("C003", "Web Development", "Information Technology", 3));

        Instructor lopez = new Instructor("I001", "Dr. Lopez", "Computer Studies");
        Instructor santos = new Instructor("I002", "Prof. Santos", "Computer Studies");
        instructorService.addInstructor(lopez);
        instructorService.addInstructor(santos);
        instructorService.assignInstructorToSection(lopez, bsit1A);

        studentService.addStudent(new Student("S001", "John Doe", "Information Technology"));
        studentService.addStudent(new Student("S002", "Jane Smith", "Information Technology"));
    }

    private static void runMainMenu() {
        while (true) {
            System.out.println();
            System.out.println("=== Adao Enrollment System ===");
            System.out.println("[1] Student Management");
            System.out.println("[2] Instructor Management");
            System.out.println("[3] Course Management");
            System.out.println("[4] Department & Section Management");
            System.out.println("[5] Enrollment");
            System.out.println("[6] Tuition Fee Management");
            System.out.println("[7] View Department Hierarchy");
            System.out.println("[0] Exit");
            String choice = readString("Choice: ");

            switch (choice) {
                case "1": studentMenu(); break;
                case "2": instructorMenu(); break;
                case "3": courseMenu(); break;
                case "4": departmentMenu(); break;
                case "5": enrollmentMenu(); break;
                case "6": tuitionMenu(); break;
                case "7": hierarchyMenu(); break;
                case "0":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Placeholder sub-menus — filled in over the next parts
    private static void studentMenu() {
        System.out.println("Student menu — not yet implemented");
    }

    private static void instructorMenu() {
        System.out.println("Instructor menu — not yet implemented");
    }

    private static void courseMenu() {
        System.out.println("Course menu — not yet implemented");
    }

    private static void departmentMenu() {
        System.out.println("Department & Section menu — not yet implemented");
    }

    private static void enrollmentMenu() {
        System.out.println("Enrollment menu — not yet implemented");
    }

    private static void tuitionMenu() {
        System.out.println("Tuition menu — not yet implemented");
    }

    private static void hierarchyMenu() {
        System.out.println("Hierarchy menu — not yet implemented");
    }

    // Input helpers
    private static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static int readInt(String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(scanner.nextLine());
    }

    private static double readDouble(String prompt) {
        System.out.print(prompt);
        return Double.parseDouble(scanner.nextLine());
    }
}