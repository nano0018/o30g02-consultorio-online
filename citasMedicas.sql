CREATE DATABASE  IF NOT EXISTS `citasmedicas` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `citasmedicas`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: citasmedicas
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `citamedicdto`
--

DROP TABLE IF EXISTS `citamedicdto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `citamedicdto` (
  `idmedical_appointment` int NOT NULL,
  `especialidad` varchar(255) DEFAULT NULL,
  `fechaCita` datetime(6) DEFAULT NULL,
  `nombreMedico` varchar(255) DEFAULT NULL,
  `nombrePaciente` varchar(255) DEFAULT NULL,
  `observaciones` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idmedical_appointment`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citamedicdto`
--

LOCK TABLES `citamedicdto` WRITE;
/*!40000 ALTER TABLE `citamedicdto` DISABLE KEYS */;
/*!40000 ALTER TABLE `citamedicdto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctordto`
--

DROP TABLE IF EXISTS `doctordto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctordto` (
  `idDoctor` int NOT NULL,
  `nombreMedico` varchar(255) DEFAULT NULL,
  `especialidad` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idDoctor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctordto`
--

LOCK TABLES `doctordto` WRITE;
/*!40000 ALTER TABLE `doctordto` DISABLE KEYS */;
/*!40000 ALTER TABLE `doctordto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctors`
--

DROP TABLE IF EXISTS `doctors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctors` (
  `idDoctor` int NOT NULL AUTO_INCREMENT,
  `area` varchar(45) NOT NULL,
  `id_workers` int NOT NULL,
  PRIMARY KEY (`idDoctor`),
  KEY `fk_doctors_workers1_idx` (`id_workers`),
  CONSTRAINT `fk_doctors_workers1` FOREIGN KEY (`id_workers`) REFERENCES `workers` (`idworkers`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctors`
--

LOCK TABLES `doctors` WRITE;
/*!40000 ALTER TABLE `doctors` DISABLE KEYS */;
INSERT INTO `doctors` VALUES (10,'General',103698852),(11,'General',103698855),(12,'General',103698866),(13,'General',103698857),(14,'General',103698858),(15,'General',103698861),(16,'General',103698862),(17,'General',103698864),(18,'General',103698865);
/*!40000 ALTER TABLE `doctors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medical_appointment`
--

DROP TABLE IF EXISTS `medical_appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medical_appointment` (
  `idmedical_appointment` int NOT NULL AUTO_INCREMENT,
  `user_userId` int NOT NULL,
  `doctors_idDoctor` int NOT NULL,
  `observations` text,
  `medical_appointment_date` date NOT NULL,
  PRIMARY KEY (`idmedical_appointment`),
  KEY `fk_medical_appointment_user1_idx` (`user_userId`),
  KEY `fk_medical_appointment_doctors1_idx` (`doctors_idDoctor`),
  CONSTRAINT `fk_medical_appointment_doctors1` FOREIGN KEY (`doctors_idDoctor`) REFERENCES `doctors` (`idDoctor`),
  CONSTRAINT `fk_medical_appointment_user1` FOREIGN KEY (`user_userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical_appointment`
--

LOCK TABLES `medical_appointment` WRITE;
/*!40000 ALTER TABLE `medical_appointment` DISABLE KEYS */;
INSERT INTO `medical_appointment` VALUES (28,9289936,13,'Ninguna','2022-09-07');
/*!40000 ALTER TABLE `medical_appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(40) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(60) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `userLastName` varchar(45) NOT NULL,
  `userNum` varchar(45) NOT NULL,
  `userId` int NOT NULL AUTO_INCREMENT,
  `userRole` varchar(45) DEFAULT 'USER',
  PRIMARY KEY (`userId`),
  UNIQUE KEY `userId_UNIQUE` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=179698859 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('Andres','khkljh@pojoi.com','123456','2022-09-19 05:00:00','ojghkjgk','1565165156156',9289936,'USER'),('Gram','gpimleyd@symantec.com','123456','2022-09-17 01:33:04','Pimley','4311317152',10239965,'USER'),('Beatrisa','bjukubczak8@i2i.jp','123456','2022-09-17 01:33:04','Jukubczak','6906746158',101598868,'USER'),('Frederique','freidec@examiner.com','123456','2022-09-17 01:33:04','Reide','1406140234',102236556,'USER'),('Emmie','eroach1@bloomberg.com','123456','2022-09-17 01:33:04','Roach','3486720685',103658854,'USER'),('Edik','emackellar3@devhub.com','123456','2022-09-17 01:33:04','MacKellar','3784128865',103698856,'USER'),('Alford','aharmour9@hao123.com','123456','2022-09-17 01:33:04','Harmour','9764593956',103698860,'USER'),('Duffy','dconochieb@multiply.com','123456','2022-09-17 01:33:04','Conochie','2904640071',103698863,'USER'),('Kingsly','kelverston2@baidu.com','123456','2022-09-17 01:33:04','Elverston','5593710134',103798855,'USER'),('Tammi','tgillani0@rambler.ru','123456','2022-09-17 01:32:29','Gillani','8936999017',104698852,'USER'),('Cletus','cgarret6@cbslocal.com','123456','2022-09-17 01:33:04','Garret','8879461093',104998859,'USER'),('Idell','iwaylena@unesco.org','123456','2022-09-17 01:33:04','Waylen','2408221797',109448860,'USER'),('Juliana','jclench4@nih.gov','123456','2022-09-17 01:33:04','Clench','3739040421',113498857,'USER'),('Hurleigh','hhouse7@scientificamerican.com','123456','2022-09-17 01:33:04','House','2179817076',129998861,'USER'),('Curtice','ccuerdale5@webs.com','123456','2022-09-17 01:33:04','Cuerdale','4744743204',179698858,'USER');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workers`
--

DROP TABLE IF EXISTS `workers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workers` (
  `idworkers` int NOT NULL AUTO_INCREMENT,
  `workerName` varchar(45) NOT NULL,
  `workerLastName` varchar(45) NOT NULL,
  `workerEmployment` varchar(45) NOT NULL,
  `workerSalary` double NOT NULL,
  `workerTel` varchar(45) NOT NULL,
  `typeContract` varchar(45) NOT NULL,
  `workerPassword` varchar(60) NOT NULL,
  PRIMARY KEY (`idworkers`),
  UNIQUE KEY `idworkers_UNIQUE` (`idworkers`)
) ENGINE=InnoDB AUTO_INCREMENT=103698867 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workers`
--

LOCK TABLES `workers` WRITE;
/*!40000 ALTER TABLE `workers` DISABLE KEYS */;
INSERT INTO `workers` VALUES (103698852,'Elisabetta','Mellers','DOCTOR',1526298,'7739322544','Fijo','123456'),(103698854,'Leilah','Billing','ADMIN',2537314,'5648438009','Fijo','123456'),(103698855,'Odele','Ridgwell','DOCTOR',1611572,'5354380378','Fijo','123456'),(103698856,'Vern','McOrkil','ADMIN',1736402,'9189086497','Fijo','123456'),(103698857,'Hersh','Wiz','DOCTOR',2010098,'4057029387','Fijo','123456'),(103698858,'Terrijo','Alessandrucci','DOCTOR',2915594,'9249116203','Fijo','123456'),(103698859,'Isa','Belvard','ADMIN',2038969,'2031038456','Fijo','123456'),(103698860,'Mame','Buffy','ADMIN',2409293,'2366696995','Fijo','123456'),(103698861,'Deedee','Peeke','DOCTOR',1829127,'2673581130','Fijo','123456'),(103698862,'Lance','Sansam','DOCTOR',1692420,'2353638673','Fijo','123456'),(103698863,'Maxwell','Borrow','ADMIN',3266801,'3252093128','Fijo','123456'),(103698864,'Rowland','Posten','DOCTOR',2471177,'7311904805','Fijo','123456'),(103698865,'Demeter','Al Hirsi','DOCTOR',1728340,'6178576455','Fijo','123456'),(103698866,'Akjghkj','UIghiugsdi','DOCTOR',1516165156,'5165156156','OPS','123456');
/*!40000 ALTER TABLE `workers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-20 16:55:37
