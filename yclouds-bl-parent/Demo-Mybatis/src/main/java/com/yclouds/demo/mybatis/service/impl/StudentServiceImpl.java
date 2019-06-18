package com.yclouds.demo.mybatis.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yclouds.demo.mybatis.dao.StudentDao;
import com.yclouds.demo.mybatis.domain.StudentDO;
import com.yclouds.demo.mybatis.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * com.yclouds.demo.mybatis.service.impl.StudentServiceImpl
 *
 * @author yemeng-lhq
 * @version 2019/6/18 14:32
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao studentDao;

    @Override
    public List<StudentDO> getAllStudents() {

        return studentDao.findList();
    }

    @Override
    public Page<StudentDO> getAllStudentsByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return studentDao.findPage();
    }
}
