package services;

import entities.Student;
import java.util.ArrayList;

public interface IStudentService {
    void addStudent(Student student);
    void updateStudent(String studentId, Student updatedStudent);
    void removeStudent(String studentId);
    ArrayList<Student> getAllStudents();
}