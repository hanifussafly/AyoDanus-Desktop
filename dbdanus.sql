-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 29, 2017 at 06:17 AM
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
-- Table structure for table `danusan`
--

CREATE TABLE `danusan` (
  `id` int(11) NOT NULL,
  `JenisDanus` varchar(100) NOT NULL,
  `DanusMingguan` int(10) NOT NULL,
  `HariDanus` varchar(255) NOT NULL,
  `JamReminder` time NOT NULL,
  `catatan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `danusan`
--

INSERT INTO `danusan` (`id`, `JenisDanus`, `DanusMingguan`, `HariDanus`, `JamReminder`, `catatan`) VALUES
(1, 'JCo', 2, 'Kamis,Jumat', '07:00:00', 'gapapa'),
(2, 'Panganan Liyane', 3, 'Kamis,Senin,Selasa', '07:00:00', 'gapapa'),
(3, 'Kotak Putih', 1, 'Kamis', '07:00:00', 'pler');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `danusan`
--
ALTER TABLE `danusan`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `danusan`
--
ALTER TABLE `danusan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
