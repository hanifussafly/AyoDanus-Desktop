-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 08, 2017 at 02:54 PM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbdanus`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dana`
--

CREATE TABLE `dana` (
  `id` int(10) NOT NULL,
  `Nama` varchar(100) NOT NULL,
  `TargetDanus` int(11) NOT NULL,
  `HargaperDanus` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `danusan`
--

CREATE TABLE `danusan` (
  `id` int(11) NOT NULL,
  `Nama` varchar(100) NOT NULL,
  `Divisi` varchar(20) NOT NULL,
  `No. Telepon` varchar(13) NOT NULL,
  `JenisDanus` varchar(100) NOT NULL,
  `DanusMingguan` int(10) NOT NULL,
  `HariDanus` varchar(255) NOT NULL,
  `JamReminder` time NOT NULL,
  `catatan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `danusan`
--

INSERT INTO `danusan` (`id`, `Nama`, `Divisi`, `No. Telepon`, `JenisDanus`, `DanusMingguan`, `HariDanus`, `JamReminder`, `catatan`) VALUES
(12, '', '', '', 'JCo', 1, 'Sabtu', '22:31:01', 'kudu moni'),
(13, '', '', '', 'Panganan Liyane', 1, 'Selasa', '22:33:01', 'hehehehehhe'),
(15, '', '', '', 'Kotak Putih', 1, 'Senin', '11:45:08', 'hhhhh'),
(16, '', '', '', 'JCo', 2, 'Senin,Kamis', '07:08:07', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dana`
--
ALTER TABLE `dana`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `Nama` (`Nama`);

--
-- Indexes for table `danusan`
--
ALTER TABLE `danusan`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dana`
--
ALTER TABLE `dana`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `danusan`
--
ALTER TABLE `danusan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
