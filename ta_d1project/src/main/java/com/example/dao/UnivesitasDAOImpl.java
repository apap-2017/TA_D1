package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.model.ApiModel;

@Service
public class UnivesitasDAOImpl implements UniversitasDAO {
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public ApiModel selectAllFakultas(int id_univ) {
		ApiModel listFakultas = restTemplate.getForObject("https://apap2017-univ-apps.herokuapp.com/getFakultasList/1", ApiModel.class);
		return listFakultas;
	}

	@Override
	public ApiModel selectAllProdi(int id_univ,int id_fakultas) {
		ApiModel listProdi = restTemplate.getForObject("https://apap2017-univ-apps.herokuapp.com/getProdiList/1/" + id_fakultas, ApiModel.class);
		return listProdi;
	}

	@Override
	public ApiModel selectFakultas(int id_univ, int id_fakultas) {
		ApiModel fakultas = restTemplate.getForObject("https://apap2017-univ-apps.herokuapp.com/getFakultas/1/" + id_fakultas, ApiModel.class);
		return fakultas;
	}

	@Override
	public ApiModel selectProdi(int id_univ, int id_fakultas, int id_prodi) {
		// TODO Auto-generated method stub
		return null;
	}

}
