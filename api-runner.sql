/*
Navicat MySQL Data Transfer

Source Server         : localhost本机
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : api-runner

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2019-12-10 13:49:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `api`
-- ----------------------------
DROP TABLE IF EXISTS `api`;
CREATE TABLE `api` (
  `id` int(11) NOT NULL auto_increment COMMENT '主键id',
  `api_classification_id` int(11) default NULL COMMENT '接口分类编号',
  `name` varchar(100) default NULL COMMENT '接口名称',
  `method` varchar(32) default NULL COMMENT '接口请求方法',
  `url` varchar(500) default NULL COMMENT '接口url地址',
  `description` varchar(500) default NULL COMMENT '接口描述',
  `create_user` int(11) default NULL COMMENT '创建用户',
  `create_time` datetime default NULL COMMENT '创建时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of api
-- ----------------------------
INSERT INTO `api` VALUES ('2', '1', '注册', 'post', '/futureloan/mvc/api/member/register', '', '2', '2019-08-16 14:23:28');
INSERT INTO `api` VALUES ('3', '1', '登录', 'get', '/futureloan/mvc/api/member/login', null, '2', '2019-08-16 14:23:31');
INSERT INTO `api` VALUES ('4', null, '注册', null, '/futureloan/mvc/api/member/register', null, '2', '2019-08-16 14:23:34');
INSERT INTO `api` VALUES ('5', '2', 'tz1', 'get', 'tz1', null, '2', '2019-08-16 14:23:38');
INSERT INTO `api` VALUES ('6', '3', 'dd1', 'get', 'dd1', null, '2', '2019-08-16 14:23:40');
INSERT INTO `api` VALUES ('7', '1', 'aa', 'post', '/xx/yy', null, null, null);

-- ----------------------------
-- Table structure for `api_classification`
-- ----------------------------
DROP TABLE IF EXISTS `api_classification`;
CREATE TABLE `api_classification` (
  `id` int(11) NOT NULL auto_increment COMMENT '主键id',
  `project_id` int(11) default NULL COMMENT '对应的项目id',
  `name` varchar(100) default NULL COMMENT '分类名称',
  `description` varchar(500) default NULL COMMENT '分类描述',
  `create_user` int(11) default NULL COMMENT '创建人',
  `create_time` datetime default NULL COMMENT '创建时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of api_classification
-- ----------------------------
INSERT INTO `api_classification` VALUES ('1', '1', '用户类', '用户相关的接口', '0', '2019-08-09 21:01:41');
INSERT INTO `api_classification` VALUES ('2', '1', '投资类', '投资相关的接口', '0', '2019-08-09 21:02:24');
INSERT INTO `api_classification` VALUES ('3', '1', '订单类', '所有订相关的接口', '0', '2019-08-09 21:03:19');
INSERT INTO `api_classification` VALUES ('4', '1', '公共分类', '公共分类', '0', '2019-08-09 21:25:53');
INSERT INTO `api_classification` VALUES ('5', '7', '公共分类', '公共分类', '0', '2019-08-09 21:27:30');
INSERT INTO `api_classification` VALUES ('6', '1', '测试分类', '测试分类', '0', '2019-08-09 22:11:16');

-- ----------------------------
-- Table structure for `api_request_param`
-- ----------------------------
DROP TABLE IF EXISTS `api_request_param`;
CREATE TABLE `api_request_param` (
  `id` int(11) NOT NULL auto_increment COMMENT '主键id',
  `api_id` int(11) default NULL COMMENT '关联的接口编号',
  `name` varchar(100) default NULL COMMENT '参数名称',
  `param_type` varchar(100) default NULL COMMENT '字段类型（string、int...）',
  `type` int(11) default NULL COMMENT '参数类型（1：query参数；2：body参数；3：header）',
  `example_data` varchar(100) default NULL COMMENT '参数值示例',
  `description` varchar(500) default NULL COMMENT '字段描述',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of api_request_param
-- ----------------------------
INSERT INTO `api_request_param` VALUES ('88', '2', 'mobilephone', 'string', '2', '', '');
INSERT INTO `api_request_param` VALUES ('93', '2', 'pwd', 'string', '2', '', '');
INSERT INTO `api_request_param` VALUES ('94', '2', 'Content-Type', 'string', '3', 'application/x-www-form-urlencoded;charset=utf-8', '');

-- ----------------------------
-- Table structure for `cases`
-- ----------------------------
DROP TABLE IF EXISTS `cases`;
CREATE TABLE `cases` (
  `id` int(11) NOT NULL auto_increment COMMENT '主键id',
  `suite_id` int(11) default NULL COMMENT '关联套件编号',
  `name` varchar(100) default NULL COMMENT '用例名称',
  `create_user` int(11) default NULL COMMENT '创建人',
  `create_time` datetime default NULL COMMENT '创建时间',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `ind_suite_case_name` (`suite_id`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cases
-- ----------------------------
INSERT INTO `cases` VALUES ('1', '2', '注册-手机号为空', null, null);
INSERT INTO `cases` VALUES ('2', '2', '注册-密码为空', null, null);
INSERT INTO `cases` VALUES ('3', '1', '注册-密码为空', null, null);
INSERT INTO `cases` VALUES ('4', '1', '注册-手机号为空', null, null);
INSERT INTO `cases` VALUES ('5', null, 'abc', null, null);
INSERT INTO `cases` VALUES ('6', null, 'abc', null, null);
INSERT INTO `cases` VALUES ('7', null, 'abc', null, null);
INSERT INTO `cases` VALUES ('8', null, 'abc', null, null);
INSERT INTO `cases` VALUES ('9', null, 'abc', null, null);
INSERT INTO `cases` VALUES ('10', null, 'abc', null, null);
INSERT INTO `cases` VALUES ('11', null, 'abc', null, null);
INSERT INTO `cases` VALUES ('12', null, 'abc', null, null);
INSERT INTO `cases` VALUES ('13', null, 'abc', null, null);
INSERT INTO `cases` VALUES ('14', null, 'abc', null, null);
INSERT INTO `cases` VALUES ('15', null, 'abc', null, null);
INSERT INTO `cases` VALUES ('16', null, 'abc', null, null);
INSERT INTO `cases` VALUES ('17', null, 'abc', null, null);
INSERT INTO `cases` VALUES ('18', null, 'abc', null, null);
INSERT INTO `cases` VALUES ('19', null, 'abc', null, null);
INSERT INTO `cases` VALUES ('20', null, 'abc', null, null);
INSERT INTO `cases` VALUES ('21', null, 'abc', null, null);

-- ----------------------------
-- Table structure for `case_param_value`
-- ----------------------------
DROP TABLE IF EXISTS `case_param_value`;
CREATE TABLE `case_param_value` (
  `id` int(11) NOT NULL auto_increment COMMENT '主键id',
  `case_id` int(11) default NULL COMMENT '关联的用例编号',
  `api_request_param_id` int(11) default NULL COMMENT '关联的接口参数字段编号',
  `api_request_param_value` varchar(100) default NULL COMMENT '给参数字段准备的测试数据',
  `create_user` int(11) default NULL COMMENT '创建人',
  `create_time` datetime default NULL COMMENT '创建时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of case_param_value
-- ----------------------------
INSERT INTO `case_param_value` VALUES ('58', '1', '88', '', null, null);
INSERT INTO `case_param_value` VALUES ('59', '1', '93', '123456', null, null);
INSERT INTO `case_param_value` VALUES ('60', '1', '94', 'application/x-www-form-urlencoded;charset=utf-8', null, null);
INSERT INTO `case_param_value` VALUES ('61', '2', '88', '13517315120', null, null);
INSERT INTO `case_param_value` VALUES ('62', '2', '93', '', null, null);
INSERT INTO `case_param_value` VALUES ('63', '2', '94', 'application/x-www-form-urlencoded;charset=utf-8', null, null);
INSERT INTO `case_param_value` VALUES ('64', '3', '88', '13517315120', null, null);
INSERT INTO `case_param_value` VALUES ('65', '3', '93', '', null, null);
INSERT INTO `case_param_value` VALUES ('66', '3', '94', 'application/x-www-form-urlencoded;charset=utf-8', null, null);
INSERT INTO `case_param_value` VALUES ('67', '4', '88', '', null, null);
INSERT INTO `case_param_value` VALUES ('68', '4', '93', '123456', null, null);
INSERT INTO `case_param_value` VALUES ('69', '4', '94', 'application/x-www-form-urlencoded;charset=utf-8', null, null);

-- ----------------------------
-- Table structure for `project`
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` int(11) NOT NULL auto_increment COMMENT 'id主键',
  `name` varchar(100) default NULL COMMENT '接口项目名',
  `host` varchar(100) default NULL COMMENT '接口项目的主机地址',
  `description` varchar(500) default NULL COMMENT '描述',
  `create_user` int(11) default NULL COMMENT '创建用户id',
  `create_time` datetime default NULL COMMENT '创建时间',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `name_index` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('1', 'abc', 'http://test.lemonban.com', 'abc', '9', '2019-08-07 21:13:32');
INSERT INTO `project` VALUES ('2', 'bbc', 'bbc', 'bbc', '0', '2019-08-07 21:58:08');
INSERT INTO `project` VALUES ('3', 'ddd', 'ddd', 'ddd', '0', '2019-08-07 21:58:32');
INSERT INTO `project` VALUES ('4', 'hh', 'http://test.lemonban.com', '这是一个接口项目', '0', '2019-08-07 22:02:11');
INSERT INTO `project` VALUES ('5', '测试项目', 'http://test.lemonban.com', '测试', '0', '2019-08-09 21:23:18');
INSERT INTO `project` VALUES ('6', '测试项目2', 'http://test.lemonban.com', '测试项目2', '0', '2019-08-09 21:25:53');
INSERT INTO `project` VALUES ('7', '测试项目3', '测试项目3', '测试项目3', '0', '2019-08-09 21:27:30');

-- ----------------------------
-- Table structure for `suite`
-- ----------------------------
DROP TABLE IF EXISTS `suite`;
CREATE TABLE `suite` (
  `id` int(11) NOT NULL auto_increment COMMENT '主键id',
  `project_id` int(11) NOT NULL COMMENT '关联项目id',
  `name` varchar(100) default NULL COMMENT '集合名字',
  `description` varchar(500) default NULL COMMENT '描述',
  `create_user` int(11) default NULL COMMENT '创建人',
  `create_time` datetime default NULL COMMENT '创建时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of suite
-- ----------------------------
INSERT INTO `suite` VALUES ('1', '1', '公共测试集', '公共测试集', null, null);
INSERT INTO `suite` VALUES ('2', '1', '注册用例集', '注册用例集', null, null);
INSERT INTO `suite` VALUES ('3', '1', '登录测试集111', '登录测试集111', null, null);

-- ----------------------------
-- Table structure for `test_report`
-- ----------------------------
DROP TABLE IF EXISTS `test_report`;
CREATE TABLE `test_report` (
  `id` int(11) NOT NULL auto_increment COMMENT '主键',
  `case_id` int(11) NOT NULL COMMENT '用例编号',
  `request_url` varchar(200) default NULL COMMENT '接口地址',
  `request_headers` varchar(2000) default NULL COMMENT '请求头',
  `request_body` varchar(5000) default NULL COMMENT '请求体数据',
  `response_headers` varchar(2000) default NULL COMMENT '响应头',
  `response_body` varchar(10000) default NULL COMMENT '响应体',
  `pass_flag` varchar(21) default NULL COMMENT '测试结果（通过 or 不通过）',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test_report
-- ----------------------------
INSERT INTO `test_report` VALUES ('39', '3', 'http://test.lemonban.com/futureloan/mvc/api/member/register', '{\n	\"Content-Type\":\"application/x-www-form-urlencoded;charset=utf-8\"\n}', 'mobilephone=13517315120&pwd=', '{\n	\"Transfer-Encoding\":\"chunked\",\n	\"Server\":\"nginx/1.12.0\",\n	\"Connection\":\"keep-alive\",\n	\"Date\":\"Wed, 18 Sep 2019 14:17:50 GMT\",\n	\"Content-Type\":\"application/json;charset=UTF-8\"\n}', '{\n	\"msg\":\"密码不能为空\",\n	\"code\":\"20103\",\n	\"status\":0\n}', '不通过');
INSERT INTO `test_report` VALUES ('40', '4', 'http://test.lemonban.com/futureloan/mvc/api/member/register', '{\n	\"Content-Type\":\"application/x-www-form-urlencoded;charset=utf-8\"\n}', 'mobilephone=&pwd=123456', '{\n	\"Transfer-Encoding\":\"chunked\",\n	\"Server\":\"nginx/1.12.0\",\n	\"Connection\":\"keep-alive\",\n	\"Date\":\"Wed, 18 Sep 2019 14:17:50 GMT\",\n	\"Content-Type\":\"application/json;charset=UTF-8\"\n}', '{\n	\"msg\":\"手机号不能为空\",\n	\"code\":\"20103\",\n	\"status\":0\n}', '通过');
INSERT INTO `test_report` VALUES ('41', '1', 'http://test.lemonban.com/futureloan/mvc/api/member/register', '{\n	\"Content-Type\":\"application/x-www-form-urlencoded;charset=utf-8\"\n}', 'mobilephone=&pwd=123456', '{\n	\"Transfer-Encoding\":\"chunked\",\n	\"Server\":\"nginx/1.12.0\",\n	\"Connection\":\"keep-alive\",\n	\"Date\":\"Wed, 18 Sep 2019 14:20:01 GMT\",\n	\"Content-Type\":\"application/json;charset=UTF-8\"\n}', '{\n	\"msg\":\"手机号不能为空\",\n	\"code\":\"20103\",\n	\"status\":0\n}', '未设置校验规则');
INSERT INTO `test_report` VALUES ('42', '2', 'http://test.lemonban.com/futureloan/mvc/api/member/register', '{\n	\"Content-Type\":\"application/x-www-form-urlencoded;charset=utf-8\"\n}', 'mobilephone=13517315120&pwd=', '{\n	\"Transfer-Encoding\":\"chunked\",\n	\"Server\":\"nginx/1.12.0\",\n	\"Connection\":\"keep-alive\",\n	\"Date\":\"Wed, 18 Sep 2019 14:20:01 GMT\",\n	\"Content-Type\":\"application/json;charset=UTF-8\"\n}', '{\n	\"msg\":\"密码不能为空\",\n	\"code\":\"20103\",\n	\"status\":0\n}', '未设置校验规则');

-- ----------------------------
-- Table structure for `test_rule`
-- ----------------------------
DROP TABLE IF EXISTS `test_rule`;
CREATE TABLE `test_rule` (
  `id` int(11) NOT NULL auto_increment COMMENT '主键id',
  `case_id` int(11) default NULL COMMENT '用例编号',
  `rule` varchar(100) default 'jsonpath' COMMENT '验证方式',
  `expression` varchar(500) default NULL COMMENT '验证表达式',
  `operator` varchar(100) default NULL COMMENT '匹配规则',
  `expected` varchar(500) default NULL COMMENT '期望值',
  `create_user` int(11) default NULL COMMENT '创建人',
  `create_time` datetime default NULL COMMENT '创建时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test_rule
-- ----------------------------
INSERT INTO `test_rule` VALUES ('23', '3', 'jsonpath', '$.msg', '=', '请输入密码', null, null);
INSERT INTO `test_rule` VALUES ('25', '3', 'jsonpath', '$.code', '=', '20103', null, null);

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment COMMENT '用户编号（主键）',
  `username` varchar(100) default NULL COMMENT '用户名',
  `password` varchar(100) default NULL COMMENT '密码',
  `regtime` datetime default NULL COMMENT '注册时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'nick002@qq.com', '123456', '2019-08-02 21:19:00');
INSERT INTO `user` VALUES ('2', '001@qq.com', 'e10adc3949ba59abbe56e057f20f883e', null);
INSERT INTO `user` VALUES ('3', '002@qq.com', 'e10adc3949ba59abbe56e057f20f883e', '2019-08-02 21:48:17');
INSERT INTO `user` VALUES ('4', '003@qq.com', 'e10adc3949ba59abbe56e057f20f883e', '2019-08-02 21:50:54');
INSERT INTO `user` VALUES ('5', '004@qq.com', 'e10adc3949ba59abbe56e057f20f883e', '2019-08-04 11:36:50');
INSERT INTO `user` VALUES ('8', '005@qq.com', 'e10adc3949ba59abbe56e057f20f883e', '2019-08-04 12:17:52');
INSERT INTO `user` VALUES ('9', '006@qq.com', 'e10adc3949ba59abbe56e057f20f883e', '2019-08-04 12:33:00');
INSERT INTO `user` VALUES ('10', '007@qq.com', 'e10adc3949ba59abbe56e057f20f883e', '2019-08-05 21:01:14');
INSERT INTO `user` VALUES ('11', 'nick001@qq.com', '123456', null);
INSERT INTO `user` VALUES ('12', '10089@qq.com', '123456', '2019-10-24 11:31:47');
INSERT INTO `user` VALUES ('13', '10086@qq.com', '123456', '2019-10-24 14:43:45');
