package com.example.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.ApiModel;
import com.example.model.KurikulumModel;
import com.example.service.KurikulumService;

@RestController
@RequestMapping("/api")
public class KurikulumRestController {
	@Autowired
	KurikulumService kurikulumService;

	@RequestMapping("/getKurikulum/{id}")
	public ApiModel<Map<String, KurikulumModel>> getKurikulum(@PathVariable(value = "id") String id) {
		int id_kurikulum = 0;
		boolean tes = true;
		ApiModel<Map<String, KurikulumModel>> api = new ApiModel<Map<String, KurikulumModel>>();

		try {
			id_kurikulum = Integer.parseInt(id);
		} catch (NumberFormatException e) {
			tes = false;
		}
		if (tes) {
			KurikulumModel kurikulum = kurikulumService.selectKurikulumAPI(id_kurikulum);
			Map<String, KurikulumModel> map = new HashMap<>();
			map.put("kurikulum", kurikulum);

			if (kurikulum != null) {
				api.setResult(map);
				api.setMsg("success");
				api.setStatus(200);
			} else {
				tes = false;
			}
		}
		if (!tes) {
			api.setMsg("Kurikulum tidak ditemukan");
			api.setStatus(404);
		}
		return api;
	}

	@RequestMapping("/getKurikulumProdi/{id_univ}/{id_fkl}/{id_prd}")
	public ApiModel<Map<String, List<KurikulumModel>>> getKurikulumProdi(@PathVariable(value = "id_univ") String id_univ,
			@PathVariable(value = "id_fkl") String id_fkl, @PathVariable(value = "id_prd") String id_prd) {
		int id_prodi = 0;
		int id_fakultas = 0;
		int id_universitas =0;
		boolean tes = true;
		ApiModel<Map<String, List<KurikulumModel>>> api = new ApiModel<Map<String, List<KurikulumModel>>>();

		try {
			id_prodi = Integer.parseInt(id_prd);
			id_fakultas = Integer.parseInt(id_fkl);
			id_universitas = Integer.parseInt(id_univ);
		} catch (NumberFormatException e) {
			tes = false;
		}
		if (tes) {
			List<KurikulumModel> kurikulum = kurikulumService.selectKurikulumProdi(id_universitas, id_fakultas, id_prodi);
			Map<String, List<KurikulumModel>> map = new HashMap<>();
			map.put("kurikulum", kurikulum);
			
			if (kurikulum.size() > 0) {
				api.setResult(map);
				api.setMsg("success");
				api.setStatus(200);
			} else {
				tes = false;
			}
		}
		if (!tes) {
			api.setMsg("Kurikulum tidak ditemukan");
			api.setStatus(404);
		}
		
		return api;
	}
}
