package com.example.ServerBook.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ServerBook.entity.CartEntity;
import com.example.ServerBook.entity.DonHangEntity;
import com.example.ServerBook.entity.KhachHangEntity;
import com.example.ServerBook.entity.NhanVienEntity;

@Repository
public interface DonHangRepon extends JpaRepository<DonHangEntity, Long> {
	List<DonHangEntity> findByKhachHang(KhachHangEntity kh);
	@Query(value = "SELECT * FROM dbo.don_hang WHERE iddh like %?1% ",
			nativeQuery = true)
	DonHangEntity search(Long iddh);
}
