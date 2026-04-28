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
        while (true) {
            System.out.println();
            System.out.println("--- Student Management ---");
            System.out.println("[1] Add Student");
            System.out.println("[2] Display All Students");
            System.out.println("[3] Update Student");
            System.out.println("[4] Remove Student");
            System.out.println("[0] Back to Main Menu");
            String choice = readString("Choice: ");

            switch (choice) {
                case "1":
                    String id = readString("Enter Student ID: ");
                    String name = readString("Enter Student Name: ");
                    String program = readString("Enter Program: ");
                    studentService.addStudent(new Student(id, name, program));
                    System.out.println("Student added.");
                    break;
                case "2":
                    ArrayList<Student> students = studentService.getAllStudents();
                    if (students.isEmpty()) {
                        System.out.println("No students in the system.");
                    } else {
                        for (Student s : students) {
                            System.out.println("Student ID: " + s.getPersonId()
                                    + " | Name: " + s.getPersonName()
                                    + " | Program: " + s.getProgram());
                        }
                    }
                    break;
                case "3":
                    String updateId = readString("Enter Student ID to update: ");
                    String newName = readString("Enter New Name: ");
                    String newProgram = readString("Enter New Program: ");
                    studentService.updateStudent(updateId, new Student(updateId, newName, newProgram));
                    System.out.println("Student updated.");
                    break;
                case "4":
                    String removeId = readString("Enter Student ID to remove: ");
                    studentService.removeStudent(removeId);
                    System.out.println("Student removed.");
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    private static void instructorMenu() {
        while (true) {
            System.out.println();
            System.out.println("--- Instructor Management ---");
            System.out.println("[1] Add Instructor");
            System.out.println("[2] Display All Instructors");
            System.out.println("[3] Update Instructor");
            System.out.println("[4] Remove Instructor");
            System.out.println("[5] Get Instructor Details");
            System.out.println("[6] Assign Instructor to Section");
            System.out.println("[0] Back to Main Menu");
            String choice = readString("Choice: ");

            switch (choice) {
                case "1":
                    String id = readString("Enter Instructor ID: ");
                    String name = readString("Enter Instructor Name: ");
                    String department = readString("Enter Department: ");
                    instructorService.addInstructor(new Instructor(id, name, department));
                    System.out.println("Instructor added.");
                    break;
                case "2":
                    ArrayList<Instructor> instructors = instructorService.getAllInstructors();
                    if (instructors.isEmpty()) {
                        System.out.println("No instructors in the system.");
                    } else {
                        for (Instructor i : instructors) {
                            System.out.println("Instructor ID: " + i.getPersonId()
                                    + " | Name: " + i.getPersonName()
                                    + " | Department: " + i.getDepartment());
                        }
                    }
                    break;
                case "3":
                    String updateId = readString("Enter Instructor ID to update: ");
                    String newName = readString("Enter New Name: ");
                    String newDept = readString("Enter New Department: ");
                    instructorService.updateInstructor(updateId, new Instructor(updateId, newName, newDept));
                    System.out.println("Instructor updated.");
                    break;
                case "4":
                    String removeId = readString("Enter Instructor ID to remove: ");
                    instructorService.removeInstructor(removeId);
                    System.out.println("Instructor removed.");
                    break;
                case "5":
                    String detailId = readString("Enter Instructor ID: ");
                    Instructor found = instructorService.getInstructorDetails(detailId);
                    if (found == null) {
                        System.out.println("Instructor not found.");
                    } else {
                        System.out.println("Instructor ID: " + found.getPersonId());
                        System.out.println("Name: " + found.getPersonName());
                        System.out.println("Department: " + found.getDepartment());
                        System.out.println("Main Task: " + found.mainTask());
                    }
                    break;
                case "6":
                    String instId = readString("Enter Instructor ID: ");
                    Instructor inst = instructorService.getInstructorDetails(instId);
                    if (inst == null) {
                        System.out.println("Instructor not found.");
                        break;
                    }
                    Section sec = pickSection();
                    if (sec == null) {
                        break;
                    }
                    instructorService.assignInstructorToSection(inst, sec);
                    System.out.println("Assigned " + inst.getPersonName() + " to " + sec.getSectionName() + ".");
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void courseMenu() {
        while (true) {
            System.out.println();
            System.out.println("--- Course Management ---");
            System.out.println("[1] Add Course");
            System.out.println("[2] Display All Courses");
            System.out.println("[3] Update Course");
            System.out.println("[4] Remove Course");
            System.out.println("[0] Back to Main Menu");
            String choice = readString("Choice: ");

            switch (choice) {
                case "1":
                    String id = readString("Enter Course ID: ");
                    String name = readString("Enter Course Name: ");
                    String program = readString("Enter Program: ");
                    int units = readInt("Enter Units: ");
                    courseService.addCourse(new Course(id, name, program, units));
                    System.out.println("Course added.");
                    break;
                case "2":
                    ArrayList<Course> courses = courseService.getAllCourses();
                    if (courses.isEmpty()) {
                        System.out.println("No courses in the system.");
                    } else {
                        for (Course c : courses) {
                            System.out.println("Course ID: " + c.getCourseId()
                                    + " | Name: " + c.getCourseName()
                                    + " | Program: " + c.getProgram()
                                    + " | Units: " + c.getUnits());
                        }
                    }
                    break;
                case "3":
                    String updateId = readString("Enter Course ID to update: ");
                    String newName = readString("Enter New Course Name: ");
                    String newProgram = readString("Enter New Program: ");
                    int newUnits = readInt("Enter New Units: ");
                    courseService.updateCourse(updateId, new Course(updateId, newName, newProgram, newUnits));
                    System.out.println("Course updated.");
                    break;
                case "4":
                    String removeId = readString("Enter Course ID to remove: ");
                    courseService.removeCourse(removeId);
                    System.out.println("Course removed.");
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void departmentMenu() {
        while (true) {
            System.out.println();
            System.out.println("--- Department & Section Management ---");
            System.out.println("[1] Add Department");
            System.out.println("[2] Display All Departments");
            System.out.println("[3] Add Section to a Department");
            System.out.println("[4] Display Sections of a Department");
            System.out.println("[0] Back to Main Menu");
            String choice = readString("Choice: ");

            switch (choice) {
                case "1":
                    String deptName = readString("Enter Department Name: ");
                    departmentList.add(new Department(deptName));
                    System.out.println("Department added.");
                    break;
                case "2":
                    if (departmentList.isEmpty()) {
                        System.out.println("No departments in the system.");
                    } else {
                        for (Department d : departmentList) {
                            System.out.println("- " + d.getDepartmentName()
                                    + " (" + d.getSections().size() + " section(s))");
                        }
                    }
                    break;
                case "3":
                    Department dept = pickDepartment();
                    if (dept == null) break;
                    String secName = readString("Enter Section Name (e.g., BSIT-1A): ");
                    int capacity = readInt("Enter Max Capacity: ");
                    dept.getSections().add(new Section(secName, capacity));
                    System.out.println("Section added to " + dept.getDepartmentName() + ".");
                    break;
                case "4":
                    Department dept2 = pickDepartment();
                    if (dept2 == null) break;
                    if (dept2.getSections().isEmpty()) {
                        System.out.println("No sections in " + dept2.getDepartmentName() + ".");
                    } else {
                        for (Section s : dept2.getSections()) {
                            System.out.println("- " + s.getSectionName()
                                    + " (" + s.getEnrolledStudents().size() + "/" + s.getMaxCapacity() + ")");
                        }
                    }
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
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

    // Selection helpers
    private static Department pickDepartment() {
        if (departmentList.isEmpty()) {
            System.out.println("No departments exist yet.");
            return null;
        }
        System.out.println("Departments:");
        for (int i = 0; i < departmentList.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + departmentList.get(i).getDepartmentName());
        }
        int idx = readInt("Pick department number: ") - 1;
        if (idx < 0 || idx >= departmentList.size()) {
            System.out.println("Invalid department number.");
            return null;
        }
        return departmentList.get(idx);
    }

    private static Section pickSection() {
        ArrayList<Section> allSections = new ArrayList<>();
        for (Department d : departmentList) {
            allSections.addAll(d.getSections());
        }
        if (allSections.isEmpty()) {
            System.out.println("No sections exist in any department yet.");
            return null;
        }
        System.out.println("Available sections:");
        for (int i = 0; i < allSections.size(); i++) {
            Section s = allSections.get(i);
            System.out.println("[" + (i + 1) + "] " + s.getSectionName()
                    + " (" + s.getEnrolledStudents().size() + "/" + s.getMaxCapacity() + ")");
        }
        int idx = readInt("Pick section number: ") - 1;
        if (idx < 0 || idx >= allSections.size()) {
            System.out.println("Invalid section number.");
            return null;
        }
        return allSections.get(idx);
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