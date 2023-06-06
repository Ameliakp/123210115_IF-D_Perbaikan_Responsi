-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 06, 2023 at 12:44 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `al_maul`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` varchar(10) NOT NULL DEFAULT 'renter'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`username`, `password`, `role`) VALUES
('admin', 'admin', 'admin'),
('user1', 'user1', 'renter');

-- --------------------------------------------------------

--
-- Table structure for table `renter`
--

CREATE TABLE `renter` (
  `name` varchar(50) NOT NULL,
  `id` varchar(30) NOT NULL,
  `contact` varchar(50) NOT NULL,
  `duration` int(11) NOT NULL,
  `bill` int(11) DEFAULT NULL,
  `status` varchar(10) NOT NULL DEFAULT 'notPaid',
  `room` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `renter`
--

INSERT INTO `renter` (`name`, `id`, `contact`, `duration`, `bill`, `status`, `room`) VALUES
('testes', '123200139', 'tes@gmail.com', 10, 200000, 'Paid', 'A1'),
('alex', 'cob@gmail.com', '5555', 555, 450000, 'notPaid', 'C1'),
('tes', 'coba@gmail.com', '44', 56, 400000, 'notPaid', 'C2'),
('gustian', 'gustian@gmail.com', '555', 6, 250000, 'Paid', 'B2'),
('islakha', 'islakha', '555', 6, 250000, 'Paid', 'B2'),
('kiky', 'kiky@gmail.com', '555', 6, 250000, 'Paid', 'B2');

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

CREATE TABLE `rooms` (
  `name` varchar(5) NOT NULL,
  `size` varchar(5) NOT NULL,
  `price` int(11) NOT NULL,
  `status` varchar(50) NOT NULL DEFAULT 'empty'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rooms`
--

INSERT INTO `rooms` (`name`, `size`, `price`, `status`) VALUES
('A1', '3x4', 200000, 'empty'),
('A2', '3x4', 200000, 'Post Malone'),
('B1', '4x4', 230000, 'empty'),
('B2', '4x4', 250000, 'empty'),
('C1', '5x5', 450000, 'alex'),
('C2', '5x4', 400000, 'tes');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accounts`
--
ALTER TABLE `accounts`
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `renter`
--
ALTER TABLE `renter`
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `rooms`
--
ALTER TABLE `rooms`
  ADD UNIQUE KEY `name` (`name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
