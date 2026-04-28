package impl;

import entities.Course;
import services.ICourseService;

import java.util.ArrayList;
import exceptions.DuplicateIdException;
public class CourseServiceImpl implements ICourseService {
    private ArrayList<Course> courseList;

    public CourseServiceImpl() {
        this.courseList = new ArrayList<>();
    }

    @Override
    public void addCourse(Course course) throws DuplicateIdException {
        for (Course existing : courseList) {
            if (existing.getCourseId().equals(course.getCourseId())) {
                throw new DuplicateIdException(
                        "Cannot add course: ID '" + course.getCourseId() + "' already exists."
                );
            }
        }
        courseList.add(course);
    }
    @Override
    public void updateCourse(String courseId, Course updatedCourse) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseId().equals(courseId)) {
                courseList.set(i, updatedCourse);
                return;
            }
        }
    }

    @Override
    public void removeCourse(String courseId) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseId().equals(courseId)) {
                courseList.remove(i);
                return;
            }
        }
    }

    @Override
    public ArrayList<Course> getAllCourses() {
        return courseList;
    }
}