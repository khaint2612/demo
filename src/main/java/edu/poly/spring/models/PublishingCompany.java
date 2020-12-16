package edu.poly.spring.models;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "publishingCompany")
public class PublishingCompany implements Serializable {
	@Id
	private String id;
	@Column
	private String name;
	@OneToMany(mappedBy = "publishingCompany",cascade = CascadeType.ALL)
	private Set<Book> book;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Set<Book> getBook() {
		return book;
	}
	public void setBook(Set<Book> book) {
		this.book = book;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public PublishingCompany(String id, String name, Set<Book> book) {
		super();
		this.id = id;
		this.name = name;
		this.book = book;
	}
	public PublishingCompany() {
		super();
	}
	
}