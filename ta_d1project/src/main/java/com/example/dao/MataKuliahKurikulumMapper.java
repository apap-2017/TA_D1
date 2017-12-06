package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.MataKuliahKurikulumModel;

@Mapper
public interface MataKuliahKurikulumMapper {
	@Select("select id, id_kurikulum, id_matkul, status_matkul, term from mata_kuliah_kurikulum where id = #{id}")
	MataKuliahKurikulumModel selectMataKuliahKurikulum(@Param (value = "id") int id);
	
	@Update("update mata_kuliah_kurikulum set id_kurikulum = #{mata_kuliah_kurikulum.id_kurikulum}, "
			+ "id_matkul = #{mata_kuliah_kurikulum.id_matkul}, status_matkul = #{mata_kuliah_kurikulum.status_matkul}, "
			+ "term = #{mata_kuliah_kurikulum.term} where id = #{id}")
	void updateMataKuliahKurikulum(@Param(value = "mata_kuliah_kurikulum") MataKuliahKurikulumModel mataKuliahKurikulum, @Param(value = "id") int id);
	
	@Delete("delete from mata_kuliah_kurikulum where id = #{id}")
	void deleteMataKuliahKurikulum(@Param(value = "id") int id);
	
	@Select("select * from mata_kuliah_kurikulum where term= #{term}")
	List<MataKuliahKurikulumModel> selectMatkulTerm(@Param("term") int term);
}
