package edu.poly.spring.dtos;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import edu.poly.spring.models.Author;
import edu.poly.spring.models.Category;
import edu.poly.spring.models.PublishingCompany;

public class BookDTO implements Serializable {

	private String id;
	
	private String name;

	private String originName;

    private Integer year;
	
	
	private String description;

	private  MultipartFile photo;

	public BookDTO(String id, String name, String originName, Integer year, String description, MultipartFile photo) {
		super();
		this.id = id;
		this.name = name;
		this.originName = originName;
		this.year = year;
		this.description = description;
		this.photo = photo;
	}

	public BookDTO() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
}
