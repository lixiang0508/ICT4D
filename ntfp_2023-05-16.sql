# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.29)
# Database: ntfp
# Generation Time: 2023-05-16 09:48:57 +0000
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


# Dump of table photo
# ------------------------------------------------------------

DROP TABLE IF EXISTS `photo`;

CREATE TABLE `photo` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `image` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `photo` WRITE;
/*!40000 ALTER TABLE `photo` DISABLE KEYS */;

INSERT INTO `photo` (`id`, `product_id`, `image`)
VALUES
	(1,1498826404,'/Users/zhanglixiang/Desktop/CSMaster/ict4d/ict4d_demo_backend/Ict4d_backend/src/main/resources/static/img/1684146715472截屏2023-05-07 11.41.34.png'),
	(2,856448188,'/Users/zhanglixiang/Desktop/CSMaster/ict4d/ict4d_demo_backend/Ict4d_backend/src/main/resources/static/img/1684149328821pic1.png'),
	(3,1486556676,'/Users/zhanglixiang/Desktop/CSMaster/ict4d/ict4d_demo_backend/Ict4d_backend/src/main/resources/static/img/1684150568043pic2.png'),
	(5,374199921,'/Users/zhanglixiang/Desktop/Ict4d_shop1/images/1684154873004pic2.png'),
	(6,1430109594,'/Users/zhanglixiang/Desktop/Ict4d_shop1/images/1684155306781pic1.png'),
	(7,790759627,'/Users/zhanglixiang/Desktop/Ict4d_shop1/images/1684155554969pic1.png');

/*!40000 ALTER TABLE `photo` ENABLE KEYS */;
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
  `contact` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `Product` WRITE;
/*!40000 ALTER TABLE `Product` DISABLE KEYS */;

INSERT INTO `Product` (`id`, `user_id`, `category_id`, `name`, `quantity`, `price`, `address`, `information`, `user_name`, `contact`)
VALUES
	(374199921,NULL,1,'aa234',2,23,'Cornelis Lelylaan','etyhwew cf','Lixiang Zhang','+310626508877'),
	(790759627,NULL,1,'product111',100,100,'Cornelis Lelylaan','100100','Lixiang Zhang','+310626508877'),
	(856448188,NULL,1,'Zhang',3,3,'Cornelis Lelylaan','ttt','lixiangzhang','+310626508877'),
	(1430109594,NULL,1,'sdlast',1,4,'Cornelis Lelylaan','The last','Lixiang Zhang','+310626508877'),
	(1486556676,NULL,2,'tu76gy',5,5,'Cornelis Lelylaan','yyyyy','Lixiang Zhang','+310626508877'),
	(1498826404,NULL,2,'Zhang',3,4,'Cornelis Lelylaan','uuu','Lixiang Zhang','+310626508877');

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
	(23,'13898862408','c603e1175c38910a70c2f1eebb1dcf4',NULL),
	(24,'zhanglixiang','25d55ad283aa400af464c76d713c07ad',NULL),
	(26,'qtmd','c603e1175c38910a70c2f1eebb1dcf4',NULL),
	(27,'zdj1','c603e1175c38910a70c2f1eebb1dcf4','13940268022');

/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
