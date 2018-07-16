package com.lanzhu.ssp.dao;

import com.lanzhu.ssp.entities.UserGoods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserGoodsMapper {

    int insert(UserGoods record);

    UserGoods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserGoods record);

}