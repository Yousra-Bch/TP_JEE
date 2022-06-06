-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 06 juin 2022 à 18:16
-- Version du serveur : 10.4.21-MariaDB
-- Version de PHP : 7.3.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `library`
--

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `id` bigint(20) NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `nbLivreEmprunte` bigint(20) DEFAULT NULL,
  `nbLivreMensuel_Autorise` bigint(20) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `pack` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `pwdL` varchar(255) DEFAULT NULL,
  `pwdLivre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`id`, `login`, `nbLivreEmprunte`, `nbLivreMensuel_Autorise`, `nom`, `pack`, `prenom`, `pwd`, `pwdL`, `pwdLivre`) VALUES
(1, 'CH_KA', 0, 20, 'Kaci', 'premium', 'Chanez', '12345', NULL, 'book123'),
(2, 'test', 0, 10, 'Bouchaoui', 'standard', 'Yousra', 'azer', NULL, 'book123'),
(7, 'khaoula', 0, 20, 'Cheridi', 'premium', 'Khaoula', 'azer', NULL, 'book123');

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(15),
(15);

-- --------------------------------------------------------

--
-- Structure de la table `livre`
--

CREATE TABLE `livre` (
  `id` bigint(20) NOT NULL,
  `domaine` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `livre`
--

INSERT INTO `livre` (`id`, `domaine`, `nom`, `url`) VALUES
(3, 'Informatique', 'LangageC', 'LangageC.pdf'),
(6, 'Informatique', 'Java', 'programmerEnJava.pdf'),
(9, 'Math', 'Algebre', 'algebre.pdf'),
(14, 'Informatique', 'JEE', 'JEE.pdf');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `livre`
--
ALTER TABLE `livre`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
