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

	@Select("select id, kode_matkul, nama_matkul, jumlah_sks, prasyarat_sks, id_prodi, id_univ, id_fakultas from mata_kuliah where id = #{id}")
    @Results(value = {
    		@Result(property="id", column="id"),
    		@Result(property="kode_matkul", column="kode_matkul"),
    		@Result(property="nama_matkul", column="nama_matkul"),
    		@Result(property="jumlah_sks", column="jumlah_sks"),
    		@Result(property="prasyarat_sks", column="prasyarat_sks"),
    		@Result(property="id_prodi", column="id_prodi"),
    		@Result(property="id_univ", column="id_univ"),
    		@Result(property="id_fakultas", column="id_fakultas"),
    		@Result(property="listPrasyarat", column="kode_matkul",
    		javaType = List.class,
    		many=@Many(select="selectPrasyarat"))
    })
	MataKuliahModel selectMataKuliah(@Param("id") int id);

	@Select("select * from mata_kuliah where kode_matkul IN (select kode_prasyarat_matkul from prasyarat_mata_kuliah where kode_matkul = #{kode_matkul})")
	List<MataKuliahModel> selectPrasyarat (@Param("kode_matkul") String kode_matkul);
	
	
	 @Select("select id, id_univ, id_fakultas, id_prodi, kode_matkul, nama_matkul, jumlah_sks, "
	   + "prasyarat_sks from mata_kuliah where id_univ = #{id_univ} AND id_fakultas = #{id_fakultas} AND id_prodi=#{id_prodi}")
	 List<MataKuliahModel> selectMataKuliahProdi(@Param (value = "id_univ") int id_univ,
			 									 @Param (value = "id_fakultas") int id_fakultas, 
			 									 @Param (value = "id_prodi") int id_prodi );

	
	 @Insert("insert into prasyarat_mata_kuliah(id, kode_matkul,kode_prasyarat_matkul) values (#{id}, #{kode_matkul},#{kode_matkul2})")
	 void addPrasyarat(@Param("id") int id, @Param("kode_matkul") String kode_matkul,@Param("kode_matkul2") String kode_matkul2);

	 @Select("select max(id) from prasyarat_mata_kuliah")
	 int getIdPrasyarat();

	 @Delete("delete from prasyarat_mata_kuliah where kode_matkul = #{kode_matkul} and kode_prasyarat_matkul = #{kode_matkul2}")
	 void deletePrasyarat(@Param("kode_matkul") String kode_matkul, @Param("kode_matkul2") String kode_matkul2);

	 @Select("select id, kode_matkul, nama_matkul, jumlah_sks, prasyarat_sks, id_prodi, id_univ, id_fakultas from mata_kuliah where kode_matkul = #{kode_matkul2}")
	 @Results(value = {
			 @Result(property="id", column="id"),
			 @Result(property="kode_matkul", column="kode_matkul"),
			 @Result(property="nama_matkul", column="nama_matkul"),
			 @Result(property="jumlah_sks", column="jumlah_sks"),
			 @Result(property="prasyarat_sks", column="prasyarat_sks"),
			 @Result(property="id_prodi", column="id_prodi"),
			 @Result(property="id_univ", column="id_univ"),
			 @Result(property="id_fakultas", column="id_fakultas"),
			 @Result(property="listPrasyarat", column="kode_matkul",
			 javaType = List.class,
			 many=@Many(select="selectPrasyarat"))
	 })
	 MataKuliahModel selectMataKuliahByKode(@Param("kode_matkul2") int kode_matkul2);

	 @Update("update mata_kuliah set nama_matkul = #{nama_matkul} , jumlah_sks = #{jumlah_sks2} , prasyarat_sks = #{prasyarat_sks2}"
		 		+ " where kode_matkul = #{kode_matkul2} ")
	 void updateMataKuliah(@Param("kode_matkul2") String kode_matkul2, @Param("jumlah_sks2") int jumlah_sks2, @Param("prasyarat_sks2") int prasyarat_sks2, @Param("nama_matkul") String nama_matkul);

	 @Delete("delete from mata_kuliah where id = #{id2}")
	 void deleteMatkul(@Param("id2") int id2); 

}
