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
import com.example.model.AngkatanModel;
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
public class IndexController {
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

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/username", method = RequestMethod.GET)
	@ResponseBody
	public String currentUserName(Principal principal) {
		return principal.getName();
	}

	@RequestMapping(value = "/contoh", method = RequestMethod.GET)
	@ResponseBody
	public String contoh(Principal principal) {
		String usernameUser = principal.getName();
		UserModel user = userDAO.selectUser(usernameUser);
		return "" + user.getNama() + " " + user.getPassword() + " " + user.getUsername();
	}

	@RequestMapping(value = "/view-profile", method = RequestMethod.GET)
	public String viewProfile(Principal principal, Model model) {
		String usernameUser = principal.getName();
		UserModel user = userDAO.selectUser(usernameUser);
		FakultasModel fakultas = universitasDAO.selectFakultas(1, user.getId_fakultas());
		ProdiModel prodi = universitasDAO.selectProdi(1, user.getId_fakultas(), user.getId_prodi());
		model.addAttribute("fakultas", fakultas);
		model.addAttribute("prodi", prodi);
		model.addAttribute("user", user);
		return "profile-view";
	}
}
