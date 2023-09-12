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
-- Table structure for table `t_product_product`
--

DROP TABLE IF EXISTS `t_product_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_product_product` (
  `productid` int(11) NOT NULL AUTO_INCREMENT,
  `classid` int(11) DEFAULT NULL,
  `brandid` int(11) DEFAULT NULL,
  `productname` varchar(50) DEFAULT NULL,
  `smallimg` varchar(50) DEFAULT NULL,
  `bigimg` varchar(50) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`productid`),
  KEY `FK_Reference_3` (`classid`),
  KEY `FK_Reference_4` (`brandid`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`classid`) REFERENCES `t_product_class` (`classid`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`brandid`) REFERENCES `t_product_brand` (`brandid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_product`
--

LOCK TABLES `t_product_product` WRITE;
/*!40000 ALTER TABLE `t_product_product` DISABLE KEYS */;
INSERT INTO `t_product_product` VALUES (3,2,1,'Mateboot 13','51671fbc5d82485682b3041f4a38b31a.png','596c78c3f9274741b3d06f94aa6429d9.png',6000,'性能良好'),(4,3,2,'ZR001','9cc008c827e444948966f20d691f9839.jpg','c25d4c4746e14156840bf69e9a52e62b.jpg',1000,'good'),(5,2,1,'Mateboot 13','51671fbc5d82485682b3041f4a38b31a.png','596c78c3f9274741b3d06f94aa6429d9.png',6000,'性能良好'),(6,3,2,'ZR001','9cc008c827e444948966f20d691f9839.jpg','c25d4c4746e14156840bf69e9a52e62b.jpg',1000,'good'),(7,2,1,'Mateboot 13','51671fbc5d82485682b3041f4a38b31a.png','596c78c3f9274741b3d06f94aa6429d9.png',6000,'性能良好'),(8,3,2,'ZR001','9cc008c827e444948966f20d691f9839.jpg','c25d4c4746e14156840bf69e9a52e62b.jpg',1000,'good'),(9,2,1,'Mateboot 13','51671fbc5d82485682b3041f4a38b31a.png','596c78c3f9274741b3d06f94aa6429d9.png',6000,'性能良好'),(10,3,2,'ZR001','9cc008c827e444948966f20d691f9839.jpg','c25d4c4746e14156840bf69e9a52e62b.jpg',1000,'good'),(11,2,1,'Mateboot 13','51671fbc5d82485682b3041f4a38b31a.png','596c78c3f9274741b3d06f94aa6429d9.png',6000,'性能良好'),(12,3,2,'ZR001','9cc008c827e444948966f20d691f9839.jpg','c25d4c4746e14156840bf69e9a52e62b.jpg',1000,'good'),(13,2,1,'Mateboot 13','51671fbc5d82485682b3041f4a38b31a.png','596c78c3f9274741b3d06f94aa6429d9.png',6000,'性能良好'),(14,3,2,'ZR001','9cc008c827e444948966f20d691f9839.jpg','c25d4c4746e14156840bf69e9a52e62b.jpg',1000,'good'),(15,2,1,'Mateboot 13','51671fbc5d82485682b3041f4a38b31a.png','596c78c3f9274741b3d06f94aa6429d9.png',6000,'性能良好'),(16,3,2,'ZR001','9cc008c827e444948966f20d691f9839.jpg','c25d4c4746e14156840bf69e9a52e62b.jpg',1000,'good'),(17,2,1,'Mateboot 13','51671fbc5d82485682b3041f4a38b31a.png','596c78c3f9274741b3d06f94aa6429d9.png',6000,'性能良好'),(18,2,1,'测试','cea1cbd531dc48ed9dab17c20dd1fc87.png','d0fb45135fce408a886b2fda3320b1ac.jpg',5000,'李厚霖df');
/*!40000 ALTER TABLE `t_product_product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-23 14:51:24
