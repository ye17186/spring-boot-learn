package com.yclouds.demo.mybatisplus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yclouds.demo.mybatisplus.entity.UserEntity;
import com.yclouds.demo.mybatisplus.model.MyPage;
import com.yclouds.demo.mybatisplus.model.PageParam;
import com.yclouds.demo.mybatisplus.model.UserResult;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * com.yclouds.demo.mybatisplus.dao.UserDao
 *
 * @author ye17186
 * @version 2019/6/20 10:44
 */
@Repository
public interface UserDao extends BaseMapper<UserEntity> {

    IPage<UserEntity> selectPageByDiy1(
        @Param("page") Page<UserEntity> page, @Param("param") PageParam param);

    IPage<UserEntity> selectPageByDiy2(MyPage<UserEntity> page);

    List<UserEntity> selectPageByDiy3(MyPage<UserEntity> myPage);

    IPage<UserResult> selectPageByDiy4(MyPage<UserResult> myPage);
}
