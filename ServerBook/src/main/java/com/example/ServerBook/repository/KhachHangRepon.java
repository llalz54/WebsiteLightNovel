package com.example.ServerBook.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ServerBook.entity.KhachHangEntity;




@Repository
public interface KhachHangRepon extends JpaRepository<KhachHangEntity, Long> {
	Page<KhachHangEntity> findAll(Pageable pageable);
	@Query(value = "SELECT * FROM dbo.users WHERE ho_ten like %?1% ",
			nativeQuery = true)
	List<KhachHangEntity> search(String kh);
	@Query(value = "select * from dbo.users where email = ? and pass_word =?", nativeQuery = true)
	KhachHangEntity FindByEmailAndPassWord(String email, String password);

}
