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

import com.example.model.KurikulumModel;
import com.example.service.KurikulumService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SIKurikulumController {
	@Autowired
	KurikulumService kurikulumDAO;

	@RequestMapping("/")
	public String index() {
		return "index";
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
	public String updateKurikulum(Model model, @PathVariable(value = "id") int id) {
		KurikulumModel kurikulum = kurikulumDAO.selectKurikulum(id);
		
		if(kurikulum != null) {
			model.addAttribute("kurikulum", kurikulum);
			return "kurikulum-update";
		} else {
			model.addAttribute("id", id);
			return "not-found";
		}
	}
	
	// akses halaman submit ubah kurikulum
	@RequestMapping(value = "/kurikulum/update/submit", method = RequestMethod.POST)
	public String updateSubmitKurikulum(KurikulumModel kurikulum) {
		kurikulumDAO.updateKurikulum(kurikulum, kurikulum.getId());
		
		return "redirect:/kurikulum/view/" + kurikulum.getId();
	}
	
	// halaman hapus kurikulum
	@RequestMapping("/kurikulum/delete/{id}")
	public String deleteKurikulum(Model model, @PathVariable (value = "id") int id) {
		KurikulumModel kurikulum = kurikulumDAO.selectKurikulum(id);
		
		if(kurikulum != null) {
			kurikulumDAO.deleteKurikulum(id);
			return "kurikulum-delete";
		} else {
			model.addAttribute("id", id);
			return "not-found";
		}
	}
}