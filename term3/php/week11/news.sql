/*
Navicat MySQL Data Transfer

Source Server         : msyql1101
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : news

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2019-11-04 11:51:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '',
  `pwd` varchar(32) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('2', 'admin', '21232f297a57a5a743894a0e4a801fc3');

-- ----------------------------
-- Table structure for news_cat
-- ----------------------------
DROP TABLE IF EXISTS `news_cat`;
CREATE TABLE `news_cat` (
  `catID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `catTitle` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`catID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news_cat
-- ----------------------------

-- ----------------------------
-- Table structure for news_info
-- ----------------------------
DROP TABLE IF EXISTS `news_info`;
CREATE TABLE `news_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL DEFAULT '',
  `summary` varchar(200) NOT NULL DEFAULT '',
  `postTime` date NOT NULL DEFAULT '0000-00-00',
  `author` varchar(30) NOT NULL DEFAULT '',
  `content` text NOT NULL,
  `updateTime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news_info
-- ----------------------------
INSERT INTO `news_info` VALUES ('1', '华软学院举行主题教育第一次集中学习研讨', '【不忘初心、牢记使命】华软学院举行主题教育第一次集中学习研讨（图文）', '2019-10-23', '张三', '本网讯  10月15日上午，华软学院在图书馆310党员教育中心举行“不忘初心、牢记使命”主题教育第一次集中学习研讨，重点学习《习近平新时代中国特色社会主义思想学习纲要》。学院党委书记刘友坤、党委委员、党总支书记、直属党支部书记出席。学习研讨活动由刘友坤书记主持，由党群工作部曾伟朝部长、学院办公室王婧主任和学院团委罗达书记领学。 \n\n根据广州大学党委和学院党委主题教育实施方案要求，华软学院制定了“不忘初心、牢记使命”主题教育集中学习研讨方案，围绕习近平新时代中国特色社会主义思想体系、习近平总书记关于初心使命的重要论述、关于教育工作的重要讲话和指示精神，通过个人自学、领导领学、集中学习研讨、交流会、知识竞赛、观看革命历史纪录片、参观红色教育基地、参观廉政文化教育展等多种形式，全面深入系统学，在学深悟透做实上下真功夫，确保学习教育取得了扎实成效。 \n', null);
INSERT INTO `news_info` VALUES ('2', '广州大学华软软件学院：推出“学习强国”平台激励机制', '【学习强国】广州大学华软软件学院：推出“学习强国”平台激励机制，助力主题教育（2019年10月14日）', '2019-10-22', 'zhangsan', '学习强国学习平台讯  最近，广州大学华软软件学院党委利用“学习强国”平台作为推进主题教育的重要载体加以推进，坚持第一时间启动、第一时间推动、第一时间落实，迅速推动全体党员下载、注册、登录“学习强国”APP，并且积极向全院师生推荐使用，让全体党员干部在“学习强国”平台上学有所获、学有所悟、学以致用。 \r\n呈现“比学赶超”的态势 \r\n\r\n近日，广州大学华软软件学院党委公布“学习强国”教工党员前50名和学生党员前30名排行榜，他们是学院“学习强国”学习标兵。“学习强国”学习平台推广以来，广州大学华软软件学院各基层党组织掀起了一股学习热潮。全院党员干部充分利用空闲时间阅读、浏览、学习、关注、转发，学习排名每天都有新变化，呈现出“比学赶超”的态势。 \r\n\r\n \r\n\r\n线上线下联动，让学习成为新风尚 \r\n\r\n今年上半年，华软学院举行第40、41期分党校开班，首次将“自学课程为注册‘学习强国’平台学满1000分”作为入党积极分子党校学习的安排之一，在学院青马工程培训班，同样将“学习强国”平台学习纳入考核范畴。 \r\n\r\n师生党员们表示，用好“学习强国”这个平台，可以开拓视野和胸襟，更好地了解社会变化，做到与时俱进。同时，还能储备专业技能、先进知识，理论联系实际，更好地创新工作，提高服务水平。大家一起边答题边讨论学习经验，营造了浓厚的“比、学、赶、帮、超”学习氛围。上“学习强国”，看时政、读文章、强理论、做任务、分享评论，“充充电”“加加油”已经成为各党支部党员之间的新风尚。 \r\n', null);
INSERT INTO `news_info` VALUES ('4', '华软学院举行2019年“青春告白祖国”合唱比赛暨联欢晚会', 'aaa', '0000-00-00', '张三', ' 9月27日晚上，华软学院举行2019年“青春告白祖国”', null);
INSERT INTO `news_info` VALUES ('3', '【学习强国】广州大学华软软件学院', '【学习强国】广州大学华软软件学院：推出“学习强国”平台激励机制，助力主题教育（2019年10月14日）', '2019-10-22', 'zhangsan', '学习强国学习平台讯  最近，广州大学华软软件学院党委利用“学习强国”平台作为推进主题教育的重要载体加以推进，坚持第一时间启动、第一时间推动、第一时间落实，迅速推动全体党员下载、注册、登录“学习强国”APP，并且积极向全院师生推荐使用，让全体党员干部在“学习强国”平台上学有所获、学有所悟、学以致用。 \r\n呈现“比学赶超”的态势 \r\n\r\n近日，广州大学华软软件学院党委公布“学习强国”教工党员前50名和学生党员前30名排行榜，他们是学院“学习强国”学习标兵。“学习强国”学习平台推广以来，广州大学华软软件学院各基层党组织掀起了一股学习热潮。全院党员干部充分利用空闲时间阅读、浏览、学习、关注、转发，学习排名每天都有新变化，呈现出“比学赶超”的态势。 \r\n\r\n \r\n\r\n线上线下联动，让学习成为新风尚 \r\n\r\n今年上半年，华软学院举行第40、41期分党校开班，首次将“自学课程为注册‘学习强国’平台学满1000分”作为入党积极分子党校学习的安排之一，在学院青马工程培训班，同样将“学习强国”平台学习纳入考核范畴。 \r\n\r\n师生党员们表示，用好“学习强国”这个平台，可以开拓视野和胸襟，更好地了解社会变化，做到与时俱进。同时，还能储备专业技能、先进知识，理论联系实际，更好地创新工作，提高服务水平。大家一起边答题边讨论学习经验，营造了浓厚的“比、学、赶、帮、超”学习氛围。上“学习强国”，看时政、读文章、强理论、做任务、分享评论，“充充电”“加加油”已经成为各党支部党员之间的新风尚。 \r\n', null);
INSERT INTO `news_info` VALUES ('5', 'ccccc', 'aaa', '0000-00-00', '李四', '青春告白祖国', '2019-10-24');
INSERT INTO `news_info` VALUES ('6', '人类是这个世界的智慧生物', '概要', '2019-10-23', '张三', '我们的都知道，人类是这个世界的智慧生物，但是面对大自然人类却很渺小，因为大自然偶尔会发生一些天灾人祸，就比喻说人类至今都无法避免的地震，一场地震让我们见证了而太多的人间冷暖，往往只有在生死关头才能发现谁是真心关爱你。当初在地震中留下了不少感人肺腑的英雄事迹，张开双臂护住几位学生并且英勇牺牲的老师也给我们留下了深刻的印象。但是但是在地震中却有一位老师让大家都气愤不已，那就是丢下了学生独自逃命的范跑跑。', null);
INSERT INTO `news_info` VALUES ('7', 'aaaaaaaaaaa', '概要', '2019-10-24', 'aaaaaaaaaa', '\r\naaaaaaaaaaaaaaaaaa\r\n                  ', null);

-- ----------------------------
-- Table structure for pic_news
-- ----------------------------
DROP TABLE IF EXISTS `pic_news`;
CREATE TABLE `pic_news` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `picTitle` varchar(30) NOT NULL,
  `description` varchar(200) NOT NULL,
  `picName` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pic_news
-- ----------------------------
