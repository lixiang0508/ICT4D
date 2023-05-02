# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.29)
# Database: ntfp
# Generation Time: 2023-04-30 20:08:30 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table NutrInfo
# ------------------------------------------------------------

DROP TABLE IF EXISTS `NutrInfo`;

CREATE TABLE `NutrInfo` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `author_id` int(11) DEFAULT NULL,
  `author_name` varchar(256) DEFAULT NULL,
  `content` varchar(256) DEFAULT NULL,
  `title` varchar(256) DEFAULT NULL,
  `likes` int(11) DEFAULT NULL,
  `comments` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `NutrInfo` WRITE;
/*!40000 ALTER TABLE `NutrInfo` DISABLE KEYS */;

INSERT INTO `NutrInfo` (`id`, `author_id`, `author_name`, `content`, `title`, `likes`, `comments`, `create_time`)
VALUES
	(1,1,'zlx','this is a blabla','title1',1,2,NULL),
	(2,1,'abc','this is another','title2',3,2,'2023-04-23 14:39:52'),
	(3,22,'zdj','some content','some title',1,2,NULL);

/*!40000 ALTER TABLE `NutrInfo` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Product
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Product`;

CREATE TABLE `Product` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `name` varchar(256) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `address` varchar(256) DEFAULT NULL,
  `information` varchar(256) DEFAULT NULL,
  `user_name` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `Product` WRITE;
/*!40000 ALTER TABLE `Product` DISABLE KEYS */;

INSERT INTO `Product` (`id`, `user_id`, `category_id`, `name`, `quantity`, `price`, `address`, `information`, `user_name`)
VALUES
	(1,1,2,'ntfp1',2,12.5,'somewhere','Good ','a'),
	(2,19,3,'ntfp2',3,14,'the middle of nowhere','Nice','b'),
	(5,NULL,NULL,NULL,NULL,NULL,NULL,'Excellent','c'),
	(6,19,2,'ntfp3',4,15.6,'somewhere','Awesome','d'),
	(8,1,2,'zhang',12,100.4,'somewhere2','good','ntfp3');

/*!40000 ALTER TABLE `Product` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table ProductComment
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ProductComment`;

CREATE TABLE `ProductComment` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(256) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `comment` varchar(256) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `ProductComment` WRITE;
/*!40000 ALTER TABLE `ProductComment` DISABLE KEYS */;

INSERT INTO `ProductComment` (`id`, `user_id`, `user_name`, `score`, `product_id`, `comment`, `create_time`)
VALUES
	(1,1,'zhang',5,1,'good product','2023-04-25 12:21:16'),
	(2,19,'hejie',10,2,'Very nice','2023-04-25 12:22:09'),
	(3,22,'zdj',4,1,'goood','2023-04-25 15:19:13');

/*!40000 ALTER TABLE `ProductComment` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table users
# ------------------------------------------------------------

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;

INSERT INTO `users` (`id`, `user_name`, `password`, `phone`)
VALUES
	(1,'hejie','19f41cb41807e0856d6414d3f2f6d246','12356731267'),
	(19,'zlxzlx11','5cdf2ec04ed836a7a81a04b72e0c63bb','12345698'),
	(20,'LexusChung','c603e1175c38910a70c2f1eebb1dcf4','15002217164'),
	(21,'Zhang','c603e1175c38910a70c2f1eebb1dcf4','15002217163'),
	(22,'zdj','c603e1175c38910a70c2f1eebb1dcf4','13940268022'),
	(23,'13898862408','c603e1175c38910a70c2f1eebb1dcf4',NULL);

/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
