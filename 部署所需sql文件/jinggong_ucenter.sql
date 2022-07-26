/*
Navicat MySQL Data Transfer

Source Server         : 39.102.36.248
Source Server Version : 50732
Source Host           : 39.102.36.248:3306
Source Database       : jinggong_ucenter

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

Date: 2021-01-17 07:46:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ucenter_member`
-- ----------------------------
DROP TABLE IF EXISTS `ucenter_member`;
CREATE TABLE `ucenter_member` (
  `id` char(19) NOT NULL COMMENT '会员id',
  `openid` varchar(128) DEFAULT NULL COMMENT '微信openid',
  `mobile` varchar(11) DEFAULT '' COMMENT '手机号',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `sex` tinyint(2) unsigned DEFAULT NULL COMMENT '性别 1 男，2 女',
  `age` tinyint(3) unsigned DEFAULT NULL COMMENT '年龄',
  `avatar` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `sign` varchar(100) DEFAULT NULL COMMENT '用户签名',
  `is_disabled` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否禁用 1（true）已禁用，  0（false）未禁用',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='会员表';

-- ----------------------------
-- Records of ucenter_member
-- ----------------------------
INSERT INTO `ucenter_member` VALUES ('1080736474267144193', null, '13700000011', '96e79218965eb72c92a549dd5a330112', '用户XJtDfaYeKk', '1', '19', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', null, '0', '0', '2019-01-02 12:12:45', '2019-01-02 12:12:56');
INSERT INTO `ucenter_member` VALUES ('1080736474355224577', null, '13700000002', '96e79218965eb72c92a549dd5a330112', '用户wUrNkzAPrc', '1', '27', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', null, '0', '0', '2019-01-02 12:13:56', '2019-01-02 12:14:07');
INSERT INTO `ucenter_member` VALUES ('1086387099449442306', null, '13520191388', '96e79218965eb72c92a549dd5a330112', '用户XTMUeHDAoj', '2', '20', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', null, '0', '0', '2019-01-19 06:17:23', '2019-01-19 06:17:23');
INSERT INTO `ucenter_member` VALUES ('1086387099520745473', null, '13520191389', '96e79218965eb72c92a549dd5a330112', '用户vSdKeDlimn', '1', '21', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', null, '0', '0', '2019-01-19 06:17:23', '2019-01-19 06:17:23');
INSERT INTO `ucenter_member` VALUES ('1086387099608825858', null, '13520191381', '96e79218965eb72c92a549dd5a330112', '用户EoyWUVXQoP', '1', '18', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', null, '0', '0', '2019-01-19 06:17:23', '2019-01-19 06:17:23');
INSERT INTO `ucenter_member` VALUES ('1086387099701100545', null, '13520191382', '96e79218965eb72c92a549dd5a330112', '用户LcAYbxLNdN', '2', '24', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', null, '0', '0', '2019-01-19 06:17:23', '2019-01-19 06:17:23');
INSERT INTO `ucenter_member` VALUES ('1086387099776598018', null, '13520191383', '96e79218965eb72c92a549dd5a330112', '用户dZdjcgltnk', '2', '25', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', null, '0', '0', '2019-01-19 06:17:23', '2019-01-19 06:17:23');
INSERT INTO `ucenter_member` VALUES ('1086387099852095490', null, '13520191384', '96e79218965eb72c92a549dd5a330112', '用户wNHGHlxUwX', '2', '23', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', null, '0', '0', '2019-01-19 06:17:23', '2019-01-19 06:17:23');
INSERT INTO `ucenter_member` VALUES ('1106746895272849410', 'o1R-t5u2TfEVeVjO9CPGdHPNw-to', null, null, '檀梵\'', null, null, 'http://thirdwx.qlogo.cn/mmopen/vi_32/zZfLXcetf2Rpsibq6HbPUWKgWSJHtha9y1XBeaqluPUs6BYicW1FJaVqj7U3ozHd3iaodGKJOvY2PvqYTuCKwpyfQ/132', null, '0', '0', '2019-03-16 10:39:57', '2019-03-16 10:39:57');
INSERT INTO `ucenter_member` VALUES ('1106823035660357634', 'o1R-t5i4gENwHYRb5lVFy98Z0bdk', null, null, 'GaoSir', null, null, 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJI53RcCuc1no02os6ZrattWGiazlPnicoZQ59zkS7phNdLEWUPDk8fzoxibAnXV1Sbx0trqXEsGhXPw/132', null, '0', '0', '2019-03-16 15:42:30', '2019-03-16 15:42:30');
INSERT INTO `ucenter_member` VALUES ('1106823115788341250', 'o1R-t5l_3rnbZbn4jWwFdy6Gk6cg', null, null, '换个网名哇、', null, null, 'http://thirdwx.qlogo.cn/mmopen/vi_32/jJHyeM0EN2jhB70LntI3k8fEKe7W6CwykrKMgDJM4VZqCpcxibVibX397p0vmbKURGkLS4jxjGB0GpZfxCicgt07w/132', null, '0', '0', '2019-03-16 15:42:49', '2019-03-16 15:42:49');
INSERT INTO `ucenter_member` VALUES ('1106828185829490690', 'o1R-t5nNlou5lRwBVgGNJFm4rbc4', null, null, ' 虎头', null, null, 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKxCqRzuYWQmpwiaqQEjNxbC7WicebicXQusU306jgmfoOzUcFg1qaDq5BStiblwBjw5dUOblQ2gUicQOQ/132', null, '0', '0', '2019-03-16 16:02:58', '2019-03-16 16:02:58');
INSERT INTO `ucenter_member` VALUES ('1106830599651442689', 'o1R-t5hZHQB1cbX7HZJsiM727_SA', null, null, '是吴啊', null, null, 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ9CsqApybcs7f3Dyib9IxIh0sBqJb7LicbjU4WticJFF0PVwFvHgtbFdBwfmk3H2t3NyqmEmVx17tRA/132', null, '0', '0', '2019-03-16 16:12:34', '2019-03-16 16:12:34');
INSERT INTO `ucenter_member` VALUES ('1106830976199278593', 'o1R-t5meKOoyEJ3-IhWRCBKFcvzU', null, null, '我才是Helen', null, null, 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epMicP9UT6mVjYWdno0OJZkOXiajG0sllJTbGJ9DYiceej2XvbDSGCK8LCF7jv1PuG2uoYlePWic9XO8A/132', null, '0', '0', '2019-03-16 16:14:03', '2019-03-16 16:14:03');
INSERT INTO `ucenter_member` VALUES ('1106831936900415490', 'o1R-t5jXYSWakGtnUBnKbfVT5Iok', null, null, '文若姬', null, null, 'http://thirdwx.qlogo.cn/mmopen/vi_32/3HEmJwpSzguqqAyzmBwqT6aicIanswZibEOicQInQJI3ZY1qmu59icJC6N7SahKqWYv24GvX5KH2fibwt0mPWcTJ3fg/132', null, '0', '0', '2019-03-16 16:17:52', '2019-03-16 16:17:52');
INSERT INTO `ucenter_member` VALUES ('1106832491064442882', 'o1R-t5sud081Qsa2Vb2xSKgGnf_g', null, null, 'Peanut', null, null, 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', null, '0', '0', '2019-03-16 16:20:04', '2019-03-16 16:20:04');
INSERT INTO `ucenter_member` VALUES ('1106833021442510849', 'o1R-t5lsGc3I8P5bDpHj7m_AIRvQ', null, null, '食物链终结者', null, null, 'http://thirdwx.qlogo.cn/mmopen/vi_32/MQ7qUmCprK9am16M1Ia1Cs3RK0qiarRrl9y8gsssBjIZeS2GwKSrnq7ZYhmrzuzDwBxSMMAofrXeLic9IBlW4M3Q/132', null, '0', '0', '2019-03-16 16:22:11', '2019-03-16 16:22:11');
INSERT INTO `ucenter_member` VALUES ('1191600824445046786', null, '15210078344', '96e79218965eb72c92a549dd5a330112', 'IT妖姬', '1', '5', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', null, '0', '0', '2019-11-05 14:19:10', '2019-11-08 18:04:43');
INSERT INTO `ucenter_member` VALUES ('1191616288114163713', null, '17866603606', '96e79218965eb72c92a549dd5a330112', 'xiaowu', null, null, 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', null, '0', '0', '2019-11-05 15:20:37', '2019-11-05 15:20:37');
INSERT INTO `ucenter_member` VALUES ('1195187659054329857', null, '15010546384', '96e79218965eb72c92a549dd5a330112', 'qy', null, null, 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', null, '0', '0', '2019-11-15 11:51:58', '2019-11-15 11:51:58');
INSERT INTO `ucenter_member` VALUES ('1203050193780584450', null, '18686842318', 'e10adc3949ba59abbe56e057f20f883e', 'cohen', null, null, 'https://online-teach-file-helen.oss-cn-beijing.aliyuncs.com/avatar/default.jpg', null, '0', '0', '2019-12-07 04:34:52', '2019-12-07 04:34:52');
INSERT INTO `ucenter_member` VALUES ('1203065189981810689', null, '13766816630', 'e10adc3949ba59abbe56e057f20f883e', 'helen', null, null, 'https://online-teach-file-helen.oss-cn-beijing.aliyuncs.com/avatar/default.jpg', null, '0', '0', '2019-12-07 05:34:28', '2019-12-07 05:34:28');
INSERT INTO `ucenter_member` VALUES ('1203898148695597058', 'o3_SC58aj3laPkwse2H2mBP8PFyk', '', null, '我是Helenฉันคิดถึง', '2', null, 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIhQbQxWia9dQyfUESGSiaI2qxgznhNsRsOoxYXGwn65icSYGRcosxdqTRA4a1g23icGLMSKPibxa0PHGg/132', null, '0', '0', '2019-12-09 12:44:21', '2019-12-09 12:44:21');
INSERT INTO `ucenter_member` VALUES ('1349629291796824066', null, '15810100319', 'e10adc3949ba59abbe56e057f20f883e', 'test', null, null, 'https://bit-jinggong-file.oss-cn-beijing.aliyuncs.com/avatar/2021/01/08/default.jfif', null, '0', '0', '2021-01-14 16:07:53', '2021-01-14 16:07:53');
INSERT INTO `ucenter_member` VALUES ('1350063364121972737', 'o3_SC5xmgoI8LnXdhOxrmyBTGFoM', '', null, '积极向上的阳光快乐好青年', '1', null, 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83er6KJKcYFmIyClPTqjZVclgQicd8ezpjuPa5dmaTV5BNOaicTJMLs28774lFPYYlKRmPtmYmibhAMNyw/132', null, '0', '0', '2021-01-15 20:52:44', '2021-01-15 20:52:44');
INSERT INTO `ucenter_member` VALUES ('1350541133905661954', null, '15810100000', 'e10adc3949ba59abbe56e057f20f883e', 'havefun', null, null, 'https://bit-jinggong-file.oss-cn-beijing.aliyuncs.com/avatar/2021/01/08/default.jfif', null, '0', '0', '2021-01-17 04:31:13', '2021-01-17 04:31:13');
INSERT INTO `ucenter_member` VALUES ('1350584129028100097', null, '15810100001', 'e10adc3949ba59abbe56e057f20f883e', 'wrh', null, null, 'https://bit-jinggong-file.oss-cn-beijing.aliyuncs.com/avatar/2021/01/08/default.jfif', null, '0', '0', '2021-01-17 07:22:04', '2021-01-17 07:22:04');
