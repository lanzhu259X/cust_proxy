package com.lanzhu.ssp.dao;

import com.lanzhu.ssp.entities.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    int insert(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

}