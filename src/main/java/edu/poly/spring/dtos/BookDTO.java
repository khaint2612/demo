package edu.poly.spring.dtos;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import edu.poly.spring.models.Author;
import edu.poly.spring.models.Category;
import edu.poly.spring.models.PublishingCompany;

public class BookDTO implements Serializable {
	@Length(max = 6)
	private String id;
	
	@NotNull
	@Length(max = 50, min = 5,message = "Tên không được quá 50 ký tự và phải nhiều hơn 5 ký tự")
	@NotEmpty(message = "Tên không được để trống")
	private String name;
	
	@NotNull
	private MultipartFile image;
	@Length(max = 50, min = 5, message = "Tên gốc không được quá 50 ký tự và phải nhiều hơn 5 ký tự")
	@NotEmpty(message = "Tên gốc không được để trống")
	private String originName;
	@NotNull
	private Set<Author> author;
	private Integer year;
	@NotNull
	private Set<Category> category;
	private String description;
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	private PublishingCompany publishingCompany;
	public String getId() {
		return id;
	}
	
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
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
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public String getOriginName() {
		return originName;
	}
	public void setOriginName(String originName) {
		this.originName = originName;
	}
	public Set<Author> getAuthor() {
		return author;
	}
	public void setAuthor(Set<Author> author) {
		this.author = author;
	}
	public Set<Category> getCategory() {
		return category;
	}
	public void setCategory(Set<Category> category) {
		this.category = category;
	}
	public PublishingCompany getPublishingCompany() {
		return publishingCompany;
	}
	public void setPublishingCompany(PublishingCompany publishingCompany) {
		this.publishingCompany = publishingCompany;
	}
	public BookDTO() {
		super();
	}
	
}
