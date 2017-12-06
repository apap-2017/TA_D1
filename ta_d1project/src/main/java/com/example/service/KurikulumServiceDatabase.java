package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.KurikulumMapper;
//import com.example.dao.KurikulumMapper;
import com.example.model.KurikulumModel;
import com.example.model.MataKuliahModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KurikulumServiceDatabase implements KurikulumService {
	@Autowired
	private KurikulumMapper kurikulumMapper;

	@Override
	public List<KurikulumModel> selectKurikulumProdi(int id_prodi) {
		log.info("select kurikulum with id prodi {}", id_prodi);
		// return kurikulumMapper.selectKurikulumProdi(id_prodi);
		return null;
	}


	@Override
	public String updateKurikulum(KurikulumModel kurikulum, int id_kurikulum) {
		log.info("update kurikulum with id {}", id_kurikulum);
		kurikulumMapper.updateKurikulum(kurikulum, id_kurikulum);

		return kurikulum.getNama_kurikulum();
	}

	@Override
	public void deleteKurikulum(int id) {
		log.info("delete kurikulum with id {}", id);
		kurikulumMapper.deleteKurikulum(id);
	}

	// lihat hasil cari kurikulum
	@Override
	public List<KurikulumModel> selectKurikulumbyParam(int id_fakultas, int id_prodi) {
		log.info("select kurikulum with id prodi {}", id_prodi);
		return kurikulumMapper.selectKurikulumbyParam(id_fakultas, id_prodi);
	}

	// lihat detail kurikulum
	@Override
	public KurikulumModel selectKurikulum(int id) {
		log.info("select kurikulum with id {}", id);
		return kurikulumMapper.selectKurikulum(id);
	}
	
	@Override
	public KurikulumModel selectKurikulumR(int id) {
		log.info("select kurikulum with id {}", id);
		return kurikulumMapper.selectKurikulumR(id);
	}

	// tambah kurikulum
	@Override
	public void addKurikulum(KurikulumModel kurikulum, int id_univ, int id_fakultas, int id_prodi) {
		kurikulum.getId_univ();
		kurikulum.setId_fakultas(id_fakultas);
		kurikulum.setId_prodi(id_prodi);
		
		kurikulumMapper.addKurikulum(kurikulum);
	}
	
	@Override
	public List<MataKuliahModel> selectMataKuliah(int id_kurikulum) {
		return kurikulumMapper.selectMataKuliah(id_kurikulum);
	}
}
