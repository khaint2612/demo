package edu.poly.spring.dtos;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import com.sun.istack.NotNull;

import edu.poly.spring.models.Reader;

public class StaffDto {

	private String staffId;
	
	@NotNull
	@NotEmpty(message = "Không để tên trống")
	private String name;
	
	@NotNull
	private String address;
	
	@NotNull
	private String numberPhone;
	
	@NotNull
	private String idCard;
	
	@NotNull
	private MultipartFile photo;
	
	@NotNull
	private Boolean gender;
	
	@NotNull
	private String email;
	

	private String readerId;
	
}
