/*
Navicat MySQL Data Transfer

Source Server         : mysql8@localhost_3307@root
Source Server Version : 80017
Source Host           : localhost:3307
Source Database       : activ

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2021-06-25 14:07:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '活动ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '活动名称',
  `start_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '开始时间',
  `end_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '结束时间',
  `desc` json DEFAULT NULL COMMENT '描述 json格式',
  `notity_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '是否需要通知下游：0-不需要通知；1-需要通知',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '是否删除：0-正常；1-已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='活动表';

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES ('1', 'test', '2021-06-22 15:58:56', '2021-07-30 15:58:56', null, '0', '2021-06-22 15:58:56');

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `activ_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '活动ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '奖品名称',
  `group` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '奖品分组',
  `total` int(8) DEFAULT NULL COMMENT '商品总量',
  `remain` int(8) DEFAULT NULL COMMENT '剩余数量',
  `weight` decimal(2,2) DEFAULT NULL COMMENT '中奖权重',
  `desc` json DEFAULT NULL COMMENT '描述 json格式',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '是否删除：0-正常；1-已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='奖品表';

-- ----------------------------
-- Records of item
-- ----------------------------

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `activ_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '活动ID',
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户信息',
  `item_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '奖品ID',
  `num` int(3) DEFAULT '1' COMMENT '数量',
  `action_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `notity_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '是否需要通知下游：0-不需要通知；1-需要通知',
  `notity` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '是否通知：0-未通知；1-已通知',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '是否删除：0-正常；1-已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='订单表';

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', 'string', '123', '123', '1', '2021-06-10 18:38:25', '0', '1', '2021-06-10 18:38:25', '0');
INSERT INTO `order` VALUES ('1000', '123', '123', '123', '1', '2021-06-10 18:58:16', '0', '1', '2021-06-10 18:58:16', '0');
INSERT INTO `order` VALUES ('10000', '123', '123', '123', '1', '2021-06-11 10:00:32', '0', '1', '2021-06-11 10:00:32', '0');
INSERT INTO `order` VALUES ('100000', '123', '123', '123', '1', '2021-06-11 10:30:44', '0', '1', '2021-06-11 10:30:44', '0');
INSERT INTO `order` VALUES ('100001', '123', '123', '123', '1', '2021-06-11 10:30:44', '0', '1', '2021-06-11 10:30:44', '0');
INSERT INTO `order` VALUES ('100002', '123', '123', '123', '1', '2021-06-11 10:30:43', '0', '1', '2021-06-11 10:30:43', '0');
INSERT INTO `order` VALUES ('100003', '123', '123', '123', '1', '2021-06-11 10:30:44', '0', '1', '2021-06-11 10:30:44', '0');
INSERT INTO `order` VALUES ('100004', '123', '123', '123', '1', '2021-06-11 10:30:43', '0', '1', '2021-06-11 10:30:43', '0');
INSERT INTO `order` VALUES ('100005', '123', '123', '123', '1', '2021-06-11 10:30:43', '0', '1', '2021-06-11 10:30:43', '0');
INSERT INTO `order` VALUES ('2', '34', '34', '34', '1', '2021-06-17 14:52:24', '2', '1', '2021-06-17 14:52:24', '0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '唯一',
  `activ_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '活动ID',
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户ID：脱敏加密生成，唯一',
  `idcard` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '身份证号码',
  `mobild` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机号',
  `attribute` json DEFAULT NULL COMMENT '属性 json格式',
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '描述',
  `tag` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '入库标识',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '是否删除：0-正常；1-已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
