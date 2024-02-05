package com.zb.controller;

import com.zb.pojo.model.Items;
import com.zb.pojo.model.ItemsImg;
import com.zb.pojo.model.ItemsParam;
import com.zb.pojo.model.ItemsSpec;
import com.zb.pojo.vo.CommentLevelCountsVO;
import com.zb.pojo.vo.ItemInfoVO;
import com.zb.pojo.vo.ShopcartVO;
import com.zb.service.ItemService;
import com.zb.utils.IMOOCJSONResult;
import com.zb.utils.PagedGridResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "商品接口", tags = {"商品信息展示的相关接口"})
@RestController
@RequestMapping("items")
public class ItemsController extends BaseController{

    @Autowired
    private ItemService itemService;

    // restful 接口
//    @ApiOperation(value = "查询商品详情", notes = "查询商品详情", httpMethod = "GET")
//    @RequestMapping(value = "/info/{itemId}", method = RequestMethod.GET)
//    public IMOOCJSONResult info(
//            @ApiParam(name = "/itemId", value = "商品id", required = true)
//            @PathVariable String itemId) {
//        if (StringUtils.isBlank(itemId)) {
//            return IMOOCJSONResult.errorMap("商品id为空");
//        }
//
//        Items items = itemService.queryItemById(itemId);
//        List<ItemsImg> itemImgList = itemService.queryItemImgList(itemId);
//        List<ItemsSpec> itemsSpecList = itemService.queryItemSpecList(itemId);
//        ItemsParam itemsParam = itemService.queryItemParam(itemId);
//
//        ItemInfoVO itemInfoVO = new ItemInfoVO();
//        itemInfoVO.setItem(items);
//        itemInfoVO.setItemImgList(itemImgList);
//        itemInfoVO.setItemSpecList(itemsSpecList);
//        itemInfoVO.setItemParams(itemsParam);
//
//        return IMOOCJSONResult.ok(itemInfoVO);
//    }

    @ApiOperation(value = "查询商品详情", notes = "查询商品详情", httpMethod = "GET")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public IMOOCJSONResult info(
            @ApiParam(name = "/itemId", value = "商品id", required = true)
            @RequestParam String itemId) {
        if (StringUtils.isBlank(itemId)) {
            return IMOOCJSONResult.errorMap("商品id为空");
        }

        Items items = itemService.queryItemById(itemId);
        List<ItemsImg> itemImgList = itemService.queryItemImgList(itemId);
        List<ItemsSpec> itemsSpecList = itemService.queryItemSpecList(itemId);
        ItemsParam itemsParam = itemService.queryItemParam(itemId);

        ItemInfoVO itemInfoVO = new ItemInfoVO();
        itemInfoVO.setItem(items);
        itemInfoVO.setItemImgList(itemImgList);
        itemInfoVO.setItemSpecList(itemsSpecList);
        itemInfoVO.setItemParams(itemsParam);

        return IMOOCJSONResult.ok(itemInfoVO);
    }

    @ApiOperation(value = "查询商品评价等级", notes = "查询商品评价等级", httpMethod = "GET")
    @RequestMapping(value = "/commentLevel", method = RequestMethod.GET)
    public IMOOCJSONResult commentLevel(
            @ApiParam(name = "itemId", value = "商品id", required = true)
            @RequestParam String itemId) {

        if (StringUtils.isBlank(itemId)) {
            return IMOOCJSONResult.errorMsg(null);
        }

        CommentLevelCountsVO countsVO = itemService.queryCommentCounts(itemId);

        return IMOOCJSONResult.ok(countsVO);
    }

    @ApiOperation(value = "查询商品评价", notes = "查询商品评价", httpMethod = "GET")
    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    public IMOOCJSONResult comments(
            @ApiParam(name = "itemId", value = "商品id", required = true)
            @RequestParam String itemId,
            @ApiParam(name = "level", value = "评价等级", required = false)
            @RequestParam Integer level,
            @ApiParam(name = "page", value = "查询下一页的第几页", required = false)
            @RequestParam Integer page,
            @ApiParam(name = "pageSize", value = "分页的每一页显示的条数", required = false)
            @RequestParam Integer pageSize
    ){
        if (StringUtils.isBlank(itemId)) {
            return IMOOCJSONResult.errorMsg(null);
        }

        if (page == null) {
            page = 1;
        }

        if (pageSize == null) {
            pageSize = COMMON_PAGE_SIZE;
        }

        PagedGridResult grid = itemService.queryPagedComments(itemId,
                                                                level,
                                                                page,
                                                                pageSize);

        return IMOOCJSONResult.ok(grid);
    }

    @ApiOperation(value = "搜索商品列表", notes = "搜索商品列表", httpMethod = "GET")
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public IMOOCJSONResult search(
            @ApiParam(name = "keywords", value = "关键字", required = true)
            @RequestParam String keywords,
            @ApiParam(name = "sort", value = "排序", required = false)
            @RequestParam String sort,
            @ApiParam(name = "page", value = "查询下一页的第几页", required = false)
            @RequestParam Integer page,
            @ApiParam(name = "pageSize", value = "分页的每一页显示的条数", required = false)
            @RequestParam Integer pageSize
    ) {
        if (StringUtils.isBlank(keywords)) {
            return IMOOCJSONResult.errorMsg(null);
        }

        if (page == null) {
            page = 1;
        }

        if (pageSize == null) {
            pageSize = PAGE_SIZE;
        }

        PagedGridResult grid = itemService.searhItemsByKeywords(
                keywords,
                sort,
                page,
                pageSize);

        return IMOOCJSONResult.ok(grid);
    }

    @ApiOperation(value = "通过分类id搜索商品列表", notes = "通过分类id搜索商品列表", httpMethod = "GET")
    @RequestMapping(value = "/catItems", method = RequestMethod.GET)
    public IMOOCJSONResult catItems(
            @ApiParam(name = "catId", value = "三级分类id", required = true)
            @RequestParam Integer catId,
            @ApiParam(name = "sort", value = "排序", required = false)
            @RequestParam String sort,
            @ApiParam(name = "page", value = "查询下一页的第几页", required = false)
            @RequestParam Integer page,
            @ApiParam(name = "pageSize", value = "分页的每一页显示的条数", required = false)
            @RequestParam Integer pageSize
    ) {
        if (catId == null) {
            return IMOOCJSONResult.errorMsg(null);
        }

        if (page == null) {
            page = 1;
        }

        if (pageSize == null) {
            pageSize = PAGE_SIZE;
        }

        PagedGridResult grid = itemService.searhItemsByCatId(
                catId,
                sort,
                page,
                pageSize);

        return IMOOCJSONResult.ok(grid);
    }

    // 用于用户长时间未登录网站，刷新购物车中的数据（主要是商品价格），类似京东淘宝
    @ApiOperation(value = "根据商品规格ids查找最新的商品数据", notes = "根据商品规格ids查找最新的商品数据", httpMethod = "GET")
    @RequestMapping(value = "/refresh", method = RequestMethod.GET)
    public IMOOCJSONResult refresh(
            @ApiParam(name = "itemSpecIds", value = "拼接的规格ids", required = true, example = "1001,1003,1005")
            @RequestParam String itemSpecIds
    ) {
        if (StringUtils.isBlank(itemSpecIds)) {
            return IMOOCJSONResult.ok();
        }
        List<ShopcartVO> list = itemService.queryItemsBySpecIds(itemSpecIds);

        return IMOOCJSONResult.ok(list);
    }
}
