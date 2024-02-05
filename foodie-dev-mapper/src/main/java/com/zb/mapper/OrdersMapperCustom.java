package com.zb.mapper;

import com.zb.pojo.model.OrderStatus;
import com.zb.pojo.vo.MyOrdersVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author：zhaobao1830
 * @Date：2024-02-05 17:47
 */
public interface OrdersMapperCustom {

    public List<MyOrdersVO> queryMyOrders(@Param("paramsMap") Map<String, Object> map);

    public int getMyOrderStatusCounts(@Param("paramsMap") Map<String, Object> map);

    public List<OrderStatus> getMyOrderTrend(@Param("paramsMap") Map<String, Object> map);
}
