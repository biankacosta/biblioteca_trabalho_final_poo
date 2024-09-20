package Entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Book extends BaseModel {
	private String title;
	private List<String> author;
	private BookStatus status;
	private String isbn;
	private String publisher;
	private LocalDate publishDate;
	
	private Book(String title, List<String> author, BookStatus status, String isbn, String publisher, LocalDate publishDate) {
		super();
        this.title = title;
        this.author = author;
        this.status = status;
        this.isbn = isbn;
        this.publisher = publisher;
        this.publishDate = publishDate;
    }
	
	public static Book criarLivro(String title, List<String> author, BookStatus status, String isbn, String publisher, LocalDate publishDate) {
        return new Book(title, author, status, isbn, publisher, publishDate);
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAuthor() {
        return author;
    }

    public BookStatus getStatus() {
        return status;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }
	
	@Override
	public String toString() {
		return "Informações do Livro " + title + '\n' +
                "Autores: " + String.join(", ", author) + '\n' +
                "Status: " + status + '\n' +
                "Isbn: '" + isbn + '\n' +
                "Editora: " + publisher + '\n' +
                "Data de publicação: " + publishDate;
	}
	

}
