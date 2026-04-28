package services;

import entities.Instructor;
import entities.Section;
import java.util.ArrayList;

public interface IInstructorService {
    void addInstructor(Instructor instructor);
    void updateInstructor(String instructorId, Instructor updatedInstructor);
    void removeInstructor(String instructorId);
    Instructor getInstructorDetails(String instructorId);
    ArrayList<Instructor> getAllInstructors();
    void assignInstructorToSection(Instructor instructor, Section section);
}