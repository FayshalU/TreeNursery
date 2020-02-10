-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 02, 2018 at 01:30 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `nursery`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `UserId` varchar(20) NOT NULL,
  `Balance` double(8,2) NOT NULL DEFAULT '0.00',
  `Name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`UserId`, `Balance`, `Name`) VALUES
('ahasanul', 13.00, 'qsd'),
('bari', 0.00, 'shariful'),
('hamza', 0.00, 'ahasanul'),
('Limon', 0.00, 'faysal ahmed');

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `UserID` varchar(20) NOT NULL,
  `TreeID` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`UserID`, `TreeID`) VALUES
('user2', 'tree6');

-- --------------------------------------------------------

--
-- Table structure for table `dealer`
--

CREATE TABLE `dealer` (
  `UserId` varchar(20) NOT NULL,
  `DealerID` varchar(20) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Company` varchar(50) NOT NULL,
  `Address` varchar(200) NOT NULL,
  `City` varchar(20) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Mobile` int(20) NOT NULL,
  `Balance` double(8,2) NOT NULL,
  `Nationality` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dealer`
--

INSERT INTO `dealer` (`UserId`, `DealerID`, `Name`, `Company`, `Address`, `City`, `Email`, `Mobile`, `Balance`, `Nationality`) VALUES
('user11', '5853', 'asdfgh', 'llllllll', 'dhtyrtuyui', 'Borishal', 'scdfbg@gmail.com', 234365776, 100.00, 'gfrtfvcdf'),
('user12', '48520', 'hhhhhhhhh', 'bbbbbbb', 'jjjjjjjjj', 'Noakhali', 'vsdv@gmail.com', 63548, 200.00, 'gfhgjui'),
('user13', '49367', 'wwwwww', 'yyyyyyyy', 'eeeeee', 'Comilla', 'rrrr@gmai.com', 23333333, 300.00, 'ttttttt'),
('user14', '19940', 'iiiiiiiii', 'pwpwpwpw', 'oooooo', 'Rajshahi', 'ppppp@gmail.com', 222222, 1150.00, 'pqpqpqp'),
('user15', '75635', 'jljljlj', 'uuuu', 'hlhlhlhl', 'Dhaka', 'glglgl@gmail.com', 36363636, 900.00, 'tytytytyty'),
('user16', '1111', 'AD', 'Adc', 'Gazipur', 'Gazipur', 'as@wa', 42343, 1600.00, 'Bangladeshi');

-- --------------------------------------------------------

--
-- Table structure for table `garden`
--

CREATE TABLE `garden` (
  `Area` double(10,2) NOT NULL,
  `Descrip` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `UserId` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `UserType` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`UserId`, `Password`, `UserType`) VALUES
('ahasanul', 'qdc', 'admin'),
('bari', '123', 'admin'),
('hamza', '123', 'admin'),
('Limon', '123', 'admin'),
('user1', '123', 'user'),
('user11', '123', 'dealer'),
('user12', '123', 'dealer'),
('user13', '123', 'dealer'),
('user14', '123', 'dealer'),
('user15', '123', 'dealer'),
('user16', '123', 'dealer'),
('user2', '123', 'user'),
('user3', '123', 'user'),
('user4', '123', 'user'),
('user5', '123', 'user');

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `OrderID` varchar(20) NOT NULL,
  `DealerID` varchar(20) NOT NULL,
  `TreeID` varchar(20) NOT NULL,
  `UserID` varchar(20) NOT NULL,
  `Quantity` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `plant`
--

CREATE TABLE `plant` (
  `UserID` varchar(20) NOT NULL,
  `TreeID` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `plant`
--

INSERT INTO `plant` (`UserID`, `TreeID`) VALUES
('user2', 'tree5'),
('user2', 'tree11'),
('user3', 'tree9'),
('user1', 'tree8'),
('user2', 'tree7');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `UserId` varchar(20) NOT NULL,
  `DealerId` varchar(20) NOT NULL,
  `TreeId` varchar(20) NOT NULL,
  `Price` double(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`UserId`, `DealerId`, `TreeId`, `Price`) VALUES
('user2', '49367', 'tree5', 300.00),
('user2', '1111', 'tree11', 600.00),
('user3', '75635', 'tree9', 500.00),
('user1', '19940', 'tree8', 450.00),
('user2', '19940', 'tree7', 400.00);

-- --------------------------------------------------------

--
-- Table structure for table `tree`
--

CREATE TABLE `tree` (
  `TreeId` varchar(20) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `DealerId` varchar(20) NOT NULL,
  `Image` varchar(40) NOT NULL,
  `Price` double(8,2) NOT NULL,
  `SciName` varchar(200) NOT NULL,
  `Advantage` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tree`
--

INSERT INTO `tree` (`TreeId`, `Name`, `DealerId`, `Image`, `Price`, `SciName`, `Advantage`) VALUES
('tree1', 'Aloe vera', '5853', './/Image//aloe vera.jpg', 100.00, 'Aloe vera', 'Aloe vera, sometimes described as a \"wonder plant,\" is a short-stemmed shrub.\r\nAloe is a genus that contains more than 500 species of flowering succulent plants. '),
('tree10', 'Primrose', '75635', './/Image//Primrose.jpg', 550.00, 'Primula vulgaris', 'Primula vulgaris is a species of flowering plant in the family Primulaceae, native to western and southern Europe, northwest Africa, and southwest Asia.\r\n'),
('tree11', 'Primula', '1111', './/Image//Primula.jpg', 600.00, 'Primula', 'Primula vulgaris is a species of flowering plant in the family Primulaceae, native to western and southern Europe (from the Faroe Islands and Norway south to Portugal,\r\nand east to Germany, Ukraine, the Crimea, and the Balkans), northwest Africa (Algeria), and southwest Asia (Turkey east to Iran).'),
('tree12', 'Dandelions', '1111', './/Image//Deandelions.jpg', 1000.00, 'Dandelions', 'Dandelions are modest plants that are an excellent alternative source for a raw material of high demand: natural rubber, the fundamental ingredient in rubber products.\r\nFraunhofer researchers have established the basis for the large-scale production of high quality rubber with Russian dandelion.'),
('tree2', 'Neem', '5853', './/Image//Neem.jpg', 150.00, 'Azadirachta indica', 'Neem is a fast-growing tree that can reach a height of 15–20 metres (49–66 ft),and rarely 35–40 metres (115–131 ft).\r\nIt is evergreen, but in severe drought it may shed most of its leaves or nearly all leaves.'),
('tree3', 'Hawthorn', '48520', './/Image//Hawthorn.jpg', 200.00, 'Hawthorn', 'Crataegus commonly called hawthorn, thornapple, May-tree, whitethorn, or hawberry, is a large genus of shrubs and trees in the family Rosaceae, \r\nnative to temperate regions of the Northern Hemisphere in Europe, Asia and North America\r\n'),
('tree4', 'Elder', '48520', './/Image//Sambucus Nigra.jpg', 250.00, 'sambucus nigra', 'Sambucus nigra is a species complex of flowering plants in the family Adoxaceae native to most of Europe and North America.\r\nCommon names include elder, elderberry, black elder, European elder, European elderberry and European black elderberry.'),
('tree5', 'Camp bark', '49367', './/Image//Cramp Bark.jpg', 300.00, 'Camp bark', 'Viburnum opulus is a large bush that often is grown ornamentally for its attractive white flowers. It is native to northern Asia and Europe.\r\nopulus (also known as V. trilobatum) has edible red berries, while the European variety bears bitter fruit.'),
('tree6', 'Burpee', '49367', './/Image//Burpee.jpg', 350.00, 'Burpee', 'The burpee, or squat thrust, is a full body exercise used in strength training and as an aerobic exercise. \r\nThe basic movement is performed in four steps and known as a \"four-count burpee\": Begin in a standing position.\r\n\r\n'),
('tree7', 'Carambola', '19940', './/Image//Carambola.jpg', 400.00, 'Carambola', 'Carambola or starfruit, is the fruit of Averrhoa carambola, a species of tree native to the Philippines, Indonesia, \r\nMalaysia, Vietnam, Nepal, India, Bangladesh, Sri Lanka, Mauritius.'),
('tree8', 'Dragon', '19940', './/Image//Dragon.jpg', 450.00, 'pitaya', '\r\nA pitaya or pitahaya is the fruit of several cactus species indigenous to the Americas.\r\nPitaya usually refers to fruit of the genus Stenocereus, while pitahaya or dragon fruit refers to fruit of the genus Hylocereus'),
('tree9', 'Rambutam', '75635', './/Image//Rambutam.jpg', 500.00, 'Rambutam', 'The rambutan is a medium-sized tropical tree in the family Sapindaceae. The name also refers to the edible fruit produced by this tree.\r\nThe rambutan is native to the Malay-Indonesian region, and other regions of tropical Southeast Asia.\r\n\r\n');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `UserId` varchar(20) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Address` varchar(200) NOT NULL,
  `City` varchar(20) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Mobile` int(20) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Nationality` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`UserId`, `Name`, `Address`, `City`, `Email`, `Mobile`, `Gender`, `Nationality`) VALUES
('user1', 'user', 'Comilla,Bangladesh', 'Comilla', 'abc@gmail.com', 1821032813, 'male', 'Bangladeshi'),
('user2', 'swbbdkj', 'kjdcbkib', 'Dhaka', 'tfufvuyj', 28442, 'Male', 'jnevnjef'),
('user3', 'aaa', 'aadd', 'Dhaka', 'lmn@gmail.com', 1342526, 'Male', 'bangladeshi'),
('user4', 'aefervcfd', 'segfvvdfv', 'Chitagong', 'dthyfhn@gmail.com', 2353465, 'Female', 'sfvrvr'),
('user5', 'wdfc', 'wdf', 'Dhaka', 'as@wd', 13442, 'Female', 'qwedf');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`UserId`),
  ADD UNIQUE KEY `UserId` (`UserId`);

--
-- Indexes for table `dealer`
--
ALTER TABLE `dealer`
  ADD PRIMARY KEY (`UserId`),
  ADD UNIQUE KEY `Unique` (`Email`),
  ADD UNIQUE KEY `DealerID` (`DealerID`),
  ADD UNIQUE KEY `UserId` (`UserId`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`UserId`),
  ADD UNIQUE KEY `Unique` (`UserId`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`OrderID`);

--
-- Indexes for table `tree`
--
ALTER TABLE `tree`
  ADD PRIMARY KEY (`TreeId`),
  ADD UNIQUE KEY `TreeId` (`TreeId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`UserId`),
  ADD UNIQUE KEY `Email` (`Email`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
