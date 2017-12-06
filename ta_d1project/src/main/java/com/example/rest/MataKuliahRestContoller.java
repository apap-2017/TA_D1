package com.example.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.ApiModel;
import com.example.model.MataKuliahModel;
import com.example.model.ResultModel;
import com.example.service.MataKuliahService;

@RestController
@RequestMapping("/api")
public class MataKuliahRestContoller {
	@Autowired
	MataKuliahService mataKuliahService;
	
	@RequestMapping("/getMataKuliah/{id}")
	public ApiModel<Map <String, MataKuliahModel>> view (@PathVariable (value= "id") String id) {
		int id_matkul = 0;
		boolean tes = true;
		ApiModel<Map <String, MataKuliahModel>> api = new ApiModel<Map <String, MataKuliahModel>>();
		
		try {
			id_matkul = Integer.parseInt(id);
		} 
		catch(NumberFormatException e){
	        tes = false;
	    }
		if (tes) {
			MataKuliahModel matkul = mataKuliahService.selectMataKuliah(id_matkul);
			Map <String, MataKuliahModel> map = new HashMap<>();
			map.put("matkul", matkul);
				
			if(matkul != null) {
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
}
