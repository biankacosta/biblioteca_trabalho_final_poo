package Entities;

public class Student extends User {
    private String registration;

    public Student(String email, String name, String password, String registration) {
        super(email, name, password);
        this.registration = registration;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    @Override
    public String toString() {
        return "Estudante: " + getName() + ", Email: " + getEmail() + ", Registro: " + registration;
    }
}
