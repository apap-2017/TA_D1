CREATE SCHEMA IF NOT EXISTS kurikulum;
SET search_path to kurikulum;

CREATE TABLE roles (
    id INTEGER NOT NULL,
    nama_role VARCHAR(150) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE users (
    id INTEGER NOT NULL,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    nama VARCHAR(150) NOT NULL,
    id_role INTEGER NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(id_role) REFERENCES roles(id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE fakultas (
    id INTEGER NOT NULL AUTO_INCREMENT,
    kode_fakultas VARCHAR(30) NOT NULL,
    nama_fakultas VARCHAR(150) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE prodi (
    id INTEGER NOT NULL AUTO_INCREMENT,
    id_prodi INTEGER NOT NULL,
    kode_prodi VARCHAR(30) NOT NULL,
    nama_prodi VARCHAR(150) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(id_fakultas) REFERENCES fakultas(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE kurikulum (
    id INTEGER NOT NULL AUTO_INCREMENT,
    kode_kurikulum VARCHAR(30) NOT NULL,
    nama_kurikulum VARCHAR(150) NOT NULL,
    jumlah_sks_wajib INTEGER NOT NULL,
    jumlah_sks_pilihan INTEGER NOT NULL,
    id_prodi INTEGER NOT NULL,
    id_fakultas INTEGER NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(id_prodi) REFERENCES prodi(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(id_fakultas) REFERENCES fakultas(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE mata_kuliah (
    id INTEGER NOT NULL,
    kode_matkul VARCHAR(50) NOT NULL,
    nama_matkul VARCHAR(150) NOT NULL,
    jumlah_sks INTEGER NOT NULL,
    prasyarat_sks INTEGER,
    id_prodi INTEGER NOT NULL,
    id_kurikulum INTEGER NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(id_prodi) REFERENCES prodi(id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY(id_kurikulum) REFERENCES kurikulum(id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE prasyarat_mata_kuliah (
    id INTEGER NOT NULL,
    id_matkul INTEGER NOT NULL,
    id_prasyarat_matkul INTEGER NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(id_matkul) REFERENCES mata_kuliah(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(id_prasyarat_matkul) REFERENCES mata_kuliah(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE mata_kuliah_kurikulum (
    id INTEGER NOT NULL,
    id_kurikulum INTEGER NOT NULL,
    id_matkul INTEGER NOT NULL,
    status_matkul VARCHAR(100) NOT NULL,
    term INTEGER NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(id_kurikulum) REFERENCES kurikulum(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(id_matkul) REFERENCES mata_kuliah(id) ON DELETE CASCADE ON UPDATE CASCADE
);