-- MySQL dump 10.13  Distrib 5.5.34, for debian-linux-gnu (i686)
--
-- Host: localhost    Database: algorithmhome
-- ------------------------------------------------------
-- Server version	5.5.34-0ubuntu0.12.04.1

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
-- Table structure for table `algorithm`
--

DROP TABLE IF EXISTS `algorithm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `algorithm` (
  `id` varchar(36) NOT NULL COMMENT '主键，UUID',
  `name` varchar(45) NOT NULL COMMENT '算法名称',
  `summary` varchar(100) NOT NULL COMMENT '算法简介',
  `price` tinyint(4) NOT NULL COMMENT '算法标价',
  `code` varchar(36) NOT NULL COMMENT '算法源码ID',
  `iodata` varchar(36) NOT NULL COMMENT '输入输出ID',
  `thesis` varchar(36) NOT NULL COMMENT '论文ID',
  `buycount` int(11) NOT NULL DEFAULT '0' COMMENT '已购买次数',
  `status` tinyint(4) NOT NULL COMMENT '1表示已删除，2表示未通过审核，3表示输入输出已审核，4表示输入输出未审核,5表示待审核',
  `createtime` datetime NOT NULL COMMENT '发布时间',
  `uid` varchar(36) NOT NULL COMMENT '上传者ID',
  `cid` tinyint(4) NOT NULL COMMENT '栏目ID',
  `mender` varchar(36) NOT NULL COMMENT '操作者ID',
  `updatetime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_algorithm_mender_idx` (`mender`),
  KEY `fk_algorithm_uid_idx` (`uid`),
  KEY `fk_algorithm_cid_idx` (`cid`),
  KEY `fk_algorithm_thesis_idx` (`thesis`),
  KEY `fk_algorithm_iodata_idx` (`iodata`),
  KEY `fk_algorithm_code_idx` (`code`),
  CONSTRAINT `fk_algorithm_cid` FOREIGN KEY (`cid`) REFERENCES `channel` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_algorithm_code` FOREIGN KEY (`code`) REFERENCES `attachment` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_algorithm_iodata` FOREIGN KEY (`iodata`) REFERENCES `attachment` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_algorithm_mender` FOREIGN KEY (`mender`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_algorithm_thesis` FOREIGN KEY (`thesis`) REFERENCES `attachment` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_algorithm_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `algorithmuser`
--

DROP TABLE IF EXISTS `algorithmuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `algorithmuser` (
  `aid` varchar(36) NOT NULL,
  `uid` varchar(36) NOT NULL,
  PRIMARY KEY (`aid`,`uid`),
  KEY `fk_algorithmuser_uid_idx` (`uid`),
  CONSTRAINT `fk_algorithmuser_aid` FOREIGN KEY (`aid`) REFERENCES `algorithm` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_algorithmuser_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `attachment`
--

DROP TABLE IF EXISTS `attachment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attachment` (
  `id` varchar(36) NOT NULL COMMENT '主键，UUID',
  `hash` varchar(45) NOT NULL COMMENT '七牛云存储返回的文件ID',
  `name` varchar(45) NOT NULL COMMENT '附件的名字，例如xxx.zip 、xxx.doc',
  `status` tinyint(4) NOT NULL COMMENT '1表示已删除，2表示可用',
  `mender` varchar(36) DEFAULT NULL COMMENT '修改者ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `hash_UNIQUE` (`hash`),
  KEY `fk_attachment_mender_idx` (`mender`),
  CONSTRAINT `fk_attachment_mender` FOREIGN KEY (`mender`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `channel`
--

DROP TABLE IF EXISTS `channel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `channel` (
  `id` tinyint(4) NOT NULL AUTO_INCREMENT COMMENT '主键自增长',
  `name` varchar(20) NOT NULL COMMENT '栏目名称',
  `level` tinyint(4) NOT NULL COMMENT '1表示一级栏目，2表示二级栏目，3表示三级栏目',
  `cid` tinyint(4) DEFAULT NULL COMMENT '父栏目ID',
  `mender` varchar(36) DEFAULT NULL COMMENT '修改者ID',
  `status` tinyint(4) NOT NULL COMMENT '1表示已删除，2表示可用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `fk_channel_cid_idx` (`cid`),
  KEY `fk_channel_mender_idx` (`mender`),
  CONSTRAINT `fk_channel_cid` FOREIGN KEY (`cid`) REFERENCES `channel` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_channel_mender` FOREIGN KEY (`mender`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `channeluser`
--

DROP TABLE IF EXISTS `channeluser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `channeluser` (
  `uid` varchar(36) NOT NULL,
  `cid` tinyint(4) NOT NULL,
  PRIMARY KEY (`uid`,`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `id` varchar(36) NOT NULL COMMENT '主键，UUID',
  `content` varchar(45) NOT NULL COMMENT '评论的内容',
  `aid` varchar(36) NOT NULL,
  `uid` varchar(36) NOT NULL,
  `createtime` datetime NOT NULL COMMENT '发布时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `status` tinyint(4) NOT NULL COMMENT '1表示已删除，2表示可用',
  `mender` varchar(36) NOT NULL COMMENT '修改者ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_comment_uid_idx` (`uid`),
  KEY `fk_comment_aid_idx` (`aid`),
  KEY `fk_comment_mender_idx` (`mender`),
  CONSTRAINT `fk_comment_aid` FOREIGN KEY (`aid`) REFERENCES `algorithm` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_comment_mender` FOREIGN KEY (`mender`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_comment_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `meeting`
--

DROP TABLE IF EXISTS `meeting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meeting` (
  `id` varchar(36) NOT NULL,
  `time` datetime NOT NULL,
  `name` varchar(25) NOT NULL,
  `url` varchar(45) NOT NULL,
  `createtime` datetime NOT NULL,
  `updatetime` datetime NOT NULL,
  `status` tinyint(4) NOT NULL COMMENT '1表示已删除，2表示可用',
  `mender` varchar(36) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_meeting_mender_idx` (`mender`),
  CONSTRAINT `fk_meeting_mender` FOREIGN KEY (`mender`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `id` varchar(36) NOT NULL,
  `content` varchar(100) NOT NULL,
  `status` tinyint(4) NOT NULL COMMENT '1表示已删除，2表示未接收，3表示已接收',
  `sender` varchar(36) NOT NULL,
  `receiver` varchar(36) NOT NULL,
  `createtime` datetime NOT NULL,
  `updatetime` datetime NOT NULL,
  `mender` varchar(36) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_message_sender_idx` (`sender`),
  KEY `fk_message_receiver_idx` (`receiver`),
  KEY `fk_message_mender_idx` (`mender`),
  CONSTRAINT `fk_message_mender` FOREIGN KEY (`mender`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_message_receiver` FOREIGN KEY (`receiver`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_message_sender` FOREIGN KEY (`sender`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `moderatorinfo`
--

DROP TABLE IF EXISTS `moderatorinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `moderatorinfo` (
  `id` varchar(32) NOT NULL COMMENT '用户ID，外键',
  `title` varchar(45) NOT NULL COMMENT '职称',
  `degree` varchar(45) NOT NULL,
  `summary` varchar(100) NOT NULL,
  `approve` varchar(36) NOT NULL COMMENT '认证材料ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_moderatorinfo_approve_idx` (`approve`),
  CONSTRAINT `fk_moderatorinfo_approve` FOREIGN KEY (`approve`) REFERENCES `attachment` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_moderatorinfo_id` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question` (
  `id` varchar(36) NOT NULL COMMENT '主键，UUID',
  `content` varchar(100) NOT NULL COMMENT '问题内容',
  `cid` tinyint(4) NOT NULL COMMENT '栏目ID',
  `uid` varchar(36) NOT NULL,
  `rid` varchar(36) DEFAULT NULL COMMENT '答案ID',
  `gold` tinyint(4) NOT NULL,
  `createtime` datetime NOT NULL,
  `updatetime` datetime NOT NULL,
  `mender` varchar(36) NOT NULL,
  `status` tinyint(4) NOT NULL COMMENT '1表示已删除，2表示可用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_question_uid_idx` (`uid`),
  KEY `fk_question_cid_idx` (`cid`),
  KEY `fk_question_mender_idx` (`mender`),
  KEY `fk_question_rid_idx` (`rid`),
  CONSTRAINT `fk_question_cid` FOREIGN KEY (`cid`) REFERENCES `channel` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_question_mender` FOREIGN KEY (`mender`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_question_rid` FOREIGN KEY (`rid`) REFERENCES `reply` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_question_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `reply`
--

DROP TABLE IF EXISTS `reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reply` (
  `id` varchar(36) NOT NULL COMMENT '主键，UUID',
  `content` varchar(100) NOT NULL,
  `uid` varchar(36) NOT NULL,
  `qid` varchar(36) NOT NULL,
  `createtime` datetime NOT NULL,
  `updatetime` datetime NOT NULL,
  `status` tinyint(4) NOT NULL COMMENT '1表示已删除，2表示可用',
  `mender` varchar(36) NOT NULL COMMENT '操作者ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_reply_qid_idx` (`qid`),
  KEY `fk_reply_uid_idx` (`uid`),
  KEY `fk_reply_mender_idx` (`mender`),
  CONSTRAINT `fk_reply_mender` FOREIGN KEY (`mender`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_reply_qid` FOREIGN KEY (`qid`) REFERENCES `question` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_reply_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` varchar(36) NOT NULL COMMENT '主键，UUID',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `email` varchar(30) NOT NULL COMMENT '电子邮箱',
  `password` varchar(32) NOT NULL COMMENT '用username当作盐值，通过MD5算法加密',
  `status` tinyint(4) NOT NULL DEFAULT '3' COMMENT '1表示已删除，2表示禁用，3表示邮箱未激活，4表示可用',
  `type` tinyint(4) NOT NULL DEFAULT '3' COMMENT '1表示管理员，2表示版主，3表示注册用户',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  `updatetime` datetime NOT NULL COMMENT '修改时间',
  `mender` varchar(36) DEFAULT NULL COMMENT '修改者ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `fk_user_uid_idx` (`mender`),
  CONSTRAINT `fk_user_uid` FOREIGN KEY (`mender`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userinfo` (
  `id` varchar(36) NOT NULL COMMENT '用户ID，外键',
  `activecode` varchar(36) NOT NULL COMMENT '用户注册时的邮箱激活码，UUID',
  `expiretime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '激活码过期时间，时间戳，邮箱激活时判断激活码是否过期',
  `gold` tinyint(4) NOT NULL DEFAULT '5' COMMENT '用户拥有的金币，初始值是5',
  `cid` tinyint(4) NOT NULL COMMENT '所关注领域的ID',
  `avatar` varchar(36) NOT NULL DEFAULT 'avatar' COMMENT '头像ID，外键关联attachment表',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_userinfo_cid_idx` (`cid`),
  KEY `fk_userinfo_avatar_idx` (`avatar`),
  CONSTRAINT `fk_userinfo_avatar` FOREIGN KEY (`avatar`) REFERENCES `attachment` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_userinfo_cid` FOREIGN KEY (`cid`) REFERENCES `channel` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_userinfo_id` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-12-03 23:18:16
