package com.zb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zb.pojo.model.Category;
import com.zb.pojo.vo.CategoryVO;
import com.zb.pojo.vo.NewItemsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CategoryMapper extends BaseMapper<Category> {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

//    List<Category> selectAllCategory(Integer type);

    public List<CategoryVO> getSubCatList(Integer rootCatId);

    public List<NewItemsVO> getSixNewItemsLazy(@Param("paramsMap") Map<String, Object> map);
}