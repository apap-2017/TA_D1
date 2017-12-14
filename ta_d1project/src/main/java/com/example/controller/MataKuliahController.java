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
import com.example.model.ProdiModel;

import com.example.model.UserModel;
import com.example.service.KurikulumService;
import com.example.service.MataKuliahKurikulumService;
import com.example.service.UniversitasService;
import com.example.service.UserService;

@Controller
public class MataKuliahController {
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

	@RequestMapping("/matkul/edit/{id}")
	public String editMatkul(Principal principal, Model model, @PathVariable(value = "id") String id) {
		int id2 = Integer.parseInt(id);
		String usernameUser = principal.getName();
		UserModel user = userDAO.selectUser(usernameUser);
		int id_univ = user.getId_univ();
		int id_fakultas = user.getId_fakultas();
		int id_prodi = user.getId_prodi();

		MataKuliahModel matkul = matkulDAO.selectMataKuliah(id_univ, id_fakultas, id_prodi, id2);
		if (matkul != null) {
			model.addAttribute("matkul", matkul);
			return "form-edit-matkul";
		} else {
			return "matkul-not-found";
		}
	}

	@RequestMapping("/matkul/add-prasyarat/{id}")
	public String addPrasyarat(Principal principal, Model model, @PathVariable(value = "id") String id) {
		int id2 = Integer.parseInt(id);
		String usernameUser = principal.getName();
		UserModel user = userDAO.selectUser(usernameUser);
		int id_univ = user.getId_univ();
		int id_fakultas = user.getId_fakultas();
		int id_prodi = user.getId_prodi();

		MataKuliahModel matkul = matkulDAO.selectMataKuliah(id_univ, id_fakultas, id_prodi, id2);

		if (matkul != null) {
			System.out.println(id_univ + " " + id_fakultas + " " + id_prodi + " " + matkul.getNama_matkul());
			List<MataKuliahModel> listMatkul = matkulDAO.selectMataKuliahProdi(id_univ, id_fakultas, id_prodi);
			System.out.println(listMatkul.get(1).getNama_matkul());
			String msg = null;
			model.addAttribute("msg", msg);
			model.addAttribute("matkul", matkul);
			model.addAttribute("listMatkul", listMatkul);
			return "form-add-prasyarat";
		} else {
			return "matkul-not-found";
		}
	}

	@RequestMapping(value = "/matkul/add-prasyarat/submit", method = RequestMethod.POST)
	public String submitPrasyarat(Principal principal, Model model,
			@RequestParam(value = "id_prasyarat") int id_prasyarat, @RequestParam(value = "id_matkul") int id_matkul) {
		String usernameUser = principal.getName();
		UserModel user = userDAO.selectUser(usernameUser);
		int id_univ = user.getId_univ();
		int id_fakultas = user.getId_fakultas();
		int id_prodi = user.getId_prodi();

		MataKuliahModel matkul = matkulDAO.selectMataKuliah(id_univ, id_fakultas, id_prodi, id_matkul);
		if (!matkulDAO.cekPrasyarat(matkul.getListPrasyarat(), id_prasyarat)) {
			MataKuliahModel matpras = matkulDAO.selectMataKuliah(id_univ, id_fakultas, id_prodi, id_prasyarat);
			int idtable = matkulDAO.getIdPrasyarat();
			idtable = idtable + 1;
			matkulDAO.addPrasyarat(idtable, matkul.getKode_matkul(), matpras.getKode_matkul());
			return "redirect:/matkul/edit/" + matkul.getId();
		} else {
			return "redirect:/matkul/add-prasyarat/error/" + id_matkul;
		}
	}

	@RequestMapping("/matkul/add-prasyarat/error/{id}")
	public String addPrasyaratError(Principal principal, Model model, @PathVariable(value = "id") String id) {
		int id2 = Integer.parseInt(id);
		String usernameUser = principal.getName();
		UserModel user = userDAO.selectUser(usernameUser);
		int id_univ = user.getId_univ();
		int id_fakultas = user.getId_fakultas();
		int id_prodi = user.getId_prodi();
		MataKuliahModel matkul = matkulDAO.selectMataKuliah(id_univ, id_fakultas, id_prodi, id2);

		if (matkul != null) {
			System.out.println(id_univ + " " + id_fakultas + " " + id_prodi + " " + matkul.getNama_matkul());
			List<MataKuliahModel> listMatkul = matkulDAO.selectMataKuliahProdi(id_univ, id_fakultas, id_prodi);
			System.out.println(listMatkul.get(1).getNama_matkul());
			String msg = "error";
			model.addAttribute("msg", msg);
			model.addAttribute("matkul", matkul);
			model.addAttribute("listMatkul", listMatkul);
			return "form-add-prasyarat";
		} else {
			return "matkul-not-found";
		}
	}

	@RequestMapping(value = "/matkul/delete-prasyarat", method = RequestMethod.GET)
	public String deletePrasyarat(Principal principal, Model model,
			@RequestParam(value = "id_prasyarat") int id_prasyarat, @RequestParam(value = "id_matkul") int id_matkul) {
		String usernameUser = principal.getName();
		UserModel user = userDAO.selectUser(usernameUser);
		int id_univ = user.getId_univ();
		int id_fakultas = user.getId_fakultas();
		int id_prodi = user.getId_prodi();

		MataKuliahModel matkul = matkulDAO.selectMataKuliah(id_univ, id_fakultas, id_prodi, id_matkul);
		MataKuliahModel matpras = matkulDAO.selectMataKuliah(id_univ, id_fakultas, id_prodi, id_prasyarat);
		System.out.println(matkul.getNama_matkul() + " " + matpras.getNama_matkul());
		matkulDAO.deletePrasyarat(matkul.getKode_matkul(), matpras.getKode_matkul());
		return "redirect:/matkul/edit/" + matkul.getId();
	}

	@RequestMapping(value = "/matkul/update/submit", method = RequestMethod.POST)
	public String updateMatkul(@RequestParam(value = "kode_matkul", required = false) String kode_matkul,
			@RequestParam(value = "nama_matkul", required = false) String nama_matkul,
			@RequestParam(value = "jumlah_sks", required = false) String jumlah_sks,
			@RequestParam(value = "prasyarat_sks", required = false) String prasyarat_sks) {
		int jumlah_sks2 = Integer.parseInt(jumlah_sks);
		int prasyarat_sks2 = Integer.parseInt(prasyarat_sks);
		matkulDAO.updateMataKuliah(kode_matkul, jumlah_sks2, prasyarat_sks2, nama_matkul);
		return "redirect:/";
	}

	@RequestMapping("/matkul/delete/{id}")
	public String deleteMatkul(Principal principal, Model model, @PathVariable(value = "id") String id) {
		int id2 = Integer.parseInt(id);
		String usernameUser = principal.getName();
		UserModel user = userDAO.selectUser(usernameUser);
		int id_univ = user.getId_univ();
		int id_fakultas = user.getId_fakultas();
		int id_prodi = user.getId_prodi();
		MataKuliahModel matkul = matkulDAO.selectMataKuliah(id_univ, id_fakultas, id_prodi, id2);
		if (matkul != null) {
			model.addAttribute("matkul", matkul);
			return "matkul-delete";
		} else {
			return "matkul-not-found";
		}
	}

	@RequestMapping("/matkul/delete/submit/{id}")
	public String deleteMatkulSubmit(Principal principal, Model model, @PathVariable(value = "id") String id) {
		int id2 = Integer.parseInt(id);
		String usernameUser = principal.getName();
		UserModel user = userDAO.selectUser(usernameUser);
		int id_univ = user.getId_univ();
		int id_fakultas = user.getId_fakultas();
		int id_prodi = user.getId_prodi();
		MataKuliahModel matkul = matkulDAO.selectMataKuliah(id_univ, id_fakultas, id_prodi, id2);
		if (matkul != null) {
			model.addAttribute("matkul", matkul);
			matkulDAO.deleteMatkul(id2);
			return "redirect:/";
		} else {
			return "matkul-not-found";
		}

	}

	// akses halaman lihat mata kuliah
	@RequestMapping("/matakuliah-result")
	 public String viewMataKuliah(Model model, Principal principal) {
	  String usernameUser = principal.getName();
	  UserModel user = userDAO.selectUser(usernameUser); 
	  List<MataKuliahModel> matkuls = matakuliahDAO.selectMataKuliahProdi(user.getId_univ() ,user.getId_fakultas(), user.getId_prodi());
	  if(matkuls.size() > 0) {
		  model.addAttribute("matkuls", matkuls);
		  return "matakuliah-result";
	  } else {
		  return "matkul-not-found";
	  }
	  
	 }

	// akses halaman tambah mata kuliah
	@RequestMapping("/matakuliah/add")
	public String addMataKuliah(Principal principal, Model model) {
		String usernameUser = principal.getName();
		UserModel user = userDAO.selectUser(usernameUser);

		ProdiModel prodi = universitasDAO.selectProdi(1, user.getId_fakultas(), user.getId_prodi());
		model.addAttribute("prodi", prodi);
		return "matakuliah-add";
	}

	// akses submit tambah mata kuliah
	@RequestMapping(value = "/matakuliah/add/submit", method = RequestMethod.POST)
	public String addMataKuliah(Model model, Principal principal,
			@RequestParam(value = "kode_matkul", required = false) String kode_matkul,
			@RequestParam(value = "nama_matkul", required = false) String nama_matkul,
			@RequestParam(value = "jumlah_sks", required = false) String jumlah_sks,
			@RequestParam(value = "prasyarat_sks", required = false) String prasyarat_sks) {
		int jumlah_sks2 = Integer.parseInt(jumlah_sks);
		int prasyarat_sks2 = Integer.parseInt(prasyarat_sks);
		// MataKuliahModel matkul = new MataKuliahModel(kode_matkul, nama_matkul,
		// jumlah_sks2, prasyarat_sks2);
		String usernameUser = principal.getName();
		UserModel user = userDAO.selectUser(usernameUser);

		ProdiModel prodi = universitasDAO.selectProdi(1, user.getId_fakultas(), user.getId_prodi());
		model.addAttribute("prodi", prodi);
		System.out.println(jumlah_sks);

		matakuliahDAO.addMataKuliah(kode_matkul, nama_matkul, jumlah_sks2, prasyarat_sks2, prodi.getId_univ(),
				prodi.getId_fakultas(), prodi.getId_prodi());

		return "matakuliah-submit-success";
	}

	// akses halaman lihat mata kuliah
	@RequestMapping("/matakuliah/view/{id}")
	public String viewPathMataKuliah(Principal principal, Model model, @PathVariable(value = "id") String id) {
		int id3 = Integer.parseInt(id);
		String usernameUser = principal.getName();
		UserModel user = userDAO.selectUser(usernameUser);
		int id_univ = user.getId_univ();
		int id_fakultas = user.getId_fakultas();
		int id_prodi = user.getId_prodi();
		MataKuliahModel matkul1 = matkulDAO.selectMataKuliah(id_univ, id_fakultas, id_prodi, id3);

		if (matkul1 != null) {
			model.addAttribute("matkul1", matkul1);
			return "matakuliah-view";
		} else {
			model.addAttribute("id", id);
			return "matakuliah-not-found";
		}
	}

	@RequestMapping("/matakuliah/viewkode")
	public String viewPathMataKuliahKode(Model model, @RequestParam(value = "kode") String kode) {

		MataKuliahModel matkul1 = matkulDAO.selectMataKuliahByKode(kode);
		if (matkul1 != null) {
			model.addAttribute("matkul1", matkul1);
			return "matakuliah-view";
		} else {
			model.addAttribute("kode", kode);
			return "matakuliah-not-found";
		}
	}

}