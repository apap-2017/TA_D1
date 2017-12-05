package com.example.rest;

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
	public ApiModel view (@PathVariable (value= "id") String id) {
		int id_matkul = Integer.parseInt(id);
		MataKuliahModel matkul = mataKuliahService.selectMataKuliah(id_matkul);
		ApiModel api = new ApiModel();
		ResultModel result = new ResultModel();
		
		if(matkul != null) {
			result.setMatkul(matkul);
			
			api.setResult(result);
			api.setMsg("success");
			api.setStatus(200);
		} else {
			api.setMsg("Mata Kuliah tidak ditemukan");
			api.setStatus(404);
		}
		
		return api;
	}
}
