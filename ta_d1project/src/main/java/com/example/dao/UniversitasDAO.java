package com.example.dao;


import java.util.List;

import com.example.model.AngkatanModel;
import com.example.model.ApiModel;

public interface UniversitasDAO {
	ApiModel selectFakultas(int id_univ, int id_fakultas);
	ApiModel selectProdi (int id_univ, int id_fakultas, int id_prodi);
	List<AngkatanModel> selectAngkatan(int id_univ, int id_fakultas, int id_prodi);
}
