-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 06, 2022 at 05:31 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tubespbobaru`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `No_IdentitasA` varchar(10) NOT NULL,
  `Nama` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `ID_Customer` varchar(10) NOT NULL,
  `Kode_Tiang` varchar(10) NOT NULL,
  `Nama` varchar(50) NOT NULL,
  `Alamat` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `No_Identitas` varchar(10) NOT NULL,
  `Nama` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `pekerjalapangan`
--

CREATE TABLE `pekerjalapangan` (
  `No_IdentitasPL` varchar(10) NOT NULL,
  `Nama` varchar(50) NOT NULL,
  `Deskripsi_Tugas` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `penjadwalan`
--

CREATE TABLE `penjadwalan` (
  `No_Penjadwalan` varchar(10) NOT NULL,
  `No_IdentitasPL` varchar(10) NOT NULL,
  `IDReceiveReport` varchar(10) NOT NULL,
  `Tanggal_Maintenance` date NOT NULL,
  `IDLaporan` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `receivereport`
--

CREATE TABLE `receivereport` (
  `IDReceiveReport` varchar(10) NOT NULL,
  `ID_Customer` varchar(10) NOT NULL,
  `isiLaporan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `returnreport`
--

CREATE TABLE `returnreport` (
  `IDLaporan` int(11) NOT NULL,
  `Status_Laporan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tiang`
--

CREATE TABLE `tiang` (
  `Kode_Tiang` varchar(10) NOT NULL,
  `Alamat_Tiang` varchar(50) NOT NULL,
  `Nama_ISP` varchar(50) NOT NULL,
  `Status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`No_IdentitasA`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`ID_Customer`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`No_Identitas`);

--
-- Indexes for table `pekerjalapangan`
--
ALTER TABLE `pekerjalapangan`
  ADD PRIMARY KEY (`No_IdentitasPL`);

--
-- Indexes for table `penjadwalan`
--
ALTER TABLE `penjadwalan`
  ADD PRIMARY KEY (`No_Penjadwalan`);

--
-- Indexes for table `receivereport`
--
ALTER TABLE `receivereport`
  ADD PRIMARY KEY (`IDReceiveReport`);

--
-- Indexes for table `returnreport`
--
ALTER TABLE `returnreport`
  ADD PRIMARY KEY (`IDLaporan`);

--
-- Indexes for table `tiang`
--
ALTER TABLE `tiang`
  ADD PRIMARY KEY (`Kode_Tiang`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
