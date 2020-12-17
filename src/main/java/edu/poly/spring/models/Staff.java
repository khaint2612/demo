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
@Table(name = "staff")
public class Staff implements Serializable{
	
	@Id
	@Column
	private String id;
	
	@Column
	private String name;
	
	@Column
	private String address;
	
	@Column
	private String numberPhone;
	
	@Column
	private String idCard;
	
	@Column
	private String image;
	
	@Column
	private Boolean gender;
	
	@Column
	private String email;
	
	@OneToMany(mappedBy = "staff",cascade = CascadeType.ALL)
	private Set<Reader> reader;
	
	public Staff() {
		super();
	}


	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Set<Reader> getReader() {
		return reader;
	}

	public void setReader(Set<Reader> readers) {
		this.reader = readers;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
