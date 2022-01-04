/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : laboratory

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 16/11/2021 17:59:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_device
-- ----------------------------
DROP TABLE IF EXISTS `t_device`;
CREATE TABLE `t_device`  (
  `deviceNo` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `deviceName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` float(15, 2) NOT NULL,
  `producer` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `laboratoryNo` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`deviceNo`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_device
-- ----------------------------
INSERT INTO `t_device` VALUES ('D001', '电脑A5', 6000.00, '滁州学院', 'L004');
INSERT INTO `t_device` VALUES ('D002', '电脑A6', 6099.00, '信息学院', 'L002');
INSERT INTO `t_device` VALUES ('D017', '电脑D41', 5900.00, '信息学院', 'L008');
INSERT INTO `t_device` VALUES ('D020', '电表箱B16', 1000.00, '机电学院', 'L029');
INSERT INTO `t_device` VALUES ('D021', '电脑A10', 6000.00, '信息学院', 'L021');
INSERT INTO `t_device` VALUES ('D034', '电脑F10', 5800.00, '滁州学院', 'L003');
INSERT INTO `t_device` VALUES ('D065', '电脑D7', 5900.00, '滁州学院', 'L001');
INSERT INTO `t_device` VALUES ('D128', '电脑T6', 6099.00, '信息学院', 'L012');

-- ----------------------------
-- Table structure for t_laboratory
-- ----------------------------
DROP TABLE IF EXISTS `t_laboratory`;
CREATE TABLE `t_laboratory`  (
  `laboratoryNo` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `laboratoryName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`laboratoryNo`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_laboratory
-- ----------------------------
INSERT INTO `t_laboratory` VALUES ('L001', '数据结构实验室', '信息楼201');
INSERT INTO `t_laboratory` VALUES ('L002', '操作系统实验室', '信息楼203');
INSERT INTO `t_laboratory` VALUES ('L003', '程序设计实验室', '逸夫楼3505');
INSERT INTO `t_laboratory` VALUES ('L004', '数据库实验室', '信息楼405');
INSERT INTO `t_laboratory` VALUES ('L005', '计算机组成原理实验室', '信息楼405');
INSERT INTO `t_laboratory` VALUES ('L031', '光学实验室', '机电楼');

-- ----------------------------
-- Table structure for t_use
-- ----------------------------
DROP TABLE IF EXISTS `t_use`;
CREATE TABLE `t_use`  (
  `userNo` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `deviceNo` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `useDate` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `beginTime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `endTime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`userNo`, `deviceNo`, `useDate`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_use
-- ----------------------------
INSERT INTO `t_use` VALUES ('001', 'D001', '2021年09月01日', '21:12:18', '22:00:28');
INSERT INTO `t_use` VALUES ('001', 'D001', '2021年09月02日', '19:51:28', '19:58:30');
INSERT INTO `t_use` VALUES ('001', 'D001', '2021年09月05日', '15:51:52', '15:52:05');
INSERT INTO `t_use` VALUES ('001', 'D001', '2021年09月16日', '08:45:10', '08:45:34');
INSERT INTO `t_use` VALUES ('001', 'D001', '2021年09月19日', '20:18:44', '20:18:58');
INSERT INTO `t_use` VALUES ('001', 'D001', '2021年11月03日', '23:27:57', '23:28:07');
INSERT INTO `t_use` VALUES ('001', 'D002', '2021年08月30日', '10:59:20', '11:54:52');
INSERT INTO `t_use` VALUES ('001', 'D002', '2021年09月01日', '22:08:11', '22:13:48');
INSERT INTO `t_use` VALUES ('001', 'D004', '2021年08月30日', '16:59:03', '17:07:23');
INSERT INTO `t_use` VALUES ('001', 'D004', '2021年09月02日', '14:37:59', '14:38:34');
INSERT INTO `t_use` VALUES ('001', 'D017', '2021年09月02日', '10:23:20', '10:24:02');
INSERT INTO `t_use` VALUES ('001', 'D020', '2021年09月02日', '14:34:13', '14:34:33');
INSERT INTO `t_use` VALUES ('001', 'D021', '2021年09月02日', '20:16:28', '20:16:31');
INSERT INTO `t_use` VALUES ('001', 'D034', '2021年09月02日', '10:19:16', '10:19:41');
INSERT INTO `t_use` VALUES ('001', 'D051', '2021年09月02日', '10:30:01', '10:37:29');
INSERT INTO `t_use` VALUES ('001', 'D133', '2021年09月02日', '10:22:11', '10:22:33');
INSERT INTO `t_use` VALUES ('003', 'D001', '2021年08月29日', '20:46:00', '20:48:56');
INSERT INTO `t_use` VALUES ('003', 'D001', '2021年09月02日', '20:04:53', '20:06:51');
INSERT INTO `t_use` VALUES ('004', 'D002', '2021年08月28日', '21:09:38', '21:09:47');
INSERT INTO `t_use` VALUES ('004', 'D003', '2021年08月28日', '21:08:25', '21:08:33');
INSERT INTO `t_use` VALUES ('005', 'D001', '2021年08月27日', '21:58:53', '21:59:12');
INSERT INTO `t_use` VALUES ('005', 'D002', '2021年08月27日', '22:00:07', '22:00:30');
INSERT INTO `t_use` VALUES ('005', 'D002', '2021年08月28日', '21:15:35', '21:16:01');
INSERT INTO `t_use` VALUES ('005', 'D003', '2021年08月27日', '22:19:18', '22:19:48');
INSERT INTO `t_use` VALUES ('005', 'D004', '2021年08月28日', '21:23:21', '21:23:50');
INSERT INTO `t_use` VALUES ('006', 'D001', '2021年08月27日', '20:37:39', '20:37:53');
INSERT INTO `t_use` VALUES ('009', 'D001', '2021年09月02日', '15:46:06', '15:46:13');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `userNo` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `position` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`userNo`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('001', '王康', '男', '管理员', '1515675555', '123456');
INSERT INTO `t_user` VALUES ('002', '王朋朋', '男', '管理员', '15112334556', '123456');
INSERT INTO `t_user` VALUES ('003', '杨梦龙', '男', '教师', '15146431323', '123456');
INSERT INTO `t_user` VALUES ('004', '肖瀚', '男', '学生', '15116546582', '123456');
INSERT INTO `t_user` VALUES ('005', '徐钰莹', '女', '学生', '15145648787', '123456');
INSERT INTO `t_user` VALUES ('006', '小红', '女', '学生', '15145687664', '123456');
INSERT INTO `t_user` VALUES ('007', '小明', '女', '教师', '15113215646', '123456');
INSERT INTO `t_user` VALUES ('009', '小花', '女', '学生', '19852635921', '123456');
INSERT INTO `t_user` VALUES ('011', '小小', '男', '管理员', '123124534432', '123456');

SET FOREIGN_KEY_CHECKS = 1;
