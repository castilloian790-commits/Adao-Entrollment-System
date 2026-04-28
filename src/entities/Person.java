package entities;

public abstract class Person {
    private String personId;
    private String personName;

    public Person(String personId, String personName) {
        this.personId = personId;
        this.personName = personName;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public abstract String mainTask();
}