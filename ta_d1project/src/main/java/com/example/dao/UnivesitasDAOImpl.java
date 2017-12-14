package com.example.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.model.AngkatanModel;
import com.example.model.ApiModel;
import com.example.model.FakultasModel;
import com.example.model.ProdiModel;

@Service
public class UnivesitasDAOImpl implements UniversitasDAO {
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public FakultasModel selectFakultas(int id_univ, int id_fakultas) {
		ApiModel<Map <String, FakultasModel>> api = restTemplate.exchange("https://apap2017-univ-apps.herokuapp.com/getFakultas/" + id_univ + "/" + id_fakultas, HttpMethod.GET, null,
						new ParameterizedTypeReference<ApiModel<Map<String, FakultasModel>>>() {}).getBody();
		if(api.getStatus() == 404) {
			return null;
		} else {
			FakultasModel fakultas = api.getResult().get("fakultas");
			return fakultas;
		}
	}

	@Override
	public ProdiModel selectProdi(int id_univ, int id_fakultas, int id_prodi) {
		ApiModel<Map <String, ProdiModel>> api = restTemplate.exchange("https://apap2017-univ-apps.herokuapp.com/getProdi/" + id_univ + "/" + id_fakultas + "/" + id_prodi, HttpMethod.GET, null,
				new ParameterizedTypeReference<ApiModel<Map<String, ProdiModel>>>() {}).getBody();
		if(api.getStatus() == 404) {
			return null;
		} else {
			ProdiModel prodi = api.getResult().get("prodi");
			return prodi;
		}
	}


	@Override
	public List<AngkatanModel> selectAngkatan(int id_univ, int id_fakultas, int id_prodi) {
		List<AngkatanModel> list = restTemplate.exchange("http://localhost:7070/rest/getSeluruhAngkatanAktif/" + id_univ + "/" + id_fakultas + "/" + id_prodi, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<AngkatanModel>>() {}).getBody();
		return list;
	}

}
