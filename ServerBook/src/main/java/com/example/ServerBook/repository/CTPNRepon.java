package com.example.ServerBook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ServerBook.entity.CTPNEntity;
import com.example.ServerBook.entity.PhieuNhapEntity;

@Repository
public interface CTPNRepon extends JpaRepository<CTPNEntity, Long> {

	List<CTPNEntity> findByPhieuNhap(PhieuNhapEntity pn);

}
