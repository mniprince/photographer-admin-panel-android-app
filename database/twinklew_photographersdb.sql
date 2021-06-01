-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 02, 2021 at 12:22 AM
-- Server version: 10.3.29-MariaDB
-- PHP Version: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `twinklew_photographersdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `admintbl`
--

CREATE TABLE `admintbl` (
  `id` int(11) NOT NULL,
  `fname` varchar(255) NOT NULL,
  `lname` varchar(255) NOT NULL,
  `email_addres` varchar(255) NOT NULL,
  `user_pass` varchar(255) NOT NULL,
  `signupDate` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admintbl`
--

INSERT INTO `admintbl` (`id`, `fname`, `lname`, `email_addres`, `user_pass`, `signupDate`) VALUES
(1, 'Sukanta ', 'Kumar', 'admin@gmail.com', 'admin', '2021-03-09 21:11:08');

-- --------------------------------------------------------

--
-- Table structure for table `bannertbl`
--

CREATE TABLE `bannertbl` (
  `id` int(100) NOT NULL,
  `bannerimage` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bannertbl`
--

INSERT INTO `bannertbl` (`id`, `bannerimage`) VALUES
(2, 'bannerphoto/scroll.jpg'),
(3, 'bannerphoto/scrolll.jpg'),
(4, 'bannerphoto/scrollll.jpg'),
(5, 'bannerphoto/scrolllll.jpg'),
(6, 'bannerphoto/scrolllllll.jpg'),
(7, 'bannerphoto/scrollllll.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `categorytbl`
--

CREATE TABLE `categorytbl` (
  `id` int(150) NOT NULL,
  `cimage` varchar(150) NOT NULL,
  `cname` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `categorytbl`
--

INSERT INTO `categorytbl` (`id`, `cimage`, `cname`) VALUES
(4, 'categoryphoto/wedding_photo.jpg', 'Wedding Photography '),
(5, 'categoryphoto/event-7jpg.jpg', 'Event Photography'),
(6, 'categoryphoto/portraits14__700.jpg', 'Portrait Photography'),
(7, 'categoryphoto/JbiIEE1miWw.png', 'Product Photography'),
(8, 'categoryphoto/fineart.jpg', 'Fine Art Photography'),
(9, 'categoryphoto/High Fashion Outside.jpg', 'Fashion Photography '),
(10, 'categoryphoto/Architectural Photography.jpg', 'Architectural Photography'),
(11, 'categoryphoto/Sports Photography.jpg', 'Sports Photography '),
(12, 'categoryphoto/1_fSAAKd4kayiWp0JSeUBAYw.jpeg', 'Corporate Photography'),
(13, 'categoryphoto/wildlifeeeee.jpg', 'Wild Photography'),
(14, 'categoryphoto/travellllll.jpg', 'Travel Photography');

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `id` int(11) NOT NULL,
  `course_title` varchar(100) NOT NULL,
  `total_class` varchar(100) NOT NULL,
  `fee` text NOT NULL,
  `user_id` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`id`, `course_title`, `total_class`, `fee`, `user_id`) VALUES
(21, 'Foundation Course', '20', '10000tk', 'irg6nOu7rmME33KkgJ0oEuI5pzZ2'),
(22, 'Foundation Course', '20', '10000tk', 'irg6nOu7rmME33KkgJ0oEuI5pzZ2'),
(23, 'Professional Photography Course', '25', '18000tk', 'ZS9buLwCa0ZKkIyVNoj4yjTeoMG2'),
(24, 'Professional Photography Course', '25', '18000tk', 'ZS9buLwCa0ZKkIyVNoj4yjTeoMG2'),
(25, 'Foundation Course', '20', '10000tk', 'ZS9buLwCa0ZKkIyVNoj4yjTeoMG2'),
(26, 'Foundation Course', '20', '10000tk', 'ZS9buLwCa0ZKkIyVNoj4yjTeoMG2'),
(28, 'Basic Photography Course', '15', '5500tk', 'ZS9buLwCa0ZKkIyVNoj4yjTeoMG2'),
(29, 'Foundation Course', '20', '10000tk', '050XWhqgGsTBAhJaxluNUyw2F3O2'),
(30, 'Professional Photography Course', '25', '18000tk', 'ZS9buLwCa0ZKkIyVNoj4yjTeoMG2'),
(31, 'Basic Photography Course', '15', '5500tk', '050XWhqgGsTBAhJaxluNUyw2F3O2');

-- --------------------------------------------------------

--
-- Table structure for table `favtbl`
--

CREATE TABLE `favtbl` (
  `id` int(100) NOT NULL,
  `user_id` text NOT NULL,
  `pg_id` text NOT NULL,
  `lfav` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `favtbl`
--

INSERT INTO `favtbl` (`id`, `user_id`, `pg_id`, `lfav`) VALUES
(28, 'irg6nOu7rmME33KkgJ0oEuI5pzZ2', '1', 1),
(29, 'irg6nOu7rmME33KkgJ0oEuI5pzZ2', '8', 1),
(30, 'irg6nOu7rmME33KkgJ0oEuI5pzZ2', '8', 1),
(31, 'irg6nOu7rmME33KkgJ0oEuI5pzZ2', '8', 1),
(32, 'irg6nOu7rmME33KkgJ0oEuI5pzZ2', '3', 1),
(33, 'irg6nOu7rmME33KkgJ0oEuI5pzZ2', '3', 1),
(34, 'irg6nOu7rmME33KkgJ0oEuI5pzZ2', '3', 1),
(35, 'irg6nOu7rmME33KkgJ0oEuI5pzZ2', '3', 1),
(36, 'irg6nOu7rmME33KkgJ0oEuI5pzZ2', '3', 1),
(37, 'irg6nOu7rmME33KkgJ0oEuI5pzZ2', '8', 1),
(38, 'irg6nOu7rmME33KkgJ0oEuI5pzZ2', '8', 1),
(39, 'irg6nOu7rmME33KkgJ0oEuI5pzZ2', '1', 1),
(40, 'irg6nOu7rmME33KkgJ0oEuI5pzZ2', '1', 1),
(41, 'irg6nOu7rmME33KkgJ0oEuI5pzZ2', '3', 1),
(42, 'irg6nOu7rmME33KkgJ0oEuI5pzZ2', '1', 1),
(43, 'irg6nOu7rmME33KkgJ0oEuI5pzZ2', '3', 1),
(44, 'irg6nOu7rmME33KkgJ0oEuI5pzZ2', '3', 1),
(45, 'irg6nOu7rmME33KkgJ0oEuI5pzZ2', '1', 1),
(46, 'irg6nOu7rmME33KkgJ0oEuI5pzZ2', '1', 1),
(47, 'irg6nOu7rmME33KkgJ0oEuI5pzZ2', '5', 1),
(48, 'irg6nOu7rmME33KkgJ0oEuI5pzZ2', '8', 1),
(49, 'irg6nOu7rmME33KkgJ0oEuI5pzZ2', '5', 1),
(50, 'irg6nOu7rmME33KkgJ0oEuI5pzZ2', '6', 1),
(51, 'irg6nOu7rmME33KkgJ0oEuI5pzZ2', '5', 1),
(52, 'irg6nOu7rmME33KkgJ0oEuI5pzZ2', '5', 1),
(53, 'ZS9buLwCa0ZKkIyVNoj4yjTeoMG2', '1', 1);

-- --------------------------------------------------------

--
-- Table structure for table `hiretbl`
--

CREATE TABLE `hiretbl` (
  `id` int(150) NOT NULL,
  `hname` text NOT NULL,
  `hcontact` text NOT NULL,
  `hlocation` text NOT NULL,
  `hetype` text NOT NULL,
  `hmsg` text NOT NULL,
  `userid` text NOT NULL,
  `hdate` text NOT NULL,
  `pgname` varchar(150) NOT NULL,
  `pgmail` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hiretbl`
--

INSERT INTO `hiretbl` (`id`, `hname`, `hcontact`, `hlocation`, `hetype`, `hmsg`, `userid`, `hdate`, `pgname`, `pgmail`) VALUES
(2, 'Prince', '01714368394', 'Dhaka', 'wedding', 'Contact with Details', 'irg6nOu7rmME33KkgJ0oEuI5pzZ2', '25/3/2021', 'Skukanto', 'sk@gmail.com'),
(3, 'Sadman', '01712056959', 'Sylhet', 'wedding', 'Contact urgent', 'irg6nOu7rmME33KkgJ0oEuI5pzZ2', '28/3/2021', 'Nazrul', 'mniprinceapp@gmail.com'),
(11, 'Dahir Hasnat', '01854646646', 'Ashulia', 'Bootcamp', 'Please let me know asap.', 'ZS9buLwCa0ZKkIyVNoj4yjTeoMG2', '31/4/2021', 'Mostafa Amir Emon', 'swapnahazara17@gmail.com'),
(12, 'Fardin Rupom', '07125848864', 'Mirpur 14', 'Corporate', 'When you are confirmed give me a call.', 'ZS9buLwCa0ZKkIyVNoj4yjTeoMG2', '31/4/2021', 'Mostafa Amir Emon', 'swapnahazara17@gmail.com'),
(13, 'Rupom islam', '01863856469', 'Pabna', 'Wedding', '', '050XWhqgGsTBAhJaxluNUyw2F3O2', '31/4/2021', 'Sk Sukanto', 'sk@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `pcontent`
--

CREATE TABLE `pcontent` (
  `id` int(150) NOT NULL,
  `pg_id` text NOT NULL,
  `photourl` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pcontent`
--

INSERT INTO `pcontent` (`id`, `pg_id`, `photourl`) VALUES
(4, '5', 'pcphoto/IMG_3917.jpg'),
(5, '5', 'pcphoto/IMG_4365.jpg'),
(6, '5', 'pcphoto/IMG_2741.jpg'),
(7, '5', 'pcphoto/IMG_5054_last.jpg'),
(8, '5', 'pcphoto/IMG_7786.jpg'),
(9, '5', 'pcphoto/IMG_7627.jpg'),
(10, '1', 'pcphoto/IMG_0750.jpg'),
(11, '1', 'pcphoto/IMG_4963_3.jpg'),
(12, '1', 'pcphoto/IMG_8246.jpg'),
(13, '1', 'pcphoto/IMG_1393.jpg'),
(14, '3', 'pcphoto/IMG_7897.jpg'),
(15, '3', 'pcphoto/IMG_5547.jpg'),
(16, '3', 'pcphoto/IMG_5681.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `photobuytbl`
--

CREATE TABLE `photobuytbl` (
  `id` int(150) NOT NULL,
  `photoid` varchar(100) NOT NULL,
  `pgid` varchar(100) NOT NULL,
  `photourl` varchar(150) NOT NULL,
  `price` text NOT NULL,
  `userid` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `photobuytbl`
--

INSERT INTO `photobuytbl` (`id`, `photoid`, `pgid`, `photourl`, `price`, `userid`) VALUES
(4, '6', '1', 'eventphoto/IMG_9770.jpg', '10000', 'irg6nOu7rmME33KkgJ0oEuI5pzZ2'),
(5, '5', '1', 'eventphoto/IMG_9948.jpg', '7000', 'irg6nOu7rmME33KkgJ0oEuI5pzZ2'),
(7, '7', '1', 'eventphoto/IMG_54877.jpg', '3000', 'irg6nOu7rmME33KkgJ0oEuI5pzZ2'),
(10, '4', '1', 'eventphoto/travellll.jpg', '6000', 'irg6nOu7rmME33KkgJ0oEuI5pzZ2'),
(15, '26', '5', 'eventphoto/wildlifeeeee.jpg', '2800', 'irg6nOu7rmME33KkgJ0oEuI5pzZ2'),
(16, '20', '5', 'eventphoto/travellllll.jpg', '3300', 'ZS9buLwCa0ZKkIyVNoj4yjTeoMG2'),
(17, '22', '5', 'eventphoto/travelllllllll.jpg', '4100', 'ZS9buLwCa0ZKkIyVNoj4yjTeoMG2'),
(18, '19', '5', 'eventphoto/travelllll.jpg', '2200', 'ZS9buLwCa0ZKkIyVNoj4yjTeoMG2'),
(19, '7', '1', 'eventphoto/IMG_54877.jpg', '3000', 'irg6nOu7rmME33KkgJ0oEuI5pzZ2'),
(20, '5', '1', 'eventphoto/IMG_9948.jpg', '7000', 'irg6nOu7rmME33KkgJ0oEuI5pzZ2'),
(21, '15', '5', 'eventphoto/travell.jpg', '3000', 'ZS9buLwCa0ZKkIyVNoj4yjTeoMG2'),
(22, '22', '5', 'eventphoto/travelllllllll.jpg', '4100', 'ZS9buLwCa0ZKkIyVNoj4yjTeoMG2'),
(23, '6', '1', 'eventphoto/IMG_9770.jpg', '10000', 'ZS9buLwCa0ZKkIyVNoj4yjTeoMG2'),
(24, '18', '5', 'eventphoto/travellll.jpg', '1900', 'ZS9buLwCa0ZKkIyVNoj4yjTeoMG2'),
(25, '19', '5', 'eventphoto/travelllll.jpg', '2200', 'ZS9buLwCa0ZKkIyVNoj4yjTeoMG2'),
(26, '22', '5', 'eventphoto/travelllllllll.jpg', '4100', 'ZS9buLwCa0ZKkIyVNoj4yjTeoMG2'),
(27, '19', '5', 'eventphoto/travelllll.jpg', '2200', '050XWhqgGsTBAhJaxluNUyw2F3O2'),
(28, '18', '5', 'eventphoto/travellll.jpg', '1900', '050XWhqgGsTBAhJaxluNUyw2F3O2'),
(29, '17', '5', 'eventphoto/travelll.jpg', '1000', '050XWhqgGsTBAhJaxluNUyw2F3O2');

-- --------------------------------------------------------

--
-- Table structure for table `photographertbl`
--

CREATE TABLE `photographertbl` (
  `pg_id` int(11) NOT NULL,
  `pg_name` text NOT NULL,
  `pg_email` varchar(100) NOT NULL,
  `pg_location` varchar(100) NOT NULL,
  `pg_image` varchar(150) NOT NULL,
  `pg_like` varchar(150) NOT NULL,
  `category` varchar(150) NOT NULL,
  `pg_password` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `photographertbl`
--

INSERT INTO `photographertbl` (`pg_id`, `pg_name`, `pg_email`, `pg_location`, `pg_image`, `pg_like`, `category`, `pg_password`) VALUES
(1, 'Nazrul Islam', 'mniprinceapp@gmail.com', 'Dhaka', 'pgphoto/nazrul.jpg', '5593', 'Event Photographer', 'aaa'),
(3, 'Mostafa Amir Emon', 'swapnahazara17@gmail.com', 'Dhaka', 'pgphoto/emon.jpg', '190', 'Corporate Photographer\r\n', '111'),
(5, 'Sk Sukanto', 'sk@gmail.com', 'Dhaka', 'pgphoto/sukanta.jpg', '810', 'Documentary Photographer', 'sksksk');

-- --------------------------------------------------------

--
-- Table structure for table `photostbl`
--

CREATE TABLE `photostbl` (
  `id` int(100) NOT NULL,
  `pg_id` int(100) NOT NULL,
  `category` varchar(100) NOT NULL,
  `photourl` varchar(200) NOT NULL,
  `price` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `photostbl`
--

INSERT INTO `photostbl` (`id`, `pg_id`, `category`, `photourl`, `price`) VALUES
(4, 1, 'Product Photography', 'eventphoto/travellll.jpg', '6000'),
(5, 1, 'Wedding Photography ', 'eventphoto/IMG_9948.jpg', '7000'),
(6, 1, 'Wedding Photography ', 'eventphoto/IMG_9770.jpg', '10000'),
(7, 1, 'Wedding Photography ', 'eventphoto/IMG_54877.jpg', '3000'),
(8, 1, 'Corporate Photography', 'eventphoto/IMG_5176.jpg', '8000'),
(9, 1, 'Corporate Photography', 'eventphoto/IMG_5534.jpg', '6000'),
(10, 1, 'Corporate Photography', 'eventphoto/IMG_5547.jpg', '1500'),
(11, 1, 'Corporate Photography', 'eventphoto/IMG_5681.jpg', '2600'),
(12, 1, 'Corporate Photography', 'eventphoto/IMG_7592.jpg', '3400'),
(13, 3, 'Fine Art Photography', 'eventphoto/travelllllllll.jpg', '4500'),
(14, 3, 'Fine Art Photography', 'eventphoto/zhuyo.jpg', '5000'),
(15, 5, 'Travel Photography', 'eventphoto/travell.jpg', '3000'),
(16, 5, 'Travel Photography', 'eventphoto/travelllllll.jpg', '2000'),
(17, 5, 'Travel Photography', 'eventphoto/travelll.jpg', '1000'),
(18, 5, 'Travel Photography', 'eventphoto/travellll.jpg', '1900'),
(19, 5, 'Travel Photography', 'eventphoto/travelllll.jpg', '2200'),
(20, 5, 'Travel Photography', 'eventphoto/travellllll.jpg', '3300'),
(22, 5, 'Travel Photography', 'eventphoto/travelllllllll.jpg', '4100'),
(23, 5, 'Wild Photography', 'eventphoto/wildlife.jpg', '5100'),
(24, 5, 'Wild Photography', 'eventphoto/wildlifee.jpg', '6100'),
(25, 5, 'Wild Photography', 'eventphoto/wildlifeee.jpg', '3700'),
(26, 5, 'Wild Photography', 'eventphoto/wildlifeeeee.jpg', '2800'),
(27, 5, 'Wild Photography', 'eventphoto/wildlifeeeeeeee.jpg', '6300'),
(28, 5, 'Wild Photography', 'eventphoto/wildlifeeeeeeeee.jpg', '9000');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admintbl`
--
ALTER TABLE `admintbl`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bannertbl`
--
ALTER TABLE `bannertbl`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `categorytbl`
--
ALTER TABLE `categorytbl`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `favtbl`
--
ALTER TABLE `favtbl`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hiretbl`
--
ALTER TABLE `hiretbl`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pcontent`
--
ALTER TABLE `pcontent`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `photobuytbl`
--
ALTER TABLE `photobuytbl`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `photographertbl`
--
ALTER TABLE `photographertbl`
  ADD PRIMARY KEY (`pg_id`);

--
-- Indexes for table `photostbl`
--
ALTER TABLE `photostbl`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admintbl`
--
ALTER TABLE `admintbl`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `bannertbl`
--
ALTER TABLE `bannertbl`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `categorytbl`
--
ALTER TABLE `categorytbl`
  MODIFY `id` int(150) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `favtbl`
--
ALTER TABLE `favtbl`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT for table `hiretbl`
--
ALTER TABLE `hiretbl`
  MODIFY `id` int(150) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `pcontent`
--
ALTER TABLE `pcontent`
  MODIFY `id` int(150) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `photobuytbl`
--
ALTER TABLE `photobuytbl`
  MODIFY `id` int(150) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `photographertbl`
--
ALTER TABLE `photographertbl`
  MODIFY `pg_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `photostbl`
--
ALTER TABLE `photostbl`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
