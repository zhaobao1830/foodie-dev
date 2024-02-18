package com.zb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zb.pojo.model.ItemsComments;
import com.zb.pojo.vo.ItemCommentVO;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface ItemsCommentsMapper extends BaseMapper<ItemsComments> {
    IPage<ItemCommentVO> queryItemComments(Page<ItemsComments> page, String itemId, Integer level);
}