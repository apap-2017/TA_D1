# Sistem Informasi Kurikulum

Base url: `https://localhost:5050/api/`

API List:
* [getKurikulum](id_kurikulum) 
* [getMataKuliahByTerm](term)
* [getMataKuliahKurikulum](id)
* [getListMataKuliahKurikulum](id_kurikulum)
* [getMataKuliah](id_matkul)
* [getKurikulumProdi](id_univ)/(id_fkl)/(id_prd)


[404 Error](#404-error)

## getUniversitasList

Mengembalikan data kurikulum termasuk seluruh mata kuliah di kurikulum tersebut 

**URL** : `/getKurikulum/[id_kurikulum]`

**Method** : `GET`

### Success Response

**Contoh Request**: [/getKurikulum](https://localhost:5050/api/getKurikulum/1)

```json
{  
"status": 200,
  "msg": "success",
  "result": {
    "kurikulum": {
      "id": 1,
      "id_univ": 1,
      "id_fakultas": 1,
      "id_prodi": 1,
      "kode_kurikulum": "KR1101",
      "nama_kurikulum": "Kurikulum 2010 Program Studi A1X",
      "jumlah_sks_wajib": 120,
      "jumlah_sks_pilihan": 24,
      "listMataKuliah": [
        {
          "id": 1,
          "id_univ": 1,
          "id_fakultas": 1,
          "id_prodi": 1,
          "kode_matkul": "MTK11101",
          "nama_matkul": "Mata Kuliah 11101",
          "jumlah_sks": 6,
          "prasyarat_sks": 0,
          "listPrasyarat": null
        },
        {
          "id": 2,
          "id_univ": 1,
          "id_fakultas": 1,
          "id_prodi": 1,
          "kode_matkul": "MTK11102",
          "nama_matkul": "Mata Kuliah 11102",
          "jumlah_sks": 6,
          "prasyarat_sks": 0,
          "listPrasyarat": null
        }
   }
}
```

### Error Response

**Condition** : Jika id_kurikulum tidak valid.

**Contoh Request**: [/getKurikulum/123](https://localhost:5050/api/getKurikulum/123)

```json
{
  "status": 404,
  "msg": "Kurikulum tidak ditemukan",
  "result": null
}
```

