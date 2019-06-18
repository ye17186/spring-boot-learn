package com.yclouds.demo.mybatis.service;

import com.github.pagehelper.Page;
import com.yclouds.demo.mybatis.domain.StudentDO;
import java.util.List;

/**
 * com.yclouds.demo.mybatis.service.StudentService
 *
 * @author ye1718
 * @version 2019/6/18 14:32
 */
public interface StudentService {

    /**
     * 获取所有的学生信息
     *
     * @return 学生信息列表
     */
    List<StudentDO> getAllStudents();

    /**
     * 分页获取学生信息
     *
     * @param pageNo 页码
     * @param pageSize 每页大小
     * @return 分页学生信息
     */
    Page<StudentDO> getAllStudentsByPage(int pageNo, int pageSize);
}
