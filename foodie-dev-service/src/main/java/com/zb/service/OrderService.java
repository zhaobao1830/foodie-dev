package com.zb.service;

import com.zb.pojo.dto.SubmitOrderDTO;
import com.zb.pojo.vo.OrderVO;

/**
 * @Author: zhaobao1830
 * @Date: 2024-02-05 14:37
 */
public interface OrderService {

    /**
     * 用于创建订单相关信息
     * @param submitOrderDTO 前端传递的订单相关信息
     * @return 订单对象
     */
    public OrderVO createOrder(SubmitOrderDTO submitOrderDTO);
}
