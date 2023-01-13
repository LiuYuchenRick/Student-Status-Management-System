/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : studentManager

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 13/01/2023 15:21:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sclass
-- ----------------------------
DROP TABLE IF EXISTS `sclass`;
CREATE TABLE `sclass` (
  `sclassNo` varchar(255) NOT NULL COMMENT '班级号',
  `sclassName` varchar(255) DEFAULT NULL COMMENT '班级名',
  PRIMARY KEY (`sclassNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sclass
-- ----------------------------
BEGIN;
INSERT INTO `sclass` (`sclassNo`, `sclassName`) VALUES ('1', '计算机一班');
INSERT INTO `sclass` (`sclassNo`, `sclassName`) VALUES ('2', '计算机二班');
INSERT INTO `sclass` (`sclassNo`, `sclassName`) VALUES ('3', '软件工程一班');
COMMIT;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `no` varchar(20) NOT NULL COMMENT '学号',
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(2) DEFAULT '男' COMMENT '性别',
  `age` int(4) DEFAULT '0' COMMENT '年龄',
  `grade` varchar(10) DEFAULT NULL COMMENT '年级',
  `major` varchar(20) DEFAULT NULL COMMENT '专业',
  `sclassNo` varchar(10) DEFAULT NULL COMMENT '班级号',
  `inDate` varchar(255) DEFAULT NULL COMMENT '进入班级时间',
  PRIMARY KEY (`no`),
  KEY `sclassNo_fk` (`sclassNo`),
  CONSTRAINT `sclassNo_fk` FOREIGN KEY (`sclassNo`) REFERENCES `sclass` (`sclassNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
BEGIN;
INSERT INTO `student` (`no`, `name`, `sex`, `age`, `grade`, `major`, `sclassNo`, `inDate`) VALUES ('2', '李四', '女', 18, '2021', '计算机', '2', '2022-09-01');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
