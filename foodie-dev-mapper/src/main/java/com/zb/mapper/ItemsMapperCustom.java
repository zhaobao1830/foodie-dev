package com.zb.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zb.pojo.model.Items;
import com.zb.pojo.model.ItemsComments;
import com.zb.pojo.vo.ItemCommentVO;
import com.zb.pojo.vo.SearchItemsVO;
import com.zb.pojo.vo.ShopcartVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItemsMapperCustom {
    IPage<ItemCommentVO> queryItemComments(Page<ItemsComments> page, String itemId, Integer level);

    IPage<SearchItemsVO> searchItemsByKeywords(Page<Items> page, @Param("paramsMap") Map<String, Object> map);

    IPage<SearchItemsVO> searchItemsByCatId(Page<Items> page, @Param("paramsMap") Map<String, Object> map);

    List<ShopcartVO> queryItemsBySpecIds(@Param("paramsList") List<String> specIdsList);

    int decreaseItemSpecStock(@Param("specId") String specId,
                                     @Param("pendingCounts") int pendingCounts);
}
