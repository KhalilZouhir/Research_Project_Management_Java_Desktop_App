-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 04, 2023 at 12:18 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gestionprojet`
--

-- --------------------------------------------------------

--
-- Table structure for table `appartient`
--

CREATE TABLE `appartient` (
  `id_group` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `groupe_privilege` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `associe`
--

CREATE TABLE `associe` (
  `id_project` int(11) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `associe`
--

INSERT INTO `associe` (`id_project`, `id_user`) VALUES
(1, 1),
(2, 2),
(1, 3),
(2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `groups`
--

CREATE TABLE `groups` (
  `id_group` int(11) NOT NULL,
  `name_group` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

CREATE TABLE `project` (
  `id_project` int(11) NOT NULL,
  `short_name_project` varchar(45) NOT NULL,
  `long_name_project` varchar(50) NOT NULL,
  `Desc_project` mediumtext NOT NULL,
  `theme_project` varchar(50) NOT NULL,
  `type_project` varchar(50) NOT NULL,
  `licence_projectt` varchar(50) NOT NULL,
  `visibility_project` varchar(50) NOT NULL,
  `state_project` varchar(50) NOT NULL,
  `agenda_project` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `project`
--

INSERT INTO `project` (`id_project`, `short_name_project`, `long_name_project`, `Desc_project`, `theme_project`, `type_project`, `licence_projectt`, `visibility_project`, `state_project`, `agenda_project`) VALUES
(1, 'projet1', 'projetname', 'descprojet', 'themeprojet', 'typeprojet', 'licenceprojet', 'public', 'accepted', 'agendaproj'),
(2, 'shortnameproject2', 'ongnameproj2', 'descripprojet2', 'themeproject2', 'typeproject2', 'licenceproj2', 'prive', 'rejected', 'agendaproj2');

-- --------------------------------------------------------

--
-- Table structure for table `request`
--

CREATE TABLE `request` (
  `id_request` int(11) NOT NULL,
  `short_name_request` varbinary(30) NOT NULL,
  `long_name_request` varchar(30) NOT NULL,
  `Desc_request` mediumtext NOT NULL,
  `theme_request` varchar(30) NOT NULL,
  `type_project_request` varchar(30) NOT NULL,
  `licence_request` varchar(30) NOT NULL,
  `visibility` varchar(30) NOT NULL,
  `type_request` varchar(30) NOT NULL,
  `status` varchar(40) NOT NULL DEFAULT 'Rejected',
  `id_User` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `request`
--

INSERT INTO `request` (`id_request`, `short_name_request`, `long_name_request`, `Desc_request`, `theme_request`, `type_project_request`, `licence_request`, `visibility`, `type_request`, `status`, `id_User`) VALUES
(1, 0x7069636f6c6962, 'library', 'descpicolib', 'documents', 'gestion', 'prog', 'public', 'open', 'Rejected', 1);

-- --------------------------------------------------------

--
-- Table structure for table `ressources`
--

CREATE TABLE `ressources` (
  `id_ressource` int(11) NOT NULL,
  `type_ressource` varchar(50) NOT NULL,
  `content_ressource` longtext NOT NULL,
  `id_project` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ressources`
--

INSERT INTO `ressources` (`id_ressource`, `type_ressource`, `content_ressource`, `id_project`) VALUES
(1, 'messagerie', 'hello world this me\r\nim new here', 1),
(2, 'agenda', 'this is my new agenda', 1),
(3, 'messagerie', 'thi is a second esssagrieie\r\nheil', 2),
(4, 'agenda', 'this is a very new agenda 2\r\n', 2);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `Id_User` int(11) NOT NULL,
  `Surname` varchar(30) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `MDP` varchar(30) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Type` varchar(30) NOT NULL DEFAULT 'user',
  `Agenda` longtext DEFAULT NULL,
  `username` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`Id_User`, `Surname`, `Name`, `MDP`, `Email`, `Type`, `Agenda`, `username`) VALUES
(1, 'mouraji', 'ikram', 'jungkook', 'ikrammouraji@gmail.com', 'user', 'states\n/nmy new flex /nheeloohi this is new to memy thingthis is ikramim your manager\nhello world Tue Jan 03 10:17:26 WEST 2023 Tue Jan 03 10:23:06 WEST 2023 Tue Jan 03 10:26:53 WEST 2023 Tue Jan 03 10:29:34 WEST 2023 Tue Jan 03 10:38:37 WEST 2023 Tue Jan 03 10:45:11 WEST 2023 /n yessssssssssssssssss Tue Jan 03 10:46:30 WEST 2023\n jiuh\n heeloo\n je vais faire un projet de java Tue Jan 03 10:56:35 WEST 2023\n hello my \n Tue Jan 03 18:43:15 WEST 2023\n new year eve Tue Jan 03 20:33:11 WEST 2023', 'imouraji'),
(2, 'zouhair', 'khalil', '123', 'khalilzouahir@gmail.com', 'user', NULL, 'kzouhair'),
(3, 'nahli', 'chaimaa', '1234', 'cnahli@gmail.com', 'user', NULL, 'cnahli'),
(4, 'Guest', 'guesr', 'Guest', 'guest', 'guest', 'guest agenda', 'Guest'),
(5, 'ikram', 'rajai', 'azer', 'ikram@gmail.com', 'admin', 'my agenda', 'ikramadmin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appartient`
--
ALTER TABLE `appartient`
  ADD KEY `id_groupe_appartient` (`id_group`),
  ADD KEY `id_user_appartient` (`id_user`);

--
-- Indexes for table `associe`
--
ALTER TABLE `associe`
  ADD KEY `id_project_associe` (`id_project`),
  ADD KEY `id_user_associe` (`id_user`);

--
-- Indexes for table `groups`
--
ALTER TABLE `groups`
  ADD PRIMARY KEY (`id_group`);

--
-- Indexes for table `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`id_project`);

--
-- Indexes for table `request`
--
ALTER TABLE `request`
  ADD PRIMARY KEY (`id_request`),
  ADD KEY `id_user_request` (`id_User`);

--
-- Indexes for table `ressources`
--
ALTER TABLE `ressources`
  ADD PRIMARY KEY (`id_ressource`),
  ADD KEY `id_project_ressources` (`id_project`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`Id_User`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `groups`
--
ALTER TABLE `groups`
  MODIFY `id_group` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `project`
--
ALTER TABLE `project`
  MODIFY `id_project` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `request`
--
ALTER TABLE `request`
  MODIFY `id_request` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `ressources`
--
ALTER TABLE `ressources`
  MODIFY `id_ressource` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `Id_User` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `appartient`
--
ALTER TABLE `appartient`
  ADD CONSTRAINT `id_groupe_appartient` FOREIGN KEY (`id_group`) REFERENCES `groups` (`id_group`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `id_user_appartient` FOREIGN KEY (`id_user`) REFERENCES `users` (`Id_User`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `associe`
--
ALTER TABLE `associe`
  ADD CONSTRAINT `id_project_associe` FOREIGN KEY (`id_project`) REFERENCES `project` (`id_project`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `id_user_associe` FOREIGN KEY (`id_user`) REFERENCES `users` (`Id_User`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `request`
--
ALTER TABLE `request`
  ADD CONSTRAINT `id_user_request` FOREIGN KEY (`id_User`) REFERENCES `users` (`Id_User`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ressources`
--
ALTER TABLE `ressources`
  ADD CONSTRAINT `id_project_ressources` FOREIGN KEY (`id_project`) REFERENCES `project` (`id_project`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
