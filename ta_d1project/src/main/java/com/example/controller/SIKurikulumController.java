package com.example.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.MataKuliahModel;
import com.example.service.MataKuliahService;

import com.example.model.ApiModel;
import com.example.model.FakultasModel;
import com.example.model.KurikulumModel;
import com.example.model.MataKuliahModel;
import com.example.model.MataKuliahKurikulumModel;
import com.example.model.ProdiModel;
import com.example.model.ResultModel;

import com.example.model.UniversitasModel;
import com.example.model.UserModel;
import com.example.service.KurikulumService;
import com.example.service.MataKuliahService;
import com.example.service.KurikulumServiceDatabase;
import com.example.service.MataKuliahKurikulumService;
import com.example.service.UniversitasService;
import com.example.service.UserService;

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
	@Autowired
	MataKuliahService matakuliahDAO;
	@Autowired
	UserService userDao;

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
	@RequestMapping("/kurikulum/viewall")
	public String resultKurikulum(Model model, @RequestParam(value = "id_univ") int id_univ,
			@RequestParam(value = "id_fakultas") int id_fakultas, @RequestParam(value = "id_prodi") int id_prodi) {
		// FakultasModel fakultas = universitasDAO.
		List<KurikulumModel> kurikulum = kurikulumDAO.selectKurikulumbyParam(id_univ, id_fakultas, id_prodi);
		// FakultasModel fakultas = kurikulumDAO.selectFakultasbyId(id_fakultas,
		// id_univ);

		if (kurikulum != null) {
			model.addAttribute("kurikulums", kurikulum);
			// model.addAttribute("fakultas", fakultas);
			return "kurikulum-viewall";
		} else {
			model.addAttribute("id_fakultas", id_fakultas);
			model.addAttribute("id_prodi", id_prodi);
			return "not-found";
		}

	}

	// akses halaman lihat kurikulum

//	@RequestMapping("/kurikulum/view")
//	public String viewKurikulum(Model model, @RequestParam(value = "id") int id) {
//		KurikulumModel kurikulum = kurikulumDAO.selectKurikulum(id);
//		MataKuliahKurikulumModel matkulKurikulum = kurikulumDAO.selectMatkulbyId(kurikulum.getId() );
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
//	}

	@RequestMapping("/kurikulum/view/{id}")
	public String viewPathKurikulum(Model model, @PathVariable(value = "id") int id) {
		KurikulumModel kurikulum = kurikulumDAO.selectKurikulumR(id);

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

		// List<MataKuliahKurikulumModel> matkul_kurikulum =
		// kurikulum.getListMataKuliahKurikulum();
		// List<MataKuliahModel> matkul = kurikulum.getListMataKuliah();

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

			// model.addAttribute("matkul_kurikulum", matkul_kurikulum);
			// model.addAttribute("matkul", matkul);
			return "kurikulum-view";
		} else {
			model.addAttribute("id", id);
			return "not-found";
		}
	}

	// akses halaman lihat kurikulum
	// @RequestMapping("/kurikulum/view/{id}")
	// public String viewPathKurikulum() {
	//
	// return "kurikulum-view";
	// }

	// halaman tambah kurikulum
	// @RequestMapping("/kurikulum/add")
	// public String addKurikulum() {
	// return "kurikulum-add";
	// }

	// akses halaman submit tambah kurikulum
	// @RequestMapping(value = "/kurikulum/add/submit", method = RequestMethod.POST)
	// public String addSubmitKurikulum(KurikulumModel kurikulum) {
	// kurikulumDAO.addKurikulum(kurikulum);
	//
	// return "redirect:/kurikulum/view/" + kurikulum.getId();
	// }

	// halaman tambah kurikulum
	@RequestMapping("/kurikulum/add")
	public String addKurikulum(Model model) {
		model.addAttribute("kurikulum", new KurikulumModel());
		return "kurikulum-add";
	}

	// akses halaman submit tambah kurikulum
	@RequestMapping(value = "/kurikulum/add/submit", method = RequestMethod.POST)
	public String addSubmitKurikulum(KurikulumModel kurikulum) {
		// kurikulumDAO.addKurikulum(kurikulum, id_univ, id_fakultas, id_prodi);

		return "redirect:/kurikulum/view/" + kurikulum.getId();
	}

	// halaman tambah matkul kurikulum
	@RequestMapping("/matkul-kurikulum/add/{id_kurikulum}")
	public String addMatkulKurikulum(Model model, @PathVariable(value = "id_kurikulum") int id_kurikulum) {
		String kodeKurikulum = kurikulumDAO.selectKurikulumR(id_kurikulum).getKode_kurikulum();
		List<MataKuliahModel> matkuls = kurikulumDAO.selectMataKuliah(id_kurikulum);

		model.addAttribute("kodeKurikulum", kodeKurikulum);
		model.addAttribute("matkuls", matkuls);
		return "matkul-kurikulum-add";
	}

	// akses halaman submit add matkul kurikulum
	@RequestMapping(value = "/matkul-kurikulum/add/submit", method = RequestMethod.POST)
	public String addSubmitKurikulum(MataKuliahKurikulumModel matkul_kurikulum) {
		matkulKurikulumDAO.addMataKuliahKurikulum(matkul_kurikulum);

		return "redirect:/kurikulum/view/" + matkul_kurikulum.getId_kurikulum();
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
	@RequestMapping(value = "/kurikulum/delete/{id}/{nama_kurikulum}", method = RequestMethod.POST)
	public String deleteKurikulum(Model model, @PathVariable(value = "id") int id, @PathVariable(value = "nama_kurikulum") int nama_kurikulum) {
		KurikulumModel kurikulum = kurikulumDAO.selectKurikulumR(id);
		
		if (kurikulum != null) {
			kurikulumDAO.deleteKurikulum(id);
			return "redirect:/kurikulum/result";
		} else {
			model.addAttribute("id", id);
			return "kurikulum-not-found";
		}
	}

	// halaman hapus kurikulum
	@RequestMapping("/kurikulum/delete/{id}")
	public String deleteKurikulumConfirmation(Model model, @PathVariable(value = "id") int id) {
		KurikulumModel kurikulum = kurikulumDAO.selectKurikulumR(id);
		String nama_kurikulum = kurikulum.getNama_kurikulum();
		
		model.addAttribute("id", id);
		model.addAttribute("nama_kurikulum", nama_kurikulum);
		return "kurikulum-delete-confirmation";
	}


//	// halaman hapus mata kuliah kurikulum
//	@RequestMapping("/mata-kuliah-kurikulum/delete/{id_kurikulum}/{id_mata_kuliah_kurikulum}")
//	public String deleteMataKuliahKurikulum(Model model, @PathVariable(value = "id_kurikulum") int id_kurikulum, @PathVariable(value = "id_mata_kuliah_kurikulum") int id_mata_kuliah_kurikulum) {
//		mataKuliahKurikulumDAO.deleteMataKuliahKurikulum(id_mata_kuliah_kurikulum);
//		return "redirect:/kurikulum/view/" + id_kurikulum;
//	}

	// halaman hapus matkul kurikulum
	@RequestMapping("/matkul-kurikulum/delete/{id_kurikulum}/{id_matkul_kurikulum}")
	public String deleteMataKuliahKurikulum(Model model, @PathVariable(value = "id_kurikulum") int id_kurikulum,
			@PathVariable(value = "id_matkul_kurikulum") int id_matkul_kurikulum) {
		matkulKurikulumDAO.deleteMataKuliahKurikulum(id_matkul_kurikulum);
		return "redirect:/kurikulum/view/" + id_kurikulum;
	}

	// halaman update matkul kurikulum
	@RequestMapping("/matkul-kurikulum/update/{id_kurikulum}/{id_matkul_kurikulum}")
	public String updateMatkulKurikulum(Model model, @PathVariable(value = "id_kurikulum") int id_kurikulum,
			@PathVariable(value = "id_matkul_kurikulum") int id_matkul_kurikulum) {
		MataKuliahKurikulumModel matkulKurikulum = matkulKurikulumDAO.selectMataKuliahKurikulum(id_matkul_kurikulum);
		String kodeKurikulum = kurikulumDAO.selectKurikulumR(id_kurikulum).getKode_kurikulum();
		List<MataKuliahModel> matkuls = kurikulumDAO.selectMataKuliah(id_kurikulum);

		model.addAttribute("matkulKurikulum", matkulKurikulum);
		model.addAttribute("kodeKurikulum", kodeKurikulum);
		model.addAttribute("matkuls", matkuls);
		return "matkul-kurikulum-update";
	}

	// akses halaman submit ubah matkul kurikulum
	@RequestMapping(value = "/matkul-kurikulum/update/submit", method = RequestMethod.POST)
	public String updateSubmitKurikulum(MataKuliahKurikulumModel matkulKurikulum) {
		matkulKurikulumDAO.updateMataKuliahKurikulum(matkulKurikulum, matkulKurikulum.getId());

		return "redirect:/kurikulum/view/" + matkulKurikulum.getId_kurikulum();
	}

	// akses halaman lihat kurikulum angkatan
	@RequestMapping("/kurikulum/angkatan")
	public String viewKurikulumAngkatan(Model model) {

		FakultasModel fakultas = universitasDAO.selectFakultas(1, 1);
		ProdiModel prodi = universitasDAO.selectProdi(1, 1, 1);

		model.addAttribute("fakultas", fakultas);
		model.addAttribute("prodi", prodi);

		return "angkatan-view";
	}

	@RequestMapping("/matkul/edit/{id}")
	public String editMatkul(Model model, @PathVariable(value = "id") String id) {
		int id2 = Integer.parseInt(id);
		MataKuliahModel matkul = matkulDAO.selectMataKuliah(id2);
		if (matkul != null) {
			model.addAttribute("matkul", matkul);
			return "form-edit-matkul";
		} else {
			return "matkul-not-found";
		}
	}

	@RequestMapping("/matkul/add-prasyarat/{id}")
	public String addPrasyarat(Model model, @PathVariable(value = "id") String id) {
		int id2 = Integer.parseInt(id);
		MataKuliahModel matkul = matkulDAO.selectMataKuliah(id2);
		
		if(matkul != null) {
			int id_univ = matkul.getId_univ();
			int id_fakultas = matkul.getId_fakultas();
			int id_prodi = matkul.getId_prodi();
			System.out.println(id_univ + " " + id_fakultas + " " + id_prodi + " " + matkul.getNama_matkul() );
			List<MataKuliahModel> listMatkul = matkulDAO.selectMataKuliahProdi(id_univ,id_fakultas,id_prodi);
			System.out.println(listMatkul.get(1).getNama_matkul());
			model.addAttribute("matkul",matkul);
			model.addAttribute("listMatkul",listMatkul);
			return "form-add-prasyarat";
		} else {
			return "matkul-not-found";
		}
	}


	@RequestMapping(value = "/matkul/add-prasyarat/submit", method = RequestMethod.POST)
	public String submitPrasyarat(Model model, 
								  @RequestParam(value="id_prasyarat") int id_prasyarat,
								  @RequestParam(value="id_matkul") int id_matkul
			)
	{
		MataKuliahModel matkul = matkulDAO.selectMataKuliah(id_matkul);
		if(!matkulDAO.cekPrasyarat(matkul.getListPrasyarat(),id_prasyarat)) {
			MataKuliahModel matpras = matkulDAO.selectMataKuliah(id_prasyarat);
			int idtable = matkulDAO.getIdPrasyarat();
			idtable = idtable + 1;
			matkulDAO.addPrasyarat(idtable,matkul.getKode_matkul(), matpras.getKode_matkul());
			return "redirect:/matkul/edit/" + matkul.getId();
		} else {
			MataKuliahModel matpras = matkulDAO.selectMataKuliah(id_prasyarat);
			model.addAttribute("matkul",matkul);
			model.addAttribute("matpras", matpras);
			return "failed-add-prasyarat";
		}
	}
	
	@RequestMapping(value = "/matkul/delete-prasyarat", method = RequestMethod.GET)
	public String deletePrasyarat(Model model, 
								  @RequestParam(value="id_prasyarat") int id_prasyarat,
								  @RequestParam(value="id_matkul") int id_matkul
	) {
		MataKuliahModel matkul = matkulDAO.selectMataKuliah(id_matkul);
		MataKuliahModel matpras = matkulDAO.selectMataKuliah(id_prasyarat);
		System.out.println(matkul.getNama_matkul() + " " + matpras.getNama_matkul());
		matkulDAO.deletePrasyarat(matkul.getKode_matkul(),matpras.getKode_matkul());
		return "redirect:/matkul/edit/" + matkul.getId();
	}
	
	@RequestMapping(value = "/matkul/update/submit", method = RequestMethod.POST)
	public String updateMatkul(
							   @RequestParam(value="kode_matkul", required=false) String kode_matkul,
							   @RequestParam(value="nama_matkul", required=false) String nama_matkul,
							   @RequestParam(value="jumlah_sks", required=false) String jumlah_sks,
							   @RequestParam(value="prasyarat_sks", required=false) String prasyarat_sks) {
		int jumlah_sks2 = Integer.parseInt(jumlah_sks);
		int prasyarat_sks2 = Integer.parseInt(prasyarat_sks);
		matkulDAO.updateMataKuliah(kode_matkul,jumlah_sks2,prasyarat_sks2,nama_matkul );
		return "redirect:/";
	}
	
	
	@RequestMapping(value = "/username", method = RequestMethod.GET)
	@ResponseBody
	public String currentUserName(Principal principal) {
		return principal.getName();
	}
	
	@RequestMapping(value="/contoh", method = RequestMethod.GET)
	@ResponseBody
	public String contoh(Principal principal) {
		String usernameUser = principal.getName();
		UserModel user = userDao.selectUser(usernameUser);
		return "" + user.getNama() + " " + user.getPassword() + " " + user.getUsername();
	}
	
	@RequestMapping("/matkul/delete/{id}")
	public String deleteMatkul (Model model, @PathVariable(value = "id") String id)
	{
		int id2 = Integer.parseInt(id);
		MataKuliahModel matkul = matkulDAO.selectMataKuliah(id2);
		model.addAttribute("matkul",matkul);
		return "matkul-delete";

	}
	
	@RequestMapping("/matkul/delete/submit/{id}")
	public String deleteMatkulSubmit (Model model, @PathVariable(value = "id") String id)
	{
		int id2 = Integer.parseInt(id);
		MataKuliahModel matkul = matkulDAO.selectMataKuliah(id2);
		model.addAttribute("matkul",matkul);
		matkulDAO.deleteMatkul (id2);
		return "redirect:/";

	}


	// // akses halaman cari mata kuliah
	// @RequestMapping("/matakuliah")
	// public String matakuliah(Model model, @RequestParam(value="fakultas",
	// required=false)
	// String id_fakultas, @RequestParam(value="prodi", required=false)
	// String id_prodi ) {
	// if(id_fakultas != null){
	// if(id_prodi != null){
	// return "matakuliah-view";
	// } else {
	// int id_fakultas2 = Integer.parseInt(id_fakultas);
	// ApiModel apiSatu = universitasDAO.selectAllProdi(1, id_fakultas2);
	// ApiModel apiDua = universitasDAO.selectFakultas(1, id_fakultas2);
	// List<ProdiModel> listProdi = apiSatu.getResult().getProdiList();
	// FakultasModel fkl = apiDua.getResult().getFakultas();
	// fkl.setListProdi(listProdi);
	//
	// model.addAttribute("fakultas", fkl);
	//
	// return "matakuliah-cariprodi";
	// }
	// } else {
	// ApiModel api = universitasDAO.selectAllFakultas(1);
	// ResultModel result = api.getResult();
	// List<FakultasModel> listFakultas = result.getFakultasList();
	// UniversitasModel univ = new UniversitasModel(1,"A", listFakultas);
	// model.addAttribute("universitas",univ);
	// return "matakuliah";
	// }
	// }

	// akses halaman lihat mata kuliah
	@RequestMapping("/matakuliah-result")
	public String viewMataKuliah(Model model, @RequestParam(value = "fakultas", required = false) String id_fakultas,
			@RequestParam(value = "prodi", required = false) String id_prodi) {
		int id_prodi2 = Integer.parseInt(id_prodi);
		int id_fakultas2 = Integer.parseInt(id_fakultas);
		List<MataKuliahModel> matkuls = matakuliahDAO.selectMataKuliahProdi(id_fakultas2, id_prodi2);
		model.addAttribute("matkuls", matkuls);
		return "matakuliah-result";
	}

	// akses halaman tambah mata kuliah
	@RequestMapping("/matakuliah/add")
	public String addMataKuliah() {
		return "matakuliah-add";
	}

	// akses submit tambah mata kuliah
	@RequestMapping("/matakuliah/add/submit")
	public String addMataKuliah(@RequestParam(value = "kode_matkul", required = false) String kode_matkul,
			@RequestParam(value = "nama_matkul", required = false) String nama_matkul,
			@RequestParam(value = "jumlah_sks", required = false) int jumlah_sks,
			@RequestParam(value = "prasyarat_sks", required = false) int prasyarat_sks) {
		// int jumlah_sks2 = Integer.parseInt(jumlah_sks);
		// int prasyarat_sks2 = Integer.parseInt(prasyarat_sks);
		// MataKuliahModel matkul = new MataKuliahModel(kode_matkul, nama_matkul,
		// jumlah_sks, prasyarat_sks);
		System.out.println(jumlah_sks);
		matakuliahDAO.addMataKuliah(kode_matkul, nama_matkul, jumlah_sks, prasyarat_sks, 1, 1, 1);

		return "matakuliah-submit-success";
	}

	// akses halaman lihat mata kuliah
	@RequestMapping("/matakuliah/view/{id}")
	public String viewPathMataKuliah() {
		return "matakuliah-view";
	}
	
	@RequestMapping(value="/view-profile", method = RequestMethod.GET)
	public String viewProfile(Principal principal, Model model) {
		String usernameUser = principal.getName();
		UserModel user = userDao.selectUser(usernameUser);
		FakultasModel fakultas = universitasDAO.selectFakultas(1, user.getId_fakultas());
		ProdiModel prodi = universitasDAO.selectProdi(1, user.getId_fakultas(), user.getId_prodi());
		model.addAttribute("fakultas",fakultas);
		model.addAttribute("prodi", prodi);
		model.addAttribute("user", user);
		return "view-profile";
	}

}