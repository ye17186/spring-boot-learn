package com.yclouds.demo.mybatisplus;

import com.yclouds.demo.mybatisplus.dao.UserDao;
import com.yclouds.demo.mybatisplus.entity.UserEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * com.yclouds.demo.mybatisplus.OptimisticLockerTests
 *
 * @author ye17186
 * @version 2019/6/20 15:56
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OptimisticLockerTests {

    @Autowired
    UserDao userDao;

    @Test
    @Rollback(value = false)
    public void update() {

        UserEntity user = userDao.selectById(5L);
        System.out.println(user);

        UserEntity updateEntity = new UserEntity();
        updateEntity.setId(user.getId());
        updateEntity.setAge(99);
        // 减1操作，就是模拟该条数据已经被其他线程修改了
        updateEntity.setVersion(user.getVersion() - 1);

        // 数据被修改，更新失败
        int count1 = userDao.updateById(updateEntity);
        Assert.assertEquals(0, count1);


        updateEntity.setVersion(user.getVersion());
        // 数据未被修改
        int count2 = userDao.updateById(updateEntity);
        Assert.assertEquals(1, count2);
    }

}
