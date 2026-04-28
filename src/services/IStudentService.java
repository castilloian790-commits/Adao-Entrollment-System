package services;

import entities.Student;
import java.util.ArrayList;
import exceptions.DuplicateIdException;

public interface IStudentService {
    void addStudent(Student student) throws DuplicateIdException;
    void updateStudent(String studentId, Student updatedStudent);
    void removeStudent(String studentId);
    ArrayList<Student> getAllStudents();
}