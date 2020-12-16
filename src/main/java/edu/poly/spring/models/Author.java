package edu.poly.spring.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "author")
public class Author implements Serializable {
	@Id
	private String id;
	@Column
	private String name;
	public String getId() {
		return id;
	}
	@ManyToMany
	private Set<Book> book;
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Author(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Author() {
		super();
	}
	
}
