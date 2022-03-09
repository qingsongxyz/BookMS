package com.hubu.service;

import com.hubu.pojo.OrderList;

import java.util.List;

public interface OrderListService {

    int createOrder(OrderList orderList);

    int deleteOrder(String orderId);

    int getTotalNumber(String marketId);

    List<OrderList> getOrderListByMarketId(String marketId, int pageNum, int pageSize);
}
