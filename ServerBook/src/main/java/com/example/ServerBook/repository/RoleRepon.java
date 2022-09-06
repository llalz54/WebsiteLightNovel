package com.example.ServerBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ServerBook.entity.RoleEntity;

@Repository
public interface RoleRepon extends JpaRepository<RoleEntity, Long>{

}
