package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.model.FakultasModel;

@Service
public class UnivesitasDAOImpl implements UniversitasDAO {
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<FakultasModel> selectAllFakultas(int id_univ) {
		List<FakultasModel> fakultases = restTemplate.getForObject("https://apap2017-univ-apps.herokuapp.com/getFakultasList/1", List.class);
		return fakultases;
	}

}
