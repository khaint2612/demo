package edu.poly.spring.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "library")
public class Library implements Serializable{
	@Id
	private String id;
	@Column
	private String name;
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
	public Library(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Library() {
		super();
	}
	
}
