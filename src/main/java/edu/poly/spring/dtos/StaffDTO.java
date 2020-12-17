package edu.poly.spring.dtos;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.sun.istack.NotNull;

import edu.poly.spring.models.Reader;

public class StaffDTO {

	private String id;

	private String name;
	private boolean gender;
	
	private String idcard;
	

	private  MultipartFile photo;

	private String address;

	private String phone;
	
	private String email;
	


	public StaffDTO() {
		super();
	}



	public StaffDTO(String id, String name, boolean gender, String idcard, MultipartFile photo, String address,
			String phone, String email) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.idcard = idcard;
		this.photo = photo;
		this.address = address;
		this.phone = phone;
		this.email = email;
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



	public boolean isGender() {
		return gender;
	}



	public void setGender(boolean gender) {
		this.gender = gender;
	}



	public String getIdcard() {
		return idcard;
	}



	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}



	public MultipartFile getPhoto() {
		return photo;
	}



	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}
	
}
