package com.example.service;

import java.util.List;

import com.example.model.MataKuliahModel;

public interface MataKuliahService
{
    MataKuliahModel selectMataKuliah (int id);
    
    List<MataKuliahModel> selectMataKuliahProdi (int id_prodi, int id_fakultas, int id_prodi2);

    String addMataKuliah (MataKuliahModel mata_kuliah);

    void deleteMataKuliah (int id);

	boolean cekPrasyarat(List<MataKuliahModel> listPrasyarat, int id_prasyarat);

	void addPrasyarat(int idtable, String kode_matkul, String kode_matkul2);

	int getIdPrasyarat();

	void deletePrasyarat(String kode_matkul, String kode_matkul2);

	MataKuliahModel selectMataKuliahByKode(int kode_matkul2);

	void updateMataKuliah(String kode_matkul2, int jumlah_sks2, int prasyarat_sks2, String nama_matkul);

	void deleteMatkul(int id2);

}
