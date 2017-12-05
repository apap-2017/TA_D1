package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.KurikulumModel;
import com.example.model.MataKuliahKurikulumModel;
import com.example.model.MataKuliahModel;

@Mapper
public interface KurikulumMapper {	
	@Select("select id, id_univ, id_fakultas, id_prodi, kode_kurikulum, nama_kurikulum, jumlah_sks_wajib, jumlah_sks_pilihan "
			+ "from kurikulum where id = #{id}")
	@Results(value= {
			@Result(property="id", column="id"),
			@Result(property="kode_kurikulum", column="kode_kurikulum"),
			@Result(property="nama_kurikulum", column="nama_kurikulum"),
			@Result(property="jumlah_sks_wajib", column="jumlah_sks_wajib"),
			@Result(property="jumlah_sks_pilihan", column="jumlah_sks_pilihan"),
			@Result(property="id_univ", column="id_univ"),
			@Result(property="id_prodi", column="id_prodi"),
			@Result(property="id_fakultas", column="id_fakultas"),
			@Result(property="listMataKuliah", column="id",
					javaType = List.class,
					many=@Many (select="selectMataKuliah")),
			@Result(property="listMataKuliahKurikulum", column="id",
					javaType = List.class,
					many=@Many (select="selectMataKuliahKurikulum"))			
	})
	KurikulumModel selectKurikulum(@Param (value = "id") int id);	
	
	@Update("UPDATE kurikulum SET id_fakultas = #{kurikulum.id_fakultas}, id_prodi = #{kurikulum.id_prodi},"
			+ " kode_kurikulum = #{kurikulum.kode_kurikulum}, nama_kurikulum = #{kurikulum.nama_kurikulum}, "
			+ "jumlah_sks_wajib = #{kurikulum.jumlah_sks_wajib}, jumlah_sks_pilihan = #{kurikulum.jumlah_sks_pilihan} "
			+ "where id = #{id_kurikulum}")
	void updateKurikulum(@Param("kurikulum") KurikulumModel kurikulum, @Param(value = "id_kurikulum") int id_kurikulum);
	
	@Delete("DELETE FROM kurikulum where id = #{id}")
	void deleteKurikulum(@Param("id") int id);
	
	@Select("select mata_kuliah_kurikulum.id, mata_kuliah_kurikulum.id_kurikulum, mata_kuliah_kurikulum.id_matkul, "
			+ "mata_kuliah_kurikulum.status_matkul, mata_kuliah_kurikulum.term from mata_kuliah_kurikulum join kurikulum"
			+ " on mata_kuliah_kurikulum.id_kurikulum = kurikulum.id where kurikulum.id = #{id}")
	List<MataKuliahKurikulumModel> selectMataKuliahKurikulum (@Param (value = "id") int id);
	
	@Select("SELECT mata_kuliah.id, mata_kuliah.id_univ, mata_kuliah.id_fakultas, mata_kuliah.id_prodi, mata_kuliah.kode_matkul,"
			+ " mata_kuliah.nama_matkul, mata_kuliah.jumlah_sks, "
			+ "mata_kuliah.prasyarat_sks from mata_kuliah join mata_kuliah_kurikulum on "
			+ "mata_kuliah.id = mata_kuliah_kurikulum.id_matkul JOIN kurikulum on kurikulum.id = "
			+ "mata_kuliah_kurikulum.id_kurikulum WHERE kurikulum.id = #{id}")
	List<MataKuliahModel> selectMataKuliah(@Param (value = "id") int id);
}
