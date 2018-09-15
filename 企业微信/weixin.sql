/*
Navicat MySQL Data Transfer

Source Server         : TEST
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : weixin

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-08-31 00:02:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for company_user
-- ----------------------------
DROP TABLE IF EXISTS `company_user`;
CREATE TABLE `company_user` (
  `company_user_id` int(10) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(100) NOT NULL,
  `contacts_id` int(10) NOT NULL,
  `open_id` varchar(30) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`company_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company_user
-- ----------------------------
INSERT INTO `company_user` VALUES ('4', '广州南站', '1', 'oR1_v0_u3VooogPF2thX6baqWySM', '姚颖', '0');
INSERT INTO `company_user` VALUES ('5', '广州', '2', 'oR1_v0_u3VooogPF2thX6baqWySM', '姚颖', '0');
INSERT INTO `company_user` VALUES ('6', '测试客户', '3', 'oR1_v02pyVOcmXq6-w_9pzWzRGoU', '吴宁', '0');
INSERT INTO `company_user` VALUES ('7', '测试客户', '4', 'oR1_v02pyVOcmXq6-w_9pzWzRGoU', '吴宁', '0');
INSERT INTO `company_user` VALUES ('8', '八一', '5', 'oR1_v02pyVOcmXq6-w_9pzWzRGoU', '吴宁', '0');
INSERT INTO `company_user` VALUES ('9', '北京', '6', 'oR1_v0_u3VooogPF2thX6baqWySM', '姚颖', '0');
INSERT INTO `company_user` VALUES ('10', '公司', '7', 'oR1_v0xKJ0wv5KEXr3CUtB5m2WU8', '吴凡超', '0');
INSERT INTO `company_user` VALUES ('11', '八二', '8', 'oR1_v0_u3VooogPF2thX6baqWySM', '姚颖', '0');
INSERT INTO `company_user` VALUES ('12', '新帆广告', '9', 'oR1_v0xKJ0wv5KEXr3CUtB5m2WU8', '吴凡超', '0');
INSERT INTO `company_user` VALUES ('13', '华工', '10', 'oR1_v0_u3VooogPF2thX6baqWySM', '姚颖', '0');
INSERT INTO `company_user` VALUES ('14', '123敬业', '11', 'oR1_v0_u3VooogPF2thX6baqWySM', '姚颖', '0');
INSERT INTO `company_user` VALUES ('15', '广州', '12', 'oR1_v0_u3VooogPF2thX6baqWySM', '姚颖', '0');
INSERT INTO `company_user` VALUES ('16', '测试客户', '13', 'oR1_v0_u3VooogPF2thX6baqWySM', '姚颖', '0');
INSERT INTO `company_user` VALUES ('17', '测试客户', '14', 'oR1_v0_u3VooogPF2thX6baqWySM', '姚颖', '0');
INSERT INTO `company_user` VALUES ('19', '测试客户', '16', 'oR1_v0_u3VooogPF2thX6baqWySM', '姚颖', '0');
INSERT INTO `company_user` VALUES ('20', '335', '17', 'oR1_v0_u3VooogPF2thX6baqWySM', '姚颖', '0');
INSERT INTO `company_user` VALUES ('21', '南方', '18', 'oR1_v0_u3VooogPF2thX6baqWySM', '姚颖', '0');
INSERT INTO `company_user` VALUES ('22', '南方', '19', 'oR1_v0_u3VooogPF2thX6baqWySM', '姚颖', '0');
INSERT INTO `company_user` VALUES ('23', '广州', '20', 'oR1_v0_u3VooogPF2thX6baqWySM', '姚颖', '0');
INSERT INTO `company_user` VALUES ('24', '汽车测试', '21', 'oR1_v02pyVOcmXq6-w_9pzWzRGoU', '吴宁', '0');
INSERT INTO `company_user` VALUES ('25', '新帆广告创意', '22', 'oR1_v0xKJ0wv5KEXr3CUtB5m2WU8', '吴凡超', '0');
INSERT INTO `company_user` VALUES ('26', '图书', '23', 'oR1_v03q8zaDj8s2S-hqinH1UUAg', '小毛毛', '0');
INSERT INTO `company_user` VALUES ('27', '网易', '24', 'oR1_v03q8zaDj8s2S-hqinH1UUAg', '毛爱', '0');
INSERT INTO `company_user` VALUES ('28', '广州', '25', 'yaoyaoyaodama', '姚颖', '0');

-- ----------------------------
-- Table structure for contacts
-- ----------------------------
DROP TABLE IF EXISTS `contacts`;
CREATE TABLE `contacts` (
  `contacts_id` int(10) NOT NULL AUTO_INCREMENT,
  `contacts_name` varchar(50) NOT NULL,
  `company_name` varchar(100) NOT NULL,
  `department` varchar(100) NOT NULL,
  `post` varchar(100) NOT NULL,
  `tel` varchar(50) NOT NULL,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`contacts_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contacts
-- ----------------------------
INSERT INTO `contacts` VALUES ('1', '张三', '广州南站', '铁路', '车长', '15245635700', '0');
INSERT INTO `contacts` VALUES ('2', '张四', '广州', '铁路', '运输', '15536912377', '0');
INSERT INTO `contacts` VALUES ('3', '陈小姐', '测试客户', '品牌部', '总监', '13812312312', '0');
INSERT INTO `contacts` VALUES ('4', '陈小姐', '测试客户', '运营部', '总监', '13313313312', '0');
INSERT INTO `contacts` VALUES ('5', '陈', '八一', '陈', '哼', '15421345674', '0');
INSERT INTO `contacts` VALUES ('6', '老6', '北京', 'it', '1', '15245639611', '0');
INSERT INTO `contacts` VALUES ('7', '吴', '公司', '华南区', '总经理', '18676891425', '0');
INSERT INTO `contacts` VALUES ('8', '一', '八二', '三九四九', '三九四九', '15212345688', '0');
INSERT INTO `contacts` VALUES ('9', '刘强东', '新帆广告', '广告事务部', '经理', '18674125386', '0');
INSERT INTO `contacts` VALUES ('10', '摇摇', '华工', 'it', '职员', '15274023691', '0');
INSERT INTO `contacts` VALUES ('11', '姚', '123敬业', '123', '123', '15274692356', '0');
INSERT INTO `contacts` VALUES ('12', '王武', '广州', 'qw', '想你想见', '15698745622', '0');
INSERT INTO `contacts` VALUES ('13', '李三', '测试客户', 'i', 'i', '15274892500', '0');
INSERT INTO `contacts` VALUES ('16', '王9', '测试客户', 'it', '职员', '15612475836', '0');
INSERT INTO `contacts` VALUES ('17', 'yao', '335', 'it', '组长', '15245632177', '0');
INSERT INTO `contacts` VALUES ('18', '吴凡超', '南方', 'it', '职员', '15212345655', '0');
INSERT INTO `contacts` VALUES ('19', '张一鸣', '南方', 'it', '职员', '15525832199', '0');
INSERT INTO `contacts` VALUES ('20', '张三', '广州', 'it', '经理', '15524356722', '0');
INSERT INTO `contacts` VALUES ('21', '陈小姐', '汽车测试', '品牌部', '总监', '13313313322', '0');
INSERT INTO `contacts` VALUES ('22', '吴宁', '新帆广告创意', '数据统计', '经理', '18614725836', '0');
INSERT INTO `contacts` VALUES ('23', '网易', '图书', 'IT', 'qqq', '15236915922', '0');
INSERT INTO `contacts` VALUES ('24', '姚颖', '网易', '游戏设计', '业务员', '13250514740', '0');
INSERT INTO `contacts` VALUES ('25', 'qq', '广州', '数据中心', '职员', '15247852611', '0');

-- ----------------------------
-- Table structure for my_daily
-- ----------------------------
DROP TABLE IF EXISTS `my_daily`;
CREATE TABLE `my_daily` (
  `daily_id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `company_name` varchar(100) NOT NULL,
  `contacts_name` varchar(200) NOT NULL,
  `user_id` int(10) NOT NULL,
  `stage` varchar(50) NOT NULL,
  `budget` varchar(30) NOT NULL,
  `intention` varchar(500) NOT NULL,
  `discount` varchar(50) NOT NULL,
  `progress` varchar(1000) NOT NULL,
  `point` varchar(1000) NOT NULL,
  `advice` varchar(1000) DEFAULT NULL,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`daily_id`),
  KEY `FK_Reference_2` (`user_id`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of my_daily
-- ----------------------------
INSERT INTO `my_daily` VALUES ('35', '2018-08-29 23:43:40', '广州', 'qq', '39', '接触阶段', '无', '无', '无', '无', '无', 'OK', '0');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(10) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '业务员');
INSERT INTO `role` VALUES ('2', '总经理');
INSERT INTO `role` VALUES ('3', '管理员');

-- ----------------------------
-- Table structure for t_token
-- ----------------------------
DROP TABLE IF EXISTS `t_token`;
CREATE TABLE `t_token` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `access_token` varchar(1024) NOT NULL,
  `expires_in` int(11) NOT NULL,
  `createTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=697 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_token
-- ----------------------------
INSERT INTO `t_token` VALUES ('651', 'ma_XbfPBdU9gC_HHSSdCbtbjH_gbsgMbRCTcXye8AZZfGs0gtKe5dqeMlnzG6qagL2Ru5PwRCNZmpcxbMoU1wcdS6UcfmpjOW4u94vKt8pcpKZ8ofoBgbRTRIpV9HkuXyrWfmo0a3wBfBguHf_B2N5urb9wvzUkVlE_k_s8CCoTgZxBBXS4GKOlYLaTT3NbMn9s8a7rqbpkNDbAXlOkNdA', '7200', '2018-08-29 02:02:15');
INSERT INTO `t_token` VALUES ('652', '1tzBoTMz1YWR3KMr7ryNHeFI_Wy-DwiQKGoATMX9Nh719Yy-hVhf2hP3RPK4nfZlJb4S9dZS4qbhdUAItYrLeL8oFnYJhwVeoCFZoFgpp9ow7IIgR_DPs-NnsuFO-gfJmZjxRORADjcJ_GdgwWQxelgjAAwmoNtTWABWVs4vPN974uAyWrMWK11BOGNWjK6nfO8Z51UbBu3dpS6G_9QWLg', '7200', '2018-08-29 09:11:28');
INSERT INTO `t_token` VALUES ('653', '1tzBoTMz1YWR3KMr7ryNHeFI_Wy-DwiQKGoATMX9Nh719Yy-hVhf2hP3RPK4nfZlJb4S9dZS4qbhdUAItYrLeL8oFnYJhwVeoCFZoFgpp9ow7IIgR_DPs-NnsuFO-gfJmZjxRORADjcJ_GdgwWQxelgjAAwmoNtTWABWVs4vPN974uAyWrMWK11BOGNWjK6nfO8Z51UbBu3dpS6G_9QWLg', '7200', '2018-08-29 09:58:52');
INSERT INTO `t_token` VALUES ('654', '1tzBoTMz1YWR3KMr7ryNHeFI_Wy-DwiQKGoATMX9Nh719Yy-hVhf2hP3RPK4nfZlJb4S9dZS4qbhdUAItYrLeL8oFnYJhwVeoCFZoFgpp9ow7IIgR_DPs-NnsuFO-gfJmZjxRORADjcJ_GdgwWQxelgjAAwmoNtTWABWVs4vPN974uAyWrMWK11BOGNWjK6nfO8Z51UbBu3dpS6G_9QWLg', '7200', '2018-08-29 10:02:07');
INSERT INTO `t_token` VALUES ('655', '1tzBoTMz1YWR3KMr7ryNHeFI_Wy-DwiQKGoATMX9Nh719Yy-hVhf2hP3RPK4nfZlJb4S9dZS4qbhdUAItYrLeL8oFnYJhwVeoCFZoFgpp9ow7IIgR_DPs-NnsuFO-gfJmZjxRORADjcJ_GdgwWQxelgjAAwmoNtTWABWVs4vPN974uAyWrMWK11BOGNWjK6nfO8Z51UbBu3dpS6G_9QWLg', '7200', '2018-08-29 10:10:42');
INSERT INTO `t_token` VALUES ('656', '1tzBoTMz1YWR3KMr7ryNHeFI_Wy-DwiQKGoATMX9Nh719Yy-hVhf2hP3RPK4nfZlJb4S9dZS4qbhdUAItYrLeL8oFnYJhwVeoCFZoFgpp9ow7IIgR_DPs-NnsuFO-gfJmZjxRORADjcJ_GdgwWQxelgjAAwmoNtTWABWVs4vPN974uAyWrMWK11BOGNWjK6nfO8Z51UbBu3dpS6G_9QWLg', '7200', '2018-08-29 10:32:41');
INSERT INTO `t_token` VALUES ('657', 'hzMwVntFmpjIfgYtlZtG41PXZMG7HGUoKJ_xk_7w4MfCOApTxnhwFpbSCTZrqcn8zr-fpIfhq4A7-UqG0WTMv5guZDth_jjqhbG0MA0ozUtScDhSIgCicgzDS-A2E-PSt6SnNjrtbTX_fqXcSSkuzU-FgKRN6iO6BgthXMNc89yFjaCrYmVlpGRzB2JF324qwMsgWAkRi-iDFiAd5A_XKA', '7200', '2018-08-29 18:00:04');
INSERT INTO `t_token` VALUES ('658', 'hzMwVntFmpjIfgYtlZtG41PXZMG7HGUoKJ_xk_7w4MfCOApTxnhwFpbSCTZrqcn8zr-fpIfhq4A7-UqG0WTMv5guZDth_jjqhbG0MA0ozUtScDhSIgCicgzDS-A2E-PSt6SnNjrtbTX_fqXcSSkuzU-FgKRN6iO6BgthXMNc89yFjaCrYmVlpGRzB2JF324qwMsgWAkRi-iDFiAd5A_XKA', '7200', '2018-08-29 18:19:54');
INSERT INTO `t_token` VALUES ('659', 'CUyOmPu0ddIR1tLWhZRJiXCy3o3C64dc5Su-99t1To85ir77cCW5suYACoczCxCH5i6cApNd2PLXsO-RbpuRZ8FR3oyCYspWu-4cino5mgdq6yCsWf3YtC8wNl3GfO-_fJEpws3aq73QpYuDznQkMJCWwe6BQk7UPrvjPbGqKyfO-zZz-25_qHYn4GILA4n09MgXTs4UgNEtFz3dPQxv_Q', '7200', '2018-08-29 21:42:07');
INSERT INTO `t_token` VALUES ('660', 'CUyOmPu0ddIR1tLWhZRJiXCy3o3C64dc5Su-99t1To85ir77cCW5suYACoczCxCH5i6cApNd2PLXsO-RbpuRZ8FR3oyCYspWu-4cino5mgdq6yCsWf3YtC8wNl3GfO-_fJEpws3aq73QpYuDznQkMJCWwe6BQk7UPrvjPbGqKyfO-zZz-25_qHYn4GILA4n09MgXTs4UgNEtFz3dPQxv_Q', '7200', '2018-08-29 21:49:46');
INSERT INTO `t_token` VALUES ('661', 'CUyOmPu0ddIR1tLWhZRJiXCy3o3C64dc5Su-99t1To85ir77cCW5suYACoczCxCH5i6cApNd2PLXsO-RbpuRZ8FR3oyCYspWu-4cino5mgdq6yCsWf3YtC8wNl3GfO-_fJEpws3aq73QpYuDznQkMJCWwe6BQk7UPrvjPbGqKyfO-zZz-25_qHYn4GILA4n09MgXTs4UgNEtFz3dPQxv_Q', '7200', '2018-08-29 21:50:09');
INSERT INTO `t_token` VALUES ('662', 'CUyOmPu0ddIR1tLWhZRJiXCy3o3C64dc5Su-99t1To85ir77cCW5suYACoczCxCH5i6cApNd2PLXsO-RbpuRZ8FR3oyCYspWu-4cino5mgdq6yCsWf3YtC8wNl3GfO-_fJEpws3aq73QpYuDznQkMJCWwe6BQk7UPrvjPbGqKyfO-zZz-25_qHYn4GILA4n09MgXTs4UgNEtFz3dPQxv_Q', '7200', '2018-08-29 21:51:04');
INSERT INTO `t_token` VALUES ('663', 'CUyOmPu0ddIR1tLWhZRJiXCy3o3C64dc5Su-99t1To85ir77cCW5suYACoczCxCH5i6cApNd2PLXsO-RbpuRZ8FR3oyCYspWu-4cino5mgdq6yCsWf3YtC8wNl3GfO-_fJEpws3aq73QpYuDznQkMJCWwe6BQk7UPrvjPbGqKyfO-zZz-25_qHYn4GILA4n09MgXTs4UgNEtFz3dPQxv_Q', '7200', '2018-08-29 21:53:38');
INSERT INTO `t_token` VALUES ('664', 'CUyOmPu0ddIR1tLWhZRJiXCy3o3C64dc5Su-99t1To85ir77cCW5suYACoczCxCH5i6cApNd2PLXsO-RbpuRZ8FR3oyCYspWu-4cino5mgdq6yCsWf3YtC8wNl3GfO-_fJEpws3aq73QpYuDznQkMJCWwe6BQk7UPrvjPbGqKyfO-zZz-25_qHYn4GILA4n09MgXTs4UgNEtFz3dPQxv_Q', '7200', '2018-08-29 21:56:03');
INSERT INTO `t_token` VALUES ('665', 'CUyOmPu0ddIR1tLWhZRJiXCy3o3C64dc5Su-99t1To85ir77cCW5suYACoczCxCH5i6cApNd2PLXsO-RbpuRZ8FR3oyCYspWu-4cino5mgdq6yCsWf3YtC8wNl3GfO-_fJEpws3aq73QpYuDznQkMJCWwe6BQk7UPrvjPbGqKyfO-zZz-25_qHYn4GILA4n09MgXTs4UgNEtFz3dPQxv_Q', '7200', '2018-08-29 21:57:17');
INSERT INTO `t_token` VALUES ('666', 'CUyOmPu0ddIR1tLWhZRJiXCy3o3C64dc5Su-99t1To85ir77cCW5suYACoczCxCH5i6cApNd2PLXsO-RbpuRZ8FR3oyCYspWu-4cino5mgdq6yCsWf3YtC8wNl3GfO-_fJEpws3aq73QpYuDznQkMJCWwe6BQk7UPrvjPbGqKyfO-zZz-25_qHYn4GILA4n09MgXTs4UgNEtFz3dPQxv_Q', '7200', '2018-08-29 22:02:19');
INSERT INTO `t_token` VALUES ('667', 'CUyOmPu0ddIR1tLWhZRJiXCy3o3C64dc5Su-99t1To85ir77cCW5suYACoczCxCH5i6cApNd2PLXsO-RbpuRZ8FR3oyCYspWu-4cino5mgdq6yCsWf3YtC8wNl3GfO-_fJEpws3aq73QpYuDznQkMJCWwe6BQk7UPrvjPbGqKyfO-zZz-25_qHYn4GILA4n09MgXTs4UgNEtFz3dPQxv_Q', '7200', '2018-08-29 22:09:45');
INSERT INTO `t_token` VALUES ('668', 'CUyOmPu0ddIR1tLWhZRJiXCy3o3C64dc5Su-99t1To85ir77cCW5suYACoczCxCH5i6cApNd2PLXsO-RbpuRZ8FR3oyCYspWu-4cino5mgdq6yCsWf3YtC8wNl3GfO-_fJEpws3aq73QpYuDznQkMJCWwe6BQk7UPrvjPbGqKyfO-zZz-25_qHYn4GILA4n09MgXTs4UgNEtFz3dPQxv_Q', '7200', '2018-08-29 22:11:21');
INSERT INTO `t_token` VALUES ('669', 'CUyOmPu0ddIR1tLWhZRJiXCy3o3C64dc5Su-99t1To85ir77cCW5suYACoczCxCH5i6cApNd2PLXsO-RbpuRZ8FR3oyCYspWu-4cino5mgdq6yCsWf3YtC8wNl3GfO-_fJEpws3aq73QpYuDznQkMJCWwe6BQk7UPrvjPbGqKyfO-zZz-25_qHYn4GILA4n09MgXTs4UgNEtFz3dPQxv_Q', '7200', '2018-08-29 22:16:02');
INSERT INTO `t_token` VALUES ('670', 'CUyOmPu0ddIR1tLWhZRJiXCy3o3C64dc5Su-99t1To85ir77cCW5suYACoczCxCH5i6cApNd2PLXsO-RbpuRZ8FR3oyCYspWu-4cino5mgdq6yCsWf3YtC8wNl3GfO-_fJEpws3aq73QpYuDznQkMJCWwe6BQk7UPrvjPbGqKyfO-zZz-25_qHYn4GILA4n09MgXTs4UgNEtFz3dPQxv_Q', '7200', '2018-08-29 22:18:49');
INSERT INTO `t_token` VALUES ('671', 'CUyOmPu0ddIR1tLWhZRJiXCy3o3C64dc5Su-99t1To85ir77cCW5suYACoczCxCH5i6cApNd2PLXsO-RbpuRZ8FR3oyCYspWu-4cino5mgdq6yCsWf3YtC8wNl3GfO-_fJEpws3aq73QpYuDznQkMJCWwe6BQk7UPrvjPbGqKyfO-zZz-25_qHYn4GILA4n09MgXTs4UgNEtFz3dPQxv_Q', '7200', '2018-08-29 22:20:14');
INSERT INTO `t_token` VALUES ('672', 'CUyOmPu0ddIR1tLWhZRJiXCy3o3C64dc5Su-99t1To85ir77cCW5suYACoczCxCH5i6cApNd2PLXsO-RbpuRZ8FR3oyCYspWu-4cino5mgdq6yCsWf3YtC8wNl3GfO-_fJEpws3aq73QpYuDznQkMJCWwe6BQk7UPrvjPbGqKyfO-zZz-25_qHYn4GILA4n09MgXTs4UgNEtFz3dPQxv_Q', '7200', '2018-08-29 22:20:27');
INSERT INTO `t_token` VALUES ('673', 'CUyOmPu0ddIR1tLWhZRJiXCy3o3C64dc5Su-99t1To85ir77cCW5suYACoczCxCH5i6cApNd2PLXsO-RbpuRZ8FR3oyCYspWu-4cino5mgdq6yCsWf3YtC8wNl3GfO-_fJEpws3aq73QpYuDznQkMJCWwe6BQk7UPrvjPbGqKyfO-zZz-25_qHYn4GILA4n09MgXTs4UgNEtFz3dPQxv_Q', '7200', '2018-08-29 22:21:31');
INSERT INTO `t_token` VALUES ('674', 'CUyOmPu0ddIR1tLWhZRJiXCy3o3C64dc5Su-99t1To85ir77cCW5suYACoczCxCH5i6cApNd2PLXsO-RbpuRZ8FR3oyCYspWu-4cino5mgdq6yCsWf3YtC8wNl3GfO-_fJEpws3aq73QpYuDznQkMJCWwe6BQk7UPrvjPbGqKyfO-zZz-25_qHYn4GILA4n09MgXTs4UgNEtFz3dPQxv_Q', '7200', '2018-08-29 22:21:43');
INSERT INTO `t_token` VALUES ('675', 'CUyOmPu0ddIR1tLWhZRJiXCy3o3C64dc5Su-99t1To85ir77cCW5suYACoczCxCH5i6cApNd2PLXsO-RbpuRZ8FR3oyCYspWu-4cino5mgdq6yCsWf3YtC8wNl3GfO-_fJEpws3aq73QpYuDznQkMJCWwe6BQk7UPrvjPbGqKyfO-zZz-25_qHYn4GILA4n09MgXTs4UgNEtFz3dPQxv_Q', '7200', '2018-08-29 22:22:57');
INSERT INTO `t_token` VALUES ('676', 'CUyOmPu0ddIR1tLWhZRJiXCy3o3C64dc5Su-99t1To85ir77cCW5suYACoczCxCH5i6cApNd2PLXsO-RbpuRZ8FR3oyCYspWu-4cino5mgdq6yCsWf3YtC8wNl3GfO-_fJEpws3aq73QpYuDznQkMJCWwe6BQk7UPrvjPbGqKyfO-zZz-25_qHYn4GILA4n09MgXTs4UgNEtFz3dPQxv_Q', '7200', '2018-08-29 22:23:30');
INSERT INTO `t_token` VALUES ('677', 'CUyOmPu0ddIR1tLWhZRJiXCy3o3C64dc5Su-99t1To85ir77cCW5suYACoczCxCH5i6cApNd2PLXsO-RbpuRZ8FR3oyCYspWu-4cino5mgdq6yCsWf3YtC8wNl3GfO-_fJEpws3aq73QpYuDznQkMJCWwe6BQk7UPrvjPbGqKyfO-zZz-25_qHYn4GILA4n09MgXTs4UgNEtFz3dPQxv_Q', '7200', '2018-08-29 22:48:54');
INSERT INTO `t_token` VALUES ('678', 'CUyOmPu0ddIR1tLWhZRJiXCy3o3C64dc5Su-99t1To85ir77cCW5suYACoczCxCH5i6cApNd2PLXsO-RbpuRZ8FR3oyCYspWu-4cino5mgdq6yCsWf3YtC8wNl3GfO-_fJEpws3aq73QpYuDznQkMJCWwe6BQk7UPrvjPbGqKyfO-zZz-25_qHYn4GILA4n09MgXTs4UgNEtFz3dPQxv_Q', '7200', '2018-08-29 22:49:05');
INSERT INTO `t_token` VALUES ('679', 'CUyOmPu0ddIR1tLWhZRJiXCy3o3C64dc5Su-99t1To85ir77cCW5suYACoczCxCH5i6cApNd2PLXsO-RbpuRZ8FR3oyCYspWu-4cino5mgdq6yCsWf3YtC8wNl3GfO-_fJEpws3aq73QpYuDznQkMJCWwe6BQk7UPrvjPbGqKyfO-zZz-25_qHYn4GILA4n09MgXTs4UgNEtFz3dPQxv_Q', '7200', '2018-08-29 23:24:46');
INSERT INTO `t_token` VALUES ('680', 'CUyOmPu0ddIR1tLWhZRJiXCy3o3C64dc5Su-99t1To85ir77cCW5suYACoczCxCH5i6cApNd2PLXsO-RbpuRZ8FR3oyCYspWu-4cino5mgdq6yCsWf3YtC8wNl3GfO-_fJEpws3aq73QpYuDznQkMJCWwe6BQk7UPrvjPbGqKyfO-zZz-25_qHYn4GILA4n09MgXTs4UgNEtFz3dPQxv_Q', '7200', '2018-08-29 23:24:59');
INSERT INTO `t_token` VALUES ('681', 'CUyOmPu0ddIR1tLWhZRJiXCy3o3C64dc5Su-99t1To85ir77cCW5suYACoczCxCH5i6cApNd2PLXsO-RbpuRZ8FR3oyCYspWu-4cino5mgdq6yCsWf3YtC8wNl3GfO-_fJEpws3aq73QpYuDznQkMJCWwe6BQk7UPrvjPbGqKyfO-zZz-25_qHYn4GILA4n09MgXTs4UgNEtFz3dPQxv_Q', '7200', '2018-08-29 23:29:32');
INSERT INTO `t_token` VALUES ('682', 'CUyOmPu0ddIR1tLWhZRJiXCy3o3C64dc5Su-99t1To85ir77cCW5suYACoczCxCH5i6cApNd2PLXsO-RbpuRZ8FR3oyCYspWu-4cino5mgdq6yCsWf3YtC8wNl3GfO-_fJEpws3aq73QpYuDznQkMJCWwe6BQk7UPrvjPbGqKyfO-zZz-25_qHYn4GILA4n09MgXTs4UgNEtFz3dPQxv_Q', '7200', '2018-08-29 23:33:14');
INSERT INTO `t_token` VALUES ('683', 'CUyOmPu0ddIR1tLWhZRJiXCy3o3C64dc5Su-99t1To85ir77cCW5suYACoczCxCH5i6cApNd2PLXsO-RbpuRZ8FR3oyCYspWu-4cino5mgdq6yCsWf3YtC8wNl3GfO-_fJEpws3aq73QpYuDznQkMJCWwe6BQk7UPrvjPbGqKyfO-zZz-25_qHYn4GILA4n09MgXTs4UgNEtFz3dPQxv_Q', '7200', '2018-08-29 23:36:12');
INSERT INTO `t_token` VALUES ('684', 'JbjzFCSgfQQqms3zrPCZyVKkGlM4LSUZcgDvyHHM4YExird1nJAA5WXKcH5uUyrEPTWL5YCxkGs_wEM0jCWwB88KlIRVTTZBECuyOXHzy1gyNVGHE9CEYZHOie-ty_5sMpgKVbSMCJBDWNU0zwY1JXKJ9pBlftPIozO_WZIHqAMYDgGxSwMTF39BXEj2S87OouwQDZJL345i0Q41BJWbOg', '7200', '2018-08-29 23:42:21');
INSERT INTO `t_token` VALUES ('685', 'JbjzFCSgfQQqms3zrPCZyVKkGlM4LSUZcgDvyHHM4YExird1nJAA5WXKcH5uUyrEPTWL5YCxkGs_wEM0jCWwB88KlIRVTTZBECuyOXHzy1gyNVGHE9CEYZHOie-ty_5sMpgKVbSMCJBDWNU0zwY1JXKJ9pBlftPIozO_WZIHqAMYDgGxSwMTF39BXEj2S87OouwQDZJL345i0Q41BJWbOg', '7200', '2018-08-29 23:42:34');
INSERT INTO `t_token` VALUES ('686', 'JbjzFCSgfQQqms3zrPCZyVKkGlM4LSUZcgDvyHHM4YExird1nJAA5WXKcH5uUyrEPTWL5YCxkGs_wEM0jCWwB88KlIRVTTZBECuyOXHzy1gyNVGHE9CEYZHOie-ty_5sMpgKVbSMCJBDWNU0zwY1JXKJ9pBlftPIozO_WZIHqAMYDgGxSwMTF39BXEj2S87OouwQDZJL345i0Q41BJWbOg', '7200', '2018-08-29 23:43:07');
INSERT INTO `t_token` VALUES ('687', 'JbjzFCSgfQQqms3zrPCZyVKkGlM4LSUZcgDvyHHM4YExird1nJAA5WXKcH5uUyrEPTWL5YCxkGs_wEM0jCWwB88KlIRVTTZBECuyOXHzy1gyNVGHE9CEYZHOie-ty_5sMpgKVbSMCJBDWNU0zwY1JXKJ9pBlftPIozO_WZIHqAMYDgGxSwMTF39BXEj2S87OouwQDZJL345i0Q41BJWbOg', '7200', '2018-08-29 23:48:23');
INSERT INTO `t_token` VALUES ('688', 'JbjzFCSgfQQqms3zrPCZyVKkGlM4LSUZcgDvyHHM4YExird1nJAA5WXKcH5uUyrEPTWL5YCxkGs_wEM0jCWwB88KlIRVTTZBECuyOXHzy1gyNVGHE9CEYZHOie-ty_5sMpgKVbSMCJBDWNU0zwY1JXKJ9pBlftPIozO_WZIHqAMYDgGxSwMTF39BXEj2S87OouwQDZJL345i0Q41BJWbOg', '7200', '2018-08-29 23:48:56');
INSERT INTO `t_token` VALUES ('689', 'JbjzFCSgfQQqms3zrPCZyVKkGlM4LSUZcgDvyHHM4YExird1nJAA5WXKcH5uUyrEPTWL5YCxkGs_wEM0jCWwB88KlIRVTTZBECuyOXHzy1gyNVGHE9CEYZHOie-ty_5sMpgKVbSMCJBDWNU0zwY1JXKJ9pBlftPIozO_WZIHqAMYDgGxSwMTF39BXEj2S87OouwQDZJL345i0Q41BJWbOg', '7200', '2018-08-29 23:50:01');
INSERT INTO `t_token` VALUES ('690', 'JbjzFCSgfQQqms3zrPCZyVKkGlM4LSUZcgDvyHHM4YExird1nJAA5WXKcH5uUyrEPTWL5YCxkGs_wEM0jCWwB88KlIRVTTZBECuyOXHzy1gyNVGHE9CEYZHOie-ty_5sMpgKVbSMCJBDWNU0zwY1JXKJ9pBlftPIozO_WZIHqAMYDgGxSwMTF39BXEj2S87OouwQDZJL345i0Q41BJWbOg', '7200', '2018-08-29 23:56:08');
INSERT INTO `t_token` VALUES ('691', 'JbjzFCSgfQQqms3zrPCZyVKkGlM4LSUZcgDvyHHM4YExird1nJAA5WXKcH5uUyrEPTWL5YCxkGs_wEM0jCWwB88KlIRVTTZBECuyOXHzy1gyNVGHE9CEYZHOie-ty_5sMpgKVbSMCJBDWNU0zwY1JXKJ9pBlftPIozO_WZIHqAMYDgGxSwMTF39BXEj2S87OouwQDZJL345i0Q41BJWbOg', '7200', '2018-08-29 23:57:33');
INSERT INTO `t_token` VALUES ('692', 'JbjzFCSgfQQqms3zrPCZyVKkGlM4LSUZcgDvyHHM4YExird1nJAA5WXKcH5uUyrEPTWL5YCxkGs_wEM0jCWwB88KlIRVTTZBECuyOXHzy1gyNVGHE9CEYZHOie-ty_5sMpgKVbSMCJBDWNU0zwY1JXKJ9pBlftPIozO_WZIHqAMYDgGxSwMTF39BXEj2S87OouwQDZJL345i0Q41BJWbOg', '7200', '2018-08-29 23:58:07');
INSERT INTO `t_token` VALUES ('693', 'JbjzFCSgfQQqms3zrPCZyVKkGlM4LSUZcgDvyHHM4YExird1nJAA5WXKcH5uUyrEPTWL5YCxkGs_wEM0jCWwB88KlIRVTTZBECuyOXHzy1gyNVGHE9CEYZHOie-ty_5sMpgKVbSMCJBDWNU0zwY1JXKJ9pBlftPIozO_WZIHqAMYDgGxSwMTF39BXEj2S87OouwQDZJL345i0Q41BJWbOg', '7200', '2018-08-29 23:58:29');
INSERT INTO `t_token` VALUES ('694', 'JbjzFCSgfQQqms3zrPCZyVKkGlM4LSUZcgDvyHHM4YExird1nJAA5WXKcH5uUyrEPTWL5YCxkGs_wEM0jCWwB88KlIRVTTZBECuyOXHzy1gyNVGHE9CEYZHOie-ty_5sMpgKVbSMCJBDWNU0zwY1JXKJ9pBlftPIozO_WZIHqAMYDgGxSwMTF39BXEj2S87OouwQDZJL345i0Q41BJWbOg', '7200', '2018-08-30 00:13:42');
INSERT INTO `t_token` VALUES ('695', 'zS7e7SqHxNtxbMmaAafcvSNqYCnmbwfrGXkq7NZHUrPMy7NYXHDPUXqyGol39sJobFPrcz5udk_fm3IMEU7tz-7LzyO7QcCqiTsc54ZLxPMA_oC8MKK97hccgL2EXj2xI82UG93v1UhEHGVHGIa_YhH3QoeGM-2PEwz_N9e5oRhI5V00THfzLVg82Xpm6ph0JJBeW8WfqoeR_F1Qqe3jnQ', '7200', '2018-08-30 23:36:39');
INSERT INTO `t_token` VALUES ('696', 'zS7e7SqHxNtxbMmaAafcvSNqYCnmbwfrGXkq7NZHUrPMy7NYXHDPUXqyGol39sJobFPrcz5udk_fm3IMEU7tz-7LzyO7QcCqiTsc54ZLxPMA_oC8MKK97hccgL2EXj2xI82UG93v1UhEHGVHGIa_YhH3QoeGM-2PEwz_N9e5oRhI5V00THfzLVg82Xpm6ph0JJBeW8WfqoeR_F1Qqe3jnQ', '7200', '2018-08-30 23:54:09');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `open_id` varchar(30) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `role_id` int(10) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  `department` varchar(50) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FK_Reference_11` (`role_id`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('39', 'yaoyaoyaodama', '姚颖', '3', '15521188867', '0', '市场部', '412822875@qq.com');
