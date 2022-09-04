
--  后台表
--  后台用户表

CREATE TABLE `admin` (
                         `id` bigint(20) NOT NULL AUTO_INCREMENT,
                         `username` varchar(64) DEFAULT NULL,
                         `password` varchar(64) DEFAULT NULL,
                         `icon` varchar(500) DEFAULT NULL COMMENT '头像',
                         `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
                         `nick_name` varchar(200) DEFAULT NULL COMMENT '昵称',
                         `note` varchar(500) DEFAULT NULL COMMENT '备注信息',
                         `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                         `login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
                         `status` int(1) DEFAULT '1' COMMENT '帐号启用状态：0->禁用；1->启用',
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台用户表';

-- 后台菜单表

DROP TABLE IF EXISTS `menu`;
CREATE TABLE `ums_menu` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT,
                            `parent_id` bigint(20) DEFAULT NULL COMMENT '父级ID',
                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                            `title` varchar(100) DEFAULT NULL COMMENT '菜单名称',
                            `level` int(4) DEFAULT NULL COMMENT '菜单级数',
                            `sort` int(4) DEFAULT NULL COMMENT '菜单排序',
                            `name` varchar(100) DEFAULT NULL COMMENT '前端名称',
                            `icon` varchar(200) DEFAULT NULL COMMENT '前端图标',
                            `hidden` int(1) DEFAULT NULL COMMENT '前端隐藏',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='后台菜单表';


-- 后台角色表
CREATE TABLE `role` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT,
                            `name` varchar(100) DEFAULT NULL COMMENT '名称',
                            `description` varchar(500) DEFAULT NULL COMMENT '描述',
                            `admin_count` int(11) DEFAULT NULL COMMENT '后台用户数量',
                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                            `status` int(1) DEFAULT '1' COMMENT '启用状态：0->禁用；1->启用',
                            `sort` int(11) DEFAULT '0',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='后台用户角色表';