package com.yclouds.demo.mybatis.controller;

import com.github.pagehelper.Page;
import com.yclouds.demo.mybatis.domain.StudentDO;
import com.yclouds.demo.mybatis.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.yclouds.demo.mybatis.controller.StudentController
 *
 * @author ye1718
 * @version 2019/6/18 14:31
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/all")
    public List<StudentDO> all() {
        return studentService.getAllStudents();
    }

    @GetMapping("/page")
    public Page<StudentDO> page(@RequestParam int pageNo, @RequestParam int pageSize) {
        return studentService.getAllStudentsByPage(pageNo, pageSize);
    }
}
