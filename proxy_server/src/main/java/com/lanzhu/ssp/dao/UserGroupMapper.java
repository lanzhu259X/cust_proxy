package com.lanzhu.ssp.dao;

import com.lanzhu.ssp.entities.UserGroup;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserGroupMapper {

    int insert(UserGroup record);

    UserGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserGroup record);

}