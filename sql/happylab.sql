/*
SQLyog Community Edition- MySQL GUI v6.54
MySQL - 5.7.10-log : Database - happylab
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`happylab` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `happylab`;

/*Table structure for table `analyses` */

DROP TABLE IF EXISTS `analyses`;

CREATE TABLE `analyses` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `code` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Table structure for table `customers` */

DROP TABLE IF EXISTS `customers`;

CREATE TABLE `customers` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT '',
  `city` varchar(255) DEFAULT '',
  `remark` varchar(255) DEFAULT '',
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=234 DEFAULT CHARSET=utf8;

/*Table structure for table `employees` */

DROP TABLE IF EXISTS `employees`;

CREATE TABLE `employees` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `lastname` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `positionId` int(11) unsigned NOT NULL,
  `assistant` tinyint(1) DEFAULT '0',
  `signature` tinyint(1) DEFAULT '0',
  `remark` varchar(255) DEFAULT NULL,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `titleId_idx` (`positionId`),
  CONSTRAINT `position_id` FOREIGN KEY (`positionId`) REFERENCES `positions` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8;

/*Table structure for table `journal_aes` */

DROP TABLE IF EXISTS `journal_aes`;

CREATE TABLE `journal_aes` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `probeId` int(11) unsigned NOT NULL,
  `date` date DEFAULT NULL,
  `employeeId` int(11) NOT NULL DEFAULT '0',
  `Ag` double(5,4) DEFAULT '0.0000',
  `Al` double(4,3) DEFAULT '0.000',
  `As` double(5,4) DEFAULT '0.0000',
  `B` double(4,3) DEFAULT '0.000',
  `Ba` double(5,4) DEFAULT '0.0000',
  `Be` double(6,5) DEFAULT '0.00000',
  `Bi` double(4,3) DEFAULT '0.000',
  `Ca` double(4,3) DEFAULT '0.000',
  `Cd` double(6,5) DEFAULT '0.00000',
  `Co` double(5,4) DEFAULT '0.0000',
  `Cr` double(5,4) DEFAULT '0.0000',
  `Cu` double(5,4) DEFAULT '0.0000',
  `Fe` double(4,3) DEFAULT '0.000',
  `K` double(4,3) DEFAULT '0.000',
  `Li` double(4,3) DEFAULT '0.000',
  `Mg` double(4,3) DEFAULT '0.000',
  `Mn` double(5,4) DEFAULT '0.0000',
  `Mo` double(5,4) DEFAULT '0.0000',
  `Na` double(3,2) DEFAULT '0.00',
  `Ni` double(5,4) DEFAULT '0.0000',
  `P` double(4,3) DEFAULT '0.000',
  `Pb` double(5,4) DEFAULT '0.0000',
  `S` double(4,3) DEFAULT '0.000',
  `Sb` double(5,4) DEFAULT '0.0000',
  `Se` double(5,4) DEFAULT '0.0000',
  `Si` double(4,3) DEFAULT '0.000',
  `Sn` double(5,4) DEFAULT '0.0000',
  `Sr` double(5,4) DEFAULT '0.0000',
  `Ti` double(5,4) DEFAULT '0.0000',
  `Tl` double(5,4) DEFAULT '0.0000',
  `V` double(5,4) DEFAULT '0.0000',
  `W` double(4,3) DEFAULT '0.000',
  `Zn` double(5,4) DEFAULT '0.0000',
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `id_idx` (`probeId`),
  CONSTRAINT `probes_id` FOREIGN KEY (`probeId`) REFERENCES `probes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

/*Table structure for table `journal_sanpin` */

DROP TABLE IF EXISTS `journal_sanpin`;

CREATE TABLE `journal_sanpin` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `probeId` int(11) unsigned NOT NULL,
  `date` date DEFAULT NULL,
  `employeeId` int(11) DEFAULT '0',
  `Ag` double(5,4) DEFAULT '0.0000',
  `Al` double(4,3) DEFAULT '0.000',
  `As` double(5,4) DEFAULT '0.0000',
  `B` double(4,3) DEFAULT '0.000',
  `Ba` double(5,4) DEFAULT '0.0000',
  `Be` double(6,5) DEFAULT '0.00000',
  `Bi` double(4,3) DEFAULT '0.000',
  `Cd` double(6,5) DEFAULT '0.00000',
  `Co` double(5,4) DEFAULT '0.0000',
  `Cr6` double(5,4) DEFAULT '0.0000',
  `Cr` double(5,4) DEFAULT '0.0000',
  `Cu` double(5,4) DEFAULT '0.0000',
  `Fe` double(4,3) DEFAULT '0.000',
  `Li` double(4,3) DEFAULT '0.000',
  `Mn` double(5,4) DEFAULT '0.0000',
  `Mo` double(5,4) DEFAULT '0.0000',
  `Nb` double(5,4) DEFAULT '0.0000',
  `Na+Ka` double(4,3) DEFAULT '0.000',
  `Ni` double(5,4) DEFAULT '0.0000',
  `NH3` double(4,3) DEFAULT '0.000',
  `NO2` double(5,4) DEFAULT '0.0000',
  `Pb` double(5,4) DEFAULT '0.0000',
  `Sb` double(5,4) DEFAULT '0.0000',
  `Se` double(5,4) DEFAULT '0.0000',
  `SiAcid` double(4,3) DEFAULT '0.000',
  `Si` double(4,3) DEFAULT '0.000',
  `Sr` double(5,4) DEFAULT '0.0000',
  `Te` double(4,3) DEFAULT '0.000',
  `Rodanide` double(4,3) DEFAULT '0.000',
  `Tl` double(5,4) DEFAULT '0.0000',
  `V` double(5,4) DEFAULT '0.0000',
  `W` double(4,3) DEFAULT '0.000',
  `Zn` double(5,4) DEFAULT '0.0000',
  `odour` double(2,0) DEFAULT '0',
  `flavor` double(2,0) DEFAULT '0',
  `chromaticity` double(2,1) DEFAULT '0.0',
  `turbidity` double(3,2) DEFAULT '0.00',
  `hydrogenIndex` double(3,2) DEFAULT '0.00',
  `mineralization` double(3,2) DEFAULT '0.00',
  `dryResidue` double(2,1) DEFAULT '0.0',
  `anion` double(4,3) DEFAULT '0.000',
  `stiffness` double(5,4) DEFAULT '0.0000',
  `oilProduct` double(5,4) DEFAULT '0.0000',
  `nitrate` double(5,4) DEFAULT '0.0000',
  `permaganate` double(5,4) DEFAULT '0.0000',
  `mercury` double(5,4) DEFAULT '0.0000',
  `sulfate` double(5,4) DEFAULT '0.0000',
  `fluoride` double(5,4) DEFAULT '0.0000',
  `phenolicIndex` double(5,4) DEFAULT '0.0000',
  `chloride` double(5,4) DEFAULT '0.0000',
  `cyanide` double(4,3) DEFAULT '0.000',
  `dissolvedOxygen` double(4,3) DEFAULT '0.000',
  `biologicalOxygenDemand` double(4,3) DEFAULT '0.000',
  `chemicalOxygenDemand` double(4,3) DEFAULT '0.000',
  `suspendedSolid` double(4,3) DEFAULT '0.000',
  `pesticideLindane` double(4,3) DEFAULT '0.000',
  `pesticideIsomer` double(4,3) DEFAULT '0.000',
  `radioactivityA` double(4,3) DEFAULT '0.000',
  `radioactivityB` double(4,3) DEFAULT '0.000',
  `polyphosphate` double(4,3) DEFAULT '0.000',
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `probeId_idx` (`probeId`),
  CONSTRAINT `probeId` FOREIGN KEY (`probeId`) REFERENCES `probes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

/*Table structure for table `journal_ssa` */

DROP TABLE IF EXISTS `journal_ssa`;

CREATE TABLE `journal_ssa` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `probeId` int(11) unsigned NOT NULL,
  `date` date DEFAULT NULL,
  `employeeId` int(11) DEFAULT '0',
  `Ag` double(5,4) DEFAULT '0.0000',
  `Al` double(4,3) DEFAULT '0.000',
  `As` double(5,4) DEFAULT '0.0000',
  `Au` double(4,3) DEFAULT '0.000',
  `B` double(4,3) DEFAULT '0.000',
  `Ba` double(5,4) DEFAULT '0.0000',
  `Be` double(6,5) DEFAULT '0.00000',
  `Bi` double(4,3) DEFAULT '0.000',
  `Cd` double(6,5) DEFAULT '0.00000',
  `Ce` double(4,3) DEFAULT '0.000',
  `Co` double(5,4) DEFAULT '0.0000',
  `Cr` double(5,4) DEFAULT '0.0000',
  `Cu` double(5,4) DEFAULT '0.0000',
  `Fe` double(4,3) DEFAULT '0.000',
  `Ga` double(4,3) DEFAULT '0.000',
  `Ge` double(4,3) DEFAULT '0.000',
  `Hf` double(5,4) DEFAULT '0.0000',
  `In` double(4,3) DEFAULT '0.000',
  `La` double(5,4) DEFAULT '0.0000',
  `Li` double(4,3) DEFAULT '0.000',
  `Mn` double(5,4) DEFAULT '0.0000',
  `Mo` double(5,4) DEFAULT '0.0000',
  `Nb` double(5,4) DEFAULT '0.0000',
  `Ni` double(5,4) DEFAULT '0.0000',
  `P` double(4,3) DEFAULT '0.000',
  `Pb` double(5,4) DEFAULT '0.0000',
  `Pt` double(4,3) DEFAULT '0.000',
  `Sb` double(5,4) DEFAULT '0.0000',
  `Sc` double(6,5) DEFAULT '0.00000',
  `Sn` double(5,4) DEFAULT '0.0000',
  `Sr` double(5,4) DEFAULT '0.0000',
  `Ta` double(4,3) DEFAULT '0.000',
  `Te` double(6,5) DEFAULT '0.00000',
  `Th` double(5,4) DEFAULT '0.0000',
  `Ti` double(5,4) DEFAULT '0.0000',
  `Tl` double(5,4) DEFAULT '0.0000',
  `U` double(3,2) DEFAULT '0.00',
  `V` double(5,4) DEFAULT '0.0000',
  `W` double(4,3) DEFAULT '0.000',
  `Y` double(5,4) DEFAULT '0.0000',
  `Yb` double(6,5) DEFAULT '0.00000',
  `Zn` double(5,4) DEFAULT '0.0000',
  `Zr` double(5,4) DEFAULT '0.0000',
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `probes_id_idx` (`probeId`),
  KEY `id_idx` (`probeId`),
  CONSTRAINT `id` FOREIGN KEY (`probeId`) REFERENCES `probes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

/*Table structure for table `limits` */

DROP TABLE IF EXISTS `limits`;

CREATE TABLE `limits` (
  `id` int(11) unsigned NOT NULL,
  `analysis` int(11) unsigned NOT NULL DEFAULT '0',
  `element` varchar(50) DEFAULT '',
  `limit` double DEFAULT NULL,
  `unit` varchar(50) DEFAULT '',
  `pdk` varchar(10) DEFAULT '',
  `nd` varchar(255) DEFAULT '',
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `analysis_id_idx` (`analysis`),
  CONSTRAINT `analysis_id` FOREIGN KEY (`analysis`) REFERENCES `analyses` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `number` int(11) unsigned DEFAULT '0',
  `customerId` int(11) unsigned NOT NULL,
  `date` date DEFAULT NULL,
  `remark` varchar(50) DEFAULT '',
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `customerId_idx` (`customerId`),
  CONSTRAINT `customerId` FOREIGN KEY (`customerId`) REFERENCES `customers` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1104 DEFAULT CHARSET=utf8;

/*Table structure for table `positions` */

DROP TABLE IF EXISTS `positions`;

CREATE TABLE `positions` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `position` varchar(100) DEFAULT '',
  `remark` varchar(255) DEFAULT '',
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

/*Table structure for table `probes` */

DROP TABLE IF EXISTS `probes`;

CREATE TABLE `probes` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `orderId` int(11) unsigned NOT NULL,
  `numberLab` int(11) DEFAULT NULL,
  `numberCustomer` int(11) DEFAULT NULL,
  `dateReceiving` date DEFAULT NULL,
  `pointSampling` varchar(255) DEFAULT '',
  `dateSampling` date DEFAULT NULL,
  `remark` varchar(255) DEFAULT '',
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `orderId_idx` (`orderId`),
  CONSTRAINT `orderId` FOREIGN KEY (`orderId`) REFERENCES `orders` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL DEFAULT '',
  `username` varchar(150) NOT NULL,
  `email` varchar(100) NOT NULL DEFAULT '',
  `password` varchar(100) NOT NULL,
  `usertype` varchar(255) DEFAULT '',
  `dateRegistration` date DEFAULT NULL,
  `block` tinyint(1) NOT NULL DEFAULT '0',
  `remark` varchar(255) DEFAULT '',
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1764 DEFAULT CHARSET=utf8;

/*Table structure for table `usertype` */

DROP TABLE IF EXISTS `usertype`;

CREATE TABLE `usertype` (
  `id` tinyint(11) unsigned NOT NULL AUTO_INCREMENT,
  `usertype` varchar(100) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
