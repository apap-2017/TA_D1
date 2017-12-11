-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 11, 2017 at 05:57 PM
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
-- Table structure for table `prasyarat_mata_kuliah`
--

CREATE TABLE `prasyarat_mata_kuliah` (
  `id` int(11) NOT NULL,
  `kode_matkul` varchar(30) NOT NULL,
  `kode_prasyarat_matkul` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prasyarat_mata_kuliah`
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

--
-- Indexes for dumped tables
--

--
-- Indexes for table `prasyarat_mata_kuliah`
--
ALTER TABLE `prasyarat_mata_kuliah`
  ADD PRIMARY KEY (`id`),
  ADD KEY `kode_matkul` (`kode_matkul`),
  ADD KEY `kode_prasyarat_matkul` (`kode_prasyarat_matkul`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `prasyarat_mata_kuliah`
--
ALTER TABLE `prasyarat_mata_kuliah`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `prasyarat_mata_kuliah`
--
ALTER TABLE `prasyarat_mata_kuliah`
  ADD CONSTRAINT `prasyarat_mata_kuliah_ibfk_1` FOREIGN KEY (`kode_matkul`) REFERENCES `mata_kuliah` (`kode_matkul`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `prasyarat_mata_kuliah_ibfk_2` FOREIGN KEY (`kode_prasyarat_matkul`) REFERENCES `mata_kuliah` (`kode_matkul`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
