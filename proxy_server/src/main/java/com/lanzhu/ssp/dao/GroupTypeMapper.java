package com.lanzhu.ssp.dao;

import com.lanzhu.ssp.entities.GroupType;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GroupTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GroupType record);

    GroupType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GroupType record);

}