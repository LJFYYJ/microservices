/*
Navicat MySQL Data Transfer

Source Server         : 39.102.36.248
Source Server Version : 50732
Source Host           : 39.102.36.248:3306
Source Database       : jinggong_edu

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

Date: 2021-01-17 07:46:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `edu_chapter`
-- ----------------------------
DROP TABLE IF EXISTS `edu_chapter`;
CREATE TABLE `edu_chapter` (
  `id` char(19) NOT NULL COMMENT '章节ID',
  `course_id` char(19) NOT NULL COMMENT '课程ID',
  `title` varchar(50) NOT NULL COMMENT '章节名称',
  `sort` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '显示排序',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_course_id` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='课程';

-- ----------------------------
-- Records of edu_chapter
-- ----------------------------
INSERT INTO `edu_chapter` VALUES ('1349915530500395010', '1349915474426744834', 'Java基础知识学习', '0', '2021-01-15 11:05:17', '2021-01-15 20:24:35');
INSERT INTO `edu_chapter` VALUES ('1350052956204072962', '1350045153284472833', 'Python基础知识学习', '0', '2021-01-15 20:11:22', '2021-01-15 20:11:22');
INSERT INTO `edu_chapter` VALUES ('1350053596087103489', '1350045153284472833', 'Django环境搭建', '0', '2021-01-15 20:13:55', '2021-01-15 20:13:55');
INSERT INTO `edu_chapter` VALUES ('1350056342714466306', '1349915474426744834', 'Spring Boot学习', '0', '2021-01-15 20:24:50', '2021-01-15 20:24:50');
INSERT INTO `edu_chapter` VALUES ('1350057545116565505', '1350057505610416130', 'HTML基础知识学习', '0', '2021-01-15 20:29:36', '2021-01-15 20:29:36');
INSERT INTO `edu_chapter` VALUES ('1350057603073458178', '1350057505610416130', 'JavaScript学习', '0', '2021-01-15 20:29:50', '2021-01-15 20:29:50');
INSERT INTO `edu_chapter` VALUES ('1350057625601064961', '1350057505610416130', 'Vue学习', '0', '2021-01-15 20:29:55', '2021-01-15 20:29:55');
INSERT INTO `edu_chapter` VALUES ('1350588655382564866', '1350588624785117186', '基础知识', '0', '2021-01-17 07:40:03', '2021-01-17 07:40:03');
INSERT INTO `edu_chapter` VALUES ('1350588688551120898', '1350588624785117186', '环境配置', '0', '2021-01-17 07:40:11', '2021-01-17 07:40:11');

-- ----------------------------
-- Table structure for `edu_comment`
-- ----------------------------
DROP TABLE IF EXISTS `edu_comment`;
CREATE TABLE `edu_comment` (
  `id` char(19) NOT NULL COMMENT '讲师ID',
  `course_id` char(19) NOT NULL DEFAULT '' COMMENT '课程id',
  `teacher_id` char(19) NOT NULL DEFAULT '' COMMENT '讲师id',
  `member_id` char(19) NOT NULL DEFAULT '' COMMENT '会员id',
  `nickname` varchar(50) DEFAULT NULL COMMENT '会员昵称',
  `avatar` varchar(255) DEFAULT NULL COMMENT '会员头像',
  `content` varchar(500) DEFAULT NULL COMMENT '评论内容',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_course_id` (`course_id`),
  KEY `idx_teacher_id` (`teacher_id`),
  KEY `idx_member_id` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='评论';

-- ----------------------------
-- Records of edu_comment
-- ----------------------------

-- ----------------------------
-- Table structure for `edu_course`
-- ----------------------------
DROP TABLE IF EXISTS `edu_course`;
CREATE TABLE `edu_course` (
  `id` char(19) NOT NULL COMMENT '课程ID',
  `teacher_id` char(19) NOT NULL COMMENT '课程讲师ID',
  `subject_id` char(19) NOT NULL COMMENT '课程专业ID',
  `subject_parent_id` char(19) NOT NULL COMMENT '课程专业父级ID',
  `title` varchar(50) NOT NULL COMMENT '课程标题',
  `price` decimal(10,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '课程销售价格，设置为0则可免费观看',
  `lesson_num` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '总课时',
  `cover` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '课程封面图片路径',
  `buy_count` bigint(10) unsigned NOT NULL DEFAULT '0' COMMENT '销售数量',
  `view_count` bigint(10) unsigned NOT NULL DEFAULT '0' COMMENT '浏览数量',
  `version` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT '乐观锁',
  `status` varchar(10) NOT NULL DEFAULT 'Draft' COMMENT '课程状态 Draft未发布  Normal已发布',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_title` (`title`),
  KEY `idx_subject_id` (`subject_id`),
  KEY `idx_teacher_id` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='课程';

-- ----------------------------
-- Records of edu_course
-- ----------------------------
INSERT INTO `edu_course` VALUES ('1349915474426744834', '10', '1349910890941665282', '1349910890799058946', 'Spring Boot实战', '6.00', '32', 'https://bit-jinggong-file.oss-cn-beijing.aliyuncs.com/cover/2021/01/14/6952dfe3-1113-47b6-901d-f8125428aef8.png', '0', '23', '1', 'Normal', '2021-01-15 11:05:04', '2021-01-17 07:36:31');
INSERT INTO `edu_course` VALUES ('1350045153284472833', '2', '1349910891243655169', '1349910890799058946', 'Django实战', '10.00', '16', 'https://bit-jinggong-file.oss-cn-beijing.aliyuncs.com/cover/2021/01/15/fb5a788e-ce3e-4961-9774-3201f02e0ebe.png', '0', '31', '1', 'Normal', '2021-01-15 19:40:22', '2021-01-17 07:37:45');
INSERT INTO `edu_course` VALUES ('1350057505610416130', '4', '1349910891650502657', '1349910891361095682', 'Vue实战', '0.00', '64', 'https://bit-jinggong-file.oss-cn-beijing.aliyuncs.com/cover/2021/01/15/4c0bc0be-a9ba-44ad-8a63-3f780c5c39ae.png', '0', '9', '1', 'Normal', '2021-01-15 20:29:27', '2021-01-17 04:21:53');
INSERT INTO `edu_course` VALUES ('1350588624785117186', '6', '1349910891650502657', '1349910891361095682', 'Vue实战2', '12.00', '12', 'https://bit-jinggong-file.oss-cn-beijing.aliyuncs.com/cover/2021/01/16/a880ee47-5e51-4fcf-b5fa-d5082eb08124.png', '0', '0', '1', 'Normal', '2021-01-17 07:39:56', '2021-01-17 07:40:39');

-- ----------------------------
-- Table structure for `edu_course_collect`
-- ----------------------------
DROP TABLE IF EXISTS `edu_course_collect`;
CREATE TABLE `edu_course_collect` (
  `id` char(19) NOT NULL COMMENT '收藏ID',
  `course_id` char(19) NOT NULL COMMENT '课程讲师ID',
  `member_id` char(19) NOT NULL DEFAULT '' COMMENT '课程专业ID',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='课程收藏';

-- ----------------------------
-- Records of edu_course_collect
-- ----------------------------
INSERT INTO `edu_course_collect` VALUES ('1350584617064730626', '1349915474426744834', '1350584129028100097', '2021-01-17 07:24:00', '2021-01-17 07:24:00');

-- ----------------------------
-- Table structure for `edu_course_description`
-- ----------------------------
DROP TABLE IF EXISTS `edu_course_description`;
CREATE TABLE `edu_course_description` (
  `id` char(19) NOT NULL COMMENT '课程ID',
  `description` text COMMENT '课程简介',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='课程简介';

-- ----------------------------
-- Records of edu_course_description
-- ----------------------------
INSERT INTO `edu_course_description` VALUES ('1349915474426744834', '<p>Spring Boot实战非常重要，大家一起来<strong>学习</strong>吧</p>', '2021-01-15 11:05:04', '2021-01-15 20:23:49');
INSERT INTO `edu_course_description` VALUES ('1350045153284472833', '<p>快来一起学习Django！</p>', '2021-01-15 19:40:22', '2021-01-15 19:40:22');
INSERT INTO `edu_course_description` VALUES ('1350057505610416130', '<p>快来学习Vue吧！!</p>', '2021-01-15 20:29:27', '2021-01-17 04:21:24');
INSERT INTO `edu_course_description` VALUES ('1350588624785117186', '<p>学习<strong>学习</strong></p>', '2021-01-17 07:39:56', '2021-01-17 07:39:56');

-- ----------------------------
-- Table structure for `edu_subject`
-- ----------------------------
DROP TABLE IF EXISTS `edu_subject`;
CREATE TABLE `edu_subject` (
  `id` char(19) NOT NULL COMMENT '课程类别ID',
  `title` varchar(10) NOT NULL COMMENT '类别名称',
  `parent_id` char(19) NOT NULL DEFAULT '0' COMMENT '父ID',
  `sort` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '排序字段',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_parent_id` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='课程科目';

-- ----------------------------
-- Records of edu_subject
-- ----------------------------
INSERT INTO `edu_subject` VALUES ('1349910890799058946', '后端开发', '0', '0', '2021-01-15 10:46:51', '2021-01-15 10:46:51');
INSERT INTO `edu_subject` VALUES ('1349910890941665282', 'Java', '1349910890799058946', '0', '2021-01-15 10:46:51', '2021-01-15 10:46:51');
INSERT INTO `edu_subject` VALUES ('1349910891243655169', 'Python', '1349910890799058946', '0', '2021-01-15 10:46:51', '2021-01-15 10:46:51');
INSERT INTO `edu_subject` VALUES ('1349910891361095682', '前端开发', '0', '0', '2021-01-15 10:46:51', '2021-01-15 10:46:51');
INSERT INTO `edu_subject` VALUES ('1349910891470147586', 'HTML/CSS', '1349910891361095682', '0', '2021-01-15 10:46:51', '2021-01-15 10:46:51');
INSERT INTO `edu_subject` VALUES ('1349910891650502657', 'JavaScript', '1349910891361095682', '0', '2021-01-15 10:46:51', '2021-01-15 10:46:51');
INSERT INTO `edu_subject` VALUES ('1349910891793108993', '云计算', '0', '0', '2021-01-15 10:46:51', '2021-01-15 10:46:51');
INSERT INTO `edu_subject` VALUES ('1349910891969269761', 'Docker', '1349910891793108993', '0', '2021-01-15 10:46:51', '2021-01-15 10:46:51');
INSERT INTO `edu_subject` VALUES ('1349910893013651457', 'Linux', '1349910891793108993', '0', '2021-01-15 10:46:52', '2021-01-15 10:46:52');
INSERT INTO `edu_subject` VALUES ('1349910893114314753', '系统/运维', '0', '0', '2021-01-15 10:46:52', '2021-01-15 10:46:52');
INSERT INTO `edu_subject` VALUES ('1349910893219172354', 'Linux', '1349910893114314753', '0', '2021-01-15 10:46:52', '2021-01-15 10:46:52');
INSERT INTO `edu_subject` VALUES ('1349910893357584386', 'Windows', '1349910893114314753', '0', '2021-01-15 10:46:52', '2021-01-15 10:46:52');
INSERT INTO `edu_subject` VALUES ('1349910893504385025', '数据库', '0', '0', '2021-01-15 10:46:52', '2021-01-15 10:46:52');
INSERT INTO `edu_subject` VALUES ('1349910893663768577', 'MySQL', '1349910893504385025', '0', '2021-01-15 10:46:52', '2021-01-15 10:46:52');
INSERT INTO `edu_subject` VALUES ('1349910893869289474', 'MongoDB', '1349910893504385025', '0', '2021-01-15 10:46:52', '2021-01-15 10:46:52');
INSERT INTO `edu_subject` VALUES ('1349910893974147073', '大数据', '0', '0', '2021-01-15 10:46:52', '2021-01-15 10:46:52');
INSERT INTO `edu_subject` VALUES ('1349910894095781890', 'Hadoop', '1349910893974147073', '0', '2021-01-15 10:46:52', '2021-01-15 10:46:52');
INSERT INTO `edu_subject` VALUES ('1349910894250971138', 'Spark', '1349910893974147073', '0', '2021-01-15 10:46:52', '2021-01-15 10:46:52');
INSERT INTO `edu_subject` VALUES ('1349910894422937602', '人工智能', '0', '0', '2021-01-15 10:46:52', '2021-01-15 10:46:52');
INSERT INTO `edu_subject` VALUES ('1349910894607486978', 'Python', '1349910894422937602', '0', '2021-01-15 10:46:52', '2021-01-15 10:46:52');
INSERT INTO `edu_subject` VALUES ('1349910894712344578', '编程语言', '0', '0', '2021-01-15 10:46:52', '2021-01-15 10:46:52');
INSERT INTO `edu_subject` VALUES ('1349910894821396481', 'Java', '1349910894712344578', '0', '2021-01-15 10:46:52', '2021-01-15 10:46:52');

-- ----------------------------
-- Table structure for `edu_teacher`
-- ----------------------------
DROP TABLE IF EXISTS `edu_teacher`;
CREATE TABLE `edu_teacher` (
  `id` char(19) NOT NULL COMMENT '讲师ID',
  `name` varchar(20) NOT NULL COMMENT '讲师姓名',
  `intro` varchar(500) NOT NULL DEFAULT '' COMMENT '讲师简介',
  `career` varchar(500) DEFAULT NULL COMMENT '讲师资历,一句话说明讲师',
  `level` int(10) unsigned NOT NULL COMMENT '头衔 1高级讲师 2首席讲师',
  `avatar` varchar(255) DEFAULT NULL COMMENT '讲师头像',
  `sort` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '排序',
  `join_date` date DEFAULT NULL COMMENT '入驻时间',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='讲师';

-- ----------------------------
-- Records of edu_teacher
-- ----------------------------
INSERT INTO `edu_teacher` VALUES ('1', '刘德华', '毕业于师范大学数学系，热爱教育事业，执教数学思维6年有余', '具备深厚的数学思维功底、丰富的小学教育经验，授课风格生动活泼，擅长用形象生动的比喻帮助理解、简单易懂的语言讲解难题，深受学生喜欢', '2', 'https://bit-jinggong-file.oss-cn-beijing.aliyuncs.com/avatar/2021/01/teacher/%E5%88%98%E5%BE%B7%E5%8D%8E.jpg', '10', '2019-10-29', '0', '2018-03-30 17:15:57', '2019-04-28 05:02:18');
INSERT INTO `edu_teacher` VALUES ('10', '唐嫣', '北京师范大学法学院副教授', '北京师范大学法学院副教授、清华大学法学博士。自2004年至今已有9年的司法考试培训经验。长期从事司法考试辅导，深知命题规律，了解解题技巧。内容把握准确，授课重点明确，层次分明，调理清晰，将法条法理与案例有机融合，强调综合，深入浅出。', '1', 'https://bit-jinggong-file.oss-cn-beijing.aliyuncs.com/avatar/2021/01/teacher/%E5%94%90%E5%AB%A3.jpg', '20', '2019-10-29', '0', '2018-04-03 14:32:19', '2019-02-22 02:01:26');
INSERT INTO `edu_teacher` VALUES ('1349910065494249474', '刘亦菲', '讲师简介讲师简介讲师简介讲师简介讲师简介讲师简介讲师简介讲师简介', '讲师资历讲师资历讲师资历讲师资历讲师资历讲师资历讲师资历讲师资历讲师资历讲师资历', '2', 'https://bit-jinggong-file.oss-cn-beijing.aliyuncs.com/avatar/2021/01/14/d920f068-5a44-4a18-a4fd-49cf77915f03.jpg', '1', '2021-01-01', '0', '2021-01-15 10:43:34', '2021-01-15 10:43:34');
INSERT INTO `edu_teacher` VALUES ('1350539224700424194', '刘亦菲2', '讲师简介讲师简介讲师简介讲师简介讲师简介讲师简介', '讲师资历讲师资历讲师资历讲师资历讲师资历讲师资历讲师资历讲师资历', '1', 'https://bit-jinggong-file.oss-cn-beijing.aliyuncs.com/avatar/2021/01/16/dd1b9781-52d6-4f45-a1ef-ea9a6e63793c.jpg', '0', '2021-01-09', '0', '2021-01-17 04:23:38', '2021-01-17 04:23:38');
INSERT INTO `edu_teacher` VALUES ('2', '周润发', '中国人民大学附属中学数学一级教师', '中国科学院数学与系统科学研究院应用数学专业博士，研究方向为数字图像处理，中国工业与应用数学学会会员。参与全国教育科学“十五”规划重点课题“信息化进程中的教育技术发展研究”的子课题“基与课程改革的资源开发与应用”，以及全国“十五”科研规划全国重点项目“掌上型信息技术产品在教学中的运用和开发研究”的子课题“用技术学数学”。', '2', 'https://bit-jinggong-file.oss-cn-beijing.aliyuncs.com/avatar/2021/01/teacher/%E5%91%A8%E6%B6%A6%E5%8F%91.jpg', '1', '2019-10-28', '0', '2018-03-30 18:28:26', '2020-04-14 17:40:36');
INSERT INTO `edu_teacher` VALUES ('3', '钟汉良', '毕业于北京理工大学计算机学院，荣获两次国家奖学金。', '中教一级职称。讲课极具亲和力。', '1', 'https://bit-jinggong-file.oss-cn-beijing.aliyuncs.com/avatar/2021/01/teacher/%E9%92%9F%E6%B1%89%E8%89%AF.jpg', '2', '2019-10-29', '0', '2018-03-31 09:20:46', '2019-02-22 02:01:27');
INSERT INTO `edu_teacher` VALUES ('4', '周杰伦', '长期从事考研政治课讲授和考研命题趋势与应试对策研究。考研辅导新锐派的代表。', '政治学博士、管理学博士后，北京师范大学马克思主义学院副教授。多年来总结出了一套行之有效的应试技巧与答题方法，针对性和实用性极强，能帮助考生在轻松中应考，在激励的竞争中取得高分，脱颖而出。', '1', 'https://bit-jinggong-file.oss-cn-beijing.aliyuncs.com/avatar/2021/01/teacher/%E5%91%A8%E6%9D%B0%E4%BC%A6.jpg', '1', '2019-10-27', '0', '2018-04-03 14:13:51', '2019-10-29 19:52:46');
INSERT INTO `edu_teacher` VALUES ('5', '陈伟霆', '人大附中2009届毕业生', '北京大学数学科学学院2008级本科生，2012年第八届学生五四奖章获得者，在数学领域取得多项国际国内奖项，学术研究成绩突出。曾被两次评为北京大学三好学生、一次评为北京大学三好标兵，获得过北京大学国家奖学金、北京大学廖凯原奖学金、北京大学星光国际一等奖学金、北京大学明德新生奖学金等。', '1', 'https://bit-jinggong-file.oss-cn-beijing.aliyuncs.com/avatar/2021/01/teacher/%E9%99%88%E4%BC%9F%E9%9C%86.jpg', '1', '2019-10-29', '0', '2018-04-03 14:15:36', '2019-02-22 02:01:29');
INSERT INTO `edu_teacher` VALUES ('6', '高圆圆', '华东师范大学数学系硕士生导师，中国数学奥林匹克高级教练', '曾参与北京市及全国多项数学活动的命题和组织工作，多次带领北京队参加高中、初中、小学的各项数学竞赛，均取得优异成绩。教学活而新，能够调动学生的学习兴趣并擅长对学生进行思维点拨，对学生学习习惯的养成和非智力因素培养有独到之处，是一位深受学生喜爱的老师。', '1', 'https://bit-jinggong-file.oss-cn-beijing.aliyuncs.com/avatar/2021/01/teacher/%E9%AB%98%E5%9C%86%E5%9C%86.jpg', '1', '2019-10-29', '0', '2018-04-01 14:19:28', '2019-02-22 02:01:29');
INSERT INTO `edu_teacher` VALUES ('7', '胡歌', '考研政治辅导实战派专家，全国考研政治命题研究组核心成员。', '法学博士，北京师范大学马克思主义学院副教授，专攻毛泽东思想概论、邓小平理论，长期从事考研辅导。出版著作两部，发表学术论文30余篇，主持国家社会科学基金项目和教育部重大课题子课题各一项，参与中央实施马克思主义理论研究和建设工程项目。', '2', 'https://bit-jinggong-file.oss-cn-beijing.aliyuncs.com/avatar/2021/01/teacher/%E8%83%A1%E6%AD%8C.jpg', '8', '2019-09-04', '0', '2018-04-03 14:21:03', '2019-02-22 02:01:30');
INSERT INTO `edu_teacher` VALUES ('8', '刘诗诗', '资深课程设计专家，专注10年AACTP美国培训协会认证导师', '十年课程研发和培训咨询经验，曾任国企人力资源经理、大型外企培训经理，负责企业大学和培训体系搭建；曾任专业培训机构高级顾问、研发部总监，为包括广东移动、东莞移动、深圳移动、南方电网、工商银行、农业银行、民生银行、邮储银行、TCL集团、清华大学继续教育学院、中天路桥、广西扬翔股份等超过200家企业提供过培训与咨询服务，并担任近50个大型项目的总负责人。', '1', 'https://bit-jinggong-file.oss-cn-beijing.aliyuncs.com/avatar/2021/01/teacher/%E5%88%98%E8%AF%97%E8%AF%97.jpg', '10', '2019-10-29', '0', '2018-04-03 14:23:33', '2019-11-23 08:38:09');

-- ----------------------------
-- Table structure for `edu_video`
-- ----------------------------
DROP TABLE IF EXISTS `edu_video`;
CREATE TABLE `edu_video` (
  `id` char(19) NOT NULL COMMENT '视频ID',
  `course_id` char(19) NOT NULL COMMENT '课程ID',
  `chapter_id` char(19) NOT NULL COMMENT '章节ID',
  `title` varchar(50) NOT NULL COMMENT '节点名称',
  `video_source_id` varchar(100) DEFAULT NULL COMMENT '云端视频资源',
  `video_original_name` varchar(100) DEFAULT NULL COMMENT '原始文件名称',
  `sort` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '排序字段',
  `play_count` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '播放次数',
  `is_free` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否可以试听：0收费 1免费',
  `duration` float NOT NULL DEFAULT '0' COMMENT '视频时长（秒）',
  `status` varchar(20) NOT NULL DEFAULT 'Empty' COMMENT '状态',
  `size` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '视频源文件大小（字节）',
  `version` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT '乐观锁',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_course_id` (`course_id`),
  KEY `idx_chapter_id` (`chapter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='课程视频';

-- ----------------------------
-- Records of edu_video
-- ----------------------------
INSERT INTO `edu_video` VALUES ('1350053837242806274', '1350045153284472833', '1350052956204072962', '绪论', '03bbbbbab8434574af62457e95515920', '6.mp4', '0', '0', '1', '0', 'Empty', '0', '1', '2021-01-15 20:14:52', '2021-01-15 20:17:11');
INSERT INTO `edu_video` VALUES ('1350055213041627138', '1350045153284472833', '1350052956204072962', '第一章', 'd7bb01e1717343af8d85ce380e439abc', '6.mp4', '1', '0', '0', '0', 'Empty', '0', '1', '2021-01-15 20:20:20', '2021-01-15 20:20:20');
INSERT INTO `edu_video` VALUES ('1350056253530980354', '1349915474426744834', '1349915530500395010', '第一章', 'ac2fa1bb05634b918b4d900446cdc973', '6.mp4', '0', '0', '0', '0', 'Empty', '0', '1', '2021-01-15 20:24:28', '2021-01-15 20:24:28');
INSERT INTO `edu_video` VALUES ('1350056309969534977', '1349915474426744834', '1349915530500395010', '第二章', null, null, '0', '0', '0', '0', 'Empty', '0', '1', '2021-01-15 20:24:42', '2021-01-15 20:24:42');
INSERT INTO `edu_video` VALUES ('1350056464076652545', '1349915474426744834', '1350056342714466306', '第一章', '1d5777240bb24144aa9cf2c7e073522c', '6.mp4', '0', '0', '1', '0', 'Empty', '0', '1', '2021-01-15 20:25:19', '2021-01-15 20:25:19');
INSERT INTO `edu_video` VALUES ('1350056521068855297', '1349915474426744834', '1350056342714466306', '第二章', '068f49a576454baca6e5309f44bfb56f', '6.mp4', '0', '0', '0', '0', 'Empty', '0', '1', '2021-01-15 20:25:32', '2021-01-15 20:25:32');
INSERT INTO `edu_video` VALUES ('1350057683897696258', '1350057505610416130', '1350057625601064961', '安装环境配置', '6b21bd8fe0854dedb9728a54ff011ccf', '6.mp4', '0', '0', '1', '0', 'Empty', '0', '1', '2021-01-15 20:30:09', '2021-01-15 20:30:09');
INSERT INTO `edu_video` VALUES ('1350057925997117441', '1350057505610416130', '1350057625601064961', '基本知识学习', '0ef2fd55e94d4a73a8d6c58943f75b85', '6.mp4', '0', '0', '0', '0', 'Empty', '0', '1', '2021-01-15 20:31:07', '2021-01-15 20:31:07');
INSERT INTO `edu_video` VALUES ('1350588783464026113', '1350588624785117186', '1350588688551120898', '绪论', '6b29cdeafe5048808c4ae255db5343c5', '6.mp4', '0', '0', '0', '0', 'Empty', '0', '1', '2021-01-17 07:40:33', '2021-01-17 07:40:33');
