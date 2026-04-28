package impl;

import entities.Instructor;
import entities.Section;
import services.IInstructorService;

import java.util.ArrayList;
import exceptions.DuplicateIdException;
public class InstructorServiceImpl implements IInstructorService {
    private ArrayList<Instructor> instructorList;

    public InstructorServiceImpl() {
        this.instructorList = new ArrayList<>();
    }

    @Override
    public void addInstructor(Instructor instructor) throws DuplicateIdException {
        for (Instructor existing : instructorList) {
            if (existing.getPersonId().equals(instructor.getPersonId())) {
                throw new DuplicateIdException(
                        "Cannot add instructor: ID '" + instructor.getPersonId() + "' already exists."
                );
            }
        }
        instructorList.add(instructor);
    }
    @Override
    public void updateInstructor(String instructorId, Instructor updatedInstructor) {
        for (int i = 0; i < instructorList.size(); i++) {
            if (instructorList.get(i).getPersonId().equals(instructorId)) {
                instructorList.set(i, updatedInstructor);
                return;
            }
        }
    }

    @Override
    public void removeInstructor(String instructorId) {
        for (int i = 0; i < instructorList.size(); i++) {
            if (instructorList.get(i).getPersonId().equals(instructorId)) {
                instructorList.remove(i);
                return;
            }
        }
    }

    @Override
    public Instructor getInstructorDetails(String instructorId) {
        for (Instructor instructor : instructorList) {
            if (instructor.getPersonId().equals(instructorId)) {
                return instructor;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Instructor> getAllInstructors() {
        return instructorList;
    }

    @Override
    public void assignInstructorToSection(Instructor instructor, Section section) {
        section.setInstructor(instructor);
    }
}