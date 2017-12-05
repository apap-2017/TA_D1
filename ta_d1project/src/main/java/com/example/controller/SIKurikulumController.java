package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.MataKuliahModel;
import com.example.service.MataKuliahService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SIKurikulumController {
	@Autowired
	MataKuliahService matkulDAO;
	//ProductService productDAO;

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	
	// akses halaman cari kurikulum
	@RequestMapping("/kurikulum")
	public String kurikulum() {
		return "kurikulum";
	}
	
	// akses halaman hasil cari kurikulum
	@RequestMapping("/kurikulum/result")
	public String resultKurikulum() {
		return "kurikulum-result";
	}
	
	// akses halaman lihat kurikulum
	@RequestMapping("/kurikulum/view")
	public String viewKurikulum() {
		return "kurikulum-view";
	}
	
	// akses halaman lihat kurikulum
	@RequestMapping("/kurikulum/view/{id}")
	public String viewPathKurikulum() {
		return "kurikulum-view";
	}
	
	// halaman tambah kurikulum
	@RequestMapping("/kurikulum/add")
	public String addKurikulum() {
		return "kurikulum-add";
	}
	
	// halaman ubah kurikulum
	@RequestMapping("/kurikulum/update/{id}")
	public String updateKurikulum() {
		return "kurikulum-update";
	}
	
	// akses halaman submit ubah kurikulum
	@RequestMapping("/kurikulum/update/submit")
	public String updateSubmitKurikulum() {
		return "redirect:/kurikulum/view/"; //+ kurikulum.getId();
	}
	
	// halaman hapus kurikulum
	@RequestMapping("/kurikulum/delete/{id}")
	public String deleteKurikulum() {
		return "kurikulum-delete";
	}
	
	@RequestMapping("/matkul/edit/{id}")
	public String editMatkul(Model model, @PathVariable(value="id") String id) {
		int id2 = Integer.parseInt(id);
		MataKuliahModel matkul = matkulDAO.selectMataKuliah(id2);
		if(matkul != null) {
			model.addAttribute("matkul",matkul);
			return "form-edit-matkul";
		} else {
			return "matkul-not-found";
		}
	}
	
	@RequestMapping("/matkul/add-prasyarat/{id}")
	public String addPrasyarat(Model model, @PathVariable(value="id") String id) {
		int id2 = Integer.parseInt(id);
		MataKuliahModel matkul = matkulDAO.selectMataKuliah(id2);
		if(matkul != null) {
			model.addAttribute("matkul",matkul);
			
			return "form-add-prasyarat";
		} else {
			return "matkul-not-found";
		}
	}
}