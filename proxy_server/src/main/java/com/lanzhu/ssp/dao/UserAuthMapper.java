package com.lanzhu.ssp.dao;

import com.lanzhu.ssp.entities.UserAuth;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserAuthMapper {

    int insert(UserAuth record);

    UserAuth selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserAuth record);

}