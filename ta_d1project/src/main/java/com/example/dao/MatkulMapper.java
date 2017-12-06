package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.*;

@Mapper
public interface MatkulMapper {

	@Select("select id, kode_matkul, nama_matkul, jumlah_sks, prasyarat_sks, id_prodi from mata_kuliah where id = #{id}")
    @Results(value = {
    		@Result(property="id", column="id"),
    		@Result(property="kode_matkul", column="kode_matkul"),
    		@Result(property="nama_matkul", column="nama_matkul"),
    		@Result(property="jumlah_sks", column="jumlah_sks"),
    		@Result(property="prasyarat_sks", column="prasyarat_sks"),
    		@Result(property="id_prodi", column="id_prodi"),
    		@Result(property="listPrasyarat", column="kode_matkul",
    		javaType = List.class,
    		many=@Many(select="selectPrasyarat"))
    })
	MataKuliahModel selectMataKuliah(@Param("id") int id);

	@Select("select * from mata_kuliah where kode_matkul IN (select kode_prasyarat_matkul from prasyarat_mata_kuliah where kode_matkul = #{id})")
	List<MataKuliahModel> selectPrasyarat (@Param("kode_matkul") String kode_matkul);
	
	@Select("select id, id_univ, id_fakultas, id_prodi, kode_matkul, nama_matkul, jumlah_sks, "
			+ "prasyarat_sks from mata_kuliah where id_fakultas = #{id_fakultas} AND id_prodi=#{id_prodi}")
	List<MataKuliahModel> selectMatakuliahProdi(@Param(value = "id_fakultas") int id_fakultas,
			@Param(value = "id_prodi") int id_prodi);

	@Insert("INSERT INTO mata_kuliah (kode_matkul, nama_matkul, jumlah_sks, prasyarat_sks, id_univ, id_fakultas, id_prodi) VALUES (#{kode_matkul}, #{nama_matkul}, #{jumlah_sks}, #{prasyarat_sks}, #{id_univ}, #{id_fakultas}, #{id_prodi})")
	void addMataKuliah(@Param(value = "kode_matkul") String kode_matkul, @Param(value = "nama_matkul") String nama_matkul, @Param(value = "jumlah_sks") int jumlah_sks, @Param(value = "prasyarat_sks") int prasyarat_sks, @Param(value = "id_univ") int id_univ,
			@Param(value = "id_fakultas") int id_fakultas, @Param(value = "id_prodi") int id_prodi);
}
