package com.example.ServerBook.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ServerBook.entity.CTDHEntity;
import com.example.ServerBook.entity.LoaiSPEntity;
import com.example.ServerBook.entity.TieuThuyetEntity;


@Repository
public interface TieuThuyetRepon extends JpaRepository<TieuThuyetEntity, Long> {
	Page<TieuThuyetEntity> findByLoaiTT(LoaiSPEntity loaiTT_ID, Pageable pageable);
	List<TieuThuyetEntity> findByLoaiTT(LoaiSPEntity loaiTT_ID);
	Page<TieuThuyetEntity> findAll(Pageable pageable);
	@Query(value = "SELECT * FROM dbo.tieu_thuyet WHERE ten_sach like %?1% or mo_ta like %?1%",
			nativeQuery = true)
	List<TieuThuyetEntity> search(String keyword);
	@Query(value =" select tieu_thuyet.ten_sach , sum(ctdh.don_gia * ctdh.so_luong) as 'Tổng tiền', sum(ctdh.so_luong) as 'Số lượng' \r\n"
			+ "			from ctdh\r\n"
			+ "join don_hang on don_hang.iddh = ctdh.iddh \r\n"
			+ "join tieu_thuyet on ctdh.ma_sach = tieu_thuyet.ma_sach \r\n"
			+ "where don_hang.trang_thai = -1\r\n"
			+ "group by tieu_thuyet.ten_sach\r\n"
			+ "order by sum(ctdh.so_luong) desc",nativeQuery = true)
	List<Object[]> getTieuThuyetBanChay();
	
	@Query(value = "select cast(year(don_hang.ngay_lap) as varchar) + '-' +cast(month(don_hang.ngay_lap) as varchar)+  '-' +cast(day(don_hang.ngay_lap) as varchar) day\r\n"
			+ " ,count(don_hang.iddh) as 'so luong',sum(don_hang.tong_gia) as 'tong tien' \r\n"
			+ "from don_hang where trang_thai = -1 \r\n"
			+ "group by don_hang.ngay_lap\r\n"
			+ "order by don_hang.ngay_lap desc", nativeQuery = true)
	List<Object[]> getThongKeTheoNgay();
	
	@Query(value = "select   cast(year(don_hang.ngay_lap) as varchar) + '-' +cast(month(don_hang.ngay_lap) as varchar) month,\r\n"
			+ "count(don_hang.iddh) as 'count', sum(don_hang.tong_gia) as 'sum' from don_hang where trang_thai = -1\r\n"
			+ "group by month(don_hang.ngay_lap), year(don_hang.ngay_lap)\r\n"
			+ "order by month desc", nativeQuery = true)
	List<Object[]> getThongKeTheoThang();

	@Query(value = "select year(ngay_lap) as 'year',count(iddh) as 'count', sum(tong_gia) as 'sum' from don_hang where trang_thai = -1\r\n"
			+ "group by year(ngay_lap)\r\n"
			+ "order by year(ngay_lap) desc", nativeQuery = true)
	List<Object[]> getThongKeTheoNam();


}
