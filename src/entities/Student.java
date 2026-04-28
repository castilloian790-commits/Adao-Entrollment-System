package entities;

public class Student extends Person {
    private String program;

    public Student(String personId, String personName, String program) {
        super(personId, personName);
        this.program = program;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    @Override
    public String mainTask() {
        return "Studying";
    }
}