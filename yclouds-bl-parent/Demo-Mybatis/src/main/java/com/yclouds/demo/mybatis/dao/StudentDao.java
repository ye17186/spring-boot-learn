package com.yclouds.demo.mybatis.dao;

import com.github.pagehelper.Page;
import com.yclouds.demo.mybatis.domain.StudentDO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * com.yclouds.demo.mybatis.dao.StudentDao
 *
 * @author yemeng-lhq
 * @version 2019/6/18 16:53
 */
@Repository
public interface StudentDao {

    /**
     * 查询学生信息列表
     *
     * @return 学生信息列表
     */
    List<StudentDO> findList();

    /**
     * 分页查询学生信息列表
     *
     * @return 学生信息列表
     */
    Page<StudentDO> findPage();
}
