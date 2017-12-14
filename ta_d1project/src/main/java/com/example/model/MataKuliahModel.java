package com.example.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MataKuliahModel {
	private int id;
	private int id_univ;
	private int id_fakultas;
	private int id_prodi;
	
	@NotNull
	private String kode_matkul;
	
	@NotNull
	private String nama_matkul;
	
	@NotNull
	private int jumlah_sks;
	
	@NotNull
	private int prasyarat_sks;
	
	private List<MataKuliahModel> listPrasyarat;
	private List<MataKuliahModel> listMataKuliah;
}
