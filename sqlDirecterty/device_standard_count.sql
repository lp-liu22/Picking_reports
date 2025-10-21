/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50519
 Source Host           : localhost:3306
 Source Schema         : pr

 Target Server Type    : MySQL
 Target Server Version : 50519
 File Encoding         : 65001

 Date: 16/10/2025 00:07:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for device_standard_count
-- ----------------------------
DROP TABLE IF EXISTS `device_standard_count`;
CREATE TABLE `device_standard_count`  (
  `STANDARD_ID` int(11) NOT NULL COMMENT '设备标准ID',
  `ID` int(11) NOT NULL COMMENT '设备ID',
  `STANDARD_COUNT` int(11) UNSIGNED ZEROFILL NOT NULL DEFAULT 00000000000 COMMENT '设备标准数量',
  PRIMARY KEY (`STANDARD_ID`, `ID`) USING BTREE,
  CONSTRAINT `FORM_STANDARD` FOREIGN KEY (`STANDARD_ID`) REFERENCES `device_standard` (`ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
