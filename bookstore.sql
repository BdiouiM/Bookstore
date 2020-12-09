-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 09 déc. 2020 à 23:15
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `bookstore`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `Identifiant` int(11) NOT NULL AUTO_INCREMENT,
  `UsernameAdmin` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Salaire` float NOT NULL,
  `Nom` varchar(100) NOT NULL,
  `Prenom` varchar(100) NOT NULL,
  `Adresse` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Telephone` int(11) NOT NULL,
  `Type` varchar(100) NOT NULL,
  `CIN` int(11) NOT NULL,
  PRIMARY KEY (`Identifiant`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`Identifiant`, `UsernameAdmin`, `Password`, `Salaire`, `Nom`, `Prenom`, `Adresse`, `Email`, `Telephone`, `Type`, `CIN`) VALUES
(1, 'root', 'root', 1, '', '', '', 'mohamedbedioui10@gmail.com', 22, '', 0);

-- --------------------------------------------------------

--
-- Structure de la table `bibliothecaire`
--

DROP TABLE IF EXISTS `bibliothecaire`;
CREATE TABLE IF NOT EXISTS `bibliothecaire` (
  `Identifiant` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `CIN` int(11) NOT NULL,
  `Nom` varchar(100) NOT NULL,
  `Prenom` varchar(100) NOT NULL,
  `Telephone` int(11) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Type` varchar(100) NOT NULL,
  `Salaire` float NOT NULL,
  `Adresse` varchar(100) NOT NULL,
  PRIMARY KEY (`Identifiant`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `bibliothecaire`
--

INSERT INTO `bibliothecaire` (`Identifiant`, `Username`, `Password`, `CIN`, `Nom`, `Prenom`, `Telephone`, `Email`, `Type`, `Salaire`, `Adresse`) VALUES
(1, 'biblio', 'biblio', 0, '', '', 22, 'bibliothecaire@gmail.com', '', 1, '');

-- --------------------------------------------------------

--
-- Structure de la table `bussinesstocustomer`
--

DROP TABLE IF EXISTS `bussinesstocustomer`;
CREATE TABLE IF NOT EXISTS `bussinesstocustomer` (
  `identifiant` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `CIN` int(11) NOT NULL,
  `Nom` varchar(50) NOT NULL,
  `Prenom` varchar(50) NOT NULL,
  `Telephone` int(11) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Type` varchar(100) NOT NULL,
  `Salaire` float NOT NULL,
  `Adresse` varchar(100) NOT NULL,
  PRIMARY KEY (`identifiant`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `bussinesstocustomer`
--

INSERT INTO `bussinesstocustomer` (`identifiant`, `Username`, `Password`, `CIN`, `Nom`, `Prenom`, `Telephone`, `Email`, `Type`, `Salaire`, `Adresse`) VALUES
(1, 'btc', 'btc', 55, 'btc', 'btc', 55, 'btc', 'sdg', 0.5, 'dg');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `Identifiant` int(11) NOT NULL AUTO_INCREMENT,
  `UsernameClient` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `CIN` int(11) NOT NULL,
  `Nom` varchar(100) NOT NULL,
  `Prenom` varchar(100) NOT NULL,
  `Telephone` int(11) NOT NULL,
  `Adresse` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  PRIMARY KEY (`Identifiant`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`Identifiant`, `UsernameClient`, `Password`, `CIN`, `Nom`, `Prenom`, `Telephone`, `Adresse`, `Email`) VALUES
(1, 'user01', 'client', 0, '', '', 22, '', ''),
(2, 'ahmed', 'ahmed', 1, 'ahmed', 'ahmed', 1, 'a', 'a');

-- --------------------------------------------------------

--
-- Structure de la table `echange`
--

DROP TABLE IF EXISTS `echange`;
CREATE TABLE IF NOT EXISTS `echange` (
  `Identifiantechange` varchar(100) NOT NULL,
  `CIN1` varchar(100) NOT NULL,
  `CIN2` varchar(100) NOT NULL,
  `Titre1` varchar(100) NOT NULL,
  `Titre2` varchar(100) NOT NULL,
  `StatutEchange` varchar(100) NOT NULL,
  `Client1Confirmation` varchar(100) NOT NULL,
  PRIMARY KEY (`Identifiantechange`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `echange`
--

INSERT INTO `echange` (`Identifiantechange`, `CIN1`, `CIN2`, `Titre1`, `Titre2`, `StatutEchange`, `Client1Confirmation`) VALUES
('4', '07219856', 'Null', 'jhgjgj', 'Null', 'En cours..', 'en cours ..'),
('3', '07219856', '07219855', 'kjbbkjb', 'bbbbbbbb', 'Validée..', 'en cours ..'),
('2', '07219855', '07219856', 'aaa', 'spring boot', 'Validée..', 'Validée..'),
('1', '07219855', 'aa', 'odes', ' test', 'Validée..', 'Waiting for new echnage'),
('33', '1223456', 'Null', 'bdioui', 'Null', 'En cours..', 'en cours ..'),
('100', '1', '0', 'titre11111', 'titreeee', 'En cours..', 'en cours ..');

-- --------------------------------------------------------

--
-- Structure de la table `livraison`
--

DROP TABLE IF EXISTS `livraison`;
CREATE TABLE IF NOT EXISTS `livraison` (
  `id_livraison` int(11) NOT NULL,
  `coords` varchar(30) NOT NULL,
  `adrclient` varchar(30) DEFAULT NULL,
  `id_client` int(11) NOT NULL,
  `id_livreur` int(11) NOT NULL,
  PRIMARY KEY (`id_livraison`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `livraison`
--

INSERT INTO `livraison` (`id_livraison`, `coords`, `adrclient`, `id_client`, `id_livreur`) VALUES
(1, '0000, 0000', 'hhdhdhd', 2, 3),
(2, '0000', '0000', 2, 3),
(3, '010', '000', 2, 3),
(4, '01000', 'aa000', 5, 4),
(5, '0100000', 'a000a000', 6, 6),
(7, 'kdhjsd', 'kkdd', 5, 6),
(8, 'bdioui', 'zahra', 10, 10);

-- --------------------------------------------------------

--
-- Structure de la table `livre`
--

DROP TABLE IF EXISTS `livre`;
CREATE TABLE IF NOT EXISTS `livre` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `Genre` varchar(20) NOT NULL,
  `Titre` varchar(20) NOT NULL,
  `Auteur` varchar(30) NOT NULL,
  `Prix` double NOT NULL,
  `nbrPages` int(10) NOT NULL,
  `quantite` int(20) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `livre`
--

INSERT INTO `livre` (`Id`, `Genre`, `Titre`, `Auteur`, `Prix`, `nbrPages`, `quantite`) VALUES
(19, 'a', 'aa', 'a', 44, 55, 66),
(15, 'test', 'test', 'test', 15, 20, 30),
(9, 'aaa', 'aaa', 'aaa', 1, 1, 1),
(17, 'test3', 'test3', 'test3', 80, 300, 22);

-- --------------------------------------------------------

--
-- Structure de la table `panier`
--

DROP TABLE IF EXISTS `panier`;
CREATE TABLE IF NOT EXISTS `panier` (
  `id_panier` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(30) NOT NULL,
  `prix` float NOT NULL,
  `prix_total` float NOT NULL,
  `id_client` varchar(30) NOT NULL,
  `id_livre` varchar(30) NOT NULL,
  `quantite` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_panier`),
  KEY `fk_titre` (`titre`),
  KEY `fk_prix` (`prix`),
  KEY `fk_id_client` (`id_client`),
  KEY `fk_id_livre` (`id_livre`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `panier`
--

INSERT INTO `panier` (`id_panier`, `titre`, `prix`, `prix_total`, `id_client`, `id_livre`, `quantite`) VALUES
(1, 'le petit prince', 10, 10, '1', '6', 1),
(2, 'adulthere', 20, 20, '1', '1', 1),
(3, 'mme bovary', 25, 25, '1', '2', 1),
(4, 'adulthere', 20, 20, '3', '1', 1);

-- --------------------------------------------------------

--
-- Structure de la table `personnel`
--

DROP TABLE IF EXISTS `personnel`;
CREATE TABLE IF NOT EXISTS `personnel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `poste` varchar(20) NOT NULL,
  `cin` int(11) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `adresse` text NOT NULL,
  `email` text NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` text NOT NULL,
  `type` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=177 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `personnel`
--

INSERT INTO `personnel` (`id`, `poste`, `cin`, `nom`, `prenom`, `adresse`, `email`, `username`, `password`, `type`) VALUES
(92, 'dd', 22, 'oumaima', 'shhs', 's;,x', 'qq', 'ii', 'njqjq', 'aaa');

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

DROP TABLE IF EXISTS `reclamation`;
CREATE TABLE IF NOT EXISTS `reclamation` (
  `Identifiant` int(11) NOT NULL AUTO_INCREMENT,
  `UsernameClient` varchar(50) NOT NULL,
  `DateReclamation` varchar(20) NOT NULL,
  `StatutReclamation` varchar(20) NOT NULL,
  `Type` varchar(50) NOT NULL,
  `Description` varchar(50) NOT NULL,
  PRIMARY KEY (`Identifiant`)
) ENGINE=MyISAM AUTO_INCREMENT=55 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `reclamation`
--

INSERT INTO `reclamation` (`Identifiant`, `UsernameClient`, `DateReclamation`, `StatutReclamation`, `Type`, `Description`) VALUES
(13, 'User01', 'Test2', 'annulée..', 'Test2', 'Test2'),
(15, 'Test2', 'Test2', 'validée..', 'Test2', 'Test2'),
(17, 'Test2', 'Test2', 'validée..', 'Test2', 'Test2'),
(19, 'Test2', 'Test2', 'validée..', 'Test2', 'Test2'),
(21, 'Test2', 'Test2', 'validée..', 'Test2', 'Test2'),
(23, 'Test2', 'Test2', 'validée..', 'Test2', 'Test2'),
(25, 'Test2', 'Test2', 'validée..', 'Test2', 'Test2'),
(27, 'Test2', 'Test2', 'validée..', 'Test2', 'Test2'),
(29, 'Test2', 'Test2', 'validée..', 'Test2', 'Test2'),
(31, 'Test2', 'Test2', 'validée..', 'Test2', 'Test2'),
(33, 'Test2', 'Test2', 'validée..', 'Test2', 'Test2'),
(35, 'Test2', 'Test2', 'validée..', 'Test2', 'Test2'),
(37, 'Test2', 'Test2', 'validée..', 'Test2', 'Test2'),
(39, 'Test2', 'Test2', 'validée..', 'Test2', 'Test2'),
(41, 'Test2', 'Test2', 'validée..', 'Test2', 'Test2'),
(43, 'Test2', 'Test2', 'validée..', 'Test2', 'Test2'),
(45, 'Test2', 'Test2', 'validée..', 'Test2', 'Test2'),
(47, 'Test2', 'Test2', 'validée..', 'Test2', 'Test2'),
(49, 'Test2', 'Test2', 'validée..', 'Test2', 'Test2'),
(51, 'Test2', 'Test2', 'validée..', 'Test2', 'Test2'),
(53, 'Test2', 'Test2', 'validée..', 'Test2', 'Test2'),
(54, 'testvalider', '2020-12-02', 'annulée..', 'Type3', 'testetestes');

-- --------------------------------------------------------

--
-- Structure de la table `remise`
--

DROP TABLE IF EXISTS `remise`;
CREATE TABLE IF NOT EXISTS `remise` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idLivre` int(11) NOT NULL,
  `pourcentage` float NOT NULL,
  `ancienPrix` float NOT NULL,
  `nouveauPrix` float NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idLivre` (`idLivre`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `remise`
--

INSERT INTO `remise` (`id`, `idLivre`, `pourcentage`, `ancienPrix`, `nouveauPrix`) VALUES
(2, 1, 0.5, 2.79, 1.395),
(3, 2, 0.3, 3.42, 2.394),
(5, 6, 0.5, 30, 15);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
