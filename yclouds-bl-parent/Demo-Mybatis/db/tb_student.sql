SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student`  (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '姓名',
  `age` int(11) NOT NULL COMMENT '年龄',
  `birthday` date NOT NULL COMMENT '生日',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_student
-- ----------------------------
INSERT INTO `tb_student` VALUES (1, '张三', 18, '1999-03-18');
INSERT INTO `tb_student` VALUES (2, '李四', 19, '2000-05-25');
INSERT INTO `tb_student` VALUES (3, '王五', 17, '1998-10-29');
INSERT INTO `tb_student` VALUES (4, '赵六', 18, '1999-03-18');
INSERT INTO `tb_student` VALUES (5, '钱七', 18, '2000-05-25');
INSERT INTO `tb_student` VALUES (6, '孙八', 18, '1998-10-29');

SET FOREIGN_KEY_CHECKS = 1;
