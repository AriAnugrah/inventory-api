-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 12, 2021 at 04:03 PM
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
-- Database: `springinventory`
--

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `id` int(11) NOT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `name` varchar(50) NOT NULL,
  `price` int(11) NOT NULL,
  `unit_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`id`, `created_date`, `modified_date`, `status`, `name`, `price`, `unit_id`) VALUES
(1, '2001-01-01 00:00:00.000000', '2021-02-05 09:23:34.000000', b'1', 'Air Mineral', 5000, 2),
(2, '2001-01-01 00:00:00.000000', '2021-02-05 06:43:00.000000', b'1', 'Beras', 600, 3),
(3, '2001-01-01 00:00:00.000000', NULL, b'1', 'Gula Pasir', 10000, 1),
(4, '2001-01-01 00:00:00.000000', NULL, b'1', 'Gula Merah', 5000, 1),
(5, '2001-01-01 00:00:00.000000', '2021-02-04 07:26:22.000000', b'1', 'Garam Halus', 3000, 1),
(6, '2001-01-01 00:00:00.000000', '2021-02-04 10:11:02.000000', b'1', 'Tepung Terigu', 6000, 1),
(7, '2001-01-01 00:00:00.000000', '2021-02-04 07:51:13.000000', b'1', 'Bawang Merah', 12000, 1),
(8, '2001-01-01 00:00:00.000000', '2021-02-04 09:53:26.000000', b'1', 'Bawang Putih', 4000, 1),
(9, '2001-01-01 00:00:00.000000', '2021-02-04 08:30:58.000000', b'1', 'Cabai Merah Kering', 5000, 1),
(10, '2021-02-06 02:01:21.000000', NULL, b'1', 'Bayam', 3000, 7),
(11, '2021-02-06 02:02:06.000000', NULL, b'1', 'Kacang Panjang', 4500, 4),
(12, '2021-02-06 02:02:26.000000', NULL, b'1', 'Timun', 4000, 3),
(13, '2021-02-06 02:02:44.000000', NULL, b'1', 'Tomat', 3000, 3),
(14, '2021-02-06 02:03:23.000000', NULL, b'1', 'Sawi', 4000, 4),
(15, '2021-02-06 02:04:04.000000', NULL, b'1', 'Jagung', 3000, 3),
(16, '2021-02-06 02:04:35.000000', NULL, b'1', 'Lobak', 4000, 3),
(17, '2021-02-06 02:05:19.000000', NULL, b'1', 'Jambu', 3000, 3),
(18, '2021-02-06 02:05:35.000000', NULL, b'1', 'Jeruk', 45000, 1),
(19, '2021-02-06 02:06:06.000000', NULL, b'1', 'Melon', 20000, 3),
(20, '2021-02-06 02:06:29.000000', NULL, b'1', 'Sawo', 40000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE `stock` (
  `id` int(11) NOT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `quantity` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `total_price` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`id`, `created_date`, `modified_date`, `status`, `quantity`, `item_id`, `total_price`) VALUES
(1, '2020-01-01 00:00:00.000000', '2021-02-04 16:02:55.000000', b'1', 2, 1, NULL),
(2, '2020-01-01 00:00:00.000000', '2021-01-14 07:36:40.000000', b'1', 1, 1, NULL),
(3, '2020-01-01 00:00:00.000000', NULL, b'1', 500, 3, NULL),
(4, '2020-01-01 00:00:00.000000', NULL, b'1', 100, 4, NULL),
(5, '2020-01-01 00:00:00.000000', NULL, b'1', 500, 5, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `unit`
--

CREATE TABLE `unit` (
  `id` int(11) NOT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `code` varchar(5) NOT NULL,
  `description` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `unit`
--

INSERT INTO `unit` (`id`, `created_date`, `modified_date`, `status`, `code`, `description`) VALUES
(1, '2001-01-01 00:00:00.000000', '2021-02-05 02:36:21.000000', b'1', 'kg', 'Kilogram'),
(2, '2001-01-01 00:00:00.000000', '2021-02-05 02:36:28.000000', b'1', 'L', 'Liter'),
(3, '2021-02-01 03:01:25.000000', '2021-02-05 02:37:07.000000', b'1', 'Pcs', 'Pieces'),
(4, '2021-02-01 03:07:10.000000', '2021-02-01 03:30:56.000000', b'1', 'G', 'Gram'),
(5, '2021-02-02 15:45:11.000000', '2021-02-02 15:47:03.000000', b'1', 'M', 'Meter'),
(6, '2021-02-04 02:40:04.000000', NULL, b'1', 'Pck', 'Pack'),
(7, '2021-02-06 02:00:14.000000', '2021-02-06 03:38:21.000000', b'1', 'cob', 'coba'),
(27, '2021-02-06 04:05:26.000000', NULL, b'1', 'coba', 'coba');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdslletxhla0nehtlnmh63m2sj` (`unit_id`);

--
-- Indexes for table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKf3gqo6e3aged60kygtbmtsd8s` (`item_id`);

--
-- Indexes for table `unit`
--
ALTER TABLE `unit`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT for table `stock`
--
ALTER TABLE `stock`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `unit`
--
ALTER TABLE `unit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `item`
--
ALTER TABLE `item`
  ADD CONSTRAINT `FKdslletxhla0nehtlnmh63m2sj` FOREIGN KEY (`unit_id`) REFERENCES `unit` (`id`);

--
-- Constraints for table `stock`
--
ALTER TABLE `stock`
  ADD CONSTRAINT `FKf3gqo6e3aged60kygtbmtsd8s` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
