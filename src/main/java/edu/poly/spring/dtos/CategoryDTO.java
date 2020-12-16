package edu.poly.spring.dtos;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import edu.poly.spring.models.Book;

public class CategoryDTO {
	@Length(max = 6, min = 6, message = "Phải nhập đủ 6 ký tự")
	private String id;
	@NotNull
	@NotEmpty(message = "Không được để trống")
	@Length(max = 50, message = "Không được nhập quá 50 chữ")
	private String name;
	
	public CategoryDTO() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Book> getBook() {
		return book;
	}

	public void setBook(Set<Book> book) {
		this.book = book;
	}

	private Set<Book> book;
}
