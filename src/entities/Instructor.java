package entities;

import java.util.ArrayList;

public class Instructor extends Person {
    private String department;
    private ArrayList<Course> courses;

    public Instructor(String personId, String personName, String department) {
        super(personId, personName);
        this.department = department;
        this.courses = new ArrayList<>();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String mainTask() {
        return "Teaching";
    }
}