package impl;

import entities.Student;
import services.IStudentService;

import java.util.ArrayList;

public class StudentServiceImpl implements IStudentService {
    private ArrayList<Student> studentList;

    public StudentServiceImpl() {
        this.studentList = new ArrayList<>();
    }

    @Override
    public void addStudent(Student student) {
        studentList.add(student);
    }

    @Override
    public void updateStudent(String studentId, Student updatedStudent) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getPersonId().equals(studentId)) {
                studentList.set(i, updatedStudent);
                return;
            }
        }
    }

    @Override
    public void removeStudent(String studentId) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getPersonId().equals(studentId)) {
                studentList.remove(i);
                return;
            }
        }
    }

    @Override
    public ArrayList<Student> getAllStudents() {
        return studentList;
    }
}