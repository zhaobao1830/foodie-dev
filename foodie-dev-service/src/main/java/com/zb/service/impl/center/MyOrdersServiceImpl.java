package com.zb.service.impl.center;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zb.enums.YesOrNo;
import com.zb.mapper.OrdersMapper;
import com.zb.mapper.OrdersMapperCustom;
import com.zb.pojo.model.Orders;
import com.zb.pojo.vo.MyOrdersVO;
import com.zb.service.center.MyOrdersService;
import com.zb.utils.PagedGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhaobao1830
 * @Date: 2024-02-05 17:41
 */
@Service
public class MyOrdersServiceImpl implements MyOrdersService {

    @Autowired
    public OrdersMapper ordersMapper;

    /**
     * 查询我的订单
     *
     * @param userId
     * @param orderId
     * @return
     */
    @Transactional(propagation= Propagation.SUPPORTS)
    @Override
    public Orders queryMyOrder(String userId, String orderId) {
        Orders orders = new Orders();
        orders.setUserId(userId);
        orders.setId(orderId);
        orders.setIsDelete(YesOrNo.NO.type);

        return ordersMapper.selectOne(orders);
    }
}
