package edu.poly.spring.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "poster")
public class Poster implements Serializable {
	@Id
	private String id;
	@Column
	private String name;
	@Column
	private String typeOfBook;
	@Column
	private String nameAuthor;
	@Column
	private String image;
	@Column
	private String namePublishingCompany;
	@Column
	private Integer page;
	//Tóm tắt nội dung
	@Column
	private String summary;
	@Column
	private Integer publishingYear;
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="book_id")
	private Book book;
	
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
	public String getTypeOfBook() {
		return typeOfBook;
	}
	public void setTypeOfBook(String typeOfBook) {
		this.typeOfBook = typeOfBook;
	}
	public String getNameAuthor() {
		return nameAuthor;
	}
	public void setNameAuthor(String nameAuthor) {
		this.nameAuthor = nameAuthor;
	}
	public String getNamePublishingCompany() {
		return namePublishingCompany;
	}
	public void setNamePublishingCompany(String namePublishingCompany) {
		this.namePublishingCompany = namePublishingCompany;
	}
	public Integer getPage() {
		return page;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Integer getPublishingYear() {
		return publishingYear;
	}
	public void setPublishingYear(Integer publishingYear) {
		this.publishingYear = publishingYear;
	}
	public Poster(String id, String name, String image, String typeOfBook, String nameAuthor, String namePublishingCompany,
			Integer page, String summary, Integer publishingYear) {
		super();
		this.id = id;
		this.name = name;
		this.typeOfBook = typeOfBook;
		this.nameAuthor = nameAuthor;
		this.namePublishingCompany = namePublishingCompany;
		this.page = page;
		this.image = image;
		this.summary = summary;
		this.publishingYear = publishingYear;
	}
	public Poster() {
		super();
	}
	
}
