package edu.poly.spring.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class AuthorDTO implements Serializable{
	@Length(max = 6,min = 6,message = "Nhap du 6 ky tu")
	private String id;
	@NotNull
	@Length(max = 50, message = "Khong duoc vuot qua 50 ky tu")
	@NotEmpty(message = "Ten van con trong")
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

	public AuthorDTO() {
		super();
	}
	
	
}
