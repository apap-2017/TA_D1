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

import com.example.model.ApiModel;
import com.example.model.FakultasModel;
import com.example.model.KurikulumModel;
import com.example.model.ProdiModel;
import com.example.model.ResultModel;
import com.example.service.KurikulumService;
import com.example.service.UniversitasService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SIKurikulumController {
	@Autowired
	MataKuliahService matkulDAO;
	KurikulumService kurikulumDAO;
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

	// halaman ubah kurikulum part 1
	@RequestMapping("/kurikulum/update/{id}")
	public String updateKurikulum(Model model, @PathVariable(value = "id") int id) {
		KurikulumModel kurikulum = kurikulumDAO.selectKurikulum(id);

		if (kurikulum != null) {
			String fakultas = universitasDAO.selectFakultas(kurikulum.getId_univ(), kurikulum.getId_fakultas()).getResult().getFakultas().getNama_fakultas();
			String prodi = universitasDAO.selectProdi(kurikulum.getId_univ(), kurikulum.getId_fakultas(), kurikulum.getId_prodi()).getResult().getProdi().getNama_prodi();
			
			model.addAttribute("fakultas", fakultas);
			model.addAttribute("prodi", prodi);
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
		KurikulumModel kurikulum = kurikulumDAO.selectKurikulum(id);

		if (kurikulum != null) {
			kurikulumDAO.deleteKurikulum(id);
			return "redirect:/kurikulum/result";
		} else {
			model.addAttribute("id", id);
			return "kurikulum-not-found";
		}
	}

	// akses halaman lihat kurikulum angkatan
	@RequestMapping("/kurikulum/angkatan")
	public String viewKurikulumAngkatan(Model model,
			@RequestParam(value = "fakultas", required = false) String fakultas,
			@RequestParam(value = "prodi", required = false) String prodi) {
		String halaman = "angkatan-pilihFakultas";

		if (fakultas != null) {
			int id_fakultas = Integer.parseInt(fakultas);
			if (prodi != null) {
				int id_prodi = Integer.parseInt(prodi);
				ApiModel apiSatu = universitasDAO.selectProdi(1, id_fakultas, id_prodi);
				ApiModel apiDua = universitasDAO.selectFakultas(1, id_fakultas);
				
				FakultasModel fkl = apiDua.getResult().getFakultas();
				ProdiModel prd = apiSatu.getResult().getProdi();
				
				model.addAttribute("fakultas", fkl);
				model.addAttribute("prodi", prd);
				
				halaman="angkatan-view";
			} else {
				ApiModel apiSatu = universitasDAO.selectAllProdi(1, id_fakultas);
				ApiModel apiDua = universitasDAO.selectFakultas(1, id_fakultas);
				List<ProdiModel> listProdi = apiSatu.getResult().getProdiList();
				FakultasModel fkl = apiDua.getResult().getFakultas();

				model.addAttribute("fakultas", fkl);
				model.addAttribute("listProdi", listProdi);

				halaman = "angkatan-pilihProdi";
			}
			
		}
		else {
			ApiModel api = universitasDAO.selectAllFakultas(1);
			ResultModel result = api.getResult();
			List<FakultasModel> listFakultas = result.getFakultasList();

			model.addAttribute("listFakultas", listFakultas);

		}
		return halaman;
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