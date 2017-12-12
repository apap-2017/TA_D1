package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dao.MatkulMapper;
import com.example.model.MataKuliahModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MataKuliahServiceDatabase implements MataKuliahService {
	
	@Autowired
    private MatkulMapper mataKuliahMapper;

	@Override
	public MataKuliahModel selectMataKuliah(int id) {
		log.info ("select mata kuliah with id {}", id);
        return mataKuliahMapper.selectMataKuliah (id);
	}

	@Override
	public List<MataKuliahModel> selectMataKuliahProdi(int id_fakultas,int id_prodi) {
		log.info ("select mata kuliah with id prodi {}", id_prodi);
		return mataKuliahMapper.selectMatakuliahProdi(id_fakultas,id_prodi);
	}

	@Override
	public String updateMataKuliah(MataKuliahModel mata_kuliah, int id) {
		log.info ("update mata kuliah with id {}", id);
        //return mataKuliahMapper.updateMataKuliah(mata_kuliah, id);
        return null;
	}

	@Override
	public void deleteMataKuliah(int id) {
		log.info ("delete mata kuliah with id {}", id);
        //return mataKuliahMapper.deleteMataKuliah(id);
	}

	@Override
	public void addMataKuliah(String kode_matkul, String nama_matkul, int jumlah_sks, int prasyarat_sks, int id_univ, int id_fakultas,
			int id_prodi, int id) {
		
	mataKuliahMapper.addMataKuliah(kode_matkul, nama_matkul, jumlah_sks, prasyarat_sks, id_univ, id_fakultas, id_prodi, id);
	}

}