package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.MataKuliahKurikulumModel;

@Service
public interface MataKuliahKurikulumService {
	
	MataKuliahKurikulumModel selectMataKuliahKurikulum(int id);
	
	void updateMataKuliahKurikulum (MataKuliahKurikulumModel mataKuliahKurikulum, int id);
	
	void deleteMataKuliahKurikulum (int id);


	int addMataKuliahKurikulum(MataKuliahKurikulumModel matkul_kurikulum, int id_kurikulum);

	
	List<MataKuliahKurikulumModel> selectMatkulTerm(int term);

	List<MataKuliahKurikulumModel> selectListMataKuliahKurikulum(int id_kurikulum);

}
