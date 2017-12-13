package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AngkatanModel
{
    private int id;
    private String namaAngkatan;
    private int idUniversitas;
    private int idFakultas;
    private int idProdi;
    private int idKurikulum;
    private boolean aktif;
    private boolean terhapus;
    private String nama_kurikulum;
    private String kode_kurikulum;
    
}
