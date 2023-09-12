-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: 192.168.150.243    Database: shoppingdb
-- ------------------------------------------------------
-- Server version	5.7.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_admin_admin`
--

DROP TABLE IF EXISTS `t_admin_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_admin_admin` (
  `adminid` int(11) NOT NULL AUTO_INCREMENT,
  `admingroupid` int(11) DEFAULT NULL,
  `adminname` varchar(50) DEFAULT NULL,
  `adminpwd` varchar(64) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `regtime` datetime DEFAULT NULL,
  `modifytime` datetime DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`adminid`),
  KEY `FK_Reference_8` (`admingroupid`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`admingroupid`) REFERENCES `t_admin_group` (`admingroupid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_admin_admin`
--

LOCK TABLES `t_admin_admin` WRITE;
/*!40000 ALTER TABLE `t_admin_admin` DISABLE KEYS */;
INSERT INTO `t_admin_admin` VALUES (1,1,'gary','dragon','男','2022-08-16 00:00:00','2022-08-16 00:00:00','中软讲师'),(3,1,'admin','admin888','女','2022-08-16 00:00:00','2022-08-16 00:00:00','中软讲师'),(6,2,'sys','dragon','男','2022-08-16 00:00:00','2022-08-16 00:00:00','中软讲师'),(12,1,'sdf','sdf',NULL,NULL,NULL,NULL),(13,2,'sdffs',NULL,NULL,NULL,NULL,NULL),(14,2,'sdf',NULL,NULL,NULL,NULL,NULL),(15,NULL,NULL,NULL,NULL,NULL,NULL,'');
/*!40000 ALTER TABLE `t_admin_admin` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-23 14:51:34
