package services;

import entities.Course;
import java.util.ArrayList;

public interface ICourseService {
    void addCourse(Course course);
    void updateCourse(String courseId, Course updatedCourse);
    void removeCourse(String courseId);
    ArrayList<Course> getAllCourses();
}