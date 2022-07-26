/*
Navicat MySQL Data Transfer

Source Server         : 39.102.36.248
Source Server Version : 50732
Source Host           : 39.102.36.248:3306
Source Database       : jinggong_cms

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

Date: 2021-01-17 07:45:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `cms_ad`
-- ----------------------------
DROP TABLE IF EXISTS `cms_ad`;
CREATE TABLE `cms_ad` (
  `id` char(19) NOT NULL DEFAULT '' COMMENT 'ID',
  `title` varchar(20) DEFAULT '' COMMENT '标题',
  `type_id` char(19) NOT NULL COMMENT '类型ID',
  `image_url` varchar(500) NOT NULL DEFAULT '' COMMENT '图片地址',
  `color` varchar(10) DEFAULT NULL COMMENT '背景颜色',
  `link_url` varchar(500) DEFAULT '' COMMENT '链接地址',
  `sort` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '排序',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name` (`title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='广告推荐';

-- ----------------------------
-- Records of cms_ad
-- ----------------------------
INSERT INTO `cms_ad` VALUES ('1350044220152483842', '京工书院，随时随地学习！', '1', 'https://bit-jinggong-file.oss-cn-beijing.aliyuncs.com/ad/2021/01/15/45e7b42b-2e94-4c7e-a06d-ccecbb709a28.jpg', null, '', '0', '2021-01-15 19:36:39', '2021-01-15 21:16:18');
INSERT INTO `cms_ad` VALUES ('1350069361980870657', 'Spring Boot学习', '1', 'https://bit-jinggong-file.oss-cn-beijing.aliyuncs.com/ad/2021/01/15/cd44fc58-83b6-4f64-8321-58fa2176d1e4.jpg', null, '', '0', '2021-01-15 21:16:34', '2021-01-15 21:16:34');

-- ----------------------------
-- Table structure for `cms_ad_type`
-- ----------------------------
DROP TABLE IF EXISTS `cms_ad_type`;
CREATE TABLE `cms_ad_type` (
  `id` char(19) NOT NULL COMMENT 'ID',
  `title` varchar(20) NOT NULL COMMENT '标题',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='推荐位';

-- ----------------------------
-- Records of cms_ad_type
-- ----------------------------
INSERT INTO `cms_ad_type` VALUES ('1', '首页', '2021-01-15 19:28:50', '2021-01-15 19:28:50');
