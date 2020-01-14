package com.zb.dao;

import com.zb.pojo.Stu;
import org.apache.ibatis.annotations.Mapper;

public interface StuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Stu record);

    int insertSelective(Stu record);

    Stu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Stu record);

    int updateByPrimaryKey(Stu record);
}