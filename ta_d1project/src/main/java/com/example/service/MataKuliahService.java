package com.example.service;

import java.util.List;

import com.example.model.MataKuliahModel;

public interface MataKuliahService
{
    MataKuliahModel selectMataKuliah (int id_univ, int id_fakultas, int id_prodi, int id);
    MataKuliahModel selectMataKuliahAPI(int id);

    List<MataKuliahModel> selectMataKuliahProdi (int id_univ, int id_fakultas, int id_prodi);

    //void addMataKuliah (MataKuliahModel mata_kuliah);

    void deleteMataKuliah (int id);
    
	boolean cekPrasyarat(List<MataKuliahModel> listPrasyarat, int id_prasyarat);

	void addPrasyarat(int idtable, String kode_matkul, String kode_matkul2);

	int getIdPrasyarat();

	void deletePrasyarat(String kode_matkul, String kode_matkul2);

	MataKuliahModel selectMataKuliahByKode(String kode_matkul2);

	void updateMataKuliah(String kode_matkul2, int jumlah_sks2, int prasyarat_sks2, String nama_matkul);

	void deleteMatkul(int id2);

	void addMataKuliah(String kode_matkul, String nama_matkul, int jumlah_sks, int prasyarat_sks, int id_univ, int id_fakultas, int id_prodi);

}
