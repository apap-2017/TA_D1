package com.example.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.model.KurikulumModel;

@Mapper
public interface KurikulumMapper {
	@Select("select id, kode_kurikulum, nama_kurikulum, jumlah_sks_wajib, jumlah_sks_pilihan, id_prodi, id_fakultas from kurikulum where id = #{id}")
	KurikulumModel selectKurikulum(@Param (value = "id") int id);
	
	@Delete("DELETE FROM kurikulum where id = #{id}")
	void deleteKurikulum(@Param("id") int id);
}
