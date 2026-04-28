package services;

import entities.Department;
import entities.Section;
import entities.Student;
import exceptions.SectionFullException;

public interface IEnrollmentService {
    void enrollStudentInSection(Student student, Section section) throws SectionFullException;
    void viewDepartmentHierarchy(Department department);
}