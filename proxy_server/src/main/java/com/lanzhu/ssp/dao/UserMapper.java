package com.lanzhu.ssp.dao;

import com.lanzhu.ssp.entities.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

}