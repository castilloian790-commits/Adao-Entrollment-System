package entities;

public class Course {
    private String courseId;
    private String courseName;
    private String program;
    private int units;

    public Course(String courseId, String courseName, String program, int units) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.program = program;
        this.units = units;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }
}