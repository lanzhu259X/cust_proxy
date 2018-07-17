package com.lanzhu.ssp.dao;

import com.lanzhu.ssp.entities.UserAuth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserAuthMapper {

    int insert(UserAuth record);

    UserAuth selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserAuth record);

    UserAuth findByIdentifier(@Param("identifierType") String identifierType,
                              @Param("identifier") String identifier);
}