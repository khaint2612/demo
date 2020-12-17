package edu.poly.spring.dtos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.sun.istack.NotNull;

import edu.poly.spring.models.Staff;

public class ReaderDto implements Serializable {

	private String readerId;

	@NotNull
	private MultipartFile image;

	@NotNull
	@NotEmpty(message = "Không để trống tên")
	@Length(min = 5, max = 25, message = "Tên 5 - 25")
	private String name;

	private Boolean gender;
	@NotNull
	@NotEmpty(message = "Không để trống email")
	@Length(min = 5, max = 25, message = "Email 5 - 25")

	private String email;
	@NotNull
	@NotEmpty(message = "Không để trống address")
	@Length(min = 5, max = 25, message = "Address 5 - 25")
	private String address;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date birthday;

	@NotNull
	private String staffId;

	public String getReaderId() {
		return readerId;
	}

	public void setReaderId(String readerId) {
		this.readerId = readerId;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

}
