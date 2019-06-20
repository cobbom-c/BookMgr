-- 详细设计课程设计 用到的表 都是照着当时的讨论来的。
-- 有三个不同角色的测试用户：
-- 管理员 用户名：admin 密码：admin
-- 老师 teacher teacher
-- 学生 user user
-- 可以用这三个用户登陆进系统
-- 直接在地址栏输localhost:8080会跳转过去的。
-- 
-- P.S. 记得改数据库的连接配置！
-- 这回是在/src/main/resources下面的application.properties里面改。
-- 
-- 执行这个脚本，将会在本地数据库中新建一个名为bookmgr的数据库，
-- 里面有各种表（当然是空的）
USE bookmgr;

-- MySQL dump 10.13  Distrib 5.7.26, for Linux (x86_64)
--
-- Host: localhost    Database: bookmgr
-- ------------------------------------------------------
-- Server version	5.7.26-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'admin','admin');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_ticket`
--

DROP TABLE IF EXISTS `admin_ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin_ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ticket` varchar(45) COLLATE utf8_bin NOT NULL,
  `uid` int(11) NOT NULL,
  `expired` datetime NOT NULL,
  `status` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ticket` (`ticket`),
  KEY `uid` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_ticket`
--

LOCK TABLES `admin_ticket` WRITE;
/*!40000 ALTER TABLE `admin_ticket` DISABLE KEYS */;
INSERT INTO `admin_ticket` VALUES (1,'70c0ef7bc178430aa72bf91af8cbbac8',1,'2019-06-19 05:10:59',0),(2,'43703b6ca2ce4681a69892c2fa86f572',1,'2019-06-19 05:40:21',0),(3,'60c25445e3fb4717a8f76932fc26a102',1,'2019-06-19 05:41:17',1),(4,'e2f9e7103a2b4bbf9f71a3fdc236aee8',1,'2019-06-19 05:46:16',0),(5,'c32b77ad37a64fd0948e374a6e441caf',1,'2019-06-19 06:32:16',0),(6,'d4987cce275d458cb5097bc50b266408',1,'2019-06-19 06:39:58',0),(7,'5c0ca2c973a14643a677488b24b068f8',1,'2019-06-19 06:45:37',0),(8,'1316ec92618b4fe1a07696fea76556f5',1,'2019-06-19 06:45:45',0),(9,'258ec3d1218047d2b98fd02ca19be4e2',1,'2019-06-19 07:16:18',0),(10,'bf89edf196a346238ad8dcf46f9fee89',1,'2019-06-19 07:47:38',0),(11,'39e701b382d24142b15a5b092d118d0b',1,'2019-06-19 08:40:02',0),(12,'3fe7653d542f48d4936e6a9ff94cc385',1,'2019-06-19 09:10:49',0),(13,'40da8fc275ab4a619979cb6888e7cc21',1,'2019-06-19 09:41:01',0),(14,'d9cd91c3076b43498989848318c340ee',1,'2019-06-19 10:34:54',0),(15,'479616373b82498ca140d94e0b81989e',1,'2019-06-19 11:05:57',0),(16,'5f67395bca5643de84fa46307c2cae54',1,'2019-06-19 11:40:44',0),(17,'0627229098b44a4694b58c848728b588',1,'2019-06-19 22:31:23',0),(18,'ad252e555a52416eae844b94576af618',1,'2019-06-19 23:03:56',0),(19,'7970ba8b390b476db986ce56d6f16449',1,'2019-06-20 00:06:36',0),(20,'f576b245db8f4aaab3fe1485865b15d6',1,'2019-06-20 00:37:30',0),(21,'4114de2fc75c461e9d8d2887a5255f1c',1,'2019-06-20 01:09:34',0),(22,'7c46a76250a34eeea55255d36cf2e077',1,'2019-06-20 01:40:01',0),(23,'c468b44dc46e4d54900f7a81ea2ab7c6',1,'2019-06-20 02:14:16',0),(24,'09d4bf2738444040be68edb5f561abcf',1,'2019-06-20 02:45:26',0),(25,'68498c3c50d044699b7ff6b904f7bc9e',1,'2019-06-20 03:38:41',0),(26,'30e09d6d58854651877b322fa1ebddb0',1,'2019-06-20 04:11:47',0);
/*!40000 ALTER TABLE `admin_ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attend`
--

DROP TABLE IF EXISTS `attend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attend` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) DEFAULT NULL,
  `lid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_cid_lid` (`cid`,`lid`),
  KEY `fk_attend_lesson_idx` (`lid`),
  CONSTRAINT `fk_attend_class` FOREIGN KEY (`cid`) REFERENCES `class` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_attend_lesson` FOREIGN KEY (`lid`) REFERENCES `lesson` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attend`
--

LOCK TABLES `attend` WRITE;
/*!40000 ALTER TABLE `attend` DISABLE KEYS */;
INSERT INTO `attend` VALUES (3,3,2),(2,4,2);
/*!40000 ALTER TABLE `attend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `detail_id` int(11) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_book_detail_idx` (`detail_id`),
  CONSTRAINT `fk_book_detail` FOREIGN KEY (`detail_id`) REFERENCES `book_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (3,3,'待审核'),(5,5,'待审核');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_detail`
--

DROP TABLE IF EXISTS `book_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `ISBN` varchar(45) DEFAULT NULL,
  `edition` varchar(20) DEFAULT NULL,
  `chief_editor` varchar(20) DEFAULT NULL,
  `institute` varchar(45) DEFAULT NULL,
  `pub_date` varchar(45) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  `price` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_detail`
--

LOCK TABLES `book_detail` WRITE;
/*!40000 ALTER TABLE `book_detail` DISABLE KEYS */;
INSERT INTO `book_detail` VALUES (3,'线性代数','12222221XASQW324R5G4B','3','CHD','CHD','2016-09-20','CHD',2.33),(5,'如何做好软件详细设计课程设计','XASQW324R5G4B','3','CHD','CHD','2016-09-20','CHD',22.33);
/*!40000 ALTER TABLE `book_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_order`
--

DROP TABLE IF EXISTS `book_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bid` int(11) NOT NULL,
  `num` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_book_order_bookref_idx` (`bid`),
  CONSTRAINT `fk_book_order_bookref` FOREIGN KEY (`bid`) REFERENCES `book` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_order`
--

LOCK TABLES `book_order` WRITE;
/*!40000 ALTER TABLE `book_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `book_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `grade` varchar(45) NOT NULL,
  `mid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_class_major_idx` (`mid`),
  CONSTRAINT `fk_class_major` FOREIGN KEY (`mid`) REFERENCES `major` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` VALUES (3,'2016240206','大三',5),(4,'2016240207','大三',5);
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instruct`
--

DROP TABLE IF EXISTS `instruct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instruct` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tid` int(11) DEFAULT NULL,
  `lid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_tid_lid` (`tid`,`lid`),
  KEY `fk_instruct_lesson_idx` (`lid`),
  CONSTRAINT `fk_instruct_lesson` FOREIGN KEY (`lid`) REFERENCES `lesson` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_instruct_teacher` FOREIGN KEY (`tid`) REFERENCES `teacher` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instruct`
--

LOCK TABLES `instruct` WRITE;
/*!40000 ALTER TABLE `instruct` DISABLE KEYS */;
INSERT INTO `instruct` VALUES (3,3,2);
/*!40000 ALTER TABLE `instruct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lesson`
--

DROP TABLE IF EXISTS `lesson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lesson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `detail_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_lesson_detail_idx` (`detail_id`),
  CONSTRAINT `fk_lesson_detail` FOREIGN KEY (`detail_id`) REFERENCES `lesson_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lesson`
--

LOCK TABLES `lesson` WRITE;
/*!40000 ALTER TABLE `lesson` DISABLE KEYS */;
INSERT INTO `lesson` VALUES (2,'软件详细设计',2);
/*!40000 ALTER TABLE `lesson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lesson_detail`
--

DROP TABLE IF EXISTS `lesson_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lesson_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lesson_code` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `education` varchar(45) DEFAULT NULL,
  `pos` varchar(100) DEFAULT NULL,
  `language` varchar(20) DEFAULT NULL,
  `max_stunum` int(11) DEFAULT NULL,
  `stunum` int(11) DEFAULT NULL,
  `begin_week` tinyint(4) DEFAULT NULL,
  `end_week` tinyint(4) DEFAULT NULL,
  `total_week` tinyint(4) DEFAULT NULL,
  `hours_weekly` tinyint(4) DEFAULT NULL,
  `practice_week` tinyint(4) DEFAULT NULL,
  `total_hours` int(11) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `semaster` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lesson_detail`
--

LOCK TABLES `lesson_detail` WRITE;
/*!40000 ALTER TABLE `lesson_detail` DISABLE KEYS */;
INSERT INTO `lesson_detail` VALUES (2,'X23333','选修','本科','CHDDDDDDDDDDD','CHS',NULL,NULL,1,17,16,8,10,233,4,6);
/*!40000 ALTER TABLE `lesson_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `major`
--

DROP TABLE IF EXISTS `major`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `major` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `major`
--

LOCK TABLES `major` WRITE;
/*!40000 ALTER TABLE `major` DISABLE KEYS */;
INSERT INTO `major` VALUES (5,'软件工程'),(6,'计算机科学与技术');
/*!40000 ALTER TABLE `major` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `detail_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_student_detail_idx` (`detail_id`),
  CONSTRAINT `fk_student_detail` FOREIGN KEY (`detail_id`) REFERENCES `student_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (2,'user','user',1);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_detail`
--

DROP TABLE IF EXISTS `student_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `hometown` varchar(45) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_student_detail_class_idx` (`cid`),
  CONSTRAINT `fk_student_detail_class` FOREIGN KEY (`cid`) REFERENCES `class` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_detail`
--

LOCK TABLES `student_detail` WRITE;
/*!40000 ALTER TABLE `student_detail` DISABLE KEYS */;
INSERT INTO `student_detail` VALUES (1,'CK','BHYYYYY',3);
/*!40000 ALTER TABLE `student_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_ticket`
--

DROP TABLE IF EXISTS `student_ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ticket` varchar(45) COLLATE utf8_bin NOT NULL,
  `uid` int(11) NOT NULL,
  `expired` datetime NOT NULL,
  `status` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ticket_UNIQUE` (`ticket`),
  KEY `fk_login_ticket_uid_idx` (`uid`),
  CONSTRAINT `fk_login_ticket_uid` FOREIGN KEY (`uid`) REFERENCES `student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_ticket`
--

LOCK TABLES `student_ticket` WRITE;
/*!40000 ALTER TABLE `student_ticket` DISABLE KEYS */;
INSERT INTO `student_ticket` VALUES (1,'88ac3442d8494009a9ec4c20620e6568',2,'2019-06-19 05:12:19',1),(2,'79141d43b2d54b5da32d323a683eda9c',2,'2019-06-19 05:46:01',1);
/*!40000 ALTER TABLE `student_ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `detail_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_teacher_detail_idx` (`detail_id`),
  CONSTRAINT `fk_teacher_detail` FOREIGN KEY (`detail_id`) REFERENCES `teacher_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (3,'teacher','teacher',11);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_detail`
--

DROP TABLE IF EXISTS `teacher_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_detail`
--

LOCK TABLES `teacher_detail` WRITE;
/*!40000 ALTER TABLE `teacher_detail` DISABLE KEYS */;
INSERT INTO `teacher_detail` VALUES (11,'杜瑾','123444444445','233@chd.edu.cn');
/*!40000 ALTER TABLE `teacher_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_ticket`
--

DROP TABLE IF EXISTS `teacher_ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ticket` varchar(45) COLLATE utf8_bin NOT NULL,
  `uid` int(11) NOT NULL,
  `expired` datetime NOT NULL,
  `status` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ticket` (`ticket`),
  KEY `uid` (`uid`),
  CONSTRAINT `teacher_ticket_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `teacher` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_ticket`
--

LOCK TABLES `teacher_ticket` WRITE;
/*!40000 ALTER TABLE `teacher_ticket` DISABLE KEYS */;
INSERT INTO `teacher_ticket` VALUES (1,'a3cd4c19912d4e51b0d663222495d8c1',3,'2019-06-19 05:11:14',1),(2,'a6e8f8fac93f42769d70c15cdbe28300',3,'2019-06-19 05:13:40',0),(3,'b6d0e77309194377b46beb6b046076d3',3,'2019-06-19 05:40:30',1),(4,'1c83b6b5db6a41fda7819b02432d4928',3,'2019-06-19 05:41:02',1);
/*!40000 ALTER TABLE `teacher_ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `use_book`
--

DROP TABLE IF EXISTS `use_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `use_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lid` int(11) DEFAULT NULL,
  `bid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_lid_bid` (`lid`,`bid`),
  KEY `fk_use_book_bid_idx` (`bid`),
  KEY `fk_use_book_lid_idx` (`lid`),
  CONSTRAINT `fk_use_book_bid` FOREIGN KEY (`bid`) REFERENCES `book` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_use_book_lid` FOREIGN KEY (`lid`) REFERENCES `lesson` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `use_book`
--

LOCK TABLES `use_book` WRITE;
/*!40000 ALTER TABLE `use_book` DISABLE KEYS */;
INSERT INTO `use_book` VALUES (5,2,3);
/*!40000 ALTER TABLE `use_book` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-20 17:17:28
