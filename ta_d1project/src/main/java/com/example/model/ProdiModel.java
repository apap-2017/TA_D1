package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdiModel
{
    private int id;
    private String id_fakultas;
    private String kode_prodi;
    private String nama_prodi;
}