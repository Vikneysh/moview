-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: moviewdb
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
-- Table structure for table `authentication`
--

DROP TABLE IF EXISTS `authentication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authentication` (
  `Sno` int NOT NULL AUTO_INCREMENT,
  `userId` int DEFAULT NULL,
  `userName` varchar(45) DEFAULT NULL,
  `sessionID` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`Sno`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authentication`
--

LOCK TABLES `authentication` WRITE;
/*!40000 ALTER TABLE `authentication` DISABLE KEYS */;
INSERT INTO `authentication` VALUES (15,1,'Admin','7AF20FDA1FF22D128E110A2B2979959B');
/*!40000 ALTER TABLE `authentication` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blogs`
--

DROP TABLE IF EXISTS `blogs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blogs` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `body` varchar(5000) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `img` varchar(200) DEFAULT 'https://source.unsplash.com/random/720x400/?movies',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blogs`
--

LOCK TABLES `blogs` WRITE;
/*!40000 ALTER TABLE `blogs` DISABLE KEYS */;
INSERT INTO `blogs` VALUES (1,'Reach the Rock','“Reach the Rock” plays like an experiment to see how much a movie can be slowed down before it stops. It was produced and written by John Hughes, who should have donated his screenplay to a nearby day-care center for use by preschoolers in constructing paper chains. How can the man who made “Planes, Trains and Automobiles” have thought this material was filmable? The story involves an unhappy young man named Robin (Alessandro Nivola), who in the opening scene uses a flagpole to break the window of a hardware store. When Ernie the small-town cop (Bruce Norris) arrives, he finds Robin seated in a beach chair before the window, cooling himself with an electric fan. Robin is returned to the station, where the only other cop on the overnight shift is Sgt. Phil Quinn (William Sadler).','2022-06-13','https://source.unsplash.com/random/720x400/?movies'),(2,'Sample','This is a sample','2001-11-02','https://source.unsplash.com/random/720x400/?movies'),(3,'Sample2','This is another sample\n','2006-11-14','https://source.unsplash.com/random/720x400/?fruit'),(4,'Sample3','Samle\n','2001-11-02','https://source.unsplash.com/random/720x400/?movies'),(5,'SAmple5','Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n\nThe standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.','2006-07-02','https://source.unsplash.com/random/720x400/?movies'),(8,'Mottu','Mottu','2001-11-02','https://source.unsplash.com/random/720x400/?movies'),(9,'New Blog','This is a new blog!','2022-06-20','https://source.unsplash.com/random/720x400/?movies'),(10,'NewBLog1','Hello!\n','2001-11-02','https://source.unsplash.com/random/720x400/?movies');
/*!40000 ALTER TABLE `blogs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crewmember`
--

DROP TABLE IF EXISTS `crewmember`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `crewmember` (
  `id` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crewmember`
--

LOCK TABLES `crewmember` WRITE;
/*!40000 ALTER TABLE `crewmember` DISABLE KEYS */;
INSERT INTO `crewmember` VALUES (1,'Kamal Hassan','Male'),(2,'Fahadh Fassil','Male'),(3,'Vijay Sethupathi','Male'),(4,'Surya Sivakumar','Male'),(5,'Narain','Male'),(6,'Jr. NTR','Male'),(7,'Ram Charan','Male'),(8,'Alia Bhatt','Female'),(9,'Olivia Morris','Female'),(10,'Ajay Devgn','Male'),(11,'Shriya Saran','Female'),(12,'Rajnikanth','Male'),(13,'Aishwarya Rai','Female'),(14,'Santhanam ','Male'),(15,'Karunas','Male'),(16,'Devadarshini','Female');
/*!40000 ALTER TABLE `crewmember` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genres`
--

DROP TABLE IF EXISTS `genres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genres` (
  `genreId` int NOT NULL,
  `genreName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`genreId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genres`
--

LOCK TABLES `genres` WRITE;
/*!40000 ALTER TABLE `genres` DISABLE KEYS */;
INSERT INTO `genres` VALUES (1,'Action'),(2,'Thriller'),(3,'Drama'),(4,'Sci-fi');
/*!40000 ALTER TABLE `genres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `messages`
--

DROP TABLE IF EXISTS `messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `messages` (
  `msgId` int NOT NULL AUTO_INCREMENT,
  `uname` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `message` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`msgId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messages`
--

LOCK TABLES `messages` WRITE;
/*!40000 ALTER TABLE `messages` DISABLE KEYS */;
INSERT INTO `messages` VALUES (1,'Viks','neqfcqsh@outlook.com','HEllo'),(2,'Viks','vikneysh_it@mepcoeng.ac.in','Hi here'),(3,'Hello','hello@gmail.com','Hello World'),(4,'Hello','hello@gmail.com','Hello World'),(5,'Hello','hello@hello.com','Hello Moview!'),(15,'Viks','vikneyshraj@gmail.com','Hello !!');
/*!40000 ALTER TABLE `messages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `movieId` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `year` int DEFAULT NULL,
  `language` varchar(45) DEFAULT NULL,
  `rating` float DEFAULT NULL,
  `review` varchar(10000) DEFAULT NULL,
  `director` varchar(45) DEFAULT NULL,
  `musicDirector` varchar(45) DEFAULT NULL,
  `img` varchar(200) DEFAULT NULL,
  `trailer` varchar(200) DEFAULT NULL,
  `ratingCount` int DEFAULT NULL,
  PRIMARY KEY (`movieId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'Vikram',2022,'Tamil',7.33333,'Amar is assigned to investigate a case of serial killings. When Amar investigates the case, he realizes it is not what it seems to be and following down this path will lead to nothing but war between everyone involved.','Lokesh Kanagaraj','Anirudh Ravichander','https://static.toiimg.com/photo/91660096.jpeg','https://www.youtube.com/embed/OKBMCL-frPU',3),(2,'RRR',2022,'Telugu',4,'When it comes to cinematic propaganda, blatant is better than insidious. Overt advocacy has the virtue of candor and the vigor of fervent emotion. A movie such as “Top Gun: Maverick” hides its messages under the guise of unexceptionable realities, whereas another new, high-energy, political action spectacle, the Indian film “RRR” (which was released theatrically in March and is now streaming on Netflix, where it’s in the top five), makes its statements explicit. It thrusts its imaginative artistry thrillingly and gleefully to the fore.','SS Rajamouli','MM Keeravai','https://images.hindustantimes.com/img/2022/04/01/1600x900/RRR-Movie-Review_1648825470847_1648825479894.jpg','https://www.youtube.com/embed/oO8TTM2FgIA',1),(3,'Enthiran',2010,'Tamil',8,'In ‘Endhiran’, Indian narration meets the Hollywood of Matrix and Terminators with satisfactory results, the high point being a robot that shoots from its fingertip. This is what we are so very good at: telling a story or lapping up one with a willing suspension of disbelief, with a rooted belief in the triumph of good over evil. And like all entertaining stories, this one makes you laugh a lot, wince a little and eventually come away wiping a tear.','S Shankar','A R Rahman','https://venkatarangan.com/blog/wp-content/uploads/2010/10/endhiran.jpg','https://www.youtube.com/embed/5F3H9_pYpYg',1),(4,'Kaatru Veliyidai',2017,'Tamil',8,'Kaatru Veliyidai opens with scenes of fighting between the Indian and Pakistani army. We see a pilot, Varun aka VC (Karthi), being captured by the Pakistani army. But very soon, we realise that this is a film about the battle between two hearts — in other words, not Roja!','Mani Ratnam','A R Rahman','https://images.hindustantimes.com/rf/image_size_960x540/HT/p2/2017/04/07/Pictures/karthi-veliyidai-aditi-rao-hydari-kaatru-poster_c5458614-1b6a-11e7-8dd7-d947b0232760.jpg','https://www.youtube.com/embed/xZS21vNdUyQ',1);
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_crew`
--

DROP TABLE IF EXISTS `movie_crew`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_crew` (
  `cId` int DEFAULT NULL,
  `mId` int DEFAULT NULL,
  KEY `mId_idx` (`mId`),
  KEY `cId` (`cId`),
  CONSTRAINT `cId` FOREIGN KEY (`cId`) REFERENCES `crewmember` (`id`),
  CONSTRAINT `mId` FOREIGN KEY (`mId`) REFERENCES `movie` (`movieId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_crew`
--

LOCK TABLES `movie_crew` WRITE;
/*!40000 ALTER TABLE `movie_crew` DISABLE KEYS */;
INSERT INTO `movie_crew` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(6,2),(7,2),(8,2),(9,2),(10,2),(11,2),(12,3),(13,3),(14,3),(15,3),(16,3);
/*!40000 ALTER TABLE `movie_crew` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_genre`
--

DROP TABLE IF EXISTS `movie_genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_genre` (
  `movieID` int DEFAULT NULL,
  `genreId` int DEFAULT NULL,
  KEY `genreId_idx` (`genreId`),
  KEY `movieId` (`movieID`),
  CONSTRAINT `genreId` FOREIGN KEY (`genreId`) REFERENCES `genres` (`genreId`),
  CONSTRAINT `movieId` FOREIGN KEY (`movieID`) REFERENCES `movie` (`movieId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_genre`
--

LOCK TABLES `movie_genre` WRITE;
/*!40000 ALTER TABLE `movie_genre` DISABLE KEYS */;
INSERT INTO `movie_genre` VALUES (1,1),(1,2),(2,1),(2,3),(3,1),(3,4);
/*!40000 ALTER TABLE `movie_genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `role` varchar(45) DEFAULT 'user',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin@moview.in','Admin','74c34dad86be68b7d220dee41a2be16d','2001-11-02','admin'),(2,'vikneyshraj@gmail.com','Vikneysh','2a968e168f4949ffdc4ffddb131c1fcb','2001-11-02','user'),(15,'shree@gmail.com','Shree','e10adc3949ba59abbe56e057f20f883e','2006-07-14','user'),(16,'raj@test.in','Raj','827ccb0eea8a706c4c34a16891f84e7b','2001-11-02','user'),(17,'shree@gmail.com','Shree','81dc9bdb52d04dc20036dbd8313ed055','2001-11-02','user');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_rating`
--

DROP TABLE IF EXISTS `user_rating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_rating` (
  `movieId` int NOT NULL,
  `userId` int NOT NULL,
  `rating` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userId`,`movieId`),
  KEY `userId_idx` (`userId`),
  CONSTRAINT `userId` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_rating`
--

LOCK TABLES `user_rating` WRITE;
/*!40000 ALTER TABLE `user_rating` DISABLE KEYS */;
INSERT INTO `user_rating` VALUES (1,2,'8'),(2,2,'4'),(3,2,'8'),(1,15,'5'),(1,16,'9'),(4,16,'8');
/*!40000 ALTER TABLE `user_rating` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-21 15:54:26
