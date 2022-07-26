/*
Navicat MySQL Data Transfer

Source Server         : 39.102.36.248
Source Server Version : 50732
Source Host           : 39.102.36.248:3306
Source Database       : jinggong_statistics

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

Date: 2021-01-17 07:46:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `statistics_daily`
-- ----------------------------
DROP TABLE IF EXISTS `statistics_daily`;
CREATE TABLE `statistics_daily` (
  `id` char(19) NOT NULL COMMENT '主键',
  `date_calculated` varchar(20) NOT NULL COMMENT '统计日期',
  `register_num` int(11) NOT NULL DEFAULT '0' COMMENT '注册人数',
  `login_num` int(11) NOT NULL DEFAULT '0' COMMENT '登录人数',
  `video_view_num` int(11) NOT NULL DEFAULT '0' COMMENT '每日播放视频数',
  `course_num` int(11) NOT NULL DEFAULT '0' COMMENT '每日新增课程数',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `statistics_day` (`date_calculated`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='网站统计日数据';

-- ----------------------------
-- Records of statistics_daily
-- ----------------------------
INSERT INTO `statistics_daily` VALUES ('1350341203891314690', '2020-12-16', '0', '111', '179', '124', '2021-01-16 15:16:46', '2021-01-16 15:16:46');
INSERT INTO `statistics_daily` VALUES ('1350341218198085633', '2020-12-17', '0', '108', '153', '127', '2021-01-16 15:16:49', '2021-01-16 15:16:49');
INSERT INTO `statistics_daily` VALUES ('1350341228738371586', '2020-12-18', '0', '197', '183', '141', '2021-01-16 15:16:52', '2021-01-16 15:16:52');
INSERT INTO `statistics_daily` VALUES ('1350341241744908289', '2020-12-19', '0', '143', '180', '144', '2021-01-16 15:16:55', '2021-01-16 15:16:55');
INSERT INTO `statistics_daily` VALUES ('1350341255191846913', '2020-12-20', '0', '144', '162', '163', '2021-01-16 15:16:58', '2021-01-16 15:16:58');
INSERT INTO `statistics_daily` VALUES ('1350341265048461314', '2020-12-21', '0', '122', '172', '110', '2021-01-16 15:17:00', '2021-01-16 15:17:00');
INSERT INTO `statistics_daily` VALUES ('1350341274468868098', '2020-12-22', '0', '139', '148', '180', '2021-01-16 15:17:03', '2021-01-16 15:17:03');
INSERT INTO `statistics_daily` VALUES ('1350341283671171074', '2020-12-23', '0', '131', '101', '170', '2021-01-16 15:17:05', '2021-01-16 15:17:05');
INSERT INTO `statistics_daily` VALUES ('1350341293364207617', '2020-12-24', '0', '151', '146', '164', '2021-01-16 15:17:07', '2021-01-16 15:17:07');
INSERT INTO `statistics_daily` VALUES ('1350341302860111874', '2020-12-25', '0', '160', '100', '114', '2021-01-16 15:17:09', '2021-01-16 15:17:09');
INSERT INTO `statistics_daily` VALUES ('1350341312221798402', '2020-12-26', '0', '191', '159', '157', '2021-01-16 15:17:12', '2021-01-16 15:17:12');
INSERT INTO `statistics_daily` VALUES ('1350341321512181762', '2020-12-27', '0', '120', '147', '189', '2021-01-16 15:17:14', '2021-01-16 15:17:14');
INSERT INTO `statistics_daily` VALUES ('1350341336326463489', '2020-12-28', '0', '194', '125', '126', '2021-01-16 15:17:17', '2021-01-16 15:17:17');
INSERT INTO `statistics_daily` VALUES ('1350341346019500033', '2020-12-29', '0', '164', '116', '158', '2021-01-16 15:17:20', '2021-01-16 15:17:20');
INSERT INTO `statistics_daily` VALUES ('1350341356727558146', '2020-12-30', '0', '163', '175', '112', '2021-01-16 15:17:22', '2021-01-16 15:17:22');
INSERT INTO `statistics_daily` VALUES ('1350341366194102274', '2020-12-31', '0', '167', '142', '116', '2021-01-16 15:17:24', '2021-01-16 15:17:24');
INSERT INTO `statistics_daily` VALUES ('1350342418268151810', '2021-01-01', '0', '114', '182', '165', '2021-01-16 15:21:35', '2021-01-16 15:21:35');
INSERT INTO `statistics_daily` VALUES ('1350342429114621954', '2021-01-02', '0', '118', '135', '160', '2021-01-16 15:21:38', '2021-01-16 15:21:38');
INSERT INTO `statistics_daily` VALUES ('1350342438878961665', '2021-01-03', '0', '180', '139', '126', '2021-01-16 15:21:40', '2021-01-16 15:21:40');
INSERT INTO `statistics_daily` VALUES ('1350342447674417153', '2021-01-04', '0', '193', '194', '154', '2021-01-16 15:21:42', '2021-01-16 15:21:42');
INSERT INTO `statistics_daily` VALUES ('1350342456843165698', '2021-01-05', '0', '182', '145', '105', '2021-01-16 15:21:45', '2021-01-16 15:21:45');
INSERT INTO `statistics_daily` VALUES ('1350342466636865538', '2021-01-06', '0', '172', '106', '162', '2021-01-16 15:21:47', '2021-01-16 15:21:47');
INSERT INTO `statistics_daily` VALUES ('1350342475449098241', '2021-01-07', '0', '140', '184', '164', '2021-01-16 15:21:49', '2021-01-16 15:21:49');
INSERT INTO `statistics_daily` VALUES ('1350342483980312578', '2021-01-08', '0', '194', '165', '133', '2021-01-16 15:21:51', '2021-01-16 15:21:51');
INSERT INTO `statistics_daily` VALUES ('1350342492054347777', '2021-01-09', '0', '196', '131', '169', '2021-01-16 15:21:53', '2021-01-16 15:21:53');
INSERT INTO `statistics_daily` VALUES ('1350342500476510210', '2021-01-10', '0', '168', '165', '158', '2021-01-16 15:21:55', '2021-01-16 15:21:55');
INSERT INTO `statistics_daily` VALUES ('1350342515513090049', '2021-01-11', '0', '191', '120', '152', '2021-01-16 15:21:59', '2021-01-16 15:21:59');
INSERT INTO `statistics_daily` VALUES ('1350342524446957569', '2021-01-12', '0', '117', '157', '159', '2021-01-16 15:22:01', '2021-01-16 15:22:01');
INSERT INTO `statistics_daily` VALUES ('1350342536891457538', '2021-01-13', '0', '120', '167', '155', '2021-01-16 15:22:04', '2021-01-16 15:22:04');
INSERT INTO `statistics_daily` VALUES ('1350342546110537730', '2021-01-14', '1', '158', '191', '190', '2021-01-16 15:22:06', '2021-01-16 15:22:06');
INSERT INTO `statistics_daily` VALUES ('1350484847587495937', '2021-01-15', '0', '194', '191', '190', '2021-01-17 00:47:33', '2021-01-17 00:47:33');
