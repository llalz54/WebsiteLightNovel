/*
 * package com.example.ServerBook.repository;
 * 
 * import java.util.List;
 * 
 * import org.springframework.data.domain.Page; import
 * org.springframework.data.domain.Pageable; import
 * org.springframework.data.jpa.repository.JpaRepository; import
 * org.springframework.data.jpa.repository.Query; import
 * org.springframework.stereotype.Repository;
 * 
 * import com.example.ServerBook.entity.KhachHangEntity; import
 * com.example.ServerBook.entity.NhanVienEntity;
 * 
 * @Repository public interface NhanVienRepon extends
 * JpaRepository<NhanVienEntity, Long> { Page<NhanVienEntity> findAll(Pageable
 * pageable);
 * 
 * @Query(value = "SELECT * FROM dbo.nhan_vien WHERE ho_ten like %?1%",
 * nativeQuery = true) List<NhanVienEntity> search(String nv);
 * 
 * @Query(value =
 * "select top 1 * from dbo.nhan_vien where email = ? and pass_word =?",
 * nativeQuery = true) NhanVienEntity FindByEmailAndPassWord(String email,
 * String password); }
 */