package com.yclouds.demo.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.yclouds.demo.mybatisplus.dao.UserDao;
import com.yclouds.demo.mybatisplus.entity.UserEntity;
import com.yclouds.demo.mybatisplus.enums.UserTypeEnum;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MybatisPlusCrudTests {

    @Autowired
    UserDao userDao;

    @Test
    @Rollback(value = false)
    public void testInsert() {

        UserEntity user = new UserEntity();
        user.setName("yclouds");
        user.setType(UserTypeEnum.aa);
        int count = userDao.insert(user);
        Assert.assertEquals(1, count);
        Assert.assertNotNull(user.getId());

    }

    @Test
    public void testUpdate() {

        // 普通写法
        UserEntity userDO = new UserEntity();
        userDO.setId(2L);
        userDO.setName("ycloudss");
        userDO.setAge(99);
        userDO.setEmail("aaabb@yclouds.com");

        int count = userDao.updateById(userDO);

        // lambda写法
        // LambdaUpdateWrapper<UserEntity> wrapper = Wrappers.lambdaUpdate();
        // wrapper.set(UserEntity::getName, "yclouds").set(UserEntity::getAge, 99).set(UserEntity::getEmail, "aaa@yclouds.com").eq(UserEntity::getId, 1L);
        // int count = userDao.update(null, wrapper);

        Assert.assertEquals(1, count);
        UserEntity userAfter = userDao.selectById(1L);
        Assert.assertEquals("yclouds", userAfter.getName());
        Assert.assertEquals(Integer.valueOf(99), userAfter.getAge());
        Assert.assertEquals("aaa@yclouds.com", userAfter.getEmail());
    }


    @Test
    public void testSelect() {

        // 普通写法1，通过ID查询
        // userDao.selectById(3L);

        // 普通写法2
        QueryWrapper<UserEntity> wrapper = Wrappers.query();
        wrapper.eq("name", "Tom");

        // lambda写法
        // LambdaQueryWrapper<UserEntity> wrapper = Wrappers.lambdaQuery();
        // wrapper.eq(UserEntity::getName, "Tom");

        List<UserEntity> userList = userDao.selectList(wrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void testSelectCondition() {

        // 只查询指定字段
        QueryWrapper<UserEntity> wrapper = Wrappers.query();
        wrapper.select("name", "age").eq("id", 3L);
        UserEntity userDO = userDao.selectOne(wrapper);
        System.out.println(userDO);

        Assert.assertEquals("Tom", userDO.getName());
        Assert.assertEquals(Integer.valueOf(28), userDO.getAge());
        Assert.assertNull(userDO.getId());
        Assert.assertNull(userDO.getEmail());
    }

    @Test
    @Rollback(value = false)
    public void testDelete() {

        // 普通写法1，直接通过id删除
        int count = userDao.deleteById(3L);

        // 普通写法2
        // QueryWrapper<UserEntity> wrapper = Wrappers.query();
        // int count = userDao.delete(wrapper.eq("id", 3L));

        // lambda写法
        // LambdaQueryWrapper<UserEntity> wrapper = Wrappers.lambdaQuery();
        // int count = userDao.delete(wrapper.eq(UserEntity::getId, 3L));

        Assert.assertEquals(1, count);
    }
}
