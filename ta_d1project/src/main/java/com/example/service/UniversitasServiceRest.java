package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.KurikulumMapper;
import com.example.dao.UniversitasDAO;
import com.example.model.AngkatanModel;
import com.example.model.ApiModel;
import com.example.model.FakultasModel;
import com.example.model.KurikulumModel;
import com.example.model.ProdiModel;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UniversitasServiceRest implements UniversitasService {
	@Autowired
	private UniversitasDAO universitasDAO;
	@Autowired
	private KurikulumMapper kurikulumMapper;

	@Override
	public FakultasModel selectFakultas(int id_univ, int id_fakultas) {
		FakultasModel fakultas = ((Map<String, FakultasModel>) universitasDAO.selectFakultas(id_univ, id_fakultas).getResult()).get("fakultas");
		return fakultas;
	}

	@Override
	public ProdiModel selectProdi(int id_univ, int id_fakultas, int id_prodi) {
		ProdiModel prodi = ((Map<String, ProdiModel>) universitasDAO.selectProdi(id_univ, id_fakultas, id_prodi).getResult()).get("prodi");
		
		return prodi;
	}

	@Override
	public List<AngkatanModel> selectAngkatan(int id_univ, int id_fakultas, int id_prodi) {
		List<AngkatanModel> list = universitasDAO.selectAngkatan(id_univ, id_fakultas, id_prodi);
		System.out.println(list.get(0).getNamaAngkatan());
		for (int i = 0; i < list.size(); i++) {
			if (!list.get(i).isAktif()) {
				list.remove(i);
			} else if (list.size() >0) {
				KurikulumModel krk = kurikulumMapper.getNamaKurikulum(list.get(i).getIdKurikulum());
				if (krk != null) {
					list.get(i).setKode_kurikulum(krk.getKode_kurikulum());
					list.get(i).setNama_kurikulum(krk.getNama_kurikulum());
				} else {
					list.get(i).setKode_kurikulum("Tidak ditemukan");
					list.get(i).setNama_kurikulum("Tidak ditemukan");
				}
			}
		}
	
		return list;
	}
	

}
