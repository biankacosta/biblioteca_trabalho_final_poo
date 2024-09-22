package Entities;

public class Librarian extends User {
    private String cpf;

    public Librarian(String email, String name, String password, String cpf) {
        super(email, name, password);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean authenticateByCpf(String cpf, String password) {
        return this.cpf.equals(cpf) && getPassword().equals(password);
    }

    @Override
    public String toString() {
        return "Bibliotecário: " + getName() + ", Email: " + getEmail() + ", CPF: " + cpf;
    }
}
