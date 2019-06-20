package com.yclouds.demo.mybatisplus;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yclouds.demo.mybatisplus.dao.UserDao;
import com.yclouds.demo.mybatisplus.entity.UserEntity;
import com.yclouds.demo.mybatisplus.model.MyPage;
import com.yclouds.demo.mybatisplus.model.PageParam;
import com.yclouds.demo.mybatisplus.model.UserResult;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * com.yclouds.demo.mybatisplus.PageTests
 *
 * @author ye17186
 * @version 2019/6/20 16:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PageTests {

    @Autowired
    UserDao userDao;

    /**
     * 基础用法
     */
    @Test
    public void testPage1() {

        // 分页信息
        Page<UserEntity> page = new Page<>(1, 2);

        // 查询条件 age >=30
        IPage<UserEntity>  result = userDao.selectPage(page, Wrappers.<UserEntity>lambdaQuery().ge(UserEntity::getAge, 30));

        result.getRecords().forEach(System.out::println);
    }

    @Test
    public void testPage2() {

        // 分页信息
        Page<UserEntity> page = new Page<>(1,2);

        // 查询条件 age >=30
        PageParam param = new PageParam();
        param.setGeAge(30);

        // 此方式必须把page参数放在第一位
        IPage<UserEntity>  result = userDao.selectPageByDiy1(page, param);

        System.out.println(result.toString());
    }

    @Test
    public void testPage3() {

        // MyPage集成了Page
        MyPage<UserEntity> myPage = new MyPage<>(1,2);
        myPage.setGeAge(30);
        myPage.setDeleted(false);
        IPage<UserEntity>  result = userDao.selectPageByDiy2(myPage);

        System.out.println(result.toString());
    }

    @Test
    public void testPage4() {

        // MyPage集成了Page
        MyPage<UserEntity> myPage = new MyPage<>(1,2);
        myPage.setGeAge(30);
        myPage.setDeleted(false);

        // 用List接收的话，也会进行分页查询，但是返回的结果不含分页信息了
        List<UserEntity>  result = userDao.selectPageByDiy3(myPage);

        System.out.println(result.toString());

    }

    @Test
    public void testPage5() {

        // MyPage集成了Page
        MyPage<UserResult> myPage = new MyPage<>(1,2);
        myPage.setGeAge(30);
        myPage.setDeleted(false);
        myPage.setDesc("id", "name");

        // 自定义返回结果类型UserResult，不返回UserEntity
        IPage<UserResult>  result = userDao.selectPageByDiy4(myPage);

        result.getRecords().forEach(System.out::println);
    }
}
