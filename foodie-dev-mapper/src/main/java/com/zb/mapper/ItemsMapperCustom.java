package com.zb.mapper;

import com.zb.pojo.vo.ItemCommentVO;
import com.zb.pojo.vo.SearchItemsVO;
import com.zb.pojo.vo.ShopcartVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItemsMapperCustom {
    public List<ItemCommentVO> queryItemComments(@Param("paramsMap") Map<String, Object> map);

    public List<SearchItemsVO> searchItemsByKeywords(@Param("paramsMap") Map<String, Object> map);

    public List<SearchItemsVO> searchItemsByCatId(@Param("paramsMap") Map<String, Object> map);

    public List<ShopcartVO> queryItemsBySpecIds(@Param("paramsList") List specIdsList);

    public int decreaseItemSpecStock(@Param("specId") String specId,
                                     @Param("pendingCounts") int pendingCounts);
}
