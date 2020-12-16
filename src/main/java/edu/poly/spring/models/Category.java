package edu.poly.spring.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category implements Serializable {
	@Id
	private String id;
	@Column
	private String name;
	@ManyToMany
	private Set<Book> book;
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
	
	public Category(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Category() {
		super();
	}
	
}
