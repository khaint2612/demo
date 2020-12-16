package edu.poly.spring.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="hoadonnhapsach")
public class HoaDonNhapSach {
	

	@Id
	@Column(length = 10)
	private String mahd;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date ngaygiao;
	@Column(length = 20)
	private String dongia;
	@ManyToOne(fetch =FetchType.LAZY,optional = false)
	@JoinColumn(name= "mancc")
	private NhaCungCap nhacungcaps;
	
	public HoaDonNhapSach() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public HoaDonNhapSach(String mahd, Date ngaygiao, String dongia, NhaCungCap nhacungcaps) {
		super();
		this.mahd = mahd;
		this.ngaygiao = ngaygiao;
		this.dongia = dongia;
		this.nhacungcaps = nhacungcaps;
	}

	public String getMahd() {
		return mahd;
	}
	public void setMahd(String mahd) {
		this.mahd = mahd;
	}
	public Date getNgaygiao() {
		return ngaygiao;
	}
	public void setNgaygiao(Date ngaygiao) {
		this.ngaygiao = ngaygiao;
	}
	public String getDongia() {
		return dongia;
	}
	public void setDongia(String dongia) {
		this.dongia = dongia;
	}
	public NhaCungCap getNhacungcaps() {
		return nhacungcaps;
	}
	public void setNhacungcaps(NhaCungCap nhacungcaps) {
		this.nhacungcaps = nhacungcaps;
	}
	
}
