package com.example.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
	private int id;
	private String username;
	private String password;
	private String nama;
	private int id_role;
	private int id_univ;
	private int id_prodi;
	private int id_fakultas;
}
