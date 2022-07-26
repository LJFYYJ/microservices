/*
Navicat MySQL Data Transfer

Source Server         : 39.102.36.248
Source Server Version : 50732
Source Host           : 39.102.36.248:3306
Source Database       : jinggong_trade

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

Date: 2021-01-17 07:46:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `trade_order`
-- ----------------------------
DROP TABLE IF EXISTS `trade_order`;
CREATE TABLE `trade_order` (
  `id` char(19) NOT NULL DEFAULT '',
  `order_no` varchar(20) NOT NULL DEFAULT '' COMMENT '订单号',
  `course_id` varchar(19) NOT NULL DEFAULT '' COMMENT '课程id',
  `course_title` varchar(100) DEFAULT NULL COMMENT '课程名称',
  `course_cover` varchar(255) DEFAULT NULL COMMENT '课程封面',
  `teacher_name` varchar(20) DEFAULT NULL COMMENT '讲师名称',
  `member_id` varchar(19) NOT NULL DEFAULT '' COMMENT '会员id',
  `nickname` varchar(50) DEFAULT NULL COMMENT '会员昵称',
  `mobile` varchar(11) DEFAULT NULL COMMENT '会员手机',
  `total_fee` decimal(20,2) DEFAULT NULL COMMENT '订单金额（分）',
  `pay_type` tinyint(3) DEFAULT NULL COMMENT '支付类型（1：微信 2：支付宝）',
  `status` tinyint(3) DEFAULT NULL COMMENT '订单状态（0：未支付 1：已支付）',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_order_no` (`order_no`),
  KEY `idx_course_id` (`course_id`),
  KEY `idx_member_id` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单';

-- ----------------------------
-- Records of trade_order
-- ----------------------------
INSERT INTO `trade_order` VALUES ('1350311968162082818', '20210115212035677', '1350045153284472833', 'Django实战', 'https://bit-jinggong-file.oss-cn-beijing.aliyuncs.com/cover/2021/01/15/fb5a788e-ce3e-4961-9774-3201f02e0ebe.png', '周润发', '1349629291796824066', 'test', '15810100319', '1000.00', '1', '0', '1', '2021-01-16 13:20:35', '2021-01-16 13:20:35');
INSERT INTO `trade_order` VALUES ('1350312255652261889', '20210115212143945', '1350045153284472833', 'Django实战', 'https://bit-jinggong-file.oss-cn-beijing.aliyuncs.com/cover/2021/01/15/fb5a788e-ce3e-4961-9774-3201f02e0ebe.png', '周润发', '1349629291796824066', 'test', '15810100319', '1000.00', '1', '0', '0', '2021-01-16 13:21:44', '2021-01-16 13:21:44');
INSERT INTO `trade_order` VALUES ('1350331805974294530', '20210115223925910', '1349915474426744834', 'Spring Boot实战', 'https://bit-jinggong-file.oss-cn-beijing.aliyuncs.com/cover/2021/01/14/6952dfe3-1113-47b6-901d-f8125428aef8.png', '唐嫣', '1349629291796824066', 'test', '15810100319', '600.00', '1', '0', '0', '2021-01-16 14:39:25', '2021-01-16 14:39:25');
INSERT INTO `trade_order` VALUES ('1350411607364304897', '20210116035631374', '1349915474426744834', 'Spring Boot实战', 'https://bit-jinggong-file.oss-cn-beijing.aliyuncs.com/cover/2021/01/14/6952dfe3-1113-47b6-901d-f8125428aef8.png', '唐嫣', '1350063364121972737', '积极向上的阳光快乐好青年', '', '600.00', '1', '1', '0', '2021-01-16 19:56:31', '2021-01-16 21:24:04');
INSERT INTO `trade_order` VALUES ('1350418592390410242', '20210116042416004', '1350045153284472833', 'Django实战', 'https://bit-jinggong-file.oss-cn-beijing.aliyuncs.com/cover/2021/01/15/fb5a788e-ce3e-4961-9774-3201f02e0ebe.png', '周润发', '1350063364121972737', '积极向上的阳光快乐好青年', '', '1000.00', '1', '0', '0', '2021-01-16 20:24:17', '2021-01-16 20:24:17');
INSERT INTO `trade_order` VALUES ('1350541564769734657', '20210116203255947', '1349915474426744834', 'Spring Boot实战', 'https://bit-jinggong-file.oss-cn-beijing.aliyuncs.com/cover/2021/01/14/6952dfe3-1113-47b6-901d-f8125428aef8.png', '唐嫣', '1350541133905661954', 'havefun', '15810100000', '600.00', '1', '1', '0', '2021-01-17 04:32:56', '2021-01-17 04:33:09');
INSERT INTO `trade_order` VALUES ('1350584707951104002', '20210116232421504', '1349915474426744834', 'Spring Boot实战', 'https://bit-jinggong-file.oss-cn-beijing.aliyuncs.com/cover/2021/01/14/6952dfe3-1113-47b6-901d-f8125428aef8.png', '唐嫣', '1350584129028100097', 'wrh', '15810100001', '600.00', '1', '1', '0', '2021-01-17 07:24:22', '2021-01-17 07:26:25');
INSERT INTO `trade_order` VALUES ('1350587988530171906', '20210116233723856', '1350045153284472833', 'Django实战', 'https://bit-jinggong-file.oss-cn-beijing.aliyuncs.com/cover/2021/01/15/fb5a788e-ce3e-4961-9774-3201f02e0ebe.png', '周润发', '1350584129028100097', 'wrh', '15810100001', '1000.00', '1', '1', '0', '2021-01-17 07:37:24', '2021-01-17 07:37:34');

-- ----------------------------
-- Table structure for `trade_pay_log`
-- ----------------------------
DROP TABLE IF EXISTS `trade_pay_log`;
CREATE TABLE `trade_pay_log` (
  `id` char(19) NOT NULL DEFAULT '',
  `order_no` varchar(20) NOT NULL DEFAULT '' COMMENT '订单号',
  `pay_time` datetime DEFAULT NULL COMMENT '支付完成时间',
  `total_fee` bigint(20) DEFAULT NULL COMMENT '支付金额（分）',
  `transaction_id` varchar(30) DEFAULT NULL COMMENT '交易流水号',
  `trade_state` char(20) DEFAULT NULL COMMENT '交易状态',
  `pay_type` tinyint(3) NOT NULL DEFAULT '0' COMMENT '支付类型（1：微信 2：支付宝）',
  `attr` text COMMENT '其他属性',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_order_no` (`order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='支付日志表';

-- ----------------------------
-- Records of trade_pay_log
-- ----------------------------
INSERT INTO `trade_pay_log` VALUES ('1350433639468605442', '20210116035631374', '2021-01-16 21:24:04', null, null, null, '1', null, '0', '2021-01-16 21:24:04', '2021-01-16 21:24:04');
INSERT INTO `trade_pay_log` VALUES ('1350541622936342530', '20210116203255947', '2021-01-17 04:33:09', null, null, null, '1', null, '0', '2021-01-17 04:33:09', '2021-01-17 04:33:09');
INSERT INTO `trade_pay_log` VALUES ('1350585223196184578', '20210116232421504', '2021-01-17 07:26:25', null, null, null, '1', null, '0', '2021-01-17 07:26:25', '2021-01-17 07:26:25');
INSERT INTO `trade_pay_log` VALUES ('1350588031270129666', '20210116233723856', '2021-01-17 07:37:34', null, null, null, '1', null, '0', '2021-01-17 07:37:34', '2021-01-17 07:37:34');
