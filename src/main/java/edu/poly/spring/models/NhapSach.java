package edu.poly.spring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="phieunhapsach")
public class NhapSach {
	
	@Id
	@Column(length = 10)
	private String id;
	@Column(length =50)
	private String tensach;
	@Column(length =50)
	private String soluong;
	@Column(length =50)
	private String dongia;
	@Column(length =50)
	private String ngaygiao;
	@Column(length =50)
	private boolean tinhtrang;
	@ManyToOne(fetch =FetchType.LAZY,optional = false)
	@JoinColumn(name= "staffId")
	private Staffs staffs;
	@ManyToOne(fetch =FetchType.LAZY,optional = false)
	@JoinColumn(name= "mancc")
	private NhaCungCap nhacungcaps;
	public NhapSach() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NhapSach(String id, String tensach, String soluong, String dongia, String ngaygiao, boolean tinhtrang,
			Staffs staffs, NhaCungCap nhacungcaps) {
		super();
		this.id = id;
		this.tensach = tensach;
		this.soluong = soluong;
		this.dongia = dongia;
		this.ngaygiao = ngaygiao;
		this.tinhtrang = tinhtrang;
		this.staffs = staffs;
		this.nhacungcaps = nhacungcaps;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public String getSoluong() {
		return soluong;
	}
	public void setSoluong(String soluong) {
		this.soluong = soluong;
	}
	public String getDongia() {
		return dongia;
	}
	public void setDongia(String dongia) {
		this.dongia = dongia;
	}
	public String getNgaygiao() {
		return ngaygiao;
	}
	public void setNgaygiao(String ngaygiao) {
		this.ngaygiao = ngaygiao;
	}
	public boolean isTinhtrang() {
		return tinhtrang;
	}
	public void setTinhtrang(boolean tinhtrang) {
		this.tinhtrang = tinhtrang;
	}
	public Staffs getStaffs() {
		return staffs;
	}
	public void setStaffs(Staffs staffs) {
		this.staffs = staffs;
	}
	public NhaCungCap getNhacungcaps() {
		return nhacungcaps;
	}
	public void setNhacungcaps(NhaCungCap nhacungcaps) {
		this.nhacungcaps = nhacungcaps;
	}
	}
