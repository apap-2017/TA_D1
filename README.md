# Sistem Informasi Kurikulum

Base url: `https://localhost:5050/api/`

API List:
* [getKurikulum/[id_kurikulum]](#getkurikulumid_kurikulum) 
* [getMataKuliahByTerm/[term]](#getmatakuliahbytermterm)
* [getMataKuliahKurikulum/[id_kurikulum]](#getmatakuliahkurikulumid_kurikulum)
* [getListMataKuliahKurikulum/[id_kurikulum]](#getlistmatakuliahkurikulumid_kurikulum)
* [getMataKuliah/[id_matkul]](#getmatakuliahid_matkul)
* [getKurikulumProdi/[id_univ]/[id_fkl]/[id_prd]](#getkurikulumprodiid_univid_fklid_prd)

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

## getListMataKuliahKurikulum/[id_kurikulum]

Mengambil list mata kuliah dari suatu kurikulum.

**URL** : `getListMataKuliahKurikulum/[id_kurikulum]`

**Method** : `GET`

### Success Response

**Contoh Request**: [/getListMataKuliahKurikulum/1](http://localhost:5050/api/getListMataKuliahKurikulum/1)

```json
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
      }
    ]
  }
}
```

### Error Response

**Condition** : Jika id kurikulum tidak valid.

**Contoh Request**: [/getListMataKuliahKurikulum/132](http://localhost:5050/api/getListMataKuliahKurikulum/132)

```json
{
  "status": 404,
  "msg": "Mata Kuliah Kurikulum tidak ditemukan",
  "result": null
}
```

## getMataKuliah/[id_matkul]

Mengembalikan detail mata kuliah dan prasyaratnya

**URL** : `getMataKuliah/[id_matkul]`

**Method** : `GET`

### Success Response

**Contoh Request**: [/getMataKuliah/11](http://localhost:5050/api/getMataKuliah/11)

```json
{
  "status": 200,
  "msg": "success",
  "result": {
    "matkul": {
      "id": 11,
      "id_univ": 1,
      "id_fakultas": 1,
      "id_prodi": 1,
      "kode_matkul": "MTK11111",
      "nama_matkul": "Mata Kuliah 11111",
      "jumlah_sks": 3,
      "prasyarat_sks": 0,
      "listPrasyarat": [
        {
          "id": 1,
          "id_univ": 1,
          "id_fakultas": 1,
          "id_prodi": 1,
          "kode_matkul": "MTK11101",
          "nama_matkul": "Mata Kuliah 11101",
          "jumlah_sks": 6,
          "prasyarat_sks": 0,
          "listPrasyarat": null,
          "listMataKuliah": null
        }
      ],
      "listMataKuliah": null
    }
  }
}
```

### Error Response

**Condition** : Jika id mata kuliah tidak valid.

**Contoh Request**: [/getMataKuliah/777](http://localhost:5050/api/getMataKuliah/777)

```json
{
  "status": 404,
  "msg": "Mata Kuliah tidak ditemukan",
  "result": null
}
```

## getKurikulumProdi/[id_univ]/[id_fkl]/[id_prd]

Mengambil kurikulum dari suatu prodi

**URL** : `getKurikulumProdi/[id_univ]/[id_fkl]/[id_prd]`

**Method** : `GET`

### Success Response

**Contoh Request**: [/getKurikulumProdi/1/1/1](http://localhost:5050/api/getKurikulumProdi/1/1/1)

```json

  "status": 200,
  "msg": "success",
  "result": {
    "kurikulum": [
      {
        "id": 1,
        "id_univ": 1,
        "id_fakultas": 1,
        "id_prodi": 1,
        "kode_kurikulum": "KR1101",
        "nama_kurikulum": "Kurikulum 2010 Program Studi A1X",
        "jumlah_sks_wajib": 120,
        "jumlah_sks_pilihan": 24,
        "listMataKuliah": null,
        "listMataKuliahKurikulum": null
      }
    ]
  }
}
```

### Error Response

**Condition** : Jika id universitas, fakultas, atau prodi tidak valid.

**Contoh Request**: [/getKurikulumProdi/1/3/5](http://localhost:5050/api/getKurikulumProdi/1/3/5)

```json
{
  "status": 404,
  "msg": "Kurikulum tidak ditemukan",
  "result": null
}
```
