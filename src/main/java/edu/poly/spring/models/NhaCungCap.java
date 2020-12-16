package edu.poly.spring.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="nhacungcap")
public class NhaCungCap {
	

	@Id
	@Column(length = 10)
	private String mancc;
	@Column(length = 10)
	private String tenncc;
	@OneToMany(fetch =FetchType.LAZY, mappedBy="nhacungcaps" ,cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	private Set<NhapSach> nhapSachs;
	@OneToMany(fetch =FetchType.LAZY, mappedBy="nhacungcaps" ,cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	private Set<HoaDonNhapSach> hoadonnhapsachs;
	public NhaCungCap(String mancc, String tenncc) {
		super();
		this.mancc = mancc;
		this.tenncc = tenncc;
	}
	
	public NhaCungCap() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMancc() {
		return mancc;
	}
	public void setMancc(String mancc) {
		this.mancc = mancc;
	}
	public String getTenncc() {
		return tenncc;
	}
	public void setTenncc(String tenncc) {
		this.tenncc = tenncc;
	}
	public Set<NhapSach> getNhapSachs() {
		return nhapSachs;
	}

	public void setNhapSachs(Set<NhapSach> nhapSachs) {
		this.nhapSachs = nhapSachs;
	}

	public Set<HoaDonNhapSach> getHoadonnhapsachs() {
		return hoadonnhapsachs;
	}

	public void setHoadonnhapsachs(Set<HoaDonNhapSach> hoadonnhapsachs) {
		this.hoadonnhapsachs = hoadonnhapsachs;
	}
}
