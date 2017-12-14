package com.example.dao;


import java.util.List;

import com.example.model.AngkatanModel;
import com.example.model.FakultasModel;
import com.example.model.ProdiModel;

public interface UniversitasDAO {
	FakultasModel selectFakultas(int id_univ, int id_fakultas);
	ProdiModel selectProdi (int id_univ, int id_fakultas, int id_prodi);
	List<AngkatanModel> selectAngkatan(int id_univ, int id_fakultas, int id_prodi);
}
