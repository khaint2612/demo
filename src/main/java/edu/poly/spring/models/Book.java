package edu.poly.spring.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name = "book")
public class Book implements Serializable{
	@Id
	private String id;
	@Column
	private String name;
	@Column
	private String originName;
	@Column
    private Integer year;
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	@Lob
	private String description;
	@Column
	private String image;
	@ManyToMany
	@JoinTable(
			name = "category_book", 
			  joinColumns = @JoinColumn(name = "book_id"), 
			  inverseJoinColumns = {@JoinColumn(name = "category_id")})
	private Set<Category> category;
	@ManyToMany
	@JoinTable(
			  name = "author_book", 
			  joinColumns = @JoinColumn(name = "book_id"), 
			  inverseJoinColumns = {@JoinColumn(name = "author_id")})
    private Set<Author> author;
	@ManyToOne
	@JoinColumn(name="publishing_company_id")
	private PublishingCompany publishingCompany;
	
	
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
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public PublishingCompany getPublishingCompany() {
		return publishingCompany;
	}
	public void setPublishingCompany(PublishingCompany publishingCompany) {
		this.publishingCompany = publishingCompany;
	}
	
	public String getOriginName() {
		return originName;
	}
	public void setOriginName(String originName) {
		this.originName = originName;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	
	public Set<Category> getCategory() {
		return category;
	}
	public void setCategory(Set<Category> category) {
		this.category = category;
	}
	public Set<Author> getAuthor() {
		return author;
	}
	public void setAuthor(Set<Author> author) {
		this.author = author;
	}

	public Book() {
		super();
	}
	
}
