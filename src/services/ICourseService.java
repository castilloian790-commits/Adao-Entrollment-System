package services;

import entities.Course;
import java.util.ArrayList;
import exceptions.DuplicateIdException;
public interface ICourseService {
    void addCourse(Course course) throws DuplicateIdException;
    void updateCourse(String courseId, Course updatedCourse);
    void removeCourse(String courseId);
    ArrayList<Course> getAllCourses();
}