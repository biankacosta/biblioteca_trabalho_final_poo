import Entities.Library;
import Entities.Librarian;
import Entities.Student;
import Entities.User;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Library bookstore = new Library();

		bookstore.registerUser(new Student("student1@example.com", "Alice", "1234", "S123"));
		bookstore.registerUser(new Librarian("librarian1@example.com", "Bob", "1234", "12345678900"));

		Boolean running = true;

		while (running) {
			System.out.println("Bem-vindo à biblioteca! Escolha uma opção:");
			System.out.println("1. Entrar no sistema");
			System.out.println("2. Criar nova conta");

			int choice;
			try {
				choice = scanner.nextInt();
				scanner.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
				scanner.nextLine();
				continue;
			}

			if (choice == 1) {
				boolean validRole = false;
				while (!validRole) {
					System.out.println("Escolha o tipo de usuário:");
					System.out.println("1. Bibliotecário");
					System.out.println("2. Estudante");
					System.out.println("3. Voltar");

					int role;
					try {
						role = scanner.nextInt();
						scanner.nextLine();
					} catch (InputMismatchException e) {
						System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
						scanner.nextLine();
						continue;
					}

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
									validRole = true;
									librarianInterface(bookstore);
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
									validRole = true;
									break;
								}
							}
						}

						if (!authenticated) {
							System.out.println("Email ou senha inválidos.");
						}
					} else if (role == 3) {
						validRole = true;
					} else {
						System.out.println("Entrada inválida. Por favor, tente novamente.");
						continue;
					}
				}

			} else if (choice == 2) {
				boolean validRole = false;
				while (!validRole) {
					System.out.println("Escolha o tipo de usuário para criar conta:");
					System.out.println("1. Bibliotecário");
					System.out.println("2. Estudante");
					System.out.println("3. Voltar");

					int role;
					try {
						role = scanner.nextInt();
						scanner.nextLine();
					} catch (InputMismatchException e) {
						System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
						scanner.nextLine();
						continue;
					}

					if (role == 1) {
						System.out.println("Digite seu CPF: ");
						String cpf = scanner.nextLine();

						System.out.println("Digite seu nome: ");
						String name = scanner.nextLine();

						System.out.println("Digite seu email: ");
						String email = scanner.nextLine();

						System.out.println("Digite uma senha: ");
						String password = scanner.nextLine();

						bookstore.registerUser(new Librarian(email, name, password, cpf));
						System.out.println("Conta de Bibliotecário criada com sucesso!");
						validRole = true;

					} else if (role == 2) {
						System.out.println("Digite sua matrícula: ");
						String registration = scanner.nextLine();

						System.out.println("Digite seu nome: ");
						String name = scanner.nextLine();

						System.out.println("Digite seu email: ");
						String email = scanner.nextLine();

						System.out.println("Digite uma senha: ");
						String password = scanner.nextLine();

						bookstore.registerUser(new Student(email, name, password, registration));
						System.out.println("Conta de Estudante criada com sucesso!");
						validRole = true;
					} else if (role == 3) {
						validRole = true;
					} else {
						System.out.println("Entrada inválida. Por favor, tente novamente com uma das opções a seguir.");
					}

					continue;

				}
			} else {
				System.out.println("Entrada inválida. Por favor, tente novamente com uma das opções a seguir.");
			}
		}

		scanner.close();
	}

	private static void librarianInterface(Library bookstore) {
		Scanner scanner = new Scanner(System.in);

		Boolean running = true;

		while (running) {
			System.out.println("Escolha uma opção:");
			System.out.println("1. Adicionar livro");
			System.out.println("2. Ver livro");
			System.out.println("3. Atualizar livro");
			System.out.println("4. Deletar livro");
			System.out.println("5. Ver catálogo");
			System.out.println("6. Ver empréstimos");
			System.out.println("7. Ver lista de usuários");
			System.out.println("8. Ver usuário");
			System.out.println("9. Atualizar usuário");
			System.out.println("10. Deletar usuário");
			System.out.println("11. Sair da sessão");

			int choice;
			try {
				choice = scanner.nextInt();
				scanner.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
				scanner.nextLine();
				continue;
			}

			if (choice == 1) {
				bookstore.addBookToCatalog();
				
			} else if (choice == 2) {
				System.out.println("Digite o ID do livro que deseja ver: ");
				Long id = scanner.nextLong();
				bookstore.viewBookDetailsById(id);
				
			} else if (choice == 3) {
				System.out.println("Digite o ID do livro que deseja atualizar: ");
				Long id = scanner.nextLong();
				bookstore.updateBook(id);
				
			} else if (choice == 4) {
				System.out.println("Digite o ID do livro que deseja deletar: ");
				Long id = scanner.nextLong();
				bookstore.deleteBookById(id);
				
			} else if (choice == 5) {
				bookstore.showCatalog();
				
			} else if (choice == 6) {
				System.out.println("A ser feito...");
				
			} else if (choice == 7) {
				System.out.println("Lista de usuários cadastrados: ");
				bookstore.showUsers();
				
			} else if (choice == 8) {
				System.out.println("A ser feito...");
				
			} else if (choice == 9) {
				System.out.println("A ser feito...");
				
			} else if (choice == 10) {
				System.out.println("A ser feito...");
				
			} else if (choice == 11) {
				break;
				
			} else {
				System.out.println("Entrada inválida. Por favor, tente novamente com uma das opções a seguir.");
			}

		}
	}
}
