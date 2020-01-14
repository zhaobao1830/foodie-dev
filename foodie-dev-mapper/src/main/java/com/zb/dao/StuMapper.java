package com.zb.dao;

import com.zb.dao.mapper.MyMapper;
import com.zb.pojo.Stu;

public interface StuMapper extends MyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Stu record);

    int insertSelective(Stu record);

    Stu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Stu record);

    int updateByPrimaryKey(Stu record);
}