package com.lanzhu.ssp.dao;

import com.lanzhu.ssp.entities.Goods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsMapper {

    int insert(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

}