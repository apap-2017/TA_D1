package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UniversitasDAO;
import com.example.model.FakultasModel;

@Service
public class UniversitasServiceRest implements UniversitasService {
	@Autowired
	UniversitasDAO universitasDAO;

	@Override
	public List<FakultasModel> selectAllFakultas(int id_univ) {
		return universitasDAO.selectAllFakultas(id_univ);
	}
	

}
