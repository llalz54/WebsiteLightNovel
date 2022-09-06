package com.example.ServerBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ServerBook.entity.PhieuNhapEntity;

@Repository
public interface PhieuNhapRepon extends JpaRepository<PhieuNhapEntity, Long> {

}
