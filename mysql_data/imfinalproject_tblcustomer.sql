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
-- Table structure for table `tblcustomer`
--

DROP TABLE IF EXISTS `tblcustomer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblcustomer` (
  `CustomerCode` varchar(10) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `CompanyName` varchar(30) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `PhoneNumber` varchar(15) DEFAULT NULL,
  `Fax` varchar(15) DEFAULT NULL,
  `CellNumber` varchar(15) NOT NULL,
  `Email` varchar(30) NOT NULL,
  PRIMARY KEY (`CustomerCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblcustomer`
--

LOCK TABLES `tblcustomer` WRITE;
/*!40000 ALTER TABLE `tblcustomer` DISABLE KEYS */;
INSERT INTO `tblcustomer` VALUES ('CCD1000001','Cliff Jones','Studio Wed Inc.','711-2880 Nulla St. Mankato Mississippi 96522','202-555-0745','+441619998888','(482) 205-8929','cliff.jones@gmail.com'),('CCD1000002','Jenifer Tyler','Rotary Foundation','P.O. Box 283 8562 Fusce Rd.Frederick Nebraska 20620','','222 8888','(877) 611-0880','jnftyler@gmail.com'),('CCD1000003','Celeste Slater','Maverick Helpers','606-3727 Ullamcorper. Street Roseville NH 11523','202-555-0537','','(786) 713-8616','slaterceleste@gmail.com'),('CCD1000004','Kyla Olsen','Idea Masters Inc.','Ap #651-8679 Sodales Av. Tamuning PA 10855','202-555-0377','0161 999 8888','(654) 393-5734','kyla_olsen@gmail.com'),('CCD1000005','Sophia Jackson','Maple Builders Corp.','894 Tchesinkut Lake Rd, Vanderhoof, British Columbia, Canada','250-567-6932','','+16135550158','jackson.sophia@hotmail.com'),('CCD1000006','EarlySeven Strikeland','','69 Jonam Street, Metrobarrier Complex, Mariveles, Bataan, PHL','','','+639260451696','agapitohampaslupa@gmail.com');
/*!40000 ALTER TABLE `tblcustomer` ENABLE KEYS */;
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
