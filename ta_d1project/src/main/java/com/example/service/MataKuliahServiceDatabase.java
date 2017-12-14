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
	public MataKuliahModel selectMataKuliah(int id_univ, int id_fakultas, int id_prodi, int id) {
		log.info ("select mata kuliah with id {}", id);
        return mataKuliahMapper.selectMataKuliah (id_univ, id_fakultas, id_prodi,id);
	}
	
	@Override
	public MataKuliahModel selectMataKuliahAPI(int id) {
		log.info ("select mata kuliah with id {}", id);
        return mataKuliahMapper.selectMataKuliahAPI(id);
	}

	@Override
	public List<MataKuliahModel> selectMataKuliahProdi(int id_univ,int id_fakultas, int id_prodi) {
		log.info ("select mata kuliah with id prodi {}", id_prodi);
		return mataKuliahMapper.selectMataKuliahProdi(id_univ,id_fakultas,id_prodi);
	}

	@Override
	public void deleteMataKuliah(int id) {
		log.info ("delete mata kuliah with id {}", id);
        //return mataKuliahMapper.deleteMataKuliah(id);
	}

	@Override
	public boolean cekPrasyarat(List<MataKuliahModel> listPrasyarat, int id_prasyarat) {
		boolean cek = false;
		for (int i = 0; i < listPrasyarat.size(); i++) {
			if(listPrasyarat.get(i).getId() == id_prasyarat) {
				cek = true;
			} 
		}
		return cek;
	}

	@Override
	public void addPrasyarat(int id, String kode_matkul, String kode_matkul2) {
		// TODO Auto-generated method stub
		mataKuliahMapper.addPrasyarat(id, kode_matkul, kode_matkul2);
	}

	@Override
	public int getIdPrasyarat() {
		// TODO Auto-generated method stub
		return mataKuliahMapper.getIdPrasyarat();
	}

	@Override
	public void deletePrasyarat(String kode_matkul, String kode_matkul2) {
		// TODO Auto-generated method stub
		mataKuliahMapper.deletePrasyarat(kode_matkul,kode_matkul2);
	}

	@Override
	public MataKuliahModel selectMataKuliahByKode(String kode_matkul2) {
		return mataKuliahMapper.selectMataKuliahByKode(kode_matkul2);
	}

	@Override
	public void updateMataKuliah(String kode_matkul2, int jumlah_sks2, int prasyarat_sks2, String nama_matkul) {
		// TODO Auto-generated method stub
		mataKuliahMapper.updateMataKuliah(kode_matkul2,jumlah_sks2,prasyarat_sks2,nama_matkul);
	}

	@Override
	public void deleteMatkul(int id2) {
		// TODO Auto-generated method stub
		mataKuliahMapper.deleteMatkul(id2);
	}

	


	public void addMataKuliah(String kode_matkul, String nama_matkul, int jumlah_sks, int prasyarat_sks, int id_univ, int id_fakultas,
			int id_prodi) {
		
	mataKuliahMapper.addMataKuliah(kode_matkul, nama_matkul, jumlah_sks, prasyarat_sks, id_univ, id_fakultas, id_prodi);
	}

}