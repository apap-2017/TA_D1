package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.MataKuliahKurikulumMapper;
import com.example.model.MataKuliahKurikulumModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MataKuliahKurikulumServiceDatabase implements MataKuliahKurikulumService {
	@Autowired
	private MataKuliahKurikulumMapper mataKuliahKurikulumMapper;

	@Override
	public MataKuliahKurikulumModel selectMataKuliahKurikulum(int id) {
		log.info("select mata kuliah kurikulum with id {}", id);
		return mataKuliahKurikulumMapper.selectMataKuliahKurikulum(id);
	}

	@Override
	public void updateMataKuliahKurikulum(MataKuliahKurikulumModel mataKuliahKurikulum, int id) {
		log.info("update mata kuliah kurikulum with id {}", id);
		mataKuliahKurikulumMapper.updateMataKuliahKurikulum(mataKuliahKurikulum, id);
	}

	@Override
	public void deleteMataKuliahKurikulum(int id) {
		log.info("delete mata kuliah kurikulum with id {}", id);
		mataKuliahKurikulumMapper.deleteMataKuliahKurikulum(id);
	}


	// add matkul kurikulum
	@Override
	public int addMataKuliahKurikulum(MataKuliahKurikulumModel matkul_kurikulum, int id_kurikulum) {
		matkul_kurikulum.setId_kurikulum(id_kurikulum);
		mataKuliahKurikulumMapper.addMataKuliahKurikulum(matkul_kurikulum);
		
		log.info("insert mata kuliah kurikulum with id_kurikulum {}", id_kurikulum);
		
		return id_kurikulum;
	}

	@Override
	public List<MataKuliahKurikulumModel> selectMatkulTerm(int term) {
		return mataKuliahKurikulumMapper.selectMatkulTerm(term);
	}
	
	@Override
	public List<MataKuliahKurikulumModel> selectListMataKuliahKurikulum(int id_kurikulum) {
		return mataKuliahKurikulumMapper.selectListMataKuliahKurikulum(id_kurikulum);
	}

}