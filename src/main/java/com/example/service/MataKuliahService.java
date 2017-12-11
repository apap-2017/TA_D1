package com.example.service;

import java.util.List;

import com.example.model.MataKuliahModel;

public interface MataKuliahService
{
    MataKuliahModel selectMataKuliah (int id);
    
    List<MataKuliahModel> selectMataKuliahProdi (int id_fakultas,int id_prodi);

    //void addMataKuliah (MataKuliahModel mata_kuliah);

    String updateMataKuliah (MataKuliahModel mata_kuliah, int id);

    void deleteMataKuliah (int id);

	void addMataKuliah(String kode_matkul, String nama_matkul, int jumlah_sks, int prasyarat_sks, int id_univ, int id_fakultas, int id_prodi);
}