-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 04, 2017 at 12:25 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kurikulum`
--

-- --------------------------------------------------------

--
-- Table structure for table `kurikulum`
--

CREATE TABLE `kurikulum` (
  `id` int(11) NOT NULL,
  `kode_kurikulum` varchar(30) NOT NULL,
  `nama_kurikulum` varchar(150) NOT NULL,
  `jumlah_sks_wajib` int(11) NOT NULL,
  `jumlah_sks_pilihan` int(11) NOT NULL,
  `id_prodi` int(11) NOT NULL,
  `id_fakultas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kurikulum`
--

INSERT INTO `kurikulum` (`id`, `kode_kurikulum`, `nama_kurikulum`, `jumlah_sks_wajib`, `jumlah_sks_pilihan`, `id_prodi`, `id_fakultas`) VALUES
(1, 'KRK001', 'Kurikulum S1 Program Studi A1X', 118, 26, 1, 1),
(2, 'KRK002', 'Kurikulum S1 Program Studi A1Y', 120, 24, 2, 1),
(3, 'KRK003', 'Kurikulum S1 Program Studi A1Z', 124, 20, 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `mata_kuliah`
--

CREATE TABLE `mata_kuliah` (
  `id` int(11) NOT NULL,
  `kode_matkul` varchar(50) NOT NULL,
  `nama_matkul` varchar(150) NOT NULL,
  `jumlah_sks` int(11) NOT NULL,
  `prasyarat_sks` int(11) DEFAULT NULL,
  `id_prodi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mata_kuliah`
--

INSERT INTO `mata_kuliah` (`id`, `kode_matkul`, `nama_matkul`, `jumlah_sks`, `prasyarat_sks`, `id_prodi`) VALUES
(1, 'MTK10001', 'MPKT A', 6, 0, 1),
(2, 'MTK10002', 'MPKT B', 6, 0, 1),
(3, 'MTK10003', 'MPK Bahasa Inggris', 3, 0, 1),
(4, 'MTK10004', 'MPK Agama Islam', 3, 0, 1),
(5, 'MTK10005', 'MPK Agama Kristen Katolik', 3, 0, 1),
(6, 'MTK10006', 'MPK Agama Kristen Protestan', 3, 0, 1),
(7, 'MTK10007', 'MPK Agama Hindu', 3, 0, 1),
(8, 'MTK10008', 'MPK Agama Budha', 3, 0, 1),
(9, 'MTK10009', 'MPK Agama Kong Hu Cu', 3, 0, 1),
(10, 'MTK10010', 'MPK Seni Apresiasi Film', 1, 0, 1),
(11, 'MTK10011', 'MPK Seni Batik', 1, 0, 1),
(12, 'MTK10012', 'MPK Seni Fotografi', 1, 0, 1),
(13, 'MTK10013', 'MPK Seni Kaligrafi', 1, 0, 1),
(14, 'MTK10014', 'MPK Seni Karawitan Jawa', 1, 0, 1),
(15, 'MTK10015', 'MPK Seni Karawitan dan Tari Bali', 1, 0, 1),
(16, 'MTK10016', 'MPK Seni Komik', 1, 0, 1),
(17, 'MTK10017', 'MPK Seni Lukis', 1, 0, 1),
(18, 'MTK10018', 'MPK Seni Apresiasi Musik', 1, 0, 1),
(19, 'MTK10019', 'MPK Seni Teater', 1, 0, 1),
(20, 'MTK10020', 'MPK Seni Wayang', 1, 0, 1),
(21, 'MTK10021', 'MPK Olahraga Bola Basket', 1, 0, 1),
(22, 'MTK10022', 'MPK Olahraga Bola Voli', 1, 0, 1),
(23, 'MTK10023', 'MPK Olahraga Bulutangkis', 1, 0, 1),
(24, 'MTK10024', 'MPK Olahraga Futsal', 1, 0, 1),
(25, 'MTK10025', 'MPK Olahraga Sepakbola', 1, 0, 1),
(26, 'MTK10026', 'MPK Olahraga Tenis', 1, 0, 1),
(27, 'MTK10027', 'MPK Olahraga Tenis Meja', 1, 0, 1),
(28, 'MTK10028', 'Matematika Dasar 1', 3, 0, 1),
(29, 'MTK10029', 'Fisika Dasar 1', 3, 0, 1),
(30, 'MTK10030', 'Matematika Diskret 1', 3, 0, 1),
(31, 'MTK10031', 'Dasar-Dasar Pemrograman 1', 4, 0, 1),
(32, 'MTK10032', 'Matematika Diskret 2', 3, 0, 1),
(33, 'MTK10033', 'Dasar-Dasar Pemrograman 2', 4, 0, 1),
(34, 'MTK10034', 'Aljabar Linier', 3, 0, 1),
(35, 'MTK10035', 'Perancangan & Pemrograman Web', 3, 0, 1),
(36, 'MTK10036', 'Struktur Data & Algoritma', 4, 0, 1),
(37, 'MTK10037', 'Statistika & Probabilitas', 3, 0, 1),
(38, 'MTK10038', 'Sistem Operasi', 4, 0, 1),
(39, 'MTK10039', 'Basis Data', 4, 0, 1),
(40, 'MTK10040', 'Metodologi Penelitian & Penulisan Ilmiah', 3, 0, 1),
(41, 'MTK10041', 'Kerja Praktik', 3, 100, 1),
(42, 'MTK10042', 'Komputer & Masyarakat', 3, 100, 1),
(43, 'MTK10043', 'Prinsip-Prinsip Sistem Informasi', 3, 0, 1),
(44, 'MTK10044', 'Dasar-Dasar Arsitektur Komputer', 4, 0, 1),
(45, 'MTK10045', 'Administrasi Bisnis', 3, 0, 1),
(46, 'MTK10046', 'Prinsip-Prinsip Manajemen', 3, 0, 1),
(47, 'MTK10047', 'Sistem-Sistem Perusahaan', 3, 0, 1),
(48, 'MTK10048', 'Sistem Informasi Akuntansi Keuangan', 3, 0, 1),
(49, 'MTK10049', 'Sistem Interaksi', 3, 0, 1),
(50, 'MTK10050', 'Analisis dan Perancangan Sistem Informasi', 3, 0, 1),
(51, 'MTK10051', 'Arsitektur & Pemrograman Aplikasi Perusahaan', 4, 0, 1),
(52, 'MTK10052', 'Manajemen Proyek TI', 3, 0, 1),
(53, 'MTK10053', 'Jaringan Komunikasi Data', 3, 0, 1),
(54, 'MTK10054', 'Proyek Pengembangan Sistem Informasi', 6, 0, 1),
(55, 'MTK10055', 'Komunikasi Bisnis dan Teknis', 3, 48, 1),
(56, 'MTK10056', 'Statistika Terapan', 3, 0, 1),
(57, 'MTK10057', 'Manajemen Sistem Informasi', 3, 100, 1),
(58, 'MTK10058', 'Pengantar Sistem Dijital', 4, 0, 1),
(59, 'MTK10059', 'Pengantar Organisasi Komputer', 3, 0, 1),
(60, 'MTK10060', 'Matematika Dasar 2', 3, 0, 1),
(61, 'MTK10061', 'Pemrograman Lanjut', 4, 0, 1),
(62, 'MTK10062', 'Teori Bahasa & Automata', 4, 0, 1),
(63, 'MTK10063', 'Rekayasa Perangkat Lunak', 3, 0, 1),
(64, 'MTK10064', 'Pemrograman Sistem', 3, 0, 1),
(65, 'MTK10065', 'Sistem Cerdas', 4, 0, 1),
(66, 'MTK10066', 'Jaringan Komputer', 4, 0, 1),
(67, 'MTK10067', 'Proyek Perangkat Lunak', 6, 0, 1),
(68, 'MTK10068', 'Data Science & Analytics', 3, 0, 1),
(69, 'MTK10069', 'Analisis Numerik', 3, 0, 1),
(70, 'MTK10070', 'Desain & Analisis Algoritma', 4, 0, 1),
(71, 'MTK10071', 'Manajemen Layanan TI', 3, 0, 1),
(72, 'MTK10072', 'Administrasi Sistem', 3, 0, 1),
(73, 'MTK10073', 'Manajemen Infrastruktur TI', 3, 0, 1),
(74, 'MTK10074', 'Technopreneurship', 3, 0, 1),
(75, 'MTK10075', 'Teknologi Mobile', 3, 0, 1),
(76, 'MTK10076', 'Pengantar Keamanan Informasi', 3, 0, 1),
(77, 'MTK10077', 'Pengembangan Perangkat Lunak Open Source', 3, 0, 1),
(78, 'MTK10078', 'Integrasi Aplikasi Perusahaan', 3, 0, 1),
(79, 'MTK10079', 'Dasar-Dasar Audit SI', 3, 0, 1),
(80, 'MTK10080', 'Topik Khusus Bidang Minat Manajemen SI/TI', 3, 0, 1),
(81, 'MTK10081', 'E-Dagang', 3, 0, 1),
(82, 'MTK10082', 'Sistem Informasi Kesehatan', 3, 0, 1),
(83, 'MTK10083', 'Konfigurasi ERP', 3, 0, 1),
(84, 'MTK10084', 'Manajemen Pengetahuan', 3, 0, 1),
(85, 'MTK10085', 'Analitika Media Sosial', 3, 0, 1),
(86, 'MTK10086', 'Penambangan Data & Inteligensia Bisnis', 3, 0, 1),
(87, 'MTK10087', 'Pengelolaan Data Besar', 3, 0, 1),
(88, 'MTK10088', 'Sistem Informasi Sumber Daya Manusia', 3, 0, 1),
(89, 'MTK10089', 'Manajemen Hubungan Pelanggan', 3, 0, 1),
(90, 'MTK10090', 'Manajemen Rantai Suplai', 3, 0, 1),
(91, 'MTK10091', 'Topik Khusus Bidang Minat Solusi Perusahaan', 3, 0, 1),
(92, 'MTK10092', 'Tugas Akhir', 6, 0, 1),
(93, 'MTK10093', 'Basis Data Lanjut', 3, 0, 1),
(94, 'MTK10094', 'Teknik Kompilator', 4, 0, 1),
(95, 'MTK10095', 'Grafika Komputer', 3, 0, 1),
(96, 'MTK10096', 'Kriptografi & Keamanan Informasi', 4, 0, 1),
(97, 'MTK10097', 'Layanan & Aplikasi Web', 3, 0, 1),
(98, 'MTK10098', 'Game Development', 3, 0, 1),
(99, 'MTK10099', 'Pemrograman Paralel', 4, 0, 1),
(100, 'MTK10100', 'Pemrograman Logika', 4, 0, 1),
(101, 'MTK10101', 'Penjaminan Mutu Perangkat Lunak', 4, 0, 1),
(102, 'MTK10102', 'Jejaring Semantik', 3, 0, 1),
(103, 'MTK10103', 'Metode Formal', 4, 0, 1),
(104, 'MTK10104', 'Penambangan Data', 3, 0, 1),
(105, 'MTK10105', 'Pemrograman Fungsional', 4, 0, 1),
(106, 'MTK10106', 'Pengajaran Berbantuan Komputer', 3, 0, 1),
(107, 'MTK10107', 'Topik Khusus Bidang Minat Teknologi Perangkat Lunak', 3, 0, 1),
(108, 'MTK10108', 'Pengolahan Citra', 3, 0, 1),
(109, 'MTK10109', 'Teori Informasi', 3, 0, 1),
(110, 'MTK10110', 'Pemelajaran Mesin', 3, 0, 1),
(111, 'MTK10111', 'Pengolahan Bahasa Manusia', 3, 0, 1),
(112, 'MTK10112', 'Perolehan Informasi', 3, 0, 1),
(113, 'MTK10113', 'Pengolahan Sinyal Dijital', 3, 0, 1),
(114, 'MTK10114', 'Sistem Informasi Geografis', 3, 0, 1),
(115, 'MTK10115', 'Pengolahan Multimedia', 3, 0, 1),
(116, 'MTK10116', 'Geometri Komputasional', 4, 0, 1),
(117, 'MTK10117', 'Pemodelan Geometris', 4, 0, 1),
(118, 'MTK10118', 'Topik Khusus Bidang Minat Pengolahan Informasi Multimedia', 3, 0, 1),
(119, 'MTK10119', 'Sistem Tertanam', 3, 0, 1),
(120, 'MTK10120', 'Organisasi Sistem Komputer', 3, 0, 1),
(121, 'MTK10121', 'Simulasi & Pemodelan', 3, 0, 1),
(122, 'MTK10122', 'Sistem Terdistribusi', 3, 0, 1),
(123, 'MTK10123', 'Ubiquitous & Net-Centric Computing', 3, 0, 1),
(124, 'MTK10124', 'Robotika', 3, 0, 1),
(125, 'MTK10125', 'Rancangan Sistem Dijital', 3, 0, 1),
(126, 'MTK10126', 'Topik Khusus Bidang Minat Arsitektur & Infrastruktur', 3, 0, 1),
(127, 'MTK10127', 'Bioinformatika', 3, 0, 1),
(128, 'MTK10128', 'Persamaan Diferensial', 3, 0, 1),
(129, 'MTK10129', 'Aproksimasi Sistem Nonlinier', 3, 0, 1),
(130, 'MTK10130', 'Komputasi Lunak', 3, 0, 1),
(131, 'MTK10131', 'Logika Komputasional', 3, 0, 1),
(132, 'MTK10132', 'Aljabar Linier Numerik', 3, 0, 1),
(133, 'MTK10133', 'Topik Khusus Bidang Minat Kecerdasan Komputasional', 3, 0, 1),
(134, 'MTK20001', 'MPKT A', 6, 0, 2),
(135, 'MTK20002', 'MPKT B', 6, 0, 2),
(136, 'MTK20003', 'MPK Bahasa Inggris', 3, 0, 2),
(137, 'MTK20004', 'MPK Agama Islam', 3, 0, 2),
(138, 'MTK20005', 'MPK Agama Kristen Katolik', 3, 0, 2),
(139, 'MTK20006', 'MPK Agama Kristen Protestan', 3, 0, 2),
(140, 'MTK20007', 'MPK Agama Hindu', 3, 0, 2),
(141, 'MTK20008', 'MPK Agama Budha', 3, 0, 2),
(142, 'MTK20009', 'MPK Agama Kong Hu Cu', 3, 0, 2),
(143, 'MTK20010', 'MPK Seni Apresiasi Film', 1, 0, 2),
(144, 'MTK20011', 'MPK Seni Batik', 1, 0, 2),
(145, 'MTK20012', 'MPK Seni Fotografi', 1, 0, 2),
(146, 'MTK20013', 'MPK Seni Kaligrafi', 1, 0, 2),
(147, 'MTK20014', 'MPK Seni Karawitan Jawa', 1, 0, 2),
(148, 'MTK20015', 'MPK Seni Karawitan dan Tari Bali', 1, 0, 2),
(149, 'MTK20016', 'MPK Seni Komik', 1, 0, 2),
(150, 'MTK20017', 'MPK Seni Lukis', 1, 0, 2),
(151, 'MTK20018', 'MPK Seni Apresiasi Musik', 1, 0, 2),
(152, 'MTK20019', 'MPK Seni Teater', 1, 0, 2),
(153, 'MTK20020', 'MPK Seni Wayang', 1, 0, 2),
(154, 'MTK20021', 'MPK Olahraga Bola Basket', 1, 0, 2),
(155, 'MTK20022', 'MPK Olahraga Bola Voli', 1, 0, 2),
(156, 'MTK20023', 'MPK Olahraga Bulutangkis', 1, 0, 2),
(157, 'MTK20024', 'MPK Olahraga Futsal', 1, 0, 2),
(158, 'MTK20025', 'MPK Olahraga Sepakbola', 1, 0, 2),
(159, 'MTK20026', 'MPK Olahraga Tenis', 1, 0, 2),
(160, 'MTK20027', 'MPK Olahraga Tenis Meja', 1, 0, 2),
(161, 'MTK20028', 'Matematika Dasar 1', 3, 0, 2),
(162, 'MTK20029', 'Fisika Dasar 1', 3, 0, 2),
(163, 'MTK20030', 'Matematika Diskret 1', 3, 0, 2),
(164, 'MTK20031', 'Dasar-Dasar Pemrograman 1', 4, 0, 2),
(165, 'MTK20032', 'Matematika Diskret 2', 3, 0, 2),
(166, 'MTK20033', 'Dasar-Dasar Pemrograman 2', 4, 0, 2),
(167, 'MTK20034', 'Aljabar Linier', 3, 0, 2),
(168, 'MTK20035', 'Perancangan & Pemrograman Web', 3, 0, 2),
(169, 'MTK20036', 'Struktur Data & Algoritma', 4, 0, 2),
(170, 'MTK20037', 'Statistika & Probabilitas', 3, 0, 2),
(171, 'MTK20038', 'Sistem Operasi', 4, 0, 2),
(172, 'MTK20039', 'Basis Data', 4, 0, 2),
(173, 'MTK20040', 'Metodologi Penelitian & Penulisan Ilmiah', 3, 0, 2),
(174, 'MTK20041', 'Kerja Praktik', 3, 100, 2),
(175, 'MTK20042', 'Komputer & Masyarakat', 3, 100, 2),
(176, 'MTK20043', 'Prinsip-Prinsip Sistem Informasi', 3, 0, 2),
(177, 'MTK20044', 'Dasar-Dasar Arsitektur Komputer', 4, 0, 2),
(178, 'MTK20045', 'Administrasi Bisnis', 3, 0, 2),
(179, 'MTK20046', 'Prinsip-Prinsip Manajemen', 3, 0, 2),
(180, 'MTK20047', 'Sistem-Sistem Perusahaan', 3, 0, 2),
(181, 'MTK20048', 'Sistem Informasi Akuntansi Keuangan', 3, 0, 2),
(182, 'MTK20049', 'Sistem Interaksi', 3, 0, 2),
(183, 'MTK20050', 'Analisis dan Perancangan Sistem Informasi', 3, 0, 2),
(184, 'MTK20051', 'Arsitektur & Pemrograman Aplikasi Perusahaan', 4, 0, 2),
(185, 'MTK20052', 'Manajemen Proyek TI', 3, 0, 2),
(186, 'MTK20053', 'Jaringan Komunikasi Data', 3, 0, 2),
(187, 'MTK20054', 'Proyek Pengembangan Sistem Informasi', 6, 0, 2),
(188, 'MTK20055', 'Komunikasi Bisnis dan Teknis', 3, 48, 2),
(189, 'MTK20056', 'Statistika Terapan', 3, 0, 2),
(190, 'MTK20057', 'Manajemen Sistem Informasi', 3, 100, 2),
(191, 'MTK20058', 'Pengantar Sistem Dijital', 4, 0, 2),
(192, 'MTK20059', 'Pengantar Organisasi Komputer', 3, 0, 2),
(193, 'MTK20060', 'Matematika Dasar 2', 3, 0, 2),
(194, 'MTK20061', 'Pemrograman Lanjut', 4, 0, 2),
(195, 'MTK20062', 'Teori Bahasa & Automata', 4, 0, 2),
(196, 'MTK20063', 'Rekayasa Perangkat Lunak', 3, 0, 2),
(197, 'MTK20064', 'Pemrograman Sistem', 3, 0, 2),
(198, 'MTK20065', 'Sistem Cerdas', 4, 0, 2),
(199, 'MTK20066', 'Jaringan Komputer', 4, 0, 2),
(200, 'MTK20067', 'Proyek Perangkat Lunak', 6, 0, 2),
(201, 'MTK20068', 'Data Science & Analytics', 3, 0, 2),
(202, 'MTK20069', 'Analisis Numerik', 3, 0, 2),
(203, 'MTK20070', 'Desain & Analisis Algoritma', 4, 0, 2),
(204, 'MTK20071', 'Manajemen Layanan TI', 3, 0, 2),
(205, 'MTK20072', 'Administrasi Sistem', 3, 0, 2),
(206, 'MTK20073', 'Manajemen Infrastruktur TI', 3, 0, 2),
(207, 'MTK20074', 'Technopreneurship', 3, 0, 2),
(208, 'MTK20075', 'Teknologi Mobile', 3, 0, 2),
(209, 'MTK20076', 'Pengantar Keamanan Informasi', 3, 0, 2),
(210, 'MTK20077', 'Pengembangan Perangkat Lunak Open Source', 3, 0, 2),
(211, 'MTK20078', 'Integrasi Aplikasi Perusahaan', 3, 0, 2),
(212, 'MTK20079', 'Dasar-Dasar Audit SI', 3, 0, 2),
(213, 'MTK20080', 'Topik Khusus Bidang Minat Manajemen SI/TI', 3, 0, 2),
(214, 'MTK20081', 'E-Dagang', 3, 0, 2),
(215, 'MTK20082', 'Sistem Informasi Kesehatan', 3, 0, 2),
(216, 'MTK20083', 'Konfigurasi ERP', 3, 0, 2),
(217, 'MTK20084', 'Manajemen Pengetahuan', 3, 0, 2),
(218, 'MTK20085', 'Analitika Media Sosial', 3, 0, 2),
(219, 'MTK20086', 'Penambangan Data & Inteligensia Bisnis', 3, 0, 2),
(220, 'MTK20087', 'Pengelolaan Data Besar', 3, 0, 2),
(221, 'MTK20088', 'Sistem Informasi Sumber Daya Manusia', 3, 0, 2),
(222, 'MTK20089', 'Manajemen Hubungan Pelanggan', 3, 0, 2),
(223, 'MTK20090', 'Manajemen Rantai Suplai', 3, 0, 2),
(224, 'MTK20091', 'Topik Khusus Bidang Minat Solusi Perusahaan', 3, 0, 2),
(225, 'MTK20092', 'Tugas Akhir', 6, 0, 2),
(226, 'MTK20093', 'Basis Data Lanjut', 3, 0, 2),
(227, 'MTK20094', 'Teknik Kompilator', 4, 0, 2),
(228, 'MTK20095', 'Grafika Komputer', 3, 0, 2),
(229, 'MTK20096', 'Kriptografi & Keamanan Informasi', 4, 0, 2),
(230, 'MTK20097', 'Layanan & Aplikasi Web', 3, 0, 2),
(231, 'MTK20098', 'Game Development', 3, 0, 2),
(232, 'MTK20099', 'Pemrograman Paralel', 4, 0, 2),
(233, 'MTK20100', 'Pemrograman Logika', 4, 0, 2),
(234, 'MTK20101', 'Penjaminan Mutu Perangkat Lunak', 4, 0, 2),
(235, 'MTK20102', 'Jejaring Semantik', 3, 0, 2),
(236, 'MTK20103', 'Metode Formal', 4, 0, 2),
(237, 'MTK20104', 'Penambangan Data', 3, 0, 2),
(238, 'MTK20105', 'Pemrograman Fungsional', 4, 0, 2),
(239, 'MTK20106', 'Pengajaran Berbantuan Komputer', 3, 0, 2),
(240, 'MTK20107', 'Topik Khusus Bidang Minat Teknologi Perangkat Lunak', 3, 0, 2),
(241, 'MTK20108', 'Pengolahan Citra', 3, 0, 2),
(242, 'MTK20109', 'Teori Informasi', 3, 0, 2),
(243, 'MTK20110', 'Pemelajaran Mesin', 2, 0, 2),
(244, 'MTK20111', 'Pengolahan Bahasa Manusia', 2, 0, 2),
(245, 'MTK20112', 'Perolehan Informasi', 3, 0, 2),
(246, 'MTK20113', 'Pengolahan Sinyal Dijital', 3, 0, 2),
(247, 'MTK20114', 'Sistem Informasi Geografis', 3, 0, 2),
(248, 'MTK20115', 'Pengolahan Multimedia', 3, 0, 2),
(249, 'MTK20116', 'Geometri Komputasional', 4, 0, 2),
(250, 'MTK20117', 'Pemodelan Geometris', 4, 0, 2),
(251, 'MTK20118', 'Topik Khusus Bidang Minat Pengolahan Informasi Multimedia', 3, 0, 2),
(252, 'MTK20119', 'Sistem Tertanam', 3, 0, 2),
(253, 'MTK20120', 'Organisasi Sistem Komputer', 3, 0, 2),
(254, 'MTK20121', 'Simulasi & Pemodelan', 3, 0, 2),
(255, 'MTK20122', 'Sistem Terdistribusi', 3, 0, 2),
(256, 'MTK20123', 'Ubiquitous & Net-Centric Computing', 3, 0, 2),
(257, 'MTK20124', 'Robotika', 3, 0, 2),
(258, 'MTK20125', 'Rancangan Sistem Dijital', 3, 0, 2),
(259, 'MTK20126', 'Topik Khusus Bidang Minat Arsitektur & Infrastruktur', 3, 0, 2),
(260, 'MTK20127', 'Bioinformatika', 3, 0, 2),
(261, 'MTK20128', 'Persamaan Diferensial', 2, 0, 2),
(262, 'MTK20129', 'Aproksimasi Sistem Nonlinier', 2, 0, 2),
(263, 'MTK20130', 'Komputasi Lunak', 3, 0, 2),
(264, 'MTK20131', 'Logika Komputasional', 3, 0, 2),
(265, 'MTK20132', 'Aljabar Linier Numerik', 3, 0, 2),
(266, 'MTK20133', 'Topik Khusus Bidang Minat Kecerdasan Komputasional', 3, 0, 2),
(267, 'MTK30001', 'MPKT A', 6, 0, 3),
(268, 'MTK30002', 'MPKT B', 6, 0, 3),
(269, 'MTK30003', 'MPK Bahasa Inggris', 3, 0, 3),
(270, 'MTK30004', 'MPK Agama Islam', 2, 0, 3),
(271, 'MTK30005', 'MPK Agama Kristen Katolik', 3, 0, 3),
(272, 'MTK30006', 'MPK Agama Kristen Protestan', 3, 0, 3),
(273, 'MTK30007', 'MPK Agama Hindu', 2, 0, 3),
(274, 'MTK30008', 'MPK Agama Budha', 3, 0, 3),
(275, 'MTK30009', 'MPK Agama Kong Hu Cu', 3, 0, 3),
(276, 'MTK30010', 'MPK Seni Apresiasi Film', 1, 0, 3),
(277, 'MTK30011', 'MPK Seni Batik', 1, 0, 3),
(278, 'MTK30012', 'MPK Seni Fotografi', 1, 0, 3),
(279, 'MTK30013', 'MPK Seni Kaligrafi', 1, 0, 3),
(280, 'MTK30014', 'MPK Seni Karawitan Jawa', 1, 0, 3),
(281, 'MTK30015', 'MPK Seni Karawitan dan Tari Bali', 1, 0, 3),
(282, 'MTK30016', 'MPK Seni Komik', 1, 0, 3),
(283, 'MTK30017', 'MPK Seni Lukis', 1, 0, 3),
(284, 'MTK30018', 'MPK Seni Apresiasi Musik', 1, 0, 3),
(285, 'MTK30019', 'MPK Seni Teater', 1, 0, 3),
(286, 'MTK30020', 'MPK Seni Wayang', 1, 0, 3),
(287, 'MTK30021', 'MPK Olahraga Bola Basket', 1, 0, 3),
(288, 'MTK30022', 'MPK Olahraga Bola Voli', 1, 0, 3),
(289, 'MTK30023', 'MPK Olahraga Bulutangkis', 1, 0, 3),
(290, 'MTK30024', 'MPK Olahraga Futsal', 1, 0, 3),
(291, 'MTK30025', 'MPK Olahraga Sepakbola', 1, 0, 3),
(292, 'MTK30026', 'MPK Olahraga Tenis', 1, 0, 3),
(293, 'MTK30027', 'MPK Olahraga Tenis Meja', 1, 0, 3),
(294, 'MTK30028', 'Matematika Dasar 1', 3, 0, 3),
(295, 'MTK30029', 'Fisika Dasar 1', 3, 0, 3),
(296, 'MTK30030', 'Matematika Diskret 1', 3, 0, 3),
(297, 'MTK30031', 'Dasar-Dasar Pemrograman 1', 4, 0, 3),
(298, 'MTK30032', 'Matematika Diskret 2', 3, 0, 3),
(299, 'MTK30033', 'Dasar-Dasar Pemrograman 2', 4, 0, 3),
(300, 'MTK30034', 'Aljabar Linier', 4, 0, 3),
(301, 'MTK30035', 'Perancangan & Pemrograman Web', 3, 0, 3),
(302, 'MTK30036', 'Struktur Data & Algoritma', 4, 0, 3),
(303, 'MTK30037', 'Statistika & Probabilitas', 2, 0, 3),
(304, 'MTK30038', 'Sistem Operasi', 4, 0, 3),
(305, 'MTK30039', 'Basis Data', 4, 0, 3),
(306, 'MTK30040', 'Metodologi Penelitian & Penulisan Ilmiah', 3, 0, 3),
(307, 'MTK30041', 'Kerja Praktik', 3, 100, 3),
(308, 'MTK30042', 'Komputer & Masyarakat', 3, 100, 3),
(309, 'MTK30043', 'Prinsip-Prinsip Sistem Informasi', 3, 0, 3),
(310, 'MTK30044', 'Dasar-Dasar Arsitektur Komputer', 4, 0, 3),
(311, 'MTK30045', 'Administrasi Bisnis', 3, 0, 3),
(312, 'MTK30046', 'Prinsip-Prinsip Manajemen', 3, 0, 3),
(313, 'MTK30047', 'Sistem-Sistem Perusahaan', 3, 0, 3),
(314, 'MTK30048', 'Sistem Informasi Akuntansi Keuangan', 3, 0, 3),
(315, 'MTK30049', 'Sistem Interaksi', 3, 0, 3),
(316, 'MTK30050', 'Analisis dan Perancangan Sistem Informasi', 3, 0, 3),
(317, 'MTK30051', 'Arsitektur & Pemrograman Aplikasi Perusahaan', 4, 0, 3),
(318, 'MTK30052', 'Manajemen Proyek TI', 3, 0, 3),
(319, 'MTK30053', 'Jaringan Komunikasi Data', 3, 0, 3),
(320, 'MTK30054', 'Proyek Pengembangan Sistem Informasi', 6, 0, 3),
(321, 'MTK30055', 'Komunikasi Bisnis dan Teknis', 3, 48, 3),
(322, 'MTK30056', 'Statistika Terapan', 3, 0, 3),
(323, 'MTK30057', 'Manajemen Sistem Informasi', 3, 100, 3),
(324, 'MTK30058', 'Pengantar Sistem Dijital', 4, 0, 3),
(325, 'MTK30059', 'Pengantar Organisasi Komputer', 3, 0, 3),
(326, 'MTK30060', 'Matematika Dasar 2', 3, 0, 3),
(327, 'MTK30061', 'Pemrograman Lanjut', 4, 0, 3),
(328, 'MTK30062', 'Teori Bahasa & Automata', 4, 0, 3),
(329, 'MTK30063', 'Rekayasa Perangkat Lunak', 3, 0, 3),
(330, 'MTK30064', 'Pemrograman Sistem', 3, 0, 3),
(331, 'MTK30065', 'Sistem Cerdas', 4, 0, 3),
(332, 'MTK30066', 'Jaringan Komputer', 4, 0, 3),
(333, 'MTK30067', 'Proyek Perangkat Lunak', 6, 0, 3),
(334, 'MTK30068', 'Data Science & Analytics', 3, 0, 3),
(335, 'MTK30069', 'Analisis Numerik', 3, 0, 3),
(336, 'MTK30070', 'Desain & Analisis Algoritma', 4, 0, 3),
(337, 'MTK30071', 'Manajemen Layanan TI', 3, 0, 3),
(338, 'MTK30072', 'Administrasi Sistem', 3, 0, 3),
(339, 'MTK30073', 'Manajemen Infrastruktur TI', 3, 0, 3),
(340, 'MTK30074', 'Technopreneurship', 3, 0, 3),
(341, 'MTK30075', 'Teknologi Mobile', 3, 0, 3),
(342, 'MTK30076', 'Pengantar Keamanan Informasi', 3, 0, 3),
(343, 'MTK30077', 'Pengembangan Perangkat Lunak Open Source', 3, 0, 3),
(344, 'MTK30078', 'Integrasi Aplikasi Perusahaan', 3, 0, 3),
(345, 'MTK30079', 'Dasar-Dasar Audit SI', 3, 0, 3),
(346, 'MTK30080', 'Topik Khusus Bidang Minat Manajemen SI/TI', 3, 0, 3),
(347, 'MTK30081', 'E-Dagang', 3, 0, 3),
(348, 'MTK30082', 'Sistem Informasi Kesehatan', 3, 0, 3),
(349, 'MTK30083', 'Konfigurasi ERP', 3, 0, 3),
(350, 'MTK30084', 'Manajemen Pengetahuan', 3, 0, 3),
(351, 'MTK30085', 'Analitika Media Sosial', 3, 0, 3),
(352, 'MTK30086', 'Penambangan Data & Inteligensia Bisnis', 3, 0, 3),
(353, 'MTK30087', 'Pengelolaan Data Besar', 3, 0, 3),
(354, 'MTK30088', 'Sistem Informasi Sumber Daya Manusia', 3, 0, 3),
(355, 'MTK30089', 'Manajemen Hubungan Pelanggan', 3, 0, 3),
(356, 'MTK30090', 'Manajemen Rantai Suplai', 3, 0, 3),
(357, 'MTK30091', 'Topik Khusus Bidang Minat Solusi Perusahaan', 3, 0, 3),
(358, 'MTK30092', 'Tugas Akhir', 6, 0, 3),
(359, 'MTK30093', 'Basis Data Lanjut', 3, 0, 3),
(360, 'MTK30094', 'Teknik Kompilator', 4, 0, 3),
(361, 'MTK30095', 'Grafika Komputer', 3, 0, 3),
(362, 'MTK30096', 'Kriptografi & Keamanan Informasi', 4, 0, 3),
(363, 'MTK30097', 'Layanan & Aplikasi Web', 3, 0, 3),
(364, 'MTK30098', 'Game Development', 3, 0, 3),
(365, 'MTK30099', 'Pemrograman Paralel', 4, 0, 3),
(366, 'MTK30100', 'Pemrograman Logika', 4, 0, 3),
(367, 'MTK30101', 'Penjaminan Mutu Perangkat Lunak', 4, 0, 3),
(368, 'MTK30102', 'Jejaring Semantik', 3, 0, 3),
(369, 'MTK30103', 'Metode Formal', 4, 0, 3),
(370, 'MTK30104', 'Penambangan Data', 3, 0, 3),
(371, 'MTK30105', 'Pemrograman Fungsional', 4, 0, 3),
(372, 'MTK30106', 'Pengajaran Berbantuan Komputer', 3, 0, 3),
(373, 'MTK30107', 'Topik Khusus Bidang Minat Teknologi Perangkat Lunak', 3, 0, 3),
(374, 'MTK30108', 'Pengolahan Citra', 3, 0, 3),
(375, 'MTK30109', 'Teori Informasi', 3, 0, 3),
(376, 'MTK30110', 'Pemelajaran Mesin', 3, 0, 3),
(377, 'MTK30111', 'Pengolahan Bahasa Manusia', 3, 0, 3),
(378, 'MTK30112', 'Perolehan Informasi', 3, 0, 3),
(379, 'MTK30113', 'Pengolahan Sinyal Dijital', 3, 0, 3),
(380, 'MTK30114', 'Sistem Informasi Geografis', 3, 0, 3),
(381, 'MTK30115', 'Pengolahan Multimedia', 3, 0, 3),
(382, 'MTK30116', 'Geometri Komputasional', 4, 0, 3),
(383, 'MTK30117', 'Pemodelan Geometris', 4, 0, 3),
(384, 'MTK30118', 'Topik Khusus Bidang Minat Pengolahan Informasi Multimedia', 3, 0, 3),
(385, 'MTK30119', 'Sistem Tertanam', 3, 0, 3),
(386, 'MTK30120', 'Organisasi Sistem Komputer', 3, 0, 3),
(387, 'MTK30121', 'Simulasi & Pemodelan', 2, 0, 3),
(388, 'MTK30122', 'Sistem Terdistribusi', 2, 0, 3),
(389, 'MTK30123', 'Ubiquitous & Net-Centric Computing', 3, 0, 3),
(390, 'MTK30124', 'Robotika', 3, 0, 3),
(391, 'MTK30125', 'Rancangan Sistem Dijital', 3, 0, 3),
(392, 'MTK30126', 'Topik Khusus Bidang Minat Arsitektur & Infrastruktur', 3, 0, 3),
(393, 'MTK30127', 'Bioinformatika', 2, 0, 3),
(394, 'MTK30128', 'Persamaan Diferensial', 3, 0, 3),
(395, 'MTK30129', 'Aproksimasi Sistem Nonlinier', 4, 0, 3),
(396, 'MTK30130', 'Komputasi Lunak', 3, 0, 3),
(397, 'MTK30131', 'Logika Komputasional', 3, 0, 3),
(398, 'MTK30132', 'Aljabar Linier Numerik', 3, 0, 3),
(399, 'MTK30133', 'Topik Khusus Bidang Minat Kecerdasan Komputasional', 3, 0, 3);

-- --------------------------------------------------------

--
-- Table structure for table `mata_kuliah_kurikulum`
--

CREATE TABLE `mata_kuliah_kurikulum` (
  `id` int(11) NOT NULL,
  `id_kurikulum` int(11) NOT NULL,
  `id_matkul` int(11) NOT NULL,
  `status_matkul` varchar(100) NOT NULL,
  `term` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mata_kuliah_kurikulum`
--

INSERT INTO `mata_kuliah_kurikulum` (`id`, `id_kurikulum`, `id_matkul`, `status_matkul`, `term`) VALUES
(1, 1, 2, 'Wajib UI', 1),
(2, 1, 30, 'Wajib Fakultas', 1),
(3, 1, 28, 'Wajib Rumpun', 1),
(4, 1, 31, 'Wajib Fakultas', 1),
(5, 1, 10, 'Wajib UI', 1),
(6, 1, 4, 'Wajib UI', 1),
(7, 1, 1, 'Wajib UI', 2),
(8, 1, 33, 'Wajib Fakultas', 2),
(9, 1, 32, 'Wajib Fakultas', 2),
(10, 1, 44, 'Wajib Prodi', 2),
(11, 1, 3, 'Wajib UI', 2),
(12, 1, 29, 'Wajib Rumpun', 3),
(13, 1, 34, 'Wajib Fakultas', 3),
(14, 1, 35, 'Wajib Fakultas', 3),
(15, 1, 36, 'Wajib Fakultas', 3),
(16, 1, 45, 'Wajib Prodi', 3),
(17, 1, 43, 'Wajib Prodi', 3),
(18, 1, 46, 'Wajib Prodi', 4),
(19, 1, 39, 'Wajib Fakultas', 4),
(20, 1, 37, 'Wajib Fakultas', 4),
(21, 1, 38, 'Wajib Fakultas', 4),
(22, 1, 47, 'Wajib Fakultas', 4),
(23, 1, 48, 'Wajib Fakultas', 4),
(24, 1, 49, 'Wajib Prodi', 5),
(25, 1, 50, 'Wajib Prodi', 5),
(26, 1, 51, 'Wajib Prodi', 5),
(27, 1, 52, 'Wajib Prodi', 5),
(28, 1, 53, 'Wajib Prodi', 5),
(29, 1, 40, 'Wajib Prodi', 6),
(30, 1, 54, 'Wajib Prodi', 6),
(31, 1, 55, 'Wajib Prodi', 6),
(32, 1, 56, 'Wajib Prodi', 6),
(33, 1, 41, 'Wajib Fakultas', 7),
(34, 1, 57, 'Wajib Prodi', 7),
(35, 1, 42, 'Wajib Fakultas', 8),
(36, 1, 71, 'Peminatan', 0),
(37, 1, 72, 'Peminatan', 0),
(38, 1, 73, 'Peminatan', 0),
(39, 1, 74, 'Peminatan', 0),
(40, 1, 75, 'Peminatan', 0),
(41, 1, 76, 'Peminatan', 0),
(42, 1, 77, 'Peminatan', 0),
(43, 1, 78, 'Peminatan', 0),
(44, 1, 79, 'Peminatan', 0),
(45, 1, 80, 'Peminatan', 0),
(46, 1, 81, 'Peminatan', 0),
(47, 1, 82, 'Peminatan', 0),
(48, 1, 83, 'Peminatan', 0),
(49, 1, 84, 'Peminatan', 0),
(50, 1, 85, 'Peminatan', 0),
(51, 1, 86, 'Peminatan', 0),
(52, 1, 87, 'Peminatan', 0),
(53, 1, 88, 'Peminatan', 0),
(54, 1, 89, 'Peminatan', 0),
(55, 1, 90, 'Peminatan', 0),
(56, 1, 91, 'Peminatan', 0),
(57, 1, 92, 'Peminatan', 0),
(58, 1, 93, 'Peminatan', 0),
(59, 1, 94, 'Peminatan', 0),
(60, 1, 95, 'Peminatan', 0),
(61, 1, 96, 'Peminatan', 0),
(62, 1, 97, 'Peminatan', 0),
(63, 1, 98, 'Peminatan', 0),
(64, 1, 99, 'Peminatan', 0),
(65, 1, 100, 'Peminatan', 0),
(66, 1, 101, 'Peminatan', 0),
(67, 1, 102, 'Peminatan', 0),
(68, 1, 103, 'Peminatan', 0),
(69, 1, 104, 'Peminatan', 0),
(70, 1, 105, 'Peminatan', 0),
(71, 1, 106, 'Peminatan', 0),
(72, 2, 2, 'Wajib UI', 1),
(73, 2, 30, 'Wajib Fakultas', 1),
(74, 2, 29, 'Wajib Rumpun', 1),
(75, 2, 31, 'Wajib Fakultas', 1),
(76, 2, 10, 'Wajib UI', 1),
(77, 2, 4, 'Wajib UI', 1),
(78, 2, 1, 'Wajib UI', 2),
(79, 2, 33, 'Wajib Fakultas', 2),
(80, 2, 32, 'Wajib Fakultas', 2),
(81, 2, 43, 'Wajib Prodi', 2),
(82, 2, 3, 'Wajib UI', 2),
(83, 2, 28, 'Wajib Rumpun', 3),
(84, 2, 34, 'Wajib Fakultas', 3),
(85, 2, 35, 'Wajib Fakultas', 3),
(86, 2, 36, 'Wajib Fakultas', 3),
(87, 2, 45, 'Wajib Prodi', 3),
(88, 2, 44, 'Wajib Prodi', 3),
(89, 2, 46, 'Wajib Prodi', 4),
(90, 2, 39, 'Wajib Fakultas', 4),
(91, 2, 37, 'Wajib Fakultas', 4),
(92, 2, 38, 'Wajib Fakultas', 4),
(93, 2, 47, 'Wajib Fakultas', 4),
(94, 2, 48, 'Wajib Fakultas', 4),
(95, 2, 49, 'Wajib Prodi', 5),
(96, 2, 50, 'Wajib Prodi', 5),
(97, 2, 51, 'Wajib Prodi', 5),
(98, 2, 52, 'Wajib Prodi', 5),
(99, 2, 53, 'Wajib Prodi', 5),
(100, 2, 40, 'Wajib Prodi', 6),
(101, 2, 54, 'Wajib Prodi', 6),
(102, 2, 55, 'Wajib Prodi', 6),
(103, 2, 56, 'Wajib Prodi', 6),
(104, 2, 41, 'Wajib Fakultas', 7),
(105, 2, 57, 'Wajib Prodi', 7),
(106, 2, 42, 'Wajib Fakultas', 8),
(107, 2, 71, 'Peminatan', 0),
(108, 2, 72, 'Peminatan', 0),
(109, 2, 73, 'Peminatan', 0),
(110, 2, 74, 'Peminatan', 0),
(111, 2, 75, 'Peminatan', 0),
(112, 2, 76, 'Peminatan', 0),
(113, 2, 77, 'Peminatan', 0),
(114, 2, 78, 'Peminatan', 0),
(115, 2, 79, 'Peminatan', 0),
(116, 2, 80, 'Peminatan', 0),
(117, 2, 81, 'Peminatan', 0),
(118, 2, 82, 'Peminatan', 0),
(119, 2, 83, 'Peminatan', 0),
(120, 2, 84, 'Peminatan', 0),
(121, 2, 85, 'Peminatan', 0),
(122, 2, 86, 'Peminatan', 0),
(123, 2, 87, 'Peminatan', 0),
(124, 2, 88, 'Peminatan', 0),
(125, 2, 89, 'Peminatan', 0),
(126, 2, 90, 'Peminatan', 0),
(127, 2, 91, 'Peminatan', 0),
(128, 2, 92, 'Peminatan', 0),
(129, 2, 93, 'Peminatan', 0),
(130, 2, 94, 'Peminatan', 0),
(131, 2, 95, 'Peminatan', 0),
(132, 2, 96, 'Peminatan', 0),
(133, 2, 97, 'Peminatan', 0),
(134, 2, 98, 'Peminatan', 0),
(135, 2, 99, 'Peminatan', 0),
(136, 2, 100, 'Peminatan', 0),
(137, 2, 101, 'Peminatan', 0),
(138, 2, 102, 'Peminatan', 0),
(139, 2, 103, 'Peminatan', 0),
(140, 2, 104, 'Peminatan', 0),
(141, 2, 105, 'Peminatan', 0),
(142, 2, 106, 'Peminatan', 0),
(143, 3, 1, 'Wajib UI', 1),
(144, 3, 30, 'Wajib Fakultas', 1),
(145, 3, 29, 'Wajib Rumpun', 1),
(146, 3, 31, 'Wajib Fakultas', 1),
(147, 3, 12, 'Wajib UI', 1),
(148, 3, 3, 'Wajib UI', 1),
(149, 3, 2, 'Wajib UI', 2),
(150, 3, 33, 'Wajib Fakultas', 2),
(151, 3, 32, 'Wajib Fakultas', 2),
(152, 3, 43, 'Wajib Prodi', 2),
(153, 3, 4, 'Wajib UI', 2),
(154, 3, 28, 'Wajib Rumpun', 3),
(155, 3, 34, 'Wajib Fakultas', 3),
(156, 3, 35, 'Wajib Fakultas', 3),
(157, 3, 36, 'Wajib Fakultas', 3),
(158, 3, 45, 'Wajib Prodi', 3),
(159, 3, 44, 'Wajib Prodi', 3),
(160, 3, 46, 'Wajib Prodi', 4),
(161, 3, 39, 'Wajib Fakultas', 4),
(162, 3, 37, 'Wajib Fakultas', 4),
(163, 3, 38, 'Wajib Fakultas', 4),
(164, 3, 47, 'Wajib Fakultas', 4),
(165, 3, 48, 'Wajib Fakultas', 4),
(166, 3, 49, 'Wajib Prodi', 5),
(167, 3, 50, 'Wajib Prodi', 5),
(168, 3, 51, 'Wajib Prodi', 5),
(169, 3, 52, 'Wajib Prodi', 5),
(170, 3, 53, 'Wajib Prodi', 5),
(171, 3, 40, 'Wajib Prodi', 6),
(172, 3, 54, 'Wajib Prodi', 6),
(173, 3, 55, 'Wajib Prodi', 6),
(174, 3, 56, 'Wajib Prodi', 6),
(175, 3, 41, 'Wajib Fakultas', 7),
(176, 3, 57, 'Wajib Prodi', 7),
(177, 3, 42, 'Wajib Fakultas', 8),
(178, 3, 71, 'Peminatan', 0),
(179, 3, 72, 'Peminatan', 0),
(180, 3, 73, 'Peminatan', 0),
(181, 3, 74, 'Peminatan', 0),
(182, 3, 75, 'Peminatan', 0),
(183, 3, 76, 'Peminatan', 0),
(184, 3, 77, 'Peminatan', 0),
(185, 3, 78, 'Peminatan', 0),
(186, 3, 79, 'Peminatan', 0),
(187, 3, 80, 'Peminatan', 0),
(188, 3, 81, 'Peminatan', 0),
(189, 3, 82, 'Peminatan', 0),
(190, 3, 83, 'Peminatan', 0),
(191, 3, 84, 'Peminatan', 0),
(192, 3, 85, 'Peminatan', 0),
(193, 3, 86, 'Peminatan', 0),
(194, 3, 87, 'Peminatan', 0),
(195, 3, 88, 'Peminatan', 0),
(196, 3, 89, 'Peminatan', 0),
(197, 3, 90, 'Peminatan', 0),
(198, 3, 91, 'Peminatan', 0),
(199, 3, 92, 'Peminatan', 0),
(200, 3, 93, 'Peminatan', 0),
(201, 3, 94, 'Peminatan', 0),
(202, 3, 95, 'Peminatan', 0),
(203, 3, 96, 'Peminatan', 0),
(204, 3, 97, 'Peminatan', 0),
(205, 3, 98, 'Peminatan', 0),
(206, 3, 99, 'Peminatan', 0),
(207, 3, 100, 'Peminatan', 0),
(208, 3, 101, 'Peminatan', 0),
(209, 3, 102, 'Peminatan', 0),
(210, 3, 103, 'Peminatan', 0),
(211, 3, 104, 'Peminatan', 0),
(212, 3, 105, 'Peminatan', 0),
(213, 3, 106, 'Peminatan', 0);

-- --------------------------------------------------------

--
-- Table structure for table `prasyarat_mata_kuliah`
--

CREATE TABLE `prasyarat_mata_kuliah` (
  `id` int(11) NOT NULL,
  `id_matkul` int(11) NOT NULL,
  `id_prasyarat_matkul` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prasyarat_mata_kuliah`
--

INSERT INTO `prasyarat_mata_kuliah` (`id`, `id_matkul`, `id_prasyarat_matkul`) VALUES
(1, 33, 31),
(2, 34, 30),
(3, 35, 31),
(4, 36, 33),
(5, 37, 28),
(6, 38, 44),
(7, 39, 33),
(8, 40, 1),
(9, 40, 2),
(10, 47, 45),
(11, 48, 45),
(12, 49, 35),
(13, 50, 39),
(14, 50, 43),
(15, 51, 35),
(16, 51, 36),
(17, 52, 43),
(18, 52, 46),
(19, 53, 29),
(20, 53, 31),
(21, 53, 38),
(22, 54, 49),
(23, 54, 50),
(24, 54, 52),
(25, 56, 37),
(26, 57, 43),
(27, 57, 46);

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `nama_role` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`id`, `nama_role`) VALUES
(1, 'ROLE_KAPRODI'),
(2, 'ROLE_SEKRE'),
(3, 'ROLE_DOSEN'),
(4, 'ROLE_MAHASISWA');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `nama` varchar(150) NOT NULL,
  `id_role` int(11) NOT NULL,
  `id_universitas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `nama`, `id_role`, `id_universitas`) VALUES
(1, 'kaprodi1', 'kaprodi', 'Faisal Rizky', 1, 1),
(2, 'kaprodi2', 'kaprodi', 'Radhitya Rahman', 1, 2),
(3, 'kaprodi3', 'kaprodi', 'Aditya Putra', 1, 3),
(4, 'sekre', 'sekre', 'Kurniawan Bahari', 2, 1),
(5, 'dosen', 'dosen', 'Muhammad Panji', 3, 1),
(6, 'mahasiswa', 'mahasiswa', 'Junior Aji', 4, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kurikulum`
--
ALTER TABLE `kurikulum`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mata_kuliah`
--
ALTER TABLE `mata_kuliah`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mata_kuliah_kurikulum`
--
ALTER TABLE `mata_kuliah_kurikulum`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_kurikulum` (`id_kurikulum`),
  ADD KEY `id_matkul` (`id_matkul`);

--
-- Indexes for table `prasyarat_mata_kuliah`
--
ALTER TABLE `prasyarat_mata_kuliah`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_matkul` (`id_matkul`),
  ADD KEY `id_prasyarat_matkul` (`id_prasyarat_matkul`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_role` (`id_role`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `kurikulum`
--
ALTER TABLE `kurikulum`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `mata_kuliah_kurikulum`
--
ALTER TABLE `mata_kuliah_kurikulum`
  ADD CONSTRAINT `mata_kuliah_kurikulum_ibfk_1` FOREIGN KEY (`id_kurikulum`) REFERENCES `kurikulum` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `mata_kuliah_kurikulum_ibfk_2` FOREIGN KEY (`id_matkul`) REFERENCES `mata_kuliah` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `prasyarat_mata_kuliah`
--
ALTER TABLE `prasyarat_mata_kuliah`
  ADD CONSTRAINT `prasyarat_mata_kuliah_ibfk_1` FOREIGN KEY (`id_matkul`) REFERENCES `mata_kuliah` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `prasyarat_mata_kuliah_ibfk_2` FOREIGN KEY (`id_prasyarat_matkul`) REFERENCES `mata_kuliah` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`id_role`) REFERENCES `roles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
