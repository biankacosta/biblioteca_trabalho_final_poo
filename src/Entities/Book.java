package Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Book extends BaseModel {
	
	private String title;
	private List<String> author;
	private BookStatus status;
	private String isbn;
	private String publisher;
	private LocalDate publishDate;
	
	public Book(String title, List<String> author, BookStatus status, String isbn, String publisher,
			LocalDate publishDate, Integer quantity) {
		super();
		this.title = title;
		this.author = author;
		this.status = status;
		this.isbn = isbn;
		this.publisher = publisher;
		this.publishDate = publishDate;
		this.quantity = quantity;
	}

	private Integer quantity;

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
    
	public Integer getQuantity() {
		return quantity;
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
