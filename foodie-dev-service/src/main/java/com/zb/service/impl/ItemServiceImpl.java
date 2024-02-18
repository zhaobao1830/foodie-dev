package com.zb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zb.enums.YesOrNo;
import com.zb.mapper.*;
import com.zb.enums.CommentLevel;
import com.zb.pojo.model.*;
import com.zb.pojo.vo.CommentLevelCountsVO;
import com.zb.pojo.vo.ItemCommentVO;
import com.zb.pojo.vo.SearchItemsVO;
import com.zb.pojo.vo.ShopcartVO;
import com.zb.service.ItemService;
import com.zb.utils.DesensitizationUtil;
import com.zb.utils.PagedGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemsMapper itemsMapper;

    @Autowired
    private ItemsImgMapper itemsImgMapper;

    @Autowired
    private ItemsSpecMapper itemsSpecMapper;

    @Autowired
    private ItemsParamMapper itemsParamMapper;

    @Autowired
    private ItemsCommentsMapper itemsCommentsMapper;

    @Autowired
    private ItemsMapperCustom itemsMapperCustom;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Items queryItemById(String itemId) {
        return itemsMapper.selectById(itemId);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<ItemsImg> queryItemImgList(String itemId) {
        QueryWrapper<ItemsImg> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(ItemsImg::getItemId, itemId);
        return itemsImgMapper.selectList(wrapper);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<ItemsSpec> queryItemSpecList(String itemId) {
        QueryWrapper<ItemsSpec> wrapper = new QueryWrapper<>();
        wrapper.eq("item_id", itemId);
        return itemsSpecMapper.selectList(wrapper);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public ItemsParam queryItemParam(String itemId) {
        QueryWrapper<ItemsParam> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(ItemsParam::getItemId, itemId);
        return itemsParamMapper.selectOne(wrapper);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public CommentLevelCountsVO queryCommentCounts(String itemId) {
        Integer goodCounts = getCommentCounts(itemId, CommentLevel.GOOD.type).intValue();
        Integer normalCounts = getCommentCounts(itemId, CommentLevel.NORMAL.type).intValue();
        Integer badCounts = getCommentCounts(itemId, CommentLevel.BAD.type).intValue();
        Integer totalCounts = goodCounts + normalCounts + badCounts;

        CommentLevelCountsVO countsVO = new CommentLevelCountsVO();
        countsVO.setTotalCounts(totalCounts);
        countsVO.setGoodCounts(goodCounts);
        countsVO.setNormalCounts(normalCounts);
        countsVO.setBadCounts(badCounts);

        return countsVO;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public Long getCommentCounts(String itemId, Integer level) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("itemId", itemId);
//        map.put("level", level);
        QueryWrapper<ItemsComments> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(ItemsComments::getItemId, itemId).eq(ItemsComments::getCommentLevel, level);
        return itemsCommentsMapper.selectCount(wrapper);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public PagedGridResult queryPagedComments(String itemId,
                                    Integer level,
                                    Integer page,
                                    Integer pageSize) {

        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ItemsComments> page1 = new Page<>(page, pageSize);
        IPage<ItemCommentVO> iPage= itemsCommentsMapper.queryItemComments(page1, itemId, level);
        List<ItemCommentVO> list = iPage.getRecords();
        for (ItemCommentVO vo : list) {
            vo.setNickname(DesensitizationUtil.commonDisplay(vo.getNickname()));
        }
        return setterPagedGrid(iPage.getRecords(), page);
//        Map<String, Object> map = new HashMap<>();
//        map.put("itemId", itemId);
//        map.put("level", level);
        //        for (ItemCommentVO vo : iPage.getRecords()) {
//            vo.setNickname(DesensitizationUtil.commonDisplay(vo.getNickname()));
//        }

//        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ItemsComments> page1 = new Page<>(page, pageSize);
//        QueryWrapper<ItemsComments> queryWrapper = new QueryWrapper<>();
//        queryWrapper.lambda().eq(ItemsComments::getItemId, itemId).eq(ItemsComments::getCommentLevel, level);
//        return itemsCommentsMapper.selectPage(page1, queryWrapper);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public PagedGridResult searchItemsByKeywords(String keywords, String sort, Integer page, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("keywords", keywords);
        map.put("sort", sort);

        PageHelper.startPage(page, pageSize);
        List<SearchItemsVO> list = itemsMapperCustom.searchItemsByKeywords(map);

        return setterPagedGrid(list, page);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public PagedGridResult searchItemsByCatId(Integer catId, String sort, Integer page, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("catId", catId);
        map.put("sort", sort);

        PageHelper.startPage(page, pageSize);
        List<SearchItemsVO> list = itemsMapperCustom.searchItemsByCatId(map);

        return setterPagedGrid(list, page);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<ShopcartVO> queryItemsBySpecIds(String specIds) {
        String[] ids = specIds.split(",");
        List<String> specIdsList = new ArrayList<>();
        Collections.addAll(specIdsList, ids);
        System.out.println(specIdsList);
        return itemsMapperCustom.queryItemsBySpecIds(specIdsList);
    }

    /**
     * 根据商品规格id获取规格对象的具体信息
     * @param specId 商品规格id
     * @return 对应商品的规格信息
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public ItemsSpec queryItemSpecById(String specId) {
        return itemsSpecMapper.selectById(specId);
    }

    /**
     * 根据商品id获得商品图片主图url
     * @param itemId 商品ID
     * @return 对应商品图片主图url
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public String queryItemMainImgById(String itemId) {
        QueryWrapper<ItemsImg> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(ItemsImg::getItemId, itemId).eq(ItemsImg::getIsMain, YesOrNo.YES.type);
        ItemsImg result = itemsImgMapper.selectOne(wrapper);
        return result != null ? result.getUrl() : "";
    }

    /**
     * 减少库存
     *
     * @param specId    商品规格Id(也就是skuId)
     * @param buyCounts 购买的数量
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void decreaseItemSpecStock(String specId, int buyCounts) {
        // synchronized 不推荐使用，集群下无用，性能低下
                // 锁数据库: 不推荐，导致数据库性能低下
                // 分布式锁 zookeeper redis

                // lockUtil.getLock(); -- 加锁

                // 1. 查询库存
        //        int stock = 10;

                // 2. 判断库存，是否能够减少到0以下
        //        if (stock - buyCounts < 0) {
                // 提示用户库存不够
        //            10 - 3 -3 - 5 = -1
        //        }

        // lockUtil.unLock(); -- 解锁


        int result = itemsMapperCustom.decreaseItemSpecStock(specId, buyCounts);
        if (result != 1) {
            throw new RuntimeException("订单创建失败，原因：库存不足!");
        }
    }

    private PagedGridResult setterPagedGrid(List<?> list, Integer page) {
        PageInfo<?> pageList = new PageInfo<>(list);
        PagedGridResult grid = new PagedGridResult();
        grid.setPage(page);
        grid.setRows(list);
        grid.setTotal(pageList.getPages());
        grid.setRecords(pageList.getTotal());
        return grid;
    }
}

