/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.7.10-log : Database - bookshop
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bookshop` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bookshop`;

/*Table structure for table `book` */

CREATE TABLE `book` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `typeId` int(11) NOT NULL DEFAULT '1' COMMENT '类别id',
  `bookname` varchar(255) NOT NULL COMMENT '书名',
  `author` varchar(255) NOT NULL COMMENT '作者',
  `publisher` varchar(255) DEFAULT NULL COMMENT '出版社',
  `publish_time` timestamp NULL DEFAULT NULL COMMENT '出版时间',
  `price` double NOT NULL COMMENT '原价',
  `priceoff` double DEFAULT '0' COMMENT '折扣价',
  `ISBN` varchar(255) DEFAULT NULL,
  `description` text COMMENT '简介',
  `catalog` text COMMENT '目录',
  `img` varchar(255) DEFAULT 'assets/images/book-covers/05.jpg' COMMENT '封面图片地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`id`,`typeId`,`bookname`,`author`,`publisher`,`publish_time`,`price`,`priceoff`,`ISBN`,`description`,`catalog`,`img`) values (1,1,'测试','作者','ceshi','1970-11-20 11:25:21',14,14.4,'123123','123123','31221','assets/images/book-covers/04.jpg'),(2,1,'测试书籍','测试作者2','测试出版社2','2018-11-10 21:20:15',11,22,'wawewewe','描述欸荣撒大苏打按时阿斯顿按时啊大',NULL,'assets/images/book-covers/05.jpg'),(14,2,'1222222','123123','213123','2017-12-28 08:00:00',123,132,'12313213','21123121',' ','assets/images/book-covers/05.jpg');

/*Table structure for table `book_type` */

CREATE TABLE `book_type` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `type` varchar(25) NOT NULL DEFAULT '其他' COMMENT '图书类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `book_type` */

insert  into `book_type`(`id`,`type`) values (1,'科技');

/*Table structure for table `t_order` */

CREATE TABLE `t_order` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL COMMENT '用户id',
  `bookid` int(11) NOT NULL COMMENT '书本id',
  `sum` int(11) NOT NULL DEFAULT '1' COMMENT '购买数量',
  `send_check` int(2) NOT NULL DEFAULT '0' COMMENT '发货标志',
  `upload_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单提交时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `t_order` */

insert  into `t_order`(`id`,`userid`,`bookid`,`sum`,`send_check`,`upload_time`) values (1,1,1,1,0,'2018-01-10 14:41:19'),(5,1,2,1,0,'2018-01-11 15:13:03'),(6,1,1,1,0,'2018-01-11 15:13:03');

/*Table structure for table `user` */

CREATE TABLE `user` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `points` int(11) NOT NULL DEFAULT '0' COMMENT '积分',
  `role` int(1) NOT NULL COMMENT '0:normal 1:admin',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`points`,`role`) values (1,'admin','admin',1,1),(2,'test','test',0,0),(3,'test1','test1',0,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
