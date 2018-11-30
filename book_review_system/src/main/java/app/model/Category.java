package app.model;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String description;
	private List<Book> books;
	
	public Category(Integer id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Category() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	
}
