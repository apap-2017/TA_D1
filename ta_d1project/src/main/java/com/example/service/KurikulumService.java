package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.KurikulumModel;
import com.example.model.MataKuliahModel;

@Service
public interface KurikulumService {
	List<KurikulumModel> selectKurikulumProdi(int id_prodi);

	String updateKurikulum(KurikulumModel kurikulum, int id);

	void deleteKurikulum(int id);

	// lihat hasil cari kurikulum
	List<KurikulumModel> selectKurikulumbyParam(int id_fakultas, int id_prodi);

	// lihat detail kurikulum
	KurikulumModel selectKurikulum(int id);
	
	KurikulumModel selectKurikulumR(int id);

	// tambah kurikulum
	void addKurikulum(KurikulumModel kurikulum);
	
	List<MataKuliahModel> selectMataKuliah(int id_kurikulum);
}
