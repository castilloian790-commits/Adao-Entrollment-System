package services;

import entities.Department;
import entities.Section;
import entities.Student;

public interface IEnrollmentService {
    void enrollStudentInSection(Student student, Section section);
    void viewDepartmentHierarchy(Department department);
}