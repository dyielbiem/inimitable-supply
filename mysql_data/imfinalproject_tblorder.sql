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
-- Table structure for table `tblorder`
--

DROP TABLE IF EXISTS `tblorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblorder` (
  `OrderNumber` varchar(10) NOT NULL,
  `OrderDate` date NOT NULL,
  `SalesPerson` varchar(30) NOT NULL,
  `InvoiceNumber` varchar(10) NOT NULL,
  `CustomerCode` varchar(10) NOT NULL,
  `TotalAED` decimal(13,2) NOT NULL,
  `VAT` decimal(13,2) NOT NULL,
  `GrandTotal` decimal(13,2) NOT NULL,
  `ConfirmedBy` varchar(30) NOT NULL,
  `SalesExecutive` varchar(30) NOT NULL,
  PRIMARY KEY (`OrderNumber`),
  KEY `CustomerCode_idx` (`CustomerCode`),
  CONSTRAINT `CustomerCode` FOREIGN KEY (`CustomerCode`) REFERENCES `tblcustomer` (`CustomerCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblorder`
--

LOCK TABLES `tblorder` WRITE;
/*!40000 ALTER TABLE `tblorder` DISABLE KEYS */;
INSERT INTO `tblorder` VALUES ('ORD1000001','2021-05-24','Karl Perry','IVN1000001','CCD1000001',42650.00,2132.50,44782.50,'Keefe Sellers','Colby Bernard'),('ORD1000002','2021-05-31','Alex Smith','IVN1000002','CCD1000002',396250.00,19812.50,416062.50,'Joan Romero','Colby Bernard'),('ORD1000003','2021-05-31','Alex Smith','IVN1000003','CCD1000003',81500.00,4075.00,85575.00,'Joan Romero','Colby Bernard'),('ORD1000004','2021-06-03','Karl Perry','IVN1000004','CCD1000004',662500.00,33125.00,695625.00,'Keefe Sellers','Colby Bernard'),('ORD1000005','2021-06-03','Kelly Clark','IVN1000005','CCD1000005',131250.00,6562.50,137812.50,'John Martin','David Bolivar'),('ORD1000006','2021-06-18','Alex Smith','IVN1000006','CCD1000002',61500.00,3075.00,64575.00,'Christian Davis','David Bolivar'),('ORD1000007','2021-07-15','Kelly Clark','IVN1000007','CCD1000006',86000.00,4300.00,90300.00,'Joan Romero','David Bolivar'),('ORD1000008','2021-07-15','Karl Perry','IVN1000008','CCD1000005',42650.00,2132.50,44782.50,'John Martin','David Bolivar'),('ORD1000009','2021-07-15','Alex Smith','IVN1000009','CCD1000002',507500.00,25375.00,532875.00,'Keefe Sellers','David Bolivar'),('ORD1000010','2021-08-01','Kelly Clark','IVN1000010','CCD1000006',662500.00,33125.00,695625.00,'Joan Romero','David Bolivar');
/*!40000 ALTER TABLE `tblorder` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-23 15:26:24
