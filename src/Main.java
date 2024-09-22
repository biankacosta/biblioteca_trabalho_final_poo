import Entities.Book;
import Entities.Library;
import Entities.Librarian;
import Entities.Student;
import Entities.User;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library bookstore = new Library(); 

        bookstore.registerUser(new Student("student1@example.com", "Alice", "1234", "S123"));
        bookstore.registerUser(new Librarian("librarian1@example.com", "Bob", "1234", "12345678900"));
        
        Boolean running = true;
        
        while(running) {
        	System.out.println("Bem-vindo à biblioteca! Escolha uma opção:");
            System.out.println("1. Entrar no sistema");
            System.out.println("2. Criar nova conta");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice == 1) {
                System.out.println("Escolha o tipo de usuário:");
                System.out.println("1. Bibliotecário");
                System.out.println("2. Estudante");
                int role = scanner.nextInt();
                scanner.nextLine(); 

                if (role == 1) {
                    System.out.println("Digite seu CPF: ");
                    String cpf = scanner.nextLine();

                    System.out.println("Digite sua senha: ");
                    String password = scanner.nextLine();

                    boolean authenticated = false;
                    for (User user : bookstore.getUsers()) {
                        if (user instanceof Librarian) {
                            Librarian librarian = (Librarian) user;
                            if (librarian.authenticateByCpf(cpf, password)) {
                                authenticated = true;
                                System.out.println("Login bem-sucedido como Bibliotecário: " + librarian);
                                break;
                            }
                        }
                    }

                    if (!authenticated) {
                        System.out.println("CPF ou senha inválidos.");
                    }

                } else if (role == 2) {
                    System.out.println("Digite seu email: ");
                    String email = scanner.nextLine();

                    System.out.println("Digite sua senha: ");
                    String password = scanner.nextLine();

                    boolean authenticated = false;
                    for (User user : bookstore.getUsers()) {
                        if (user instanceof Student) {
                            if (user.authenticate(email, password)) {
                                authenticated = true;
                                System.out.println("Login bem-sucedido como Estudante: " + user);
                                break;
                            }
                        }
                    }

                    if (!authenticated) {
                        System.out.println("Email ou senha inválidos.");
                    }
                }

            } else if (choice == 2) {
                System.out.println("Escolha o tipo de usuário para criar conta:");
                System.out.println("1. Bibliotecário");
                System.out.println("2. Estudante");
                int role = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Digite seu nome: ");
                String name = scanner.nextLine();

                System.out.println("Digite seu email: ");
                String email = scanner.nextLine();

                System.out.println("Digite uma senha: ");
                String password = scanner.nextLine();

                if (role == 1) {
                    System.out.println("Digite seu CPF: ");
                    String cpf = scanner.nextLine();
                    bookstore.registerUser(new Librarian(email, name, password, cpf));
                    System.out.println("Conta de Bibliotecário criada com sucesso!");

                } else if (role == 2) {
                    System.out.println("Digite sua matrícula: ");
                    String registration = scanner.nextLine();
                    bookstore.registerUser(new Student(email, name, password, registration));
                    System.out.println("Conta de Estudante criada com sucesso!");
                }
                
                continue;

            }
        }

        scanner.close();
    }
}
