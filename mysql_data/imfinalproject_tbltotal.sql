-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: imfinalproject
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `tbltotal`
--

DROP TABLE IF EXISTS `tbltotal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbltotal` (
  `OrderNumber` varchar(10) NOT NULL,
  `CodeNumber` varchar(10) NOT NULL,
  `SerialNumber` int NOT NULL,
  `Quantity` int NOT NULL,
  `Total` decimal(13,2) NOT NULL,
  PRIMARY KEY (`OrderNumber`,`CodeNumber`),
  KEY `CodeNumber_idx` (`CodeNumber`),
  CONSTRAINT `CodeNumber` FOREIGN KEY (`CodeNumber`) REFERENCES `tblcode` (`CodeNumber`),
  CONSTRAINT `OrderNumber` FOREIGN KEY (`OrderNumber`) REFERENCES `tblorder` (`OrderNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbltotal`
--

LOCK TABLES `tbltotal` WRITE;
/*!40000 ALTER TABLE `tbltotal` DISABLE KEYS */;
INSERT INTO `tbltotal` VALUES ('ORD1000001','NY 6X1 T',1,500,35000.00),('ORD1000001','TFT 10x8',2,170,7650.00),('ORD1000002','AG9-06',4,300,180000.00),('ORD1000002','SWH-15',2,100,1300.00),('ORD1000002','TFT 10x8',1,350,15750.00),('ORD1000002','WG-12',3,500,187500.00),('ORD1000003','NY 6X1 T',3,350,24500.00),('ORD1000003','SWH-15',1,150,19500.00),('ORD1000003','WG-12',2,100,37500.00),('ORD1000004','AG9-06',1,500,300000.00),('ORD1000004','TM1B120',2,500,362500.00),('ORD1000005','AG9-06',1,100,60000.00),('ORD1000005','NY 6X1 T',3,500,35000.00),('ORD1000005','TM1B120',2,50,36250.00),('ORD1000006','SWH-15',2,300,39000.00),('ORD1000006','TFT 10x8',1,500,22500.00),('ORD1000007','SWH-15',2,200,26000.00),('ORD1000007','TFT 10x8',1,500,22500.00),('ORD1000007','WG-12',3,100,37500.00),('ORD1000008','NY 6X1 T',1,500,35000.00),('ORD1000008','TFT 10x8',2,170,7650.00),('ORD1000009','TM1B120',1,700,507500.00),('ORD1000010','AG9-06',1,500,300000.00),('ORD1000010','TM1B120',2,500,362500.00);
/*!40000 ALTER TABLE `tbltotal` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-23 15:26:25