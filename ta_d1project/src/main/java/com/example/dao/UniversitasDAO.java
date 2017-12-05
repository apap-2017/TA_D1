package com.example.dao;


import com.example.model.ApiModel;

public interface UniversitasDAO {
	ApiModel selectAllFakultas(int id_univ);
	ApiModel selectFakultas(int id_univ, int id_fakultas);
	ApiModel selectAllProdi(int id_univ, int id_fakultas);
	ApiModel selectProdi (int id_univ, int id_fakultas, int id_prodi);
}
