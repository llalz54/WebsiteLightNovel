package com.example.ServerBook.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Role")
public class RoleEntity {
	@Id
	@Column(name ="role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name ="role_name",nullable = false)
	private String name;
	
	/*
	 * @OneToMany(mappedBy = "role") private List<NhanVienEntity> nv = new
	 * ArrayList<>();
	 */
	@OneToMany(mappedBy = "role")
	private List<KhachHangEntity> kh = new ArrayList<>();

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

	/*
	 * public List<NhanVienEntity> getNv() { return nv; }
	 * 
	 * public void setNv(List<NhanVienEntity> nv) { this.nv = nv; }
	 */
	
	
}
