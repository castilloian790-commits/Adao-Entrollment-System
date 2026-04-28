package impl;

import entities.Department;
import entities.Section;
import entities.Student;
import exceptions.SectionFullException;
import services.IEnrollmentService;

public class EnrollmentServiceImpl implements IEnrollmentService {

    @Override
    public void enrollStudentInSection(Student student, Section section) throws SectionFullException {
        if (section.getEnrolledStudents().size() >= section.getMaxCapacity()) {
            throw new SectionFullException(
                    "Enrollment failed: " + section.getSectionName() + " is currently full."
            );
        }
        section.getEnrolledStudents().add(student);
    }

    @Override
    public void viewDepartmentHierarchy(Department department) {
        System.out.println("=== Department: " + department.getDepartmentName() + " ===");

        if (department.getSections().isEmpty()) {
            System.out.println("  (no sections in this department yet)");
            return;
        }

        for (Section section : department.getSections()) {
            System.out.println();
            System.out.println("  Section: " + section.getSectionName());
            System.out.println("  Capacity: " + section.getEnrolledStudents().size()
                    + " / " + section.getMaxCapacity());

            if (section.getInstructor() != null) {
                System.out.println("  Instructor: " + section.getInstructor().getPersonName()
                        + " (ID: " + section.getInstructor().getPersonId() + ")");
            } else {
                System.out.println("  Instructor: (not yet assigned)");
            }

            if (section.getEnrolledStudents().isEmpty()) {
                System.out.println("  Students: (none enrolled)");
            } else {
                System.out.println("  Students:");
                for (Student student : section.getEnrolledStudents()) {
                    System.out.println("    - " + student.getPersonName()
                            + " (ID: " + student.getPersonId()
                            + ", " + student.getProgram() + ")");
                }
            }
        }
        System.out.println();
    }
}