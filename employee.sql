-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 28, 2024 at 07:11 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `employee`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee_info`
--

CREATE TABLE `employee_info` (
  `id` int(10) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `age` int(2) DEFAULT NULL,
  `desiganation` varchar(30) NOT NULL,
  `department` varchar(30) NOT NULL,
  `salary` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee_info`
--

INSERT INTO `employee_info` (`id`, `name`, `age`, `desiganation`, `department`, `salary`) VALUES
(1, 'John Doe', 30, 'Software Engineer', 'Engineering', 60000),
(2, 'Jane Smith', 35, 'Project Manager', 'Management', 75000),
(3, 'Michael Johnson', 28, 'Data Analyst', 'Analytics', 55000),
(4, 'Emily Brown', 32, 'HR Manager', 'Human Resources', 70000),
(5, 'Chris Wilson', 40, 'Sales Executive', 'Sales', 65000),
(6, 'Amy Taylor', 27, 'Marketing Specialist', 'Marketing', 60000),
(7, 'David Martinez', 33, 'Financial Analyst', 'Finance', 70000),
(8, 'Sarah Clark', 29, 'Operations Manager', 'Operations', 75000),
(9, 'Ryan Lee', 31, 'Product Manager', 'Product Management', 80000),
(10, 'Lisa Adams', 34, 'Quality Assurance Engineer', 'Quality Assurance', 60000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employee_info`
--
ALTER TABLE `employee_info`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
