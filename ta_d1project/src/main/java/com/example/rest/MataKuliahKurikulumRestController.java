package com.example.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.ApiModel;
import com.example.model.MataKuliahKurikulumModel;
import com.example.service.MataKuliahKurikulumService;

@RestController
@RequestMapping("/api")
public class MataKuliahKurikulumRestController {
	@Autowired
	MataKuliahKurikulumService matkulKurikulumService;
	
	@RequestMapping("/getMataKuliahByTerm/{term}")
	public ApiModel<Map <String, List<MataKuliahKurikulumModel>>> getMataKuliahTerm (@PathVariable (value= "term") String term) {
		int term_matkul = 0;
		boolean tes = true;
		ApiModel<Map <String, List<MataKuliahKurikulumModel>>> api = new ApiModel<Map <String, List<MataKuliahKurikulumModel>>>();
		
		try {
			term_matkul = Integer.parseInt(term);
		} 
		catch(NumberFormatException e){
	        tes = false;
	    }
		if (tes) {
			List<MataKuliahKurikulumModel> matkul = matkulKurikulumService.selectMatkulTerm(term_matkul);
			Map <String, List<MataKuliahKurikulumModel>> map = new HashMap<>();
			map.put("matkul", matkul);
				
			if(matkul.size() > 0) {
				api.setResult(map);
				api.setMsg("success");
				api.setStatus(200);
			} else {
				tes = false;
			}
		}
		 if (!tes) {
			api.setMsg("Mata Kuliah tidak ditemukan");
			api.setStatus(404);
		}
		
		return api;
	}
	
	@RequestMapping("/getMataKuliahKurikulum/{id}")
	public ApiModel<Map <String, MataKuliahKurikulumModel>> getMatkulKurikulum (@PathVariable (value= "id") String id) {
		int id_matkulk = 0;
		boolean tes = true;
		ApiModel<Map <String, MataKuliahKurikulumModel>> api = new ApiModel<Map <String, MataKuliahKurikulumModel>>();
		
		try {
			id_matkulk = Integer.parseInt(id);
		} 
		catch(NumberFormatException e){
	        tes = false;
	    }
		if (tes) {
			MataKuliahKurikulumModel matkulk = matkulKurikulumService.selectMataKuliahKurikulum(id_matkulk);
			Map <String, MataKuliahKurikulumModel> map = new HashMap<>();
			map.put("matkul", matkulk);
				
			if(matkulk != null) {
				api.setResult(map);
				api.setMsg("success");
				api.setStatus(200);
			} else {
				tes = false;
			}
		}
		 if (!tes) {
			api.setMsg("Mata Kuliah Kurikulum tidak ditemukan");
			api.setStatus(404);
		}
		
		return api;
	}
}
