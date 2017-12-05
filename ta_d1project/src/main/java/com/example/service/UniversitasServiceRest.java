package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UniversitasDAO;
import com.example.model.ApiModel;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UniversitasServiceRest implements UniversitasService {
	@Autowired
	UniversitasDAO universitasDAO;

	@Override
	public ApiModel selectAllFakultas(int id_univ) {
		log.info(universitasDAO.selectAllFakultas(id_univ).getMsg());
		return universitasDAO.selectAllFakultas(id_univ);
	}

	@Override
	public ApiModel selectAllProdi(int id_univ, int id_fakultas) {
		
		return universitasDAO.selectAllProdi(id_univ, id_fakultas);
	}

	@Override
	public ApiModel selectFakultas(int id_univ, int id_fakultas) {
		return universitasDAO.selectFakultas(id_univ, id_fakultas);
	}

	@Override
	public ApiModel selectProdi(int id_univ, int id_fakultas, int id_prodi) {
		return universitasDAO.selectProdi(id_univ, id_fakultas, id_prodi);
	}
	

}
