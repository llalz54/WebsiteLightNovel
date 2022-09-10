package com.example.ServerBook.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "Users")
public class KhachHangEntity {
	@Id
	@Column(name ="MaKH")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name ="HoTen",nullable = false)
	@Nationalized
	private String name;
	
	@Column(name ="DiaChi")
	private String diaChi;
	
	@Column(name ="SDT",length = 11)
	private String sdt;
	
	@Column(name ="PassWord",nullable = false)
	private String pass;
	
	@Column(name ="Email",unique = true, nullable = false)
	private String email;
	
	@OneToMany(mappedBy = "khachHang")
	private List<DonHangEntity> donHang = new ArrayList<>();
	
	@OneToMany(mappedBy = "khachHang")
	private List<CartEntity> cartKH = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name ="role_id",nullable = false)
	private RoleEntity role;
	
	
	public List<CartEntity> getCartKH() {
		return cartKH;
	}

	public void setCartKH(List<CartEntity> cartKH) {
		this.cartKH = cartKH;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<DonHangEntity> getDonHang() {
		return donHang;
	}

	public void setDonHang(List<DonHangEntity> donHang) {
		this.donHang = donHang;
	}

	@Override
	public String toString() {
		return "KhachHangEntity [id=" + id + ", name=" + name + "]";
	}

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}
	
	

}
