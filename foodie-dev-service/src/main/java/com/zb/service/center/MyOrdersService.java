package com.zb.service.center;

import com.zb.pojo.model.Orders;
import com.zb.utils.PagedGridResult;

/**
 * @Author: haobao1830
 * @Date: 2024-02-05 17:40
 */
public interface MyOrdersService {

    /**
     * 查询我的订单
     * @param userId
     * @param orderId
     * @return
     */
    public Orders queryMyOrder(String userId, String orderId);
}
