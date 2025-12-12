/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 50744 (5.7.44-log)
 Source Host           : localhost:3306
 Source Schema         : pr

 Target Server Type    : MySQL
 Target Server Version : 50744 (5.7.44-log)
 File Encoding         : 65001

 Date: 12/12/2025 13:10:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for device_data
-- ----------------------------
DROP TABLE IF EXISTS `device_data`;
CREATE TABLE `device_data`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `child_id` bigint(20) NOT NULL,
  `device_code` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `device_create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `device_description` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `device_manufacturer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `device_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `device_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `device_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `parent_id` bigint(20) NOT NULL,
  `type_create_time` datetime(6) NULL DEFAULT NULL,
  `type_update_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_j58bh6ga5pxxh16aua3n9epr`(`device_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of device_data
-- ----------------------------
INSERT INTO `device_data` VALUES (1, 5, 'XXXXX-20250927-0101', '测试用户', '这是设备描述', '测试厂商', 'XXX-XXXXX', '电子子类3设备', '1', 3, '2025-09-27 17:11:44.000000', '2025-09-27 18:36:38.000000');
INSERT INTO `device_data` VALUES (2, 7, 'huagong', '测试用户', 'this is 描述', '惺惺惜惺惺', '五设备型号', '化工子类设备1', '1', 2, '2025-09-27 18:36:04.000000', '2025-09-27 18:36:04.000000');
INSERT INTO `device_data` VALUES (3, 7, 'huagong1', '测试用户', 'this is 描述', '惺惺惜惺惺', '五设备型号', '化工子类设备1', '1', 2, '2025-09-27 18:36:04.000000', '2025-09-27 18:36:04.000000');
INSERT INTO `device_data` VALUES (4, 4, 'RHzx3R5Miu', 'Chu Suk Yee', '2B2oTAkFEz', 'DpBdIQ5QrW', 'u48Lqrr5qM', 'Rambutan', '1', 3, '2025-09-28 16:50:46.000000', '2025-09-28 05:52:16.000000');
INSERT INTO `device_data` VALUES (5, 5, 'wxllysMFkL', 'Yuen Ho Yin', 'cjviSMgrGS', 'KnTxV8yU83', '0Mw7IJDuxW', 'Osange', '1', 3, '2025-09-27 20:00:53.000000', '2025-09-27 05:42:24.000000');
INSERT INTO `device_data` VALUES (6, 6, 'Bi6ligh6RU', 'Maria Smith', '3jnTuiLKNu', 'IKjkIMVC5m', '5g0sxQvyFq', 'Apzle', '1', 3, '2025-09-27 01:22:36.000000', '2025-09-28 18:47:23.000000');
INSERT INTO `device_data` VALUES (7, 5, 'TjkIK4DT7H', 'Mok Ka Ling', 'TomkxcqJmH', 'mZIBrsm9Lg', 'rXJygM0hZw', 'Oranxe', '1', 3, '2025-09-27 06:36:14.000000', '2025-09-28 03:11:16.000000');

-- ----------------------------
-- Table structure for device_standard
-- ----------------------------
DROP TABLE IF EXISTS `device_standard`;
CREATE TABLE `device_standard`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `STANDARD_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标准名称',
  `STANDARD_DESCRIPTION` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标准描述',
  `CREATE_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `CREATE_USER` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建用户',
  `STANDARD_STATUS` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标准状态：0-删除',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of device_standard
-- ----------------------------
INSERT INTO `device_standard` VALUES (19, '测试设备标准1', '---', '2025-10-16 20:02:17', NULL, '测试用户', '1');

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
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of device_standard_count
-- ----------------------------
INSERT INTO `device_standard_count` VALUES (19, 2, 00000000007);
INSERT INTO `device_standard_count` VALUES (19, 3, 00000000006);

-- ----------------------------
-- Table structure for device_type
-- ----------------------------
DROP TABLE IF EXISTS `device_type`;
CREATE TABLE `device_type`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `device_create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `device_description` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `device_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `device_type_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `parent_id` bigint(20) NULL DEFAULT NULL,
  `type_create_time` datetime(6) NULL DEFAULT NULL,
  `type_update_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of device_type
-- ----------------------------
INSERT INTO `device_type` VALUES (1, 'noname', '金属切削设备', '1', '金属切削设备', NULL, '2025-09-20 23:08:16.000000', '2025-10-23 23:41:34.000000');
INSERT INTO `device_type` VALUES (2, 'noname', '化工设备', '1', '化工设备', NULL, '2025-09-20 23:08:16.000000', '2025-09-20 23:08:16.000000');
INSERT INTO `device_type` VALUES (3, '测试用户', '无介绍', '1', '电子设备', NULL, '2025-09-21 19:33:28.000000', '2025-09-21 19:33:28.000000');
INSERT INTO `device_type` VALUES (4, '测试用户', '电子设备-子类1介绍', '1', '电子设备-子类1', 3, '2025-09-21 19:34:57.000000', '2025-09-21 19:34:57.000000');
INSERT INTO `device_type` VALUES (5, '测试用户', '电子设备-子类2介绍', '1', '电子设备-子类2', 3, '2025-09-21 19:35:08.000000', '2025-09-21 19:35:08.000000');
INSERT INTO `device_type` VALUES (6, '测试用户', '电子设备-子类3介绍', '1', '电子设备-子类3', 3, '2025-09-21 19:35:16.000000', '2025-09-21 19:35:16.000000');
INSERT INTO `device_type` VALUES (7, '测试用户', '化工设备-子类1描述', '1', '化工设备-子类1', 2, '2025-09-24 01:07:15.000000', '2025-09-24 01:07:15.000000');
INSERT INTO `device_type` VALUES (8, '测试用户', '测试类描述', '2', '测试设备1', NULL, '2025-09-24 01:07:40.000000', '2025-09-25 01:09:26.000000');
INSERT INTO `device_type` VALUES (9, '测试用户', '测试设备1-子类描述', '2', '测试设备1-子类1', 4, '2025-09-25 01:10:20.000000', '2025-09-25 01:10:20.000000');
INSERT INTO `device_type` VALUES (10, '测试用户', '测试设备2-子类描述', '2', '测试设备2-子类描述', 5, '2025-09-25 01:10:41.000000', '2025-09-25 01:10:41.000000');
INSERT INTO `device_type` VALUES (11, '测试用户', '测试设备3-子类描述', '2', '测试设备3-子类', 8, '2025-09-25 01:18:39.000000', '2025-09-25 01:18:39.000000');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '部门名称',
  `dept_parent_id` bigint(20) NULL DEFAULT NULL COMMENT '部门子类id',
  `report_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用于判断该部门是否需要每日进行填报：0不需要，1需要',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '部门状态：0未启用，1启用，2废弃',
  `type_create_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (1, '部门A', NULL, '1', '1', '2025-10-16 16:35:21');
INSERT INTO `sys_dept` VALUES (2, '部门A-子部门A', 1, '1', '1', '2025-10-16 16:35:21');
INSERT INTO `sys_dept` VALUES (3, '部门A-子部门B', 1, '1', '1', '2025-10-16 16:35:21');
INSERT INTO `sys_dept` VALUES (4, '部门B', NULL, '1', '1', '2025-10-16 16:37:05');
INSERT INTO `sys_dept` VALUES (5, '部门B-子部门A', 4, '1', '1', '2025-10-16 16:35:21');
INSERT INTO `sys_dept` VALUES (6, '部门B-子部门B', 4, '1', '1', '2025-10-16 16:35:21');

-- ----------------------------
-- Table structure for sys_operation_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_operation_log`;
CREATE TABLE `sys_operation_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `exception_msg` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
  `execute_method` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `execute_time` bigint(20) NULL DEFAULT NULL,
  `ip_address` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `module` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `operation_time` datetime NULL DEFAULT NULL,
  `operation_type` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `request_method` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `request_params` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
  `request_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `response_result` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
  `status` tinyint(1) NULL DEFAULT NULL,
  `username` varchar(75) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 57 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_operation_log
-- ----------------------------
INSERT INTO `sys_operation_log` VALUES (1, '查询所有可用一级分类', NULL, 'com.cb.controller.DeviceTypeController.getAllParentType', 8, '127.0.0.1', '设备类型管理', '2025-10-16 18:31:04', '查询设备一级分类', 'GET', '[]', '/deviceType/getAllParentType', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (2, '查询所有可用一级分类', NULL, 'com.cb.controller.DeviceTypeController.getAllParentType', 2, '127.0.0.1', '设备类型管理', '2025-10-16 18:31:04', '查询设备一级分类', 'GET', '[]', '/deviceType/getAllParentType', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (3, '设备类型查询', NULL, 'com.cb.controller.DeviceTypeController.searchByCondition', 35, '127.0.0.1', '设备类型管理', '2025-10-16 18:31:04', '设备类型查询', 'POST', '[{\"pageNum\":1,\"pageSize\":1000,\"queryParam\":{\"id\":null,\"parentId\":null,\"oldParentId\":null,\"oldDeviceTypeName\":null,\"deviceTypeName\":null,\"deviceDescription\":null,\"deviceStatus\":\"\\u0000\",\"beginTime\":null,\"endTime\":null,\"deviceCreateUser\":null},\"offset\":0,\"validPageSize\":1000}]', '/deviceType/searchByCondition', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (4, '标准查询', NULL, 'com.cb.controller.DeviceStandardController.searchByCondition', 22, '127.0.0.1', '设备标准', '2025-10-16 20:01:31', '标准查询', 'POST', '[{\"pageNum\":1,\"pageSize\":10,\"queryParam\":{\"standardName\":null,\"beginTime\":null,\"endTime\":null,\"createUser\":null},\"offset\":0,\"validPageSize\":10}]', '/deviceStandard/searchByCondition', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (5, '设备查询', NULL, 'com.cb.controller.DeviceDataController.searchByCondition', 11, '127.0.0.1', '设备管理', '2025-10-16 20:01:55', '设备查询', 'POST', '[{\"pageNum\":1,\"pageSize\":5,\"queryParam\":{\"id\":null,\"deviceDescription\":null,\"deviceCode\":null,\"childId\":null,\"parentId\":null,\"deviceName\":\"\",\"deviceManufacturer\":null,\"deviceModel\":null,\"deviceStatus\":\"\\u0000\",\"beginTime\":null,\"endTime\":null,\"deviceCreateUser\":null},\"offset\":0,\"validPageSize\":5}]', '/deviceManage/searchByCondition', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (6, '查询所有可用分类', NULL, 'com.cb.controller.DeviceTypeController.getAllType', 8, '127.0.0.1', '设备类型管理', '2025-10-16 20:01:55', '查询设备所有分类', 'GET', '[]', '/deviceType/getAllType', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (7, '查询所有可用分类', NULL, 'com.cb.controller.DeviceTypeController.getAllType', 5, '127.0.0.1', '设备类型管理', '2025-10-16 20:01:59', '查询设备所有分类', 'GET', '[]', '/deviceType/getAllType', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (8, '设备查询', NULL, 'com.cb.controller.DeviceDataController.searchByCondition', 6, '127.0.0.1', '设备管理', '2025-10-16 20:01:59', '设备查询', 'POST', '[{\"pageNum\":1,\"pageSize\":5,\"queryParam\":{\"id\":null,\"deviceDescription\":null,\"deviceCode\":null,\"childId\":null,\"parentId\":null,\"deviceName\":\"\",\"deviceManufacturer\":null,\"deviceModel\":null,\"deviceStatus\":\"\\u0000\",\"beginTime\":null,\"endTime\":null,\"deviceCreateUser\":null},\"offset\":0,\"validPageSize\":5}]', '/deviceManage/searchByCondition', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (9, '设备查询', NULL, 'com.cb.controller.DeviceDataController.searchByCondition', 4, '127.0.0.1', '设备管理', '2025-10-16 20:02:00', '设备查询', 'POST', '[{\"pageNum\":1,\"pageSize\":5,\"queryParam\":{\"id\":null,\"deviceDescription\":null,\"deviceCode\":null,\"childId\":null,\"parentId\":null,\"deviceName\":\"\",\"deviceManufacturer\":null,\"deviceModel\":null,\"deviceStatus\":\"\\u0000\",\"beginTime\":null,\"endTime\":null,\"deviceCreateUser\":null},\"offset\":0,\"validPageSize\":5}]', '/deviceManage/searchByCondition', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (10, '查询所有可用分类', NULL, 'com.cb.controller.DeviceTypeController.getAllType', 7, '127.0.0.1', '设备类型管理', '2025-10-16 20:02:00', '查询设备所有分类', 'GET', '[]', '/deviceType/getAllType', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (11, '查询所有可用分类', NULL, 'com.cb.controller.DeviceTypeController.getAllType', 3, '127.0.0.1', '设备类型管理', '2025-10-16 20:02:06', '查询设备所有分类', 'GET', '[]', '/deviceType/getAllType', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (12, '设备查询', NULL, 'com.cb.controller.DeviceDataController.searchByCondition', 5, '127.0.0.1', '设备管理', '2025-10-16 20:02:06', '设备查询', 'POST', '[{\"pageNum\":1,\"pageSize\":5,\"queryParam\":{\"id\":null,\"deviceDescription\":null,\"deviceCode\":null,\"childId\":null,\"parentId\":null,\"deviceName\":\"\",\"deviceManufacturer\":null,\"deviceModel\":null,\"deviceStatus\":\"\\u0000\",\"beginTime\":null,\"endTime\":null,\"deviceCreateUser\":null},\"offset\":0,\"validPageSize\":5}]', '/deviceManage/searchByCondition', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (13, '设备查询', NULL, 'com.cb.controller.DeviceDataController.searchByCondition', 3, '127.0.0.1', '设备管理', '2025-10-16 20:02:07', '设备查询', 'POST', '[{\"pageNum\":1,\"pageSize\":5,\"queryParam\":{\"id\":null,\"deviceDescription\":null,\"deviceCode\":null,\"childId\":null,\"parentId\":null,\"deviceName\":\"\",\"deviceManufacturer\":null,\"deviceModel\":null,\"deviceStatus\":\"\\u0000\",\"beginTime\":null,\"endTime\":null,\"deviceCreateUser\":null},\"offset\":0,\"validPageSize\":5}]', '/deviceManage/searchByCondition', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (14, '查询所有可用分类', NULL, 'com.cb.controller.DeviceTypeController.getAllType', 2, '127.0.0.1', '设备类型管理', '2025-10-16 20:02:07', '查询设备所有分类', 'GET', '[]', '/deviceType/getAllType', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (15, '新增标准', NULL, 'com.cb.controller.DeviceStandardController.addDeviceStandard', 11, '127.0.0.1', '设备标准', '2025-10-16 20:02:17', '标准新增', 'POST', '[{\"id\":19,\"standardName\":\"测试设备标准1\",\"standardDescription\":\"---\",\"createUser\":\"测试用户\",\"standardDeviceData\":[{\"id\":3,\"standardCount\":6},{\"id\":2,\"standardCount\":7}]}]', '/deviceStandard/addStandard', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (16, '标准查询', NULL, 'com.cb.controller.DeviceStandardController.searchByCondition', 4, '127.0.0.1', '设备标准', '2025-10-16 20:02:17', '标准查询', 'POST', '[{\"pageNum\":1,\"pageSize\":10,\"queryParam\":{\"standardName\":\"\",\"beginTime\":null,\"endTime\":null,\"createUser\":\"\"},\"offset\":0,\"validPageSize\":10}]', '/deviceStandard/searchByCondition', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (17, '标准设备查询', NULL, 'com.cb.controller.DeviceStandardController.getStandardDevice', 5, '127.0.0.1', '设备标准', '2025-10-16 20:02:18', '标准设备查询', 'POST', '[19]', '/deviceStandard/getStandardDevice', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (18, '设备类型查询', NULL, 'com.cb.controller.DeviceTypeController.searchByCondition', 34, '127.0.0.1', '设备类型管理', '2025-10-21 21:16:15', '设备类型查询', 'POST', '[{\"pageNum\":1,\"pageSize\":1000,\"queryParam\":{\"id\":null,\"parentId\":null,\"oldParentId\":null,\"oldDeviceTypeName\":null,\"deviceTypeName\":null,\"deviceDescription\":null,\"deviceStatus\":\"\\u0000\",\"beginTime\":null,\"endTime\":null,\"deviceCreateUser\":null},\"offset\":0,\"validPageSize\":1000}]', '/deviceType/searchByCondition', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (19, '查询所有可用一级分类', NULL, 'com.cb.controller.DeviceTypeController.getAllParentType', 137, '127.0.0.1', '设备类型管理', '2025-10-21 21:16:15', '查询设备一级分类', 'GET', '[]', '/deviceType/getAllParentType', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (20, '查询所有可用一级分类', NULL, 'com.cb.controller.DeviceTypeController.getAllParentType', 3, '127.0.0.1', '设备类型管理', '2025-10-21 21:16:15', '查询设备一级分类', 'GET', '[]', '/deviceType/getAllParentType', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (21, '标准查询', NULL, 'com.cb.controller.DeviceStandardController.searchByCondition', 9, '127.0.0.1', '设备标准', '2025-10-21 21:38:50', '标准查询', 'POST', '[{\"pageNum\":1,\"pageSize\":10,\"queryParam\":{\"standardName\":null,\"beginTime\":null,\"endTime\":null,\"createUser\":null},\"offset\":0,\"validPageSize\":10}]', '/deviceStandard/searchByCondition', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (22, '设备类型查询', NULL, 'com.cb.controller.DeviceTypeController.searchByCondition', 14, '127.0.0.1', '设备类型管理', '2025-10-21 21:38:54', '设备类型查询', 'POST', '[{\"pageNum\":1,\"pageSize\":1000,\"queryParam\":{\"id\":null,\"parentId\":null,\"oldParentId\":null,\"oldDeviceTypeName\":null,\"deviceTypeName\":null,\"deviceDescription\":null,\"deviceStatus\":\"\\u0000\",\"beginTime\":null,\"endTime\":null,\"deviceCreateUser\":null},\"offset\":0,\"validPageSize\":1000}]', '/deviceType/searchByCondition', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (23, '查询所有可用一级分类', NULL, 'com.cb.controller.DeviceTypeController.getAllParentType', 4, '127.0.0.1', '设备类型管理', '2025-10-21 21:38:54', '查询设备一级分类', 'GET', '[]', '/deviceType/getAllParentType', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (24, '查询所有可用一级分类', NULL, 'com.cb.controller.DeviceTypeController.getAllParentType', 2, '127.0.0.1', '设备类型管理', '2025-10-21 21:38:54', '查询设备一级分类', 'GET', '[]', '/deviceType/getAllParentType', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (25, '查询所有可用分类', NULL, 'com.cb.controller.DeviceTypeController.getAllType', 6, '127.0.0.1', '设备类型管理', '2025-10-21 21:39:02', '查询设备所有分类', 'GET', '[]', '/deviceType/getAllType', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (26, '设备查询', NULL, 'com.cb.controller.DeviceDataController.searchByCondition', 8, '127.0.0.1', '设备管理', '2025-10-21 21:39:02', '设备查询', 'POST', '[{\"pageNum\":1,\"pageSize\":10,\"queryParam\":{\"id\":null,\"deviceDescription\":null,\"deviceCode\":null,\"childId\":null,\"parentId\":null,\"deviceName\":null,\"deviceManufacturer\":null,\"deviceModel\":null,\"deviceStatus\":\"\\u0000\",\"beginTime\":null,\"endTime\":null,\"deviceCreateUser\":null},\"offset\":0,\"validPageSize\":10}]', '/deviceManage/searchByCondition', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (27, '查询所有可用分类', NULL, 'com.cb.controller.DeviceTypeController.getAllType', 6, '127.0.0.1', '设备类型管理', '2025-10-21 21:39:02', '查询设备所有分类', 'GET', '[]', '/deviceType/getAllType', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (28, '设备类型查询', NULL, 'com.cb.controller.DeviceTypeController.searchByCondition', 45, '0:0:0:0:0:0:0:1', '设备类型管理', '2025-10-23 23:26:41', '设备类型查询', 'POST', '[{\"pageNum\":1,\"pageSize\":1000,\"queryParam\":{\"id\":null,\"parentId\":null,\"oldParentId\":null,\"oldDeviceTypeName\":null,\"deviceTypeName\":null,\"deviceDescription\":null,\"deviceStatus\":\"\\u0000\",\"beginTime\":null,\"endTime\":null,\"deviceCreateUser\":null},\"offset\":0,\"validPageSize\":1000}]', '/deviceType/searchByCondition', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (29, '查询所有可用一级分类', NULL, 'com.cb.controller.DeviceTypeController.getAllParentType', 107, '0:0:0:0:0:0:0:1', '设备类型管理', '2025-10-23 23:26:41', '查询设备一级分类', 'GET', '[]', '/deviceType/getAllParentType', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (30, '查询所有可用一级分类', NULL, 'com.cb.controller.DeviceTypeController.getAllParentType', 8, '0:0:0:0:0:0:0:1', '设备类型管理', '2025-10-23 23:26:41', '查询设备一级分类', 'GET', '[]', '/deviceType/getAllParentType', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (31, '设备类型查询', NULL, 'com.cb.controller.DeviceTypeController.searchByCondition', 100, '0:0:0:0:0:0:0:1', '设备类型管理', '2025-10-23 23:39:39', '设备类型查询', 'POST', '[{\"pageNum\":1,\"pageSize\":1000,\"queryParam\":{\"id\":null,\"parentId\":null,\"oldParentId\":null,\"oldDeviceTypeName\":null,\"deviceTypeName\":null,\"deviceDescription\":null,\"deviceStatus\":\"\\u0000\",\"beginTime\":null,\"endTime\":null,\"deviceCreateUser\":null},\"offset\":0,\"validPageSize\":1000}]', '/deviceType/searchByCondition', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (32, '查询所有可用一级分类', NULL, 'com.cb.controller.DeviceTypeController.getAllParentType', 308, '0:0:0:0:0:0:0:1', '设备类型管理', '2025-10-23 23:39:39', '查询设备一级分类', 'GET', '[]', '/deviceType/getAllParentType', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (33, '查询所有可用一级分类', NULL, 'com.cb.controller.DeviceTypeController.getAllParentType', 14, '0:0:0:0:0:0:0:1', '设备类型管理', '2025-10-23 23:39:39', '查询设备一级分类', 'GET', '[]', '/deviceType/getAllParentType', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (34, '标准查询', NULL, 'com.cb.controller.DeviceStandardController.searchByCondition', 45, '0:0:0:0:0:0:0:1', '设备标准', '2025-10-23 23:39:53', '标准查询', 'POST', '[{\"pageNum\":1,\"pageSize\":10,\"queryParam\":{\"standardName\":null,\"beginTime\":null,\"endTime\":null,\"createUser\":null},\"offset\":0,\"validPageSize\":10}]', '/deviceStandard/searchByCondition', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (35, '查询所有可用分类', NULL, 'com.cb.controller.DeviceTypeController.getAllType', 46, '0:0:0:0:0:0:0:1', '设备类型管理', '2025-10-23 23:40:01', '查询设备所有分类', 'GET', '[]', '/deviceType/getAllType', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (36, '设备查询', NULL, 'com.cb.controller.DeviceDataController.searchByCondition', 62, '0:0:0:0:0:0:0:1', '设备管理', '2025-10-23 23:40:01', '设备查询', 'POST', '[{\"pageNum\":1,\"pageSize\":5,\"queryParam\":{\"id\":null,\"deviceDescription\":null,\"deviceCode\":null,\"childId\":null,\"parentId\":null,\"deviceName\":\"\",\"deviceManufacturer\":null,\"deviceModel\":null,\"deviceStatus\":\"\\u0000\",\"beginTime\":null,\"endTime\":null,\"deviceCreateUser\":null},\"offset\":0,\"validPageSize\":5}]', '/deviceManage/searchByCondition', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (37, '设备查询', NULL, 'com.cb.controller.DeviceDataController.searchByCondition', 27, '0:0:0:0:0:0:0:1', '设备管理', '2025-10-23 23:40:10', '设备查询', 'POST', '[{\"pageNum\":2,\"pageSize\":5,\"queryParam\":{\"id\":null,\"deviceDescription\":null,\"deviceCode\":null,\"childId\":null,\"parentId\":null,\"deviceName\":\"\",\"deviceManufacturer\":null,\"deviceModel\":null,\"deviceStatus\":\"\\u0000\",\"beginTime\":null,\"endTime\":null,\"deviceCreateUser\":null},\"offset\":5,\"validPageSize\":5}]', '/deviceManage/searchByCondition', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (38, '查询所有可用分类', NULL, 'com.cb.controller.DeviceTypeController.getAllType', 39, '0:0:0:0:0:0:0:1', '设备类型管理', '2025-10-23 23:40:10', '查询设备所有分类', 'GET', '[]', '/deviceType/getAllType', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (39, '设备查询', NULL, 'com.cb.controller.DeviceDataController.searchByCondition', 43, '0:0:0:0:0:0:0:1', '设备管理', '2025-10-23 23:40:12', '设备查询', 'POST', '[{\"pageNum\":1,\"pageSize\":5,\"queryParam\":{\"id\":null,\"deviceDescription\":null,\"deviceCode\":null,\"childId\":null,\"parentId\":null,\"deviceName\":\"\",\"deviceManufacturer\":null,\"deviceModel\":null,\"deviceStatus\":\"\\u0000\",\"beginTime\":null,\"endTime\":null,\"deviceCreateUser\":null},\"offset\":0,\"validPageSize\":5}]', '/deviceManage/searchByCondition', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (40, '查询所有可用分类', NULL, 'com.cb.controller.DeviceTypeController.getAllType', 52, '0:0:0:0:0:0:0:1', '设备类型管理', '2025-10-23 23:40:12', '查询设备所有分类', 'GET', '[]', '/deviceType/getAllType', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (41, '查询所有可用分类', NULL, 'com.cb.controller.DeviceTypeController.getAllType', 36, '0:0:0:0:0:0:0:1', '设备类型管理', '2025-10-23 23:40:28', '查询设备所有分类', 'GET', '[]', '/deviceType/getAllType', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (42, '设备查询', NULL, 'com.cb.controller.DeviceDataController.searchByCondition', 46, '0:0:0:0:0:0:0:1', '设备管理', '2025-10-23 23:40:28', '设备查询', 'POST', '[{\"pageNum\":1,\"pageSize\":10,\"queryParam\":{\"id\":null,\"deviceDescription\":null,\"deviceCode\":null,\"childId\":null,\"parentId\":null,\"deviceName\":null,\"deviceManufacturer\":null,\"deviceModel\":null,\"deviceStatus\":\"\\u0000\",\"beginTime\":null,\"endTime\":null,\"deviceCreateUser\":null},\"offset\":0,\"validPageSize\":10}]', '/deviceManage/searchByCondition', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (43, '查询所有可用分类', NULL, 'com.cb.controller.DeviceTypeController.getAllType', 25, '0:0:0:0:0:0:0:1', '设备类型管理', '2025-10-23 23:40:28', '查询设备所有分类', 'GET', '[]', '/deviceType/getAllType', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (44, '查询所有可用一级分类', NULL, 'com.cb.controller.DeviceTypeController.getAllParentType', 36, '0:0:0:0:0:0:0:1', '设备类型管理', '2025-10-23 23:40:57', '查询设备一级分类', 'GET', '[]', '/deviceType/getAllParentType', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (45, '设备类型查询', NULL, 'com.cb.controller.DeviceTypeController.searchByCondition', 71, '0:0:0:0:0:0:0:1', '设备类型管理', '2025-10-23 23:40:57', '设备类型查询', 'POST', '[{\"pageNum\":1,\"pageSize\":1000,\"queryParam\":{\"id\":null,\"parentId\":null,\"oldParentId\":null,\"oldDeviceTypeName\":null,\"deviceTypeName\":null,\"deviceDescription\":null,\"deviceStatus\":\"\\u0000\",\"beginTime\":null,\"endTime\":null,\"deviceCreateUser\":null},\"offset\":0,\"validPageSize\":1000}]', '/deviceType/searchByCondition', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (46, '查询所有可用一级分类', NULL, 'com.cb.controller.DeviceTypeController.getAllParentType', 32, '0:0:0:0:0:0:0:1', '设备类型管理', '2025-10-23 23:40:57', '查询设备一级分类', 'GET', '[]', '/deviceType/getAllParentType', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (47, '新增设备分类', NULL, 'com.cb.controller.DeviceTypeController.addNewType', 10, '0:0:0:0:0:0:0:1', '设备类型管理', '2025-10-23 23:41:00', '设备类型新增', 'POST', '[{\"id\":null,\"parentId\":null,\"deviceTypeName\":\"\",\"deviceDescription\":\"\",\"deviceStatus\":\"\\u0000\",\"typeCreateTime\":null,\"typeUpdateTime\":null,\"deviceCreateUser\":\"测试用户\"}]', '/deviceType/add', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (48, '修改设备分类', NULL, 'com.cb.controller.DeviceTypeController.updateDeviceType', 20, '0:0:0:0:0:0:0:1', '设备类型管理', '2025-10-23 23:41:22', '修改设备分类', 'POST', '[{\"id\":1,\"parentId\":null,\"oldParentId\":null,\"oldDeviceTypeName\":\"金属切削设备\",\"deviceTypeName\":\"金属切削设备\",\"deviceDescription\":\"金属切削设备\",\"deviceStatus\":\"\\u0000\",\"beginTime\":null,\"endTime\":null,\"deviceCreateUser\":\"测试用户\"}]', '/deviceType/updateDeviceType', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (49, '查询所有可用一级分类', NULL, 'com.cb.controller.DeviceTypeController.getAllParentType', 13, '0:0:0:0:0:0:0:1', '设备类型管理', '2025-10-23 23:41:22', '查询设备一级分类', 'GET', '[]', '/deviceType/getAllParentType', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (50, '设备类型查询', NULL, 'com.cb.controller.DeviceTypeController.searchByCondition', 33, '0:0:0:0:0:0:0:1', '设备类型管理', '2025-10-23 23:41:22', '设备类型查询', 'POST', '[{\"pageNum\":1,\"pageSize\":1000,\"queryParam\":{\"id\":null,\"parentId\":null,\"oldParentId\":null,\"oldDeviceTypeName\":null,\"deviceTypeName\":\"\",\"deviceDescription\":null,\"deviceStatus\":\"\\u0000\",\"beginTime\":null,\"endTime\":null,\"deviceCreateUser\":\"\"},\"offset\":0,\"validPageSize\":1000}]', '/deviceType/searchByCondition', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (51, '修改设备分类', NULL, 'com.cb.controller.DeviceTypeController.updateDeviceType', 18, '0:0:0:0:0:0:0:1', '设备类型管理', '2025-10-23 23:41:34', '修改设备分类', 'POST', '[{\"id\":1,\"parentId\":null,\"oldParentId\":null,\"oldDeviceTypeName\":\"金属切削设备\",\"deviceTypeName\":\"金属切削设备\",\"deviceDescription\":\"金属切削设备\",\"deviceStatus\":\"\\u0000\",\"beginTime\":null,\"endTime\":null,\"deviceCreateUser\":\"测试用户\"}]', '/deviceType/updateDeviceType', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (52, '查询所有可用一级分类', NULL, 'com.cb.controller.DeviceTypeController.getAllParentType', 15, '0:0:0:0:0:0:0:1', '设备类型管理', '2025-10-23 23:41:34', '查询设备一级分类', 'GET', '[]', '/deviceType/getAllParentType', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (53, '设备类型查询', NULL, 'com.cb.controller.DeviceTypeController.searchByCondition', 34, '0:0:0:0:0:0:0:1', '设备类型管理', '2025-10-23 23:41:34', '设备类型查询', 'POST', '[{\"pageNum\":1,\"pageSize\":1000,\"queryParam\":{\"id\":null,\"parentId\":null,\"oldParentId\":null,\"oldDeviceTypeName\":null,\"deviceTypeName\":\"\",\"deviceDescription\":null,\"deviceStatus\":\"\\u0000\",\"beginTime\":null,\"endTime\":null,\"deviceCreateUser\":\"\"},\"offset\":0,\"validPageSize\":1000}]', '/deviceType/searchByCondition', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (54, '新增设备分类', NULL, 'com.cb.controller.DeviceTypeController.addNewType', 5, '0:0:0:0:0:0:0:1', '设备类型管理', '2025-10-23 23:41:40', '设备类型新增', 'POST', '[{\"id\":null,\"parentId\":null,\"deviceTypeName\":\"\",\"deviceDescription\":\"\",\"deviceStatus\":\"\\u0000\",\"typeCreateTime\":null,\"typeUpdateTime\":null,\"deviceCreateUser\":\"测试用户\"}]', '/deviceType/add', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (55, '新增设备分类', NULL, 'com.cb.controller.DeviceTypeController.addNewType', 6, '0:0:0:0:0:0:0:1', '设备类型管理', '2025-10-23 23:41:41', '设备类型新增', 'POST', '[{\"id\":null,\"parentId\":null,\"deviceTypeName\":\"\",\"deviceDescription\":\"\",\"deviceStatus\":\"\\u0000\",\"typeCreateTime\":null,\"typeUpdateTime\":null,\"deviceCreateUser\":\"测试用户\"}]', '/deviceType/add', NULL, 1, 'admin');
INSERT INTO `sys_operation_log` VALUES (56, '新增设备分类', NULL, 'com.cb.controller.DeviceTypeController.addNewType', 5, '0:0:0:0:0:0:0:1', '设备类型管理', '2025-10-23 23:41:41', '设备类型新增', 'POST', '[{\"id\":null,\"parentId\":null,\"deviceTypeName\":\"\",\"deviceDescription\":\"\",\"deviceStatus\":\"\\u0000\",\"typeCreateTime\":null,\"typeUpdateTime\":null,\"deviceCreateUser\":\"测试用户\"}]', '/deviceType/add', NULL, 1, 'admin');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NULL DEFAULT NULL,
  `person_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `phone_number` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_cb0fsvip6qow952a07et2k9xv`(`user_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '2025-10-16 16:38:12', '超级管理员', '15698745689', '1', 'admin', 'admin123');
INSERT INTO `sys_user` VALUES (2, '2025-10-16 16:38:12', '张三', '15698745689', '1', 'zhangsan', '123456');
INSERT INTO `sys_user` VALUES (3, '2025-10-16 16:38:12', '李四', '15698745689', '1', 'lisi', '123456');
INSERT INTO `sys_user` VALUES (4, '2025-10-16 16:38:12', '王象德', '15698745689', '1', 'wangxiangde', '123456');
INSERT INTO `sys_user` VALUES (5, '2025-10-16 16:38:12', '赵爱军', '15698745689', '1', 'zhaoaijun', '123456');

-- ----------------------------
-- Table structure for sys_user_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_dept`;
CREATE TABLE `sys_user_dept`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `authority` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '1:超级管理员（所有权限）,2:审核员（审核、查看权限）,3:填报员（填报、查看权限）,4：普通人员（只有查看权限）',
  `dept_id` bigint(20) NULL DEFAULT NULL,
  `join_time` datetime NULL DEFAULT NULL,
  `user_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uniqueFieldOfId`(`dept_id`, `user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_dept
-- ----------------------------
INSERT INTO `sys_user_dept` VALUES (1, '1', 1, '2025-10-21 21:10:23', 1);
INSERT INTO `sys_user_dept` VALUES (2, '2', 2, '2025-10-21 21:11:03', 2);

SET FOREIGN_KEY_CHECKS = 1;
