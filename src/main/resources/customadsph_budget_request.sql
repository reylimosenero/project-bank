CREATE DATABASE  IF NOT EXISTS `customadsph` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `customadsph`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: customadsph
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `budget_request`
--

DROP TABLE IF EXISTS `budget_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `budget_request` (
  `id` int NOT NULL AUTO_INCREMENT,
  `balance` double NOT NULL,
  `bank_details` varchar(255) DEFAULT NULL,
  `client` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `down_payment` double NOT NULL,
  `dp_date` date DEFAULT NULL,
  `paid_date` date DEFAULT NULL,
  `project_name` varchar(255) DEFAULT NULL,
  `request_date` date DEFAULT NULL,
  `request_type` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `supplier` varchar(255) DEFAULT NULL,
  `wallet` varchar(255) DEFAULT NULL,
  `client_name` varchar(255) DEFAULT NULL,
  `supplier_name` varchar(255) DEFAULT NULL,
  `tot_amount` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `budget_request`
--

LOCK TABLES `budget_request` WRITE;
/*!40000 ALTER TABLE `budget_request` DISABLE KEYS */;
INSERT INTO `budget_request` VALUES (1,25000,'123456','Rey','08201977',25000,'1977-08-20','1977-08-20','budget','1977-08-20','Raw Materials','paid','Bhe Divi','0916','Rey','Cristy',0),(2,75000,'BANK',NULL,NULL,25000,'1977-08-20','1977-08-20','PAYONG','1977-08-20','RAW MAT','paid',NULL,'WALLET','NAME','BHE',1000),(3,50000,'123456',NULL,NULL,50000,'1977-08-20','1977-08-20','Payong','1977-08-20','Raw Materials','pending',NULL,'0916','Rey','Cristy',100000);
/*!40000 ALTER TABLE `budget_request` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-29 23:54:05
