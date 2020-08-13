# 数据库变更相关记录

### 用户表 2020-08-13
### 组织机构表 2020-08-13
CREATE TABLE `system_org` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '机构名称',
  `code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '机构代码',
  `parent_id` int(11) DEFAULT NULL COMMENT '上级机构id',
  `parent_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '上级机构名称',
  `parent_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '上级机构代码',
  `status` varchar(1) DEFAULT NULL COMMENT '状态：0-停用，1-启用',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `create_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT 'admin' COMMENT '创建人',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT 'admin' COMMENT '更新人',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='组织机构表';

### 角色表 
### 菜单表 