package com.example.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface KurikulumMapper {
	@Delete("DELETE FROM kurikulum where id = #{id}")
	void deleteKurikulum(@Param("id") int id);
}
