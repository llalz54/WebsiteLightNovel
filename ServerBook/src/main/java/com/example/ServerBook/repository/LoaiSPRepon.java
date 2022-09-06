package com.example.ServerBook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ServerBook.entity.LoaiSPEntity;
import com.example.ServerBook.entity.TieuThuyetEntity;

@Repository
public interface LoaiSPRepon extends JpaRepository<LoaiSPEntity, Long> {

}

