package com.zb.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zb.pojo.model.*;
import com.zb.pojo.vo.CommentLevelCountsVO;
import com.zb.pojo.vo.ItemCommentVO;
import com.zb.pojo.vo.ShopcartVO;
import com.zb.utils.PagedGridResult;

import java.util.List;

public interface ItemService {
    /**
     * 根据商品ID查询详情
     * @param itemId 商品ID
     * @return 获取对应商品详情信息
     */
    Items queryItemById(String itemId);

    /**
     * 根据商品id查询商品图片列表
     * @param itemId 商品ID
     * @return 对应商品图片列表
     */
    List<ItemsImg> queryItemImgList(String itemId);

    /**
     * 根据商品id查询商品规格
     * @param itemId 商品ID
     * @return 对应商品规格
     */
    List<ItemsSpec> queryItemSpecList(String itemId);

    /**
     * 根据商品id查询商品参数
     * @param itemId 商品ID
     * @return 对应商品参数
     */
    ItemsParam queryItemParam(String itemId);

    /**
     * 根据商品id查询商品的评价等级数量
     * @param itemId 商品ID
     */
    CommentLevelCountsVO queryCommentCounts(String itemId);

    /**
     * 根据商品id查询商品的评价（分页）
     * @param itemId 商品ID
     * @param level 评价等级
     * @return 对应商品评价（带分页）
     */
    PagedGridResult queryPagedComments(String itemId, Integer level,
                                             Integer page, Integer pageSize);

    /**
     * 搜索商品列表
     * @param keywords 关键词
     * @param sort 排序
     * @param page 当前页页码
     * @param pageSize 每页条数
     * @return 对应商品列表
     */
    PagedGridResult searchItemsByKeywords(String keywords, String sort,
                                      Integer page, Integer pageSize);

    /**
     * 根据分类id搜索商品列表
     * @param catId 三级分类id
     * @param sort 排序
     * @param page 当前页页码
     * @param pageSize 每页条数
     * @return 对应商品列表
     */
    PagedGridResult searchItemsByCatId(Integer catId, String sort,
                                      Integer page, Integer pageSize);

    /**
     * 根据规格ids查询最新的购物车中商品数据（用于刷新渲染购物车中的商品数据）
     * @param specIds 商品规格ids
     * @return 对应商品数据
     */
    List<ShopcartVO> queryItemsBySpecIds(String specIds);

    /**
     * 根据商品规格id获取规格对象的具体信息
     * @param specId 商品规格id
     * @return 对应商品的规格信息
     */
    ItemsSpec queryItemSpecById(String specId);

    /**
     * 根据商品id获得商品图片主图url
     * @param itemId 商品ID
     * @return 对应商品图片主图url
     */
    String queryItemMainImgById(String itemId);

    /**
     * 减少库存
     * @param specId 商品规格Id(也就是skuId)
     * @param buyCounts 购买的数量
     */
    void decreaseItemSpecStock(String specId, int buyCounts);
}
