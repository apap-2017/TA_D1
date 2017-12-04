package com.example.dao;

import java.util.List;

import com.example.model.FakultasModel;

public interface UniversitasDAO {
	List<FakultasModel> selectAllFakultas(int id_univ);
	
}
