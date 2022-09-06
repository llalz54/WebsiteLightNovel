package com.example.ServerBook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ServerBook.entity.CartEntity;
import com.example.ServerBook.entity.KhachHangEntity;
import com.example.ServerBook.entity.TieuThuyetEntity;

@Repository
public interface CartRepon extends JpaRepository<CartEntity, Long> {
	

	List<CartEntity> findByKhachHang(KhachHangEntity kH);
	void deleteAllByKhachHang(KhachHangEntity kh);
	CartEntity findByTieuThuyetAndKhachHang(TieuThuyetEntity tt, KhachHangEntity kh);
}
