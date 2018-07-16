package com.lanzhu.ssp.dao;

import com.lanzhu.ssp.entities.Company;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyMapper {

    int insert(Company record);

    Company selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Company record);

}