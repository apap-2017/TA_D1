# Sistem Informasi Kurikulum

Base url: `https://localhost:5050/api/`

API List:
* [getKurikulum](#id_kurikulum) 
* [getMataKuliahByTerm](#term)
* [getMataKuliahKurikulum](#id)
* [getListMataKuliahKurikulum](#id_kurikulum)
* [getMataKuliah](#id_matkul)
* [getKurikulumProdi](#id_univ)/(id_fkl)/(id_prd)


[404 Error](#404-error)

## getKurikulum/[id_kurikulum]

Mengembalikan data kurikulum termasuk seluruh mata kuliah di kurikulum tersebut 

**URL** : `/getKurikulum/[id_kurikulum]`

**Method** : `GET`

### Success Response

**Contoh Request**: [/getKurikulum/1](http://localhost:5050/api/getKurikulum/1)

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
      ]
   }
}
```

### Error Response

**Condition** : Jika id_kurikulum tidak valid.

**Contoh Request**: [/getKurikulum/123](http://localhost:5050/api/getKurikulum/123)

```json
{
  "status": 404,
  "msg": "Kurikulum tidak ditemukan",
  "result": null
}
```

## getMataKuliahByTerm/[term]

Mengembalikan list mata kuliah pada term tertentu

**URL** : `/getMataKuliahByTerm/[term]`

**Method** : `GET`

### Success Response

**Contoh Request**: [/getMataKuliahByTerm/1](http://localhost:5050/api/getMataKuliahByTerm/1)

```json
{
  "status": 200,
  "msg": "success",
  "result": {
    "matkul": [
      {
        "id": 1,
        "id_kurikulum": 1,
        "id_matkul": 1,
        "status_matkul": "Wajib Univ",
        "term": 1
      },
      {
        "id": 2,
        "id_kurikulum": 1,
        "id_matkul": 2,
        "status_matkul": "Wajib Fakultas",
        "term": 1
      },
      {
        "id": 3,
        "id_kurikulum": 1,
        "id_matkul": 3,
        "status_matkul": "Wajib Fakultas",
        "term": 1
      },
     ]
   }
}
```

### Error Response

**Condition** : Jika term tidak valid.

**Contoh Request**: [/getMataKuliahByTerm/13](http://localhost:5050/api/getMataKuliahByTerm/13)

```json
{
  "status": 404,
  "msg": "Mata Kuliah tidak ditemukan",
  "result": null
}
```

## getMataKuliahKurikulum/[id_matkul_kurikulum]

Mengembalikan mata kuliah kurikulum berdasarkan id mata_kuliah_kurikulum

**URL** : `getMataKuliahKurikulum/[id_matkul_kurikulum]`

**Method** : `GET`

### Success Response

**Contoh Request**: [/getMataKuliahKurikulum/1](http://localhost:5050/api/getMataKuliahKurikulum/1)

```json
{
  "status": 200,
  "msg": "success",
  "result": {
    "matkul": {
      "id": 1,
      "id_kurikulum": 1,
      "id_matkul": 1,
      "status_matkul": "Wajib Univ",
      "term": 1
    }
  }
}
```

### Error Response

**Condition** : Jika id matkul_kurikulum tidak valid.

**Contoh Request**: [/getMataKuliahKurikulum/132](http://localhost:5050/api/getMataKuliahKurikulum/132)

```json
{
  "status": 404,
  "msg": "Mata Kuliah Kurikulum tidak ditemukan",
  "result": null
}
```


