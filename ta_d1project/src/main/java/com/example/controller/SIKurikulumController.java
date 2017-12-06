package com.example.controller;

import java.util.List;
import java.util.Map;
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

import com.example.model.ApiModel;
import com.example.model.FakultasModel;
import com.example.model.KurikulumModel;
import com.example.model.MataKuliahKurikulumModel;
import com.example.model.ProdiModel;
import com.example.model.ResultModel;
import com.example.service.KurikulumService;
import com.example.service.KurikulumServiceDatabase;
import com.example.service.MataKuliahKurikulumService;
import com.example.service.UniversitasService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class SIKurikulumController {
	@Autowired
	MataKuliahService matkulDAO;
	@Autowired
	KurikulumService kurikulumDAO;
	@Autowired
	MataKuliahKurikulumService matkulKurikulumDAO;
	@Autowired
	UniversitasService universitasDAO;
	
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
	public String resultKurikulum(Model model, @RequestParam(value = "id_fakultas") int id_fakultas,
			@RequestParam(value = "id_prodi") int id_prodi) {
		List<KurikulumModel> kurikulum = kurikulumDAO.selectKurikulumbyParam(id_fakultas, id_prodi);

		if (kurikulum != null) {
			model.addAttribute("kurkulum", kurikulum);
			return "kurikulum-result";
		} else {
			model.addAttribute("id_fakultas", id_fakultas);
			model.addAttribute("id_prodi", id_prodi);
			return "not-found";
		}

	}

	// akses halaman lihat kurikulum
	@RequestMapping("/kurikulum/view")
	public String viewKurikulum(Model model, @RequestParam(value = "id") int id) {

//		KurikulumModel kurikulum = kurikulumDAO.selectKurikulum(id);
//		MataKuliahKurikulumModel matkulKurikulum = kurikulumDAO.selectMatkulbyId(kurikulum.getId_kurikulum());
//		List<MataKuliahKurikulumModel> listMatkul = kurikulumDAO.selectListMatkul(matkul.getId_kurikulum());
//		
//		if (kurikulum != null) {
//			model.addAttribute("kurikulum", kurikulum);
//			model.addAttribute("matkulKurikulum", matkulKurikulum);
//			model.addAttribute("matkul", matkul);
//			return "kurikulum-view";
//		} else {
//			model.addAttribute("id", id);
//			return "not-found";
//		}
		return null;
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
	
	// akses halaman submit tambah kurikulum
	@RequestMapping(value = "/kurikulum/add/submit", method = RequestMethod.POST)
	public String addSubmitKurikulum(KurikulumModel kurikulum) {
		//kurikulumDAO.addKurikulum(kurikulum, id_univ, id_fakultas, id_prodi);

		return "redirect:/kurikulum/view/" + kurikulum.getId();
	}

	// halaman ubah kurikulum
	@RequestMapping("/kurikulum/update/{id}")
	public String updateKurikulum(Model model, @PathVariable(value = "id") int id) {
		KurikulumModel kurikulum = kurikulumDAO.selectKurikulumR(id);

		if (kurikulum != null) {
			model.addAttribute("kurikulum", kurikulum);
			return "kurikulum-update";
		} else {
			model.addAttribute("id", id);
			return "kurikulum-not-found";
		}
	}

	// akses halaman submit ubah kurikulum
	@RequestMapping(value = "/kurikulum/update/submit", method = RequestMethod.POST)
	public String updateSubmitKurikulum(KurikulumModel kurikulum) {
		kurikulumDAO.updateKurikulum(kurikulum, kurikulum.getId());

		return "redirect:/kurikulum/view/" + kurikulum.getId();
	}

	// halaman konfirmasi hapus kurikulum
	@RequestMapping(value = "/kurikulum/delete", method = RequestMethod.POST)
	public String deleteKurikulumConfirmation(Model model, KurikulumModel kurikulum) {
		int id = kurikulum.getId();
		String nama_kurikulum = kurikulum.getNama_kurikulum();

		model.addAttribute("id", id);
		model.addAttribute("nama_kurikulum", nama_kurikulum);
		return "kurikulum-delete-confirmation";
	}

	// halaman hapus kurikulum
	@RequestMapping("/kurikulum/delete/{id}")
	public String deleteKurikulum(Model model, @PathVariable(value = "id") int id) {
		KurikulumModel kurikulum = kurikulumDAO.selectKurikulumR(id);

		if (kurikulum != null) {
			kurikulumDAO.deleteKurikulum(id);
			return "redirect:/kurikulum/result";
		} else {
			model.addAttribute("id", id);
			return "kurikulum-not-found";
		}
	}

	// halaman hapus matkul kurikulum
	@RequestMapping("/matkul-kurikulum/delete/{id_kurikulum}/{id_matkul_kurikulum}")
	public String deleteMataKuliahKurikulum(Model model, @PathVariable(value = "id_kurikulum") int id_kurikulum, @PathVariable(value = "id_matkul_kurikulum") int id_matkul_kurikulum) {
		matkulKurikulumDAO.deleteMataKuliahKurikulum(id_matkul_kurikulum);
		return "redirect:/kurikulum/view/" + id_kurikulum;
	}
	
	//halaman update matkul kurikulum
	@RequestMapping("/matkul-kurikulum/update/{id_kurikulum}/{id_matkul_kurikulum}")
	public String updateMatkulKurikulum(Model model, @PathVariable(value = "id_kurikulum") int id_kurikulum, @PathVariable(value = "id_matkul_kurikulum") int id_matkul_kurikulum) {
		MataKuliahKurikulumModel matkulKurikulum = matkulKurikulumDAO.selectMataKuliahKurikulum(id_matkul_kurikulum);		
		String kodeKurikulum = kurikulumDAO.selectKurikulumR(id_kurikulum).getKode_kurikulum();
		List<MataKuliahModel> matkuls = kurikulumDAO.selectMataKuliah(id_kurikulum);
		
		model.addAttribute("matkulKurikulum", matkulKurikulum);
		model.addAttribute("kodeKurikulum", kodeKurikulum);
		model.addAttribute("matkuls", matkuls);
		return "matkul-kurikulum-update";
	}
	
	// akses halaman submit ubah kurikulum
	@RequestMapping(value = "/matkul-kurikulum/update/submit", method = RequestMethod.POST)
	public String updateSubmitKurikulum(MataKuliahKurikulumModel matkulKurikulum) {
		matkulKurikulumDAO.updateMataKuliahKurikulum(matkulKurikulum, matkulKurikulum.getId());

		return "redirect:/kurikulum/view/" + matkulKurikulum.getId_kurikulum();
	}

	// akses halaman lihat kurikulum angkatan
	@RequestMapping("/kurikulum/angkatan")
	public String viewKurikulumAngkatan(Model model) {
		
		FakultasModel fakultas = universitasDAO.selectFakultas(1,1);
		ProdiModel prodi = universitasDAO.selectProdi(1, 1, 1);

		model.addAttribute("fakultas", fakultas);
		model.addAttribute("prodi", prodi);

		return "angkatan-view";
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