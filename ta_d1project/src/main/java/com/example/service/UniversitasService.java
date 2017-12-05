package com.example.service;

import com.example.model.ApiModel;;

public interface UniversitasService {
	ApiModel selectAllFakultas(int id_univ);
	ApiModel selectFakultas(int id_univ, int id_fakultas);
	ApiModel selectAllProdi(int id_univ, int id_fakultas);
	ApiModel selectProdi (int id_univ, int id_fakultas, int id_prodi);
}
