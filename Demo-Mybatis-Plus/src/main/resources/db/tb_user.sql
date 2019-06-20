-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '姓名',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '邮箱',
  `type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '用户类型，A=管理员；N=普通用户',
  `version` bigint(20) NOT NULL DEFAULT 1 COMMENT '数据版本',
  `deleted` tinyint(1) NULL DEFAULT 0 COMMENT '删除标记，0=未删除；1=已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'yclouds1', 10, '111@163.com', 'A', 1, 0);
INSERT INTO `tb_user` VALUES (2, 'yclouds2', 20, '222@163.com', 'A', 1, 0);
INSERT INTO `tb_user` VALUES (3, 'yclouds3', 20, '333@163.com', 'A', 1, 0);
INSERT INTO `tb_user` VALUES (4, 'yclouds4', 30, '444@163.com', 'N', 1, 0);
INSERT INTO `tb_user` VALUES (5, 'yclouds5', 40, '111@163.com', 'A', 1, 1);
INSERT INTO `tb_user` VALUES (6, 'yclouds6', 50, '222@163.com', 'A', 1, 0);
INSERT INTO `tb_user` VALUES (7, 'yclouds7', 20, '333@163.com', 'A', 1, 0);
INSERT INTO `tb_user` VALUES (8, 'yclouds8', 30, '444@163.com', 'N', 1, 0);
INSERT INTO `tb_user` VALUES (9, 'yclouds9', 40, '555@163.com', 'A', 1, 0);
INSERT INTO `tb_user` VALUES (10, 'yclouds10', 60, '555@163.com', 'A', 1, 0);
