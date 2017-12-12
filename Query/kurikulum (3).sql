-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 06 Des 2017 pada 11.10
-- Versi Server: 10.1.21-MariaDB
-- PHP Version: 5.6.30

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
-- Struktur dari tabel `fakultas`
--

CREATE TABLE `fakultas` (
  `id_univ` int(11) NOT NULL,
  `id_fakultas` int(11) NOT NULL,
  `nama_fakultas` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `fakultas`
--

INSERT INTO `fakultas` (`id_univ`, `id_fakultas`, `nama_fakultas`) VALUES
(1, 1, 'Fakultas A1'),
(1, 2, 'Fakultas A2'),
(1, 3, 'Fakultas A3'),
(2, 1, 'Fakultas B1'),
(2, 2, 'Fakultas B2'),
(2, 3, 'Fakultas B3'),
(3, 1, 'Fakultas C1'),
(3, 2, 'Fakultas C2'),
(3, 3, 'Fakultas C3');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kurikulum`
--

CREATE TABLE `kurikulum` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_univ` int(11) NOT NULL,
  `id_fakultas` int(11) NOT NULL,
  `id_prodi` int(11) NOT NULL,
  `kode_kurikulum` varchar(30) NOT NULL,
  `nama_kurikulum` varchar(150) NOT NULL,
  `jumlah_sks_wajib` int(11) NOT NULL,
  `jumlah_sks_pilihan` int(11) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `kurikulum`
--

INSERT INTO `kurikulum` (`id`, `id_univ`, `id_fakultas`, `id_prodi`, `kode_kurikulum`, `nama_kurikulum`, `jumlah_sks_wajib`, `jumlah_sks_pilihan`) VALUES
(1, 1, 1, 1, 'KR1101', 'Kurikulum 2010 Program Studi A1X', 120, 24),
(2, 1, 1, 2, 'KR1102', 'Kurikulum 2010 Program Studi A1Y', 120, 24),
(3, 1, 1, 3, 'KR1103', 'Kurikulum 2010 Program Studi A1Z', 120, 24);

-- --------------------------------------------------------

--
-- Struktur dari tabel `mata_kuliah`
--

CREATE TABLE `mata_kuliah` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_univ` int(11) NOT NULL,
  `id_fakultas` int(11) NOT NULL,
  `id_prodi` int(11) NOT NULL,
  `kode_matkul` varchar(50) NOT NULL,
  `nama_matkul` varchar(150) NOT NULL,
  `jumlah_sks` int(11) NOT NULL,
  `prasyarat_sks` int(11) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `mata_kuliah`
--

INSERT INTO `mata_kuliah` (`id`, `id_univ`, `id_fakultas`, `id_prodi`, `kode_matkul`, `nama_matkul`, `jumlah_sks`, `prasyarat_sks`) VALUES
(1, 1, 1, 1, 'MTK11101', 'Mata Kuliah 11101', 6, 0),
(2, 1, 1, 1, 'MTK11102', 'Mata Kuliah 11102', 6, 0),
(3, 1, 1, 1, 'MTK11103', 'Mata Kuliah 11103', 1, 0),
(4, 1, 1, 1, 'MTK11104', 'Mata Kuliah 11104', 1, 0),
(5, 1, 1, 1, 'MTK11105', 'Mata Kuliah 11105', 3, 0),
(6, 1, 1, 1, 'MTK11106', 'Mata Kuliah 11106', 3, 0),
(7, 1, 1, 1, 'MTK11107', 'Mata Kuliah 11107', 3, 0),
(8, 1, 1, 1, 'MTK11108', 'Mata Kuliah 11108', 3, 0),
(9, 1, 1, 1, 'MTK11109', 'Mata Kuliah 11109', 3, 0),
(10, 1, 1, 1, 'MTK11110', 'Mata Kuliah 11110', 3, 0),
(11, 1, 1, 1, 'MTK11111', 'Mata Kuliah 11111', 3, 0),
(12, 1, 1, 1, 'MTK11112', 'Mata Kuliah 11112', 3, 0),
(13, 1, 1, 1, 'MTK11113', 'Mata Kuliah 11113', 3, 0),
(14, 1, 1, 1, 'MTK11114', 'Mata Kuliah 11114', 3, 0),
(15, 1, 1, 1, 'MTK11115', 'Mata Kuliah 11115', 3, 0),
(16, 1, 1, 1, 'MTK11116', 'Mata Kuliah 11116', 3, 0),
(17, 1, 1, 1, 'MTK11117', 'Mata Kuliah 11117', 3, 0),
(18, 1, 1, 1, 'MTK11118', 'Mata Kuliah 11118', 3, 0),
(19, 1, 1, 1, 'MTK11119', 'Mata Kuliah 11119', 3, 0),
(20, 1, 1, 1, 'MTK11120', 'Mata Kuliah 11120', 3, 0),
(21, 1, 1, 1, 'MTK11121', 'Mata Kuliah 11121', 3, 0),
(22, 1, 1, 1, 'MTK11122', 'Mata Kuliah 11122', 3, 0),
(23, 1, 1, 1, 'MTK11123', 'Mata Kuliah 11123', 3, 0),
(24, 1, 1, 1, 'MTK11124', 'Mata Kuliah 11124', 3, 0),
(25, 1, 1, 1, 'MTK11125', 'Mata Kuliah 11125', 3, 0),
(26, 1, 1, 1, 'MTK11126', 'Mata Kuliah 11126', 3, 0),
(27, 1, 1, 1, 'MTK11127', 'Mata Kuliah 11127', 3, 0),
(28, 1, 1, 1, 'MTK11128', 'Mata Kuliah 11128', 3, 0),
(29, 1, 1, 1, 'MTK11129', 'Mata Kuliah 11129', 3, 0),
(30, 1, 1, 1, 'MTK11130', 'Mata Kuliah 11130', 3, 0),
(31, 1, 1, 1, 'MTK11131', 'Mata Kuliah 11131', 3, 48),
(32, 1, 1, 1, 'MTK11132', 'Mata Kuliah 11132', 3, 100),
(33, 1, 1, 1, 'MTK11133', 'Mata Kuliah 11133', 3, 0),
(34, 1, 1, 1, 'MTK11134', 'Mata Kuliah 11134', 3, 0),
(35, 1, 1, 1, 'MTK11135', 'Mata Kuliah 11135', 3, 0),
(36, 1, 1, 1, 'MTK11136', 'Mata Kuliah 11136', 3, 0),
(37, 1, 1, 1, 'MTK11137', 'Mata Kuliah 11137', 3, 0),
(38, 1, 1, 1, 'MTK11138', 'Mata Kuliah 11138', 3, 0),
(39, 1, 1, 1, 'MTK11139', 'Mata Kuliah 11139', 3, 0),
(40, 1, 1, 1, 'MTK11140', 'Mata Kuliah 11140', 3, 0),
(41, 1, 1, 2, 'MTK11201', 'Mata Kuliah 11201', 6, 0),
(42, 1, 1, 2, 'MTK11202', 'Mata Kuliah 11202', 6, 0),
(43, 1, 1, 2, 'MTK11203', 'Mata Kuliah 11203', 1, 0),
(44, 1, 1, 2, 'MTK11204', 'Mata Kuliah 11204', 1, 0),
(45, 1, 1, 2, 'MTK11205', 'Mata Kuliah 11205', 3, 0),
(46, 1, 1, 2, 'MTK11206', 'Mata Kuliah 11206', 3, 0),
(47, 1, 1, 2, 'MTK11207', 'Mata Kuliah 11207', 3, 0),
(48, 1, 1, 2, 'MTK11208', 'Mata Kuliah 11208', 3, 0),
(49, 1, 1, 2, 'MTK11209', 'Mata Kuliah 11209', 3, 0),
(50, 1, 1, 2, 'MTK11210', 'Mata Kuliah 11210', 3, 0),
(51, 1, 1, 2, 'MTK11211', 'Mata Kuliah 11211', 3, 0),
(52, 1, 1, 2, 'MTK11212', 'Mata Kuliah 11212', 3, 0),
(53, 1, 1, 2, 'MTK11213', 'Mata Kuliah 11213', 3, 0),
(54, 1, 1, 2, 'MTK11214', 'Mata Kuliah 11214', 3, 0),
(55, 1, 1, 2, 'MTK11215', 'Mata Kuliah 11215', 3, 0),
(56, 1, 1, 2, 'MTK11216', 'Mata Kuliah 11216', 3, 0),
(57, 1, 1, 2, 'MTK11217', 'Mata Kuliah 11217', 3, 0),
(58, 1, 1, 2, 'MTK11218', 'Mata Kuliah 11218', 3, 0),
(59, 1, 1, 2, 'MTK11219', 'Mata Kuliah 11219', 3, 0),
(60, 1, 1, 2, 'MTK11220', 'Mata Kuliah 11220', 3, 0),
(61, 1, 1, 2, 'MTK11221', 'Mata Kuliah 11221', 3, 0),
(62, 1, 1, 2, 'MTK11222', 'Mata Kuliah 11222', 3, 0),
(63, 1, 1, 2, 'MTK11223', 'Mata Kuliah 11223', 3, 0),
(64, 1, 1, 2, 'MTK11224', 'Mata Kuliah 11224', 3, 0),
(65, 1, 1, 2, 'MTK11225', 'Mata Kuliah 11225', 3, 0),
(66, 1, 1, 2, 'MTK11226', 'Mata Kuliah 11226', 3, 0),
(67, 1, 1, 2, 'MTK11227', 'Mata Kuliah 11227', 3, 0),
(68, 1, 1, 2, 'MTK11228', 'Mata Kuliah 11228', 3, 0),
(69, 1, 1, 2, 'MTK11229', 'Mata Kuliah 11229', 3, 0),
(70, 1, 1, 2, 'MTK11230', 'Mata Kuliah 11230', 3, 0),
(71, 1, 1, 2, 'MTK11231', 'Mata Kuliah 11231', 3, 48),
(72, 1, 1, 2, 'MTK11232', 'Mata Kuliah 11232', 3, 100),
(73, 1, 1, 2, 'MTK11233', 'Mata Kuliah 11233', 3, 0),
(74, 1, 1, 2, 'MTK11234', 'Mata Kuliah 11234', 3, 0),
(75, 1, 1, 2, 'MTK11235', 'Mata Kuliah 11235', 3, 0),
(76, 1, 1, 2, 'MTK11236', 'Mata Kuliah 11236', 3, 0),
(77, 1, 1, 2, 'MTK11237', 'Mata Kuliah 11237', 3, 0),
(78, 1, 1, 2, 'MTK11238', 'Mata Kuliah 11238', 3, 0),
(79, 1, 1, 2, 'MTK11239', 'Mata Kuliah 11239', 3, 0),
(80, 1, 1, 2, 'MTK11240', 'Mata Kuliah 11240', 3, 0),
(81, 1, 1, 3, 'MTK11301', 'Mata Kuliah 11301', 6, 0),
(82, 1, 1, 3, 'MTK11302', 'Mata Kuliah 11302', 6, 0),
(83, 1, 1, 3, 'MTK11303', 'Mata Kuliah 11303', 1, 0),
(84, 1, 1, 3, 'MTK11304', 'Mata Kuliah 11304', 1, 0),
(85, 1, 1, 3, 'MTK11305', 'Mata Kuliah 11305', 3, 0),
(86, 1, 1, 3, 'MTK11306', 'Mata Kuliah 11306', 3, 0),
(87, 1, 1, 3, 'MTK11307', 'Mata Kuliah 11307', 3, 0),
(88, 1, 1, 3, 'MTK11308', 'Mata Kuliah 11308', 3, 0),
(89, 1, 1, 3, 'MTK11309', 'Mata Kuliah 11309', 3, 0),
(90, 1, 1, 3, 'MTK11310', 'Mata Kuliah 11310', 3, 0),
(91, 1, 1, 3, 'MTK11311', 'Mata Kuliah 11311', 3, 0),
(92, 1, 1, 3, 'MTK11312', 'Mata Kuliah 11312', 3, 0),
(93, 1, 1, 3, 'MTK11313', 'Mata Kuliah 11313', 3, 0),
(94, 1, 1, 3, 'MTK11314', 'Mata Kuliah 11314', 3, 0),
(95, 1, 1, 3, 'MTK11315', 'Mata Kuliah 11315', 3, 0),
(96, 1, 1, 3, 'MTK11316', 'Mata Kuliah 11316', 3, 0),
(97, 1, 1, 3, 'MTK11317', 'Mata Kuliah 11317', 3, 0),
(98, 1, 1, 3, 'MTK11318', 'Mata Kuliah 11318', 3, 0),
(99, 1, 1, 3, 'MTK11319', 'Mata Kuliah 11319', 3, 0),
(100, 1, 1, 3, 'MTK11320', 'Mata Kuliah 11320', 3, 0),
(101, 1, 1, 3, 'MTK11321', 'Mata Kuliah 11321', 3, 0),
(102, 1, 1, 3, 'MTK11322', 'Mata Kuliah 11322', 3, 0),
(103, 1, 1, 3, 'MTK11323', 'Mata Kuliah 11323', 3, 0),
(104, 1, 1, 3, 'MTK11324', 'Mata Kuliah 11324', 3, 0),
(105, 1, 1, 3, 'MTK11325', 'Mata Kuliah 11325', 3, 0),
(106, 1, 1, 3, 'MTK11326', 'Mata Kuliah 11326', 3, 0),
(107, 1, 1, 3, 'MTK11327', 'Mata Kuliah 11327', 3, 0),
(108, 1, 1, 3, 'MTK11328', 'Mata Kuliah 11328', 3, 0),
(109, 1, 1, 3, 'MTK11329', 'Mata Kuliah 11329', 3, 0),
(110, 1, 1, 3, 'MTK11330', 'Mata Kuliah 11330', 3, 0),
(111, 1, 1, 3, 'MTK11331', 'Mata Kuliah 11331', 3, 48),
(112, 1, 1, 3, 'MTK11332', 'Mata Kuliah 11332', 3, 100),
(113, 1, 1, 3, 'MTK11333', 'Mata Kuliah 11333', 3, 0),
(114, 1, 1, 3, 'MTK11334', 'Mata Kuliah 11334', 3, 0),
(115, 1, 1, 3, 'MTK11335', 'Mata Kuliah 11335', 3, 0),
(116, 1, 1, 3, 'MTK11336', 'Mata Kuliah 11336', 3, 0),
(117, 1, 1, 3, 'MTK11337', 'Mata Kuliah 11337', 3, 0),
(118, 1, 1, 3, 'MTK11338', 'Mata Kuliah 11338', 3, 0),
(119, 1, 1, 3, 'MTK11339', 'Mata Kuliah 11339', 3, 0),
(120, 1, 1, 3, 'MTK11340', 'Mata Kuliah 11340', 3, 0),
(121, 1, 2, 1, 'MTK12101', 'Mata Kuliah 12101', 6, 0),
(122, 1, 2, 1, 'MTK12102', 'Mata Kuliah 12102', 6, 0),
(123, 1, 2, 1, 'MTK12103', 'Mata Kuliah 12103', 1, 0),
(124, 1, 2, 1, 'MTK12104', 'Mata Kuliah 12104', 1, 0),
(125, 1, 2, 1, 'MTK12105', 'Mata Kuliah 12105', 3, 0),
(126, 1, 2, 1, 'MTK12106', 'Mata Kuliah 12106', 3, 0),
(127, 1, 2, 1, 'MTK12107', 'Mata Kuliah 12107', 3, 0),
(128, 1, 2, 1, 'MTK12108', 'Mata Kuliah 12108', 3, 0),
(129, 1, 2, 1, 'MTK12109', 'Mata Kuliah 12109', 3, 0),
(130, 1, 2, 1, 'MTK12110', 'Mata Kuliah 12110', 3, 0),
(131, 1, 2, 1, 'MTK12111', 'Mata Kuliah 12111', 3, 0),
(132, 1, 2, 1, 'MTK12112', 'Mata Kuliah 12112', 3, 0),
(133, 1, 2, 1, 'MTK12113', 'Mata Kuliah 12113', 3, 0),
(134, 1, 2, 1, 'MTK12114', 'Mata Kuliah 12114', 3, 0),
(135, 1, 2, 1, 'MTK12115', 'Mata Kuliah 12115', 3, 0),
(136, 1, 2, 1, 'MTK12116', 'Mata Kuliah 12116', 3, 0),
(137, 1, 2, 1, 'MTK12117', 'Mata Kuliah 12117', 3, 0),
(138, 1, 2, 1, 'MTK12118', 'Mata Kuliah 12118', 3, 0),
(139, 1, 2, 1, 'MTK12119', 'Mata Kuliah 12119', 3, 0),
(140, 1, 2, 1, 'MTK12120', 'Mata Kuliah 12120', 3, 0),
(141, 1, 2, 1, 'MTK12121', 'Mata Kuliah 12121', 3, 0),
(142, 1, 2, 1, 'MTK12122', 'Mata Kuliah 12122', 3, 0),
(143, 1, 2, 1, 'MTK12123', 'Mata Kuliah 12123', 3, 0),
(144, 1, 2, 1, 'MTK12124', 'Mata Kuliah 12124', 3, 0),
(145, 1, 2, 1, 'MTK12125', 'Mata Kuliah 12125', 3, 0),
(146, 1, 2, 1, 'MTK12126', 'Mata Kuliah 12126', 3, 0),
(147, 1, 2, 1, 'MTK12127', 'Mata Kuliah 12127', 3, 0),
(148, 1, 2, 1, 'MTK12128', 'Mata Kuliah 12128', 3, 0),
(149, 1, 2, 1, 'MTK12129', 'Mata Kuliah 12129', 3, 0),
(150, 1, 2, 1, 'MTK12130', 'Mata Kuliah 12130', 3, 0),
(151, 1, 2, 1, 'MTK12131', 'Mata Kuliah 12131', 3, 48),
(152, 1, 2, 1, 'MTK12132', 'Mata Kuliah 12132', 3, 100),
(153, 1, 2, 1, 'MTK12133', 'Mata Kuliah 12133', 3, 0),
(154, 1, 2, 1, 'MTK12134', 'Mata Kuliah 12134', 3, 0),
(155, 1, 2, 1, 'MTK12135', 'Mata Kuliah 12135', 3, 0),
(156, 1, 2, 1, 'MTK12136', 'Mata Kuliah 12136', 3, 0),
(157, 1, 2, 1, 'MTK12137', 'Mata Kuliah 12137', 3, 0),
(158, 1, 2, 1, 'MTK12138', 'Mata Kuliah 12138', 3, 0),
(159, 1, 2, 1, 'MTK12139', 'Mata Kuliah 12139', 3, 0),
(160, 1, 2, 1, 'MTK12140', 'Mata Kuliah 12140', 3, 0),
(161, 1, 2, 2, 'MTK12201', 'Mata Kuliah 12201', 6, 0),
(162, 1, 2, 2, 'MTK12202', 'Mata Kuliah 12202', 6, 0),
(163, 1, 2, 2, 'MTK12203', 'Mata Kuliah 12203', 1, 0),
(164, 1, 2, 2, 'MTK12204', 'Mata Kuliah 12204', 1, 0),
(165, 1, 2, 2, 'MTK12205', 'Mata Kuliah 12205', 3, 0),
(166, 1, 2, 2, 'MTK12206', 'Mata Kuliah 12206', 3, 0),
(167, 1, 2, 2, 'MTK12207', 'Mata Kuliah 12207', 3, 0),
(168, 1, 2, 2, 'MTK12208', 'Mata Kuliah 12208', 3, 0),
(169, 1, 2, 2, 'MTK12209', 'Mata Kuliah 12209', 3, 0),
(170, 1, 2, 2, 'MTK12210', 'Mata Kuliah 12210', 3, 0),
(171, 1, 2, 2, 'MTK12211', 'Mata Kuliah 12211', 3, 0),
(172, 1, 2, 2, 'MTK12212', 'Mata Kuliah 12212', 3, 0),
(173, 1, 2, 2, 'MTK12213', 'Mata Kuliah 12213', 3, 0),
(174, 1, 2, 2, 'MTK12214', 'Mata Kuliah 12214', 3, 0),
(175, 1, 2, 2, 'MTK12215', 'Mata Kuliah 12215', 3, 0),
(176, 1, 2, 2, 'MTK12216', 'Mata Kuliah 12216', 3, 0),
(177, 1, 2, 2, 'MTK12217', 'Mata Kuliah 12217', 3, 0),
(178, 1, 2, 2, 'MTK12218', 'Mata Kuliah 12218', 3, 0),
(179, 1, 2, 2, 'MTK12219', 'Mata Kuliah 12219', 3, 0),
(180, 1, 2, 2, 'MTK12220', 'Mata Kuliah 12220', 3, 0),
(181, 1, 2, 2, 'MTK12221', 'Mata Kuliah 12221', 3, 0),
(182, 1, 2, 2, 'MTK12222', 'Mata Kuliah 12222', 3, 0),
(183, 1, 2, 2, 'MTK12223', 'Mata Kuliah 12223', 3, 0),
(184, 1, 2, 2, 'MTK12224', 'Mata Kuliah 12224', 3, 0),
(185, 1, 2, 2, 'MTK12225', 'Mata Kuliah 12225', 3, 0),
(186, 1, 2, 2, 'MTK12226', 'Mata Kuliah 12226', 3, 0),
(187, 1, 2, 2, 'MTK12227', 'Mata Kuliah 12227', 3, 0),
(188, 1, 2, 2, 'MTK12228', 'Mata Kuliah 12228', 3, 0),
(189, 1, 2, 2, 'MTK12229', 'Mata Kuliah 12229', 3, 0),
(190, 1, 2, 2, 'MTK12230', 'Mata Kuliah 12230', 3, 0),
(191, 1, 2, 2, 'MTK12231', 'Mata Kuliah 12231', 3, 48),
(192, 1, 2, 2, 'MTK12232', 'Mata Kuliah 12232', 3, 100),
(193, 1, 2, 2, 'MTK12233', 'Mata Kuliah 12233', 3, 0),
(194, 1, 2, 2, 'MTK12234', 'Mata Kuliah 12234', 3, 0),
(195, 1, 2, 2, 'MTK12235', 'Mata Kuliah 12235', 3, 0),
(196, 1, 2, 2, 'MTK12236', 'Mata Kuliah 12236', 3, 0),
(197, 1, 2, 2, 'MTK12237', 'Mata Kuliah 12237', 3, 0),
(198, 1, 2, 2, 'MTK12238', 'Mata Kuliah 12238', 3, 0),
(199, 1, 2, 2, 'MTK12239', 'Mata Kuliah 12239', 3, 0),
(200, 1, 2, 2, 'MTK12240', 'Mata Kuliah 12240', 3, 0),
(201, 1, 2, 3, 'MTK12301', 'Mata Kuliah 12301', 6, 0),
(202, 1, 2, 3, 'MTK12302', 'Mata Kuliah 12302', 6, 0),
(203, 1, 2, 3, 'MTK12303', 'Mata Kuliah 12303', 1, 0),
(204, 1, 2, 3, 'MTK12304', 'Mata Kuliah 12304', 1, 0),
(205, 1, 2, 3, 'MTK12305', 'Mata Kuliah 12305', 3, 0),
(206, 1, 2, 3, 'MTK12306', 'Mata Kuliah 12306', 3, 0),
(207, 1, 2, 3, 'MTK12307', 'Mata Kuliah 12307', 3, 0),
(208, 1, 2, 3, 'MTK12308', 'Mata Kuliah 12308', 3, 0),
(209, 1, 2, 3, 'MTK12309', 'Mata Kuliah 12309', 3, 0),
(210, 1, 2, 3, 'MTK12310', 'Mata Kuliah 12310', 3, 0),
(211, 1, 2, 3, 'MTK12311', 'Mata Kuliah 12311', 3, 0),
(212, 1, 2, 3, 'MTK12312', 'Mata Kuliah 12312', 3, 0),
(213, 1, 2, 3, 'MTK12313', 'Mata Kuliah 12313', 3, 0),
(214, 1, 2, 3, 'MTK12314', 'Mata Kuliah 12314', 3, 0),
(215, 1, 2, 3, 'MTK12315', 'Mata Kuliah 12315', 3, 0),
(216, 1, 2, 3, 'MTK12316', 'Mata Kuliah 12316', 3, 0),
(217, 1, 2, 3, 'MTK12317', 'Mata Kuliah 12317', 3, 0),
(218, 1, 2, 3, 'MTK12318', 'Mata Kuliah 12318', 3, 0),
(219, 1, 2, 3, 'MTK12319', 'Mata Kuliah 12319', 3, 0),
(220, 1, 2, 3, 'MTK12320', 'Mata Kuliah 12320', 3, 0),
(221, 1, 2, 3, 'MTK12321', 'Mata Kuliah 12321', 3, 0),
(222, 1, 2, 3, 'MTK12322', 'Mata Kuliah 12322', 3, 0),
(223, 1, 2, 3, 'MTK12323', 'Mata Kuliah 12323', 3, 0),
(224, 1, 2, 3, 'MTK12324', 'Mata Kuliah 12324', 3, 0),
(225, 1, 2, 3, 'MTK12325', 'Mata Kuliah 12325', 3, 0),
(226, 1, 2, 3, 'MTK12326', 'Mata Kuliah 12326', 3, 0),
(227, 1, 2, 3, 'MTK12327', 'Mata Kuliah 12327', 3, 0),
(228, 1, 2, 3, 'MTK12328', 'Mata Kuliah 12328', 3, 0),
(229, 1, 2, 3, 'MTK12329', 'Mata Kuliah 12329', 3, 0),
(230, 1, 2, 3, 'MTK12330', 'Mata Kuliah 12330', 3, 0),
(231, 1, 2, 3, 'MTK12331', 'Mata Kuliah 12331', 3, 48),
(232, 1, 2, 3, 'MTK12332', 'Mata Kuliah 12332', 3, 100),
(233, 1, 2, 3, 'MTK12333', 'Mata Kuliah 12333', 3, 0),
(234, 1, 2, 3, 'MTK12334', 'Mata Kuliah 12334', 3, 0),
(235, 1, 2, 3, 'MTK12335', 'Mata Kuliah 12335', 3, 0),
(236, 1, 2, 3, 'MTK12336', 'Mata Kuliah 12336', 3, 0),
(237, 1, 2, 3, 'MTK12337', 'Mata Kuliah 12337', 3, 0),
(238, 1, 2, 3, 'MTK12338', 'Mata Kuliah 12338', 3, 0),
(239, 1, 2, 3, 'MTK12339', 'Mata Kuliah 12339', 3, 0),
(240, 1, 2, 3, 'MTK12340', 'Mata Kuliah 12340', 3, 0),
(241, 1, 3, 1, 'MTK13101', 'Mata Kuliah 13101', 6, 0),
(242, 1, 3, 1, 'MTK13102', 'Mata Kuliah 13102', 6, 0),
(243, 1, 3, 1, 'MTK13103', 'Mata Kuliah 13103', 1, 0),
(244, 1, 3, 1, 'MTK13104', 'Mata Kuliah 13104', 1, 0),
(245, 1, 3, 1, 'MTK13105', 'Mata Kuliah 13105', 3, 0),
(246, 1, 3, 1, 'MTK13106', 'Mata Kuliah 13106', 3, 0),
(247, 1, 3, 1, 'MTK13107', 'Mata Kuliah 13107', 3, 0),
(248, 1, 3, 1, 'MTK13108', 'Mata Kuliah 13108', 3, 0),
(249, 1, 3, 1, 'MTK13109', 'Mata Kuliah 13109', 3, 0),
(250, 1, 3, 1, 'MTK13110', 'Mata Kuliah 13110', 3, 0),
(251, 1, 3, 1, 'MTK13111', 'Mata Kuliah 13111', 3, 0),
(252, 1, 3, 1, 'MTK13112', 'Mata Kuliah 13112', 3, 0),
(253, 1, 3, 1, 'MTK13113', 'Mata Kuliah 13113', 3, 0),
(254, 1, 3, 1, 'MTK13114', 'Mata Kuliah 13114', 3, 0),
(255, 1, 3, 1, 'MTK13115', 'Mata Kuliah 13115', 3, 0),
(256, 1, 3, 1, 'MTK13116', 'Mata Kuliah 13116', 3, 0),
(257, 1, 3, 1, 'MTK13117', 'Mata Kuliah 13117', 3, 0),
(258, 1, 3, 1, 'MTK13118', 'Mata Kuliah 13118', 3, 0),
(259, 1, 3, 1, 'MTK13119', 'Mata Kuliah 13119', 3, 0),
(260, 1, 3, 1, 'MTK13120', 'Mata Kuliah 13120', 3, 0),
(261, 1, 3, 1, 'MTK13121', 'Mata Kuliah 13121', 3, 0),
(262, 1, 3, 1, 'MTK13122', 'Mata Kuliah 13122', 3, 0),
(263, 1, 3, 1, 'MTK13123', 'Mata Kuliah 13123', 3, 0),
(264, 1, 3, 1, 'MTK13124', 'Mata Kuliah 13124', 3, 0),
(265, 1, 3, 1, 'MTK13125', 'Mata Kuliah 13125', 3, 0),
(266, 1, 3, 1, 'MTK13126', 'Mata Kuliah 13126', 3, 0),
(267, 1, 3, 1, 'MTK13127', 'Mata Kuliah 13127', 3, 0),
(268, 1, 3, 1, 'MTK13128', 'Mata Kuliah 13128', 3, 0),
(269, 1, 3, 1, 'MTK13129', 'Mata Kuliah 13129', 3, 0),
(270, 1, 3, 1, 'MTK13130', 'Mata Kuliah 13130', 3, 0),
(271, 1, 3, 1, 'MTK13131', 'Mata Kuliah 13131', 3, 48),
(272, 1, 3, 1, 'MTK13132', 'Mata Kuliah 13132', 3, 100),
(273, 1, 3, 1, 'MTK13133', 'Mata Kuliah 13133', 3, 0),
(274, 1, 3, 1, 'MTK13134', 'Mata Kuliah 13134', 3, 0),
(275, 1, 3, 1, 'MTK13135', 'Mata Kuliah 13135', 3, 0),
(276, 1, 3, 1, 'MTK13136', 'Mata Kuliah 13136', 3, 0),
(277, 1, 3, 1, 'MTK13137', 'Mata Kuliah 13137', 3, 0),
(278, 1, 3, 1, 'MTK13138', 'Mata Kuliah 13138', 3, 0),
(279, 1, 3, 1, 'MTK13139', 'Mata Kuliah 13139', 3, 0),
(280, 1, 3, 1, 'MTK13140', 'Mata Kuliah 13140', 3, 0),
(281, 1, 3, 2, 'MTK13201', 'Mata Kuliah 13201', 6, 0),
(282, 1, 3, 2, 'MTK13202', 'Mata Kuliah 13202', 6, 0),
(283, 1, 3, 2, 'MTK13203', 'Mata Kuliah 13203', 1, 0),
(284, 1, 3, 2, 'MTK13204', 'Mata Kuliah 13204', 1, 0),
(285, 1, 3, 2, 'MTK13205', 'Mata Kuliah 13205', 3, 0),
(286, 1, 3, 2, 'MTK13206', 'Mata Kuliah 13206', 3, 0),
(287, 1, 3, 2, 'MTK13207', 'Mata Kuliah 13207', 3, 0),
(288, 1, 3, 2, 'MTK13208', 'Mata Kuliah 13208', 3, 0),
(289, 1, 3, 2, 'MTK13209', 'Mata Kuliah 13209', 3, 0),
(290, 1, 3, 2, 'MTK13210', 'Mata Kuliah 13210', 3, 0),
(291, 1, 3, 2, 'MTK13211', 'Mata Kuliah 13211', 3, 0),
(292, 1, 3, 2, 'MTK13212', 'Mata Kuliah 13212', 3, 0),
(293, 1, 3, 2, 'MTK13213', 'Mata Kuliah 13213', 3, 0),
(294, 1, 3, 2, 'MTK13214', 'Mata Kuliah 13214', 3, 0),
(295, 1, 3, 2, 'MTK13215', 'Mata Kuliah 13215', 3, 0),
(296, 1, 3, 2, 'MTK13216', 'Mata Kuliah 13216', 3, 0),
(297, 1, 3, 2, 'MTK13217', 'Mata Kuliah 13217', 3, 0),
(298, 1, 3, 2, 'MTK13218', 'Mata Kuliah 13218', 3, 0),
(299, 1, 3, 2, 'MTK13219', 'Mata Kuliah 13219', 3, 0),
(300, 1, 3, 2, 'MTK13220', 'Mata Kuliah 13220', 3, 0),
(301, 1, 3, 2, 'MTK13221', 'Mata Kuliah 13221', 3, 0),
(302, 1, 3, 2, 'MTK13222', 'Mata Kuliah 13222', 3, 0),
(303, 1, 3, 2, 'MTK13223', 'Mata Kuliah 13223', 3, 0),
(304, 1, 3, 2, 'MTK13224', 'Mata Kuliah 13224', 3, 0),
(305, 1, 3, 2, 'MTK13225', 'Mata Kuliah 13225', 3, 0),
(306, 1, 3, 2, 'MTK13226', 'Mata Kuliah 13226', 3, 0),
(307, 1, 3, 2, 'MTK13227', 'Mata Kuliah 13227', 3, 0),
(308, 1, 3, 2, 'MTK13228', 'Mata Kuliah 13228', 3, 0),
(309, 1, 3, 2, 'MTK13229', 'Mata Kuliah 13229', 3, 0),
(310, 1, 3, 2, 'MTK13230', 'Mata Kuliah 13230', 3, 0),
(311, 1, 3, 2, 'MTK13231', 'Mata Kuliah 13231', 3, 48),
(312, 1, 3, 2, 'MTK13232', 'Mata Kuliah 13232', 3, 100),
(313, 1, 3, 2, 'MTK13233', 'Mata Kuliah 13233', 3, 0),
(314, 1, 3, 2, 'MTK13234', 'Mata Kuliah 13234', 3, 0),
(315, 1, 3, 2, 'MTK13235', 'Mata Kuliah 13235', 3, 0),
(316, 1, 3, 2, 'MTK13236', 'Mata Kuliah 13236', 3, 0),
(317, 1, 3, 2, 'MTK13237', 'Mata Kuliah 13237', 3, 0),
(318, 1, 3, 2, 'MTK13238', 'Mata Kuliah 13238', 3, 0),
(319, 1, 3, 2, 'MTK13239', 'Mata Kuliah 13239', 3, 0),
(320, 1, 3, 2, 'MTK13240', 'Mata Kuliah 13240', 3, 0),
(321, 1, 3, 3, 'MTK13301', 'Mata Kuliah 13301', 6, 0),
(322, 1, 3, 3, 'MTK13302', 'Mata Kuliah 13302', 6, 0),
(323, 1, 3, 3, 'MTK13303', 'Mata Kuliah 13303', 1, 0),
(324, 1, 3, 3, 'MTK13304', 'Mata Kuliah 13304', 1, 0),
(325, 1, 3, 3, 'MTK13305', 'Mata Kuliah 13305', 3, 0),
(326, 1, 3, 3, 'MTK13306', 'Mata Kuliah 13306', 3, 0),
(327, 1, 3, 3, 'MTK13307', 'Mata Kuliah 13307', 3, 0),
(328, 1, 3, 3, 'MTK13308', 'Mata Kuliah 13308', 3, 0),
(329, 1, 3, 3, 'MTK13309', 'Mata Kuliah 13309', 3, 0),
(330, 1, 3, 3, 'MTK13310', 'Mata Kuliah 13310', 3, 0),
(331, 1, 3, 3, 'MTK13311', 'Mata Kuliah 13311', 3, 0),
(332, 1, 3, 3, 'MTK13312', 'Mata Kuliah 13312', 3, 0),
(333, 1, 3, 3, 'MTK13313', 'Mata Kuliah 13313', 3, 0),
(334, 1, 3, 3, 'MTK13314', 'Mata Kuliah 13314', 3, 0),
(335, 1, 3, 3, 'MTK13315', 'Mata Kuliah 13315', 3, 0),
(336, 1, 3, 3, 'MTK13316', 'Mata Kuliah 13316', 3, 0),
(337, 1, 3, 3, 'MTK13317', 'Mata Kuliah 13317', 3, 0),
(338, 1, 3, 3, 'MTK13318', 'Mata Kuliah 13318', 3, 0),
(339, 1, 3, 3, 'MTK13319', 'Mata Kuliah 13319', 3, 0),
(340, 1, 3, 3, 'MTK13320', 'Mata Kuliah 13320', 3, 0),
(341, 1, 3, 3, 'MTK13321', 'Mata Kuliah 13321', 3, 48),
(342, 1, 3, 3, 'MTK13322', 'Mata Kuliah 13322', 3, 48),
(343, 1, 3, 3, 'MTK13323', 'Mata Kuliah 13323', 3, 0),
(344, 1, 3, 3, 'MTK13324', 'Mata Kuliah 13324', 3, 0),
(345, 1, 3, 3, 'MTK13325', 'Mata Kuliah 13325', 3, 0),
(346, 1, 3, 3, 'MTK13326', 'Mata Kuliah 13326', 3, 0),
(347, 1, 3, 3, 'MTK13327', 'Mata Kuliah 13327', 3, 0),
(348, 1, 3, 3, 'MTK13328', 'Mata Kuliah 13328', 3, 0),
(349, 1, 3, 3, 'MTK13329', 'Mata Kuliah 13329', 3, 0),
(350, 1, 3, 3, 'MTK13330', 'Mata Kuliah 13330', 3, 0),
(351, 1, 3, 3, 'MTK13331', 'Mata Kuliah 13331', 3, 48),
(352, 1, 3, 3, 'MTK13332', 'Mata Kuliah 13332', 3, 100),
(353, 1, 3, 3, 'MTK13333', 'Mata Kuliah 13333', 3, 0),
(354, 1, 3, 3, 'MTK13334', 'Mata Kuliah 13334', 3, 0),
(355, 1, 3, 3, 'MTK13335', 'Mata Kuliah 13335', 3, 0),
(356, 1, 3, 3, 'MTK13336', 'Mata Kuliah 13336', 3, 0),
(357, 1, 3, 3, 'MTK13337', 'Mata Kuliah 13337', 3, 0),
(358, 1, 3, 3, 'MTK13338', 'Mata Kuliah 13338', 3, 0),
(359, 1, 3, 3, 'MTK13339', 'Mata Kuliah 13339', 3, 0),
(360, 1, 3, 3, 'MTK13340', 'Mata Kuliah 13340', 3, 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `mata_kuliah_kurikulum`
--

CREATE TABLE `mata_kuliah_kurikulum` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_kurikulum` int(11) NOT NULL,
  `id_matkul` int(11) NOT NULL,
  `status_matkul` varchar(100) NOT NULL,
  `term` int(11) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `mata_kuliah_kurikulum`
--

INSERT INTO `mata_kuliah_kurikulum` (`id`, `id_kurikulum`, `id_matkul`, `status_matkul`, `term`) VALUES
(1, 1, 1, 'Wajib Univ', 1),
(2, 1, 2, 'Wajib Fakultas', 1),
(3, 1, 3, 'Wajib Fakultas', 1),
(4, 1, 4, 'Wajib Prodi', 1),
(5, 1, 5, 'Wajib Prodi', 1),
(6, 1, 6, 'Wajib Univ', 2),
(7, 1, 7, 'Wajib Fakultas', 2),
(8, 1, 8, 'Wajib Prodi', 2),
(9, 1, 9, 'Wajib Prodi', 2),
(10, 1, 10, 'Wajib Prodi', 2),
(11, 1, 11, 'Wajib Univ', 3),
(12, 1, 12, 'Wajib Fakultas', 3),
(13, 1, 13, 'Wajib Prodi', 3),
(14, 1, 14, 'Wajib Prodi', 3),
(15, 1, 15, 'Wajib Prodi', 3),
(16, 1, 16, 'Wajib Univ', 4),
(17, 1, 17, 'Wajib Fakultas', 4),
(18, 1, 18, 'Wajib Prodi', 4),
(19, 1, 19, 'Wajib Prodi', 4),
(20, 1, 20, 'Wajib Prodi', 4),
(21, 1, 21, 'Wajib Fakultas', 5),
(22, 1, 22, 'Wajib Prodi', 5),
(23, 1, 23, 'Wajib Prodi', 5),
(24, 1, 24, 'Wajib Prodi', 5),
(25, 1, 25, 'Pilihan Minat', 5),
(26, 1, 26, 'Wajib Prodi', 6),
(27, 1, 27, 'Wajib Prodi', 6),
(28, 1, 28, 'Wajib Prodi', 6),
(29, 1, 29, 'Pilihan Minat', 6),
(30, 1, 30, 'Pilihan Minat', 6),
(31, 1, 31, 'Wajib Fakultas', 7),
(32, 1, 32, 'Wajib Prodi', 7),
(33, 1, 33, 'Pilihan Minat', 7),
(34, 1, 34, 'Pilihan Minat', 7),
(35, 1, 35, 'Pilihan Minat', 7),
(36, 1, 36, 'Wajib Prodi', 8),
(37, 1, 37, 'Pilihan Minat', 8),
(38, 1, 38, 'Pilihan Minat', 8),
(39, 1, 39, 'Pilihan Minat', 8),
(40, 1, 40, 'Pilihan Minat', 8),
(41, 2, 41, 'Wajib Univ', 1),
(42, 2, 42, 'Wajib Fakultas', 1),
(43, 2, 43, 'Wajib Fakultas', 1),
(44, 2, 44, 'Wajib Prodi', 1),
(45, 2, 45, 'Wajib Prodi', 1),
(46, 2, 46, 'Wajib Univ', 2),
(47, 2, 47, 'Wajib Fakultas', 2),
(48, 2, 48, 'Wajib Prodi', 2),
(49, 2, 49, 'Wajib Prodi', 2),
(50, 2, 50, 'Wajib Prodi', 2),
(51, 2, 51, 'Wajib Univ', 3),
(52, 2, 52, 'Wajib Fakultas', 3),
(53, 2, 53, 'Wajib Prodi', 3),
(54, 2, 54, 'Wajib Prodi', 3),
(55, 2, 55, 'Wajib Prodi', 3),
(56, 2, 56, 'Wajib Univ', 4),
(57, 2, 57, 'Wajib Fakultas', 4),
(58, 2, 58, 'Wajib Prodi', 4),
(59, 2, 59, 'Wajib Prodi', 4),
(60, 2, 60, 'Wajib Prodi', 4),
(61, 2, 61, 'Wajib Fakultas', 5),
(62, 2, 62, 'Wajib Prodi', 5),
(63, 2, 63, 'Wajib Prodi', 5),
(64, 2, 64, 'Wajib Prodi', 5),
(65, 2, 65, 'Pilihan Minat', 5),
(66, 2, 66, 'Wajib Prodi', 6),
(67, 2, 67, 'Wajib Prodi', 6),
(68, 2, 68, 'Wajib Prodi', 6),
(69, 2, 69, 'Pilihan Minat', 6),
(70, 2, 70, 'Pilihan Minat', 6),
(71, 2, 71, 'Wajib Fakultas', 7),
(72, 2, 72, 'Wajib Prodi', 7),
(73, 2, 73, 'Pilihan Minat', 7),
(74, 2, 74, 'Pilihan Minat', 7),
(75, 2, 75, 'Pilihan Minat', 7),
(76, 2, 76, 'Wajib Prodi', 8),
(77, 2, 77, 'Pilihan Minat', 8),
(78, 2, 78, 'Pilihan Minat', 8),
(79, 2, 79, 'Pilihan Minat', 8),
(80, 2, 80, 'Pilihan Minat', 8);

-- --------------------------------------------------------

--
-- Struktur dari tabel `prasyarat_mata_kuliah`
--

CREATE TABLE `prasyarat_mata_kuliah` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kode_matkul` varchar(30) NOT NULL,
  `kode_prasyarat_matkul` varchar(30) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `prasyarat_mata_kuliah`
--

INSERT INTO `prasyarat_mata_kuliah` (`id`, `kode_matkul`, `kode_prasyarat_matkul`) VALUES
(1, 'MTK11111', 'MTK11101'),
(2, 'MTK11112', 'MTK11102'),
(3, 'MTK11113', 'MTK11103'),
(4, 'MTK11211', 'MTK11201'),
(5, 'MTK11212', 'MTK11202'),
(6, 'MTK11213', 'MTK11203'),
(7, 'MTK11311', 'MTK11301'),
(8, 'MTK11312', 'MTK11302'),
(9, 'MTK11313', 'MTK11303'),
(10, 'MTK12111', 'MTK12101'),
(11, 'MTK12112', 'MTK12102'),
(12, 'MTK12113', 'MTK12103'),
(13, 'MTK12211', 'MTK12201'),
(14, 'MTK12212', 'MTK12202'),
(15, 'MTK12213', 'MTK12203'),
(16, 'MTK12311', 'MTK12301'),
(17, 'MTK12312', 'MTK12302'),
(18, 'MTK12313', 'MTK12303'),
(19, 'MTK13111', 'MTK13101'),
(20, 'MTK13112', 'MTK13102'),
(21, 'MTK13113', 'MTK13103'),
(22, 'MTK13211', 'MTK13201'),
(23, 'MTK13212', 'MTK13202'),
(24, 'MTK13213', 'MTK13203'),
(25, 'MTK13311', 'MTK13301'),
(26, 'MTK13312', 'MTK13302'),
(27, 'MTK13313', 'MTK13303');

-- --------------------------------------------------------

--
-- Struktur dari tabel `prodi`
--

CREATE TABLE `prodi` (
  `id_univ` int(11) NOT NULL,
  `id_fakultas` int(11) NOT NULL,
  `id_prodi` int(11) NOT NULL,
  `kode_prodi` varchar(30) NOT NULL,
  `nama_prodi` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `prodi`
--

INSERT INTO `prodi` (`id_univ`, `id_fakultas`, `id_prodi`, `kode_prodi`, `nama_prodi`) VALUES
(1, 1, 1, '', 'Program Studi A1X'),
(1, 1, 2, '', 'Program Studi A1Y'),
(1, 1, 3, '', 'Program Studi A1Z'),
(1, 2, 1, '', 'Program Studi A2X'),
(1, 2, 2, '', 'Program Studi A2Y'),
(1, 2, 3, '', 'Program Studi A2Z'),
(1, 3, 1, '', 'Program Studi A3X'),
(1, 3, 2, '', 'Program Studi A3Y'),
(1, 3, 3, '', 'Program Studi A3Z'),
(2, 1, 1, '', 'Program Studi B1X'),
(2, 1, 2, '', 'Program Studi B1Y'),
(2, 1, 3, '', 'Program Studi B1Z'),
(2, 2, 1, '', 'Program Studi B2X'),
(2, 2, 2, '', 'Program Studi B2Y'),
(2, 2, 3, '', 'Program Studi B2Z'),
(2, 3, 1, '', 'Program Studi B3X'),
(2, 3, 2, '', 'Program Studi B3Y'),
(2, 3, 3, '', 'Program Studi B3Z'),
(3, 1, 1, '', 'Program Studi C1X'),
(3, 1, 2, '', 'Program Studi C1Y'),
(3, 1, 3, '', 'Program Studi C1Z'),
(3, 2, 1, '', 'Program Studi C2X'),
(3, 2, 2, '', 'Program Studi C2Y'),
(3, 2, 3, '', 'Program Studi C2Z'),
(3, 3, 1, '', 'Program Studi C3X'),
(3, 3, 2, '', 'Program Studi C3Y'),
(3, 3, 3, '', 'Program Studi C3Z');

-- --------------------------------------------------------

--
-- Struktur dari tabel `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `nama_role` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `roles`
--

INSERT INTO `roles` (`id`, `nama_role`) VALUES
(1, 'ROLE_KAPRODI'),
(2, 'ROLE_SEKRETARIAT'),
(3, 'ROLE_DOSEN'),
(4, 'ROLE_MAHASISWA'),
(5, 'ROLE_STAFF');

-- --------------------------------------------------------

--
-- Struktur dari tabel `universitas`
--

CREATE TABLE `universitas` (
  `id` int(11) NOT NULL,
  `nama_univ` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `universitas`
--

INSERT INTO `universitas` (`id`, `nama_univ`) VALUES
(1, 'Universitas A'),
(2, 'Universitas B'),
(3, 'Universitas C');

-- --------------------------------------------------------

--
-- Struktur dari tabel `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `nama` varchar(150) NOT NULL,
  `id_role` int(11) NOT NULL,
  `id_univ` int(11) NOT NULL,
  `id_fakultas` int(11) NOT NULL,
  `id_prodi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `nama`, `id_role`, `id_univ`, `id_fakultas`, `id_prodi`) VALUES
(1, 'kaprodi1', 'kaprodi', 'Faisal Rizky', 1, 1, 1, 1),
(2, 'sekretariat1', 'sekre', 'Kurniawan Bahari', 2, 1, 1, 1),
(3, 'dosen1', 'dosen', 'Muhammad Panji', 3, 1, 1, 1),
(4, 'mahasiswa1', 'mahasiswa', 'Junior Aji', 4, 1, 1, 1),
(5, 'kaprodi2', 'kaprodi', 'Radhitya Rahman', 1, 2, 1, 1),
(6, 'sekretariat2', 'sekre', 'Ali Bayu', 2, 2, 1, 1),
(7, 'dosen2', 'dosen', 'Putra Utama', 3, 2, 1, 1),
(8, 'mahasiswa2', 'mahasiswa', 'Sanjaya Pratama', 4, 2, 1, 1),
(9, 'kaprodi3', 'kaprodi', 'Nugraha Aditya', 1, 3, 1, 1),
(10, 'sekretariat3', 'sekre', 'Pradana', 2, 3, 1, 1),
(11, 'dosen3', 'dosen', 'Aditya Dana', 3, 3, 1, 1),
(12, 'mahasiswa3', 'mahasiswa', 'Rizky', 4, 3, 1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `fakultas`
--
ALTER TABLE `fakultas`
  ADD PRIMARY KEY (`id_univ`,`id_fakultas`);

--
-- Indexes for table `kurikulum`
--
ALTER TABLE `kurikulum`
  ADD KEY `id_univ` (`id_univ`,`id_fakultas`,`id_prodi`);

--
-- Indexes for table `mata_kuliah`
--
ALTER TABLE `mata_kuliah`
  ADD UNIQUE KEY `kode_matkul` (`kode_matkul`),
  ADD KEY `id_univ` (`id_univ`,`id_fakultas`,`id_prodi`);

--
-- Indexes for table `mata_kuliah_kurikulum`
--
ALTER TABLE `mata_kuliah_kurikulum`
  ADD KEY `id_kurikulum` (`id_kurikulum`),
  ADD KEY `id_matkul` (`id_matkul`);

--
-- Indexes for table `prasyarat_mata_kuliah`
--
ALTER TABLE `prasyarat_mata_kuliah`
  ADD KEY `kode_matkul` (`kode_matkul`),
  ADD KEY `kode_prasyarat_matkul` (`kode_prasyarat_matkul`);

--
-- Indexes for table `prodi`
--
ALTER TABLE `prodi`
  ADD PRIMARY KEY (`id_univ`,`id_fakultas`,`id_prodi`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `universitas`
--
ALTER TABLE `universitas`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD KEY `id_role` (`id_role`),
  ADD KEY `id_univ` (`id_univ`,`id_fakultas`,`id_prodi`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `kurikulum`
--
ALTER TABLE `kurikulum`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `fakultas`
--
ALTER TABLE `fakultas`
  ADD CONSTRAINT `fakultas_ibfk_1` FOREIGN KEY (`id_univ`) REFERENCES `universitas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `kurikulum`
--
ALTER TABLE `kurikulum`
  ADD CONSTRAINT `kurikulum_ibfk_1` FOREIGN KEY (`id_univ`,`id_fakultas`,`id_prodi`) REFERENCES `prodi` (`id_univ`, `id_fakultas`, `id_prodi`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `mata_kuliah`
--
ALTER TABLE `mata_kuliah`
  ADD CONSTRAINT `mata_kuliah_ibfk_1` FOREIGN KEY (`id_univ`,`id_fakultas`,`id_prodi`) REFERENCES `prodi` (`id_univ`, `id_fakultas`, `id_prodi`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `mata_kuliah_kurikulum`
--
ALTER TABLE `mata_kuliah_kurikulum`
  ADD CONSTRAINT `mata_kuliah_kurikulum_ibfk_1` FOREIGN KEY (`id_kurikulum`) REFERENCES `kurikulum` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `mata_kuliah_kurikulum_ibfk_2` FOREIGN KEY (`id_matkul`) REFERENCES `mata_kuliah` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `prasyarat_mata_kuliah`
--
ALTER TABLE `prasyarat_mata_kuliah`
  ADD CONSTRAINT `prasyarat_mata_kuliah_ibfk_1` FOREIGN KEY (`kode_matkul`) REFERENCES `mata_kuliah` (`kode_matkul`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `prasyarat_mata_kuliah_ibfk_2` FOREIGN KEY (`kode_prasyarat_matkul`) REFERENCES `mata_kuliah` (`kode_matkul`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `prodi`
--
ALTER TABLE `prodi`
  ADD CONSTRAINT `prodi_ibfk_1` FOREIGN KEY (`id_univ`,`id_fakultas`) REFERENCES `fakultas` (`id_univ`, `id_fakultas`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`id_role`) REFERENCES `roles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `users_ibfk_2` FOREIGN KEY (`id_univ`,`id_fakultas`,`id_prodi`) REFERENCES `prodi` (`id_univ`, `id_fakultas`, `id_prodi`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
