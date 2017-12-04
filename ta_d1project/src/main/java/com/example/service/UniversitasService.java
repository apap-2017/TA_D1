package com.example.service;

import java.util.List;

import com.example.model.FakultasModel;

public interface UniversitasService {
	List<FakultasModel> selectAllFakultas(int id_univ);
}
