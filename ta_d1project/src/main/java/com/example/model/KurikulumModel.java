package com.example.model;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class KurikulumModel {
	private int id;
	private String kode_kurikulum;
	private String nama_kurikulum;
	private int jumlah_sks_wajib;
	private int jumlah_sks_pilihan;
	private int id_prodi;
	private int id_fakultas;
	private List<MataKuliahModel> listMataKuliah;
	private List<MataKuliahKurikulumModel> listMataKuliahKurikulum;
}