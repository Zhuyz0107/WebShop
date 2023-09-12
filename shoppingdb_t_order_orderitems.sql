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
-- Table structure for table `t_order_orderitems`
--

DROP TABLE IF EXISTS `t_order_orderitems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_order_orderitems` (
  `orderitemId` int(11) NOT NULL AUTO_INCREMENT,
  `orderid` varchar(64) DEFAULT NULL,
  `productid` int(11) DEFAULT NULL,
  `productName` varchar(50) DEFAULT NULL,
  `productPrice` double DEFAULT NULL,
  `buynum` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderitemId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order_orderitems`
--

LOCK TABLES `t_order_orderitems` WRITE;
/*!40000 ALTER TABLE `t_order_orderitems` DISABLE KEYS */;
INSERT INTO `t_order_orderitems` VALUES (1,'45DB3DB52B304C009D84D8BCF3C8A10F',3,'Mateboot 13',6000,1),(2,'45DB3DB52B304C009D84D8BCF3C8A10F',3,'Mateboot 13',6000,1),(3,'45DB3DB52B304C009D84D8BCF3C8A10F',4,'ZR001',1000,3),(4,'45DB3DB52B304C009D84D8BCF3C8A10F',6,'ZR001',1000,1);
/*!40000 ALTER TABLE `t_order_orderitems` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-23 14:51:33
