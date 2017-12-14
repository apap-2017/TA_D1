package com.example.controller;

import java.util.List;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.model.MataKuliahModel;
import com.example.service.MataKuliahService;
import com.example.model.AngkatanModel;
import com.example.model.FakultasModel;
import com.example.model.KurikulumModel;
import com.example.model.MataKuliahKurikulumModel;
import com.example.model.ProdiModel;

import com.example.model.UserModel;
import com.example.service.KurikulumService;
import com.example.service.MataKuliahKurikulumService;
import com.example.service.UniversitasService;
import com.example.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class KurikulumController {
	@Autowired
	MataKuliahService matkulDAO;
	@Autowired
	KurikulumService kurikulumDAO;
	@Autowired
	MataKuliahKurikulumService matkulKurikulumDAO;
	@Autowired
	UniversitasService universitasDAO;
	@Autowired
	MataKuliahService matakuliahDAO;
	@Autowired
	UserService userDAO;

	// akses halaman hasil cari kurikulum
	@RequestMapping("/kurikulum/viewall")
	public String resultKurikulum(Model model, Principal principal) {
		String usernameUser = principal.getName();
		UserModel user = userDAO.selectUser(usernameUser);
		int id_univ = user.getId_univ();
		int id_fakultas = user.getId_fakultas();
		int id_prodi = user.getId_prodi();

		List<KurikulumModel> kurikulum = kurikulumDAO.selectKurikulumbyParam(id_univ, id_fakultas, id_prodi);
		FakultasModel fakultas = universitasDAO.selectFakultas(id_univ, id_fakultas);

		if(fakultas == null) {
			return "univ-null";
		}
		else if (kurikulum.size() > 0) {
			model.addAttribute("kurikulums", kurikulum);
			model.addAttribute("fakultas", fakultas);
			return "kurikulum-viewall";
		} else {
			model.addAttribute("kurikulums", kurikulum);
			model.addAttribute("fakultas", fakultas);
			return "kurikulum-viewall-empty";
		}
	}

	// akses halaman hasil cari kurikulum dari halaman index by kode
	@RequestMapping("/kurikulum/view")
	public String findKurikulum(Principal principal, Model model, @RequestParam(value = "kode_kurikulum") String kode_kurikulum) {
		String usernameUser = principal.getName();
		UserModel user = userDAO.selectUser(usernameUser);
		int id_univ = user.getId_univ();
		int id_fakultas = user.getId_fakultas();
		int id_prodi = user.getId_prodi();
		
		List<KurikulumModel> kurikulum = kurikulumDAO.selectKurikulumbyKode(id_univ, id_fakultas, id_prodi, kode_kurikulum);

		if (kurikulum.size() > 0) {
			model.addAttribute("kurikulums", kurikulum);
			return "kurikulum-viewall";
		} else {
			model.addAttribute("kode_kurikulum", kode_kurikulum);
			return "not-found";
		}

	}

	@RequestMapping("/kurikulum/view/{id}")
	public String viewPathKurikulum(Principal principal, Model model, @PathVariable(value = "id") int id) {
		String usernameUser = principal.getName();
		UserModel user = userDAO.selectUser(usernameUser);
		int id_univ = user.getId_univ();
		int id_fakultas = user.getId_fakultas();
		int id_prodi = user.getId_prodi();
		KurikulumModel kurikulum = kurikulumDAO.selectKurikulumR(id_univ, id_fakultas, id_prodi, id);

		List<MataKuliahModel> matkulTerm1 = kurikulumDAO.getMataKuliahByTerm(kurikulum, 1);
		List<MataKuliahModel> matkulTerm2 = kurikulumDAO.getMataKuliahByTerm(kurikulum, 2);
		List<MataKuliahModel> matkulTerm3 = kurikulumDAO.getMataKuliahByTerm(kurikulum, 3);
		List<MataKuliahModel> matkulTerm4 = kurikulumDAO.getMataKuliahByTerm(kurikulum, 4);
		List<MataKuliahModel> matkulTerm5 = kurikulumDAO.getMataKuliahByTerm(kurikulum, 5);
		List<MataKuliahModel> matkulTerm6 = kurikulumDAO.getMataKuliahByTerm(kurikulum, 6);
		List<MataKuliahModel> matkulTerm7 = kurikulumDAO.getMataKuliahByTerm(kurikulum, 7);
		List<MataKuliahModel> matkulTerm8 = kurikulumDAO.getMataKuliahByTerm(kurikulum, 8);

		List<MataKuliahKurikulumModel> matkulKurikulumTerm1 = kurikulumDAO.getMatkulKurikulumByTerm(kurikulum, 1);
		List<MataKuliahKurikulumModel> matkulKurikulumTerm2 = kurikulumDAO.getMatkulKurikulumByTerm(kurikulum, 2);
		List<MataKuliahKurikulumModel> matkulKurikulumTerm3 = kurikulumDAO.getMatkulKurikulumByTerm(kurikulum, 3);
		List<MataKuliahKurikulumModel> matkulKurikulumTerm4 = kurikulumDAO.getMatkulKurikulumByTerm(kurikulum, 4);
		List<MataKuliahKurikulumModel> matkulKurikulumTerm5 = kurikulumDAO.getMatkulKurikulumByTerm(kurikulum, 5);
		List<MataKuliahKurikulumModel> matkulKurikulumTerm6 = kurikulumDAO.getMatkulKurikulumByTerm(kurikulum, 6);
		List<MataKuliahKurikulumModel> matkulKurikulumTerm7 = kurikulumDAO.getMatkulKurikulumByTerm(kurikulum, 7);
		List<MataKuliahKurikulumModel> matkulKurikulumTerm8 = kurikulumDAO.getMatkulKurikulumByTerm(kurikulum, 8);

		if (kurikulum != null) {

			model.addAttribute("kurikulum", kurikulum);
			model.addAttribute("matkulTerm1", matkulTerm1);
			model.addAttribute("matkulTerm2", matkulTerm2);
			model.addAttribute("matkulTerm3", matkulTerm3);
			model.addAttribute("matkulTerm4", matkulTerm4);
			model.addAttribute("matkulTerm5", matkulTerm5);
			model.addAttribute("matkulTerm6", matkulTerm6);
			model.addAttribute("matkulTerm7", matkulTerm7);
			model.addAttribute("matkulTerm8", matkulTerm8);
			model.addAttribute("matkulKurikulumTerm1", matkulKurikulumTerm1);
			model.addAttribute("matkulKurikulumTerm2", matkulKurikulumTerm2);
			model.addAttribute("matkulKurikulumTerm3", matkulKurikulumTerm3);
			model.addAttribute("matkulKurikulumTerm4", matkulKurikulumTerm4);
			model.addAttribute("matkulKurikulumTerm5", matkulKurikulumTerm5);
			model.addAttribute("matkulKurikulumTerm6", matkulKurikulumTerm6);
			model.addAttribute("matkulKurikulumTerm7", matkulKurikulumTerm7);
			model.addAttribute("matkulKurikulumTerm8", matkulKurikulumTerm8);

			return "kurikulum-view";
		} else {
			model.addAttribute("id", id);
			return "kurikulum-not-found";
		}
	}

	// halaman tambah kurikulum
	@RequestMapping("/kurikulum/add")
	public String addKurikulum(Model model) {
		KurikulumModel kurikulum = new KurikulumModel();
		kurikulum.setKode_kurikulum(kurikulumDAO.generateNewCode());
		
		model.addAttribute("kurikulum", kurikulum);
		return "kurikulum-add";
	}

	// akses halaman submit tambah kurikulum
	@RequestMapping(value = "/kurikulum/add/submit", method = RequestMethod.POST)
	public String addSubmitKurikulum(KurikulumModel kurikulum, Principal principal) {
		String usernameUser = principal.getName();
		UserModel user = userDAO.selectUser(usernameUser);
		int id_univ = user.getId_univ();
		int id_fakultas = user.getId_fakultas();
		int id_prodi = user.getId_prodi();

		int id_kurikulum = kurikulumDAO.addKurikulum(kurikulum, id_univ, id_fakultas, id_prodi);

		return "redirect:/kurikulum/view/" + id_kurikulum;
	}

	// halaman tambah matkul kurikulum
	@RequestMapping("/matkul-kurikulum/add/{id_kurikulum}")
	public String addMatkulKurikulum(Principal principal, Model model, @PathVariable(value = "id_kurikulum") int id_kurikulum) {
		String usernameUser = principal.getName();
		UserModel user = userDAO.selectUser(usernameUser);
		int id_univ = user.getId_univ();
		int id_fakultas = user.getId_fakultas();
		int id_prodi = user.getId_prodi();
		KurikulumModel kurikulum = kurikulumDAO.selectKurikulumR(id_univ, id_fakultas, id_prodi,id_kurikulum);
		List<MataKuliahModel> matkuls = kurikulumDAO.selectMataKuliah(id_kurikulum);
		
		if(kurikulum != null) {
			String kodeKurikulum = kurikulumDAO.selectKurikulumR(id_univ, id_fakultas, id_prodi,id_kurikulum).getKode_kurikulum();
			model.addAttribute("id_kurikulum", id_kurikulum);
			model.addAttribute("kodeKurikulum", kodeKurikulum);
			model.addAttribute("matkuls", matkuls);
			model.addAttribute("matkulKurikulum", new MataKuliahKurikulumModel());
			return "matkul-kurikulum-add";
		} else {
			model.addAttribute("id", id_kurikulum);
			return "not-found";
		}
		
	}

	// akses halaman submit add matkul kurikulum
	@RequestMapping(value = "/matkul-kurikulum/add/submit/{id_kurikulum}", method = RequestMethod.POST)
	public String addSubmitKurikulum(MataKuliahKurikulumModel matkul_kurikulum,
			@PathVariable(value = "id_kurikulum") int id_kurikulum) {
		matkulKurikulumDAO.addMataKuliahKurikulum(matkul_kurikulum, id_kurikulum);

		log.info("controller id kurikulum {}", id_kurikulum);
		return "redirect:/kurikulum/view/" + id_kurikulum;
	}

	// halaman ubah kurikulum
	@RequestMapping("/kurikulum/update/{id}")
	public String updateKurikulum(Principal principal, Model model, @PathVariable(value = "id") int id) {
		String usernameUser = principal.getName();
		UserModel user = userDAO.selectUser(usernameUser);
		int id_univ = user.getId_univ();
		int id_fakultas = user.getId_fakultas();
		int id_prodi = user.getId_prodi();
		KurikulumModel kurikulum = kurikulumDAO.selectKurikulumR(id_univ, id_fakultas, id_prodi,id);

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
	@RequestMapping(value = "/kurikulum/delete-kurikulum/{id}")
	public String deleteKurikulum(Principal principal, Model model, @PathVariable(value = "id") int id) {
		String usernameUser = principal.getName();
		UserModel user = userDAO.selectUser(usernameUser);
		int id_univ = user.getId_univ();
		int id_fakultas = user.getId_fakultas();
		int id_prodi = user.getId_prodi();
		KurikulumModel kurikulum = kurikulumDAO.selectKurikulumR(id_univ, id_fakultas, id_prodi,id);

		if (kurikulum != null) {
			kurikulumDAO.deleteKurikulum(id);
			return "redirect:/kurikulum/viewall";
		} else {
			model.addAttribute("id", id);
			return "kurikulum-not-found";
		}
	}

	// halaman hapus kurikulum
	@RequestMapping("/kurikulum/delete/{id}")
	public String deleteKurikulumConfirmation(Principal principal, Model model, @PathVariable(value = "id") int id) {
		String usernameUser = principal.getName();
		UserModel user = userDAO.selectUser(usernameUser);
		int id_univ = user.getId_univ();
		int id_fakultas = user.getId_fakultas();
		int id_prodi = user.getId_prodi();
		
		KurikulumModel kurikulum = kurikulumDAO.selectKurikulumR(id_univ, id_fakultas, id_prodi, id);
		
		if (kurikulum != null) {
			String nama_kurikulum = kurikulum.getNama_kurikulum();
			model.addAttribute("id", id);
			model.addAttribute("nama_kurikulum", nama_kurikulum);
			return "kurikulum-delete-confirmation";
		} else {
			model.addAttribute("id", id);
			return "kurikulum-not-found";
		}

		
	}

	// halaman hapus matkul kurikulum
	@RequestMapping("/matkul-kurikulum/delete/{id_kurikulum}/{id_matkul_kurikulum}")
	public String deleteMataKuliahKurikulum(Model model, @PathVariable(value = "id_kurikulum") int id_kurikulum,
			@PathVariable(value = "id_matkul_kurikulum") int id_matkul_kurikulum) {
		matkulKurikulumDAO.deleteMataKuliahKurikulum(id_matkul_kurikulum);
		return "redirect:/kurikulum/view/" + id_kurikulum;
	}

	// halaman update matkul kurikulum
	@RequestMapping("/matkul-kurikulum/update/{id_kurikulum}/{id_matkul_kurikulum}")
	public String updateMatkulKurikulum(Principal principal, Model model, @PathVariable(value = "id_kurikulum") int id_kurikulum,
			@PathVariable(value = "id_matkul_kurikulum") int id_matkul_kurikulum) {
		String usernameUser = principal.getName();
		UserModel user = userDAO.selectUser(usernameUser);
		int id_univ = user.getId_univ();
		int id_fakultas = user.getId_fakultas();
		int id_prodi = user.getId_prodi();
		KurikulumModel kurikulum = kurikulumDAO.selectKurikulumR(id_univ, id_fakultas, id_prodi,id_kurikulum);

		if(kurikulum != null) {
			String kodeKurikulum = kurikulum.getKode_kurikulum();
			List<MataKuliahModel> matkuls = kurikulumDAO.selectMataKuliah(id_kurikulum);
			MataKuliahKurikulumModel matkulKurikulum = matkulKurikulumDAO.selectMataKuliahKurikulum(id_matkul_kurikulum);

			model.addAttribute("matkulKurikulum", matkulKurikulum);
			model.addAttribute("kodeKurikulum", kodeKurikulum);
			model.addAttribute("matkuls", matkuls);
			return "matkul-kurikulum-update";
		}
		else {
			model.addAttribute("id", id_kurikulum);
			return "kurikulum-not-found";
		}
	}

	// akses halaman submit ubah matkul kurikulum
	@RequestMapping(value = "/matkul-kurikulum/update/submit", method = RequestMethod.POST)
	public String updateSubmitKurikulum(MataKuliahKurikulumModel matkulKurikulum) {
		matkulKurikulumDAO.updateMataKuliahKurikulum(matkulKurikulum, matkulKurikulum.getId());

		return "redirect:/kurikulum/view/" + matkulKurikulum.getId_kurikulum();
	}

	@RequestMapping("/kurikulum/angkatan")
	public String viewKurikulumAngkatan(Model model, Principal principal) {
		String usernameUser = principal.getName();
		UserModel user = userDAO.selectUser(usernameUser);
		FakultasModel fakultas = universitasDAO.selectFakultas(user.getId_univ(), user.getId_fakultas());
		ProdiModel prodi = universitasDAO.selectProdi(user.getId_univ(), user.getId_fakultas(), user.getId_prodi());
		List<AngkatanModel> angkatans = universitasDAO.selectAngkatan(user.getId_univ(), user.getId_fakultas(),
				user.getId_prodi());
		
		if(fakultas == null || prodi == null) {
			return "univ-null";
		} else {
			model.addAttribute("fakultas", fakultas);
			model.addAttribute("prodi", prodi);
			model.addAttribute("angkatans", angkatans);
			return "angkatan-view";
		}
	}
}