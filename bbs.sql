/*
 Navicat Premium Data Transfer

 Source Server         : Linux服务器上数据库连接
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : 114.215.185.143:3306
 Source Schema         : bbs

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 10/06/2021 15:12:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fid` int(11) NOT NULL,
  `tid` int(11) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `state` int(11) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `date` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `p_fid_uid`(`fid`) USING BTREE,
  INDEX `p_tid_uid`(`tid`) USING BTREE,
  CONSTRAINT `p_fid_uid` FOREIGN KEY (`fid`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `p_tid_uid` FOREIGN KEY (`tid`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (1, 2, 1, '关于java', '容易吗', 00000000001, '2020-02-29 15:33:12');
INSERT INTO `message` VALUES (4, 3, 1, '关于考研', '你准备好了吗？', 00000000000, '2020-02-29 16:39:08');
INSERT INTO `message` VALUES (25, 1, 1, '信息与通信工程', '地方', 00000000000, '2021-02-26 16:42:52');

-- ----------------------------
-- Table structure for test_table
-- ----------------------------
DROP TABLE IF EXISTS `test_table`;
CREATE TABLE `test_table`  (
  `Id` int(11) NULL DEFAULT NULL,
  `Name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Class` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Count` int(11) NULL DEFAULT NULL,
  `Date` datetime NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_table
-- ----------------------------
INSERT INTO `test_table` VALUES (1, '欧阳桦', '18级1班', 95, '2020-05-01 00:00:00');
INSERT INTO `test_table` VALUES (1, '孔安刚', '18级1班', 90, '2020-05-02 00:00:00');
INSERT INTO `test_table` VALUES (1, '陈世娜', '18级1班', 85, '2020-05-03 00:00:00');
INSERT INTO `test_table` VALUES (2, '卢青武', '18级2班', 89, '2020-05-01 00:00:00');
INSERT INTO `test_table` VALUES (2, '张静华', '18级2班', 82, '2020-05-02 00:00:00');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `upwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'zhangsan', '123', '1927666233@qq.com');
INSERT INTO `user` VALUES (2, 'lisi', '123', '1927666233@qq.com');
INSERT INTO `user` VALUES (3, 'wangwu', '123', '1927666233@qq.com');
INSERT INTO `user` VALUES (4, 'zhang', '1234', '191');
INSERT INTO `user` VALUES (15, '赵洲', '123', '1927666233@qq.com');
INSERT INTO `user` VALUES (16, 'zhang', '1234', NULL);

SET FOREIGN_KEY_CHECKS = 1;
