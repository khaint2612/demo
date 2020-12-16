package edu.poly.spring.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Staffs")
public class Staffs implements Serializable {
	@Id
	private String id;
	@Column(length =50)
	private String name;
	private boolean gender;
	@Column(length = 10)
	private  String idcard;
	@Column(length = 500)
	private  String address;
	@Column(length =100)
	private String email;
	@Column(length =12) 
	private String phone;
	
	@OneToMany(mappedBy = "staff",cascade = CascadeType.ALL)
	private Set<Reader> reader;

	public Staffs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Staffs(String id, String name, boolean gender, String idcard, String address, String email, String phone,
			Set<Reader> reader) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.idcard = idcard;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.reader = reader;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<Reader> getReader() {
		return reader;
	}

	public void setReader(Set<Reader> reader) {
		this.reader = reader;
	}
	
	

}
