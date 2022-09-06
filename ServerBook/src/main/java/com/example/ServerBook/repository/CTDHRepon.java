package com.example.ServerBook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ServerBook.entity.CTDHEntity;
import com.example.ServerBook.entity.DonHangEntity;

@Repository
public interface CTDHRepon extends JpaRepository<CTDHEntity, Long> {

	List<CTDHEntity> findByDonHang(DonHangEntity dh);

}
