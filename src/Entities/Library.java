package Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Library {
	
	private List<Book> catalog;
	private List<User> users;
	private Scanner scanner;
	
	public List<Book> getCatalog() {
		return catalog;
	}

	public void setCatalog(List<Book> catalog) {
		this.catalog = catalog;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Library() {
        this.catalog = new ArrayList<>();
        this.users = new ArrayList<>();
        this.scanner = new Scanner(System.in);
	}
	
	public void addBookToCatalog() {
		System.out.println("Adicionando livro...");
		catalog.add(getBookInfos());
		System.out.println("Livro adicionado com sucesso.");
	}
	
	public Book searchBookById(long id) {
        Optional<Book> bookOptional = catalog.stream()
                .filter(book -> book.getId() == id)
                .findFirst();
        
        return bookOptional.orElse(null);
    }
	
    public void viewBookDetailsById(long id) {
    	Book book = searchBookById(id);

        if (book != null) {
            System.out.println("Detalhes do Livro:\n" + book.toString());
        } else {
            System.out.println("Livro não encontrado com o ID: " + id);
        }
    }
    
    public void updateBook(long id) {
        Book book = searchBookById(id);

        if (book != null) {
            System.out.println("Atualizando informações do livro: " + book.getTitle());
            Book updatedBook = getBookInfos();

            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setStatus(updatedBook.getStatus());
            book.setIsbn(updatedBook.getIsbn());
            book.setPublisher(updatedBook.getPublisher());
            book.setPublishDate(updatedBook.getPublishDate());
            book.setQuantity(updatedBook.getQuantity());

            System.out.println("Informações do livro atualizadas com sucesso.");
        } else {
            System.out.println("Livro não encontrado com o ID: " + id);
        }
    }
    
    public void deleteBookById(long id) {
        Book book = searchBookById(id);

        if (book != null) {
            catalog.remove(book);
            System.out.println("Livro com ID " + id + " foi deletado com sucesso.");
        } else {
            System.out.println("Livro não encontrado com o ID: " + id);
        }
    }
    
    public Book getBookInfos() {
        System.out.println("Digite o título do livro: ");
        String title = scanner.nextLine();

        System.out.println("Digite os autores do livro (separados por vírgula): ");
        String authorsInput = scanner.nextLine();
        List<String> authors = Arrays.asList(authorsInput.split("\\s*,\\s*"));

        System.out.println("Digite o status do livro (DISPONIVEL, INDISPONIVEL): ");
        String statusInput = scanner.nextLine();
        BookStatus status = BookStatus.valueOf(statusInput.toUpperCase());

        System.out.println("Digite o ISBN do livro: ");
        String isbn = scanner.nextLine();

        System.out.println("Digite o nome da editora: ");
        String publisher = scanner.nextLine();

        System.out.println("Digite a data de publicação (formato AAAA-MM-DD): ");
        String publishDateInput = scanner.nextLine();
        LocalDate publishDate = LocalDate.parse(publishDateInput);

        System.out.println("Digite a quantidade de cópias do livro: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        return new Book(title, authors, status, isbn, publisher, publishDate, quantity);
    }
	
	public void registerUser(User user) {
		users.add(user);
	}
	
	public void showCatalog(){
		System.out.println("CATÁLOGO DE LIVROS:");
		for(Book book: catalog) {
			System.err.println(book.toString());
		}
	}
	
	public void showUsers(){
		System.out.println("Lista de Usuários:");
		for(User user: users) {
			System.err.println(user.toString());
		}
	}
	
}
