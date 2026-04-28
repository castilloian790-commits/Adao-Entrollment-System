package services;

import entities.Instructor;
import entities.Section;
import java.util.ArrayList;
import exceptions.DuplicateIdException;

public interface IInstructorService {
    void addInstructor(Instructor instructor) throws DuplicateIdException;
    void updateInstructor(String instructorId, Instructor updatedInstructor);
    void removeInstructor(String instructorId);
    Instructor getInstructorDetails(String instructorId);
    ArrayList<Instructor> getAllInstructors();
    void assignInstructorToSection(Instructor instructor, Section section);
}