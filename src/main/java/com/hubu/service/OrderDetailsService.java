package com.hubu.service;

import com.hubu.pojo.OrderDetails;

import java.util.List;

public interface OrderDetailsService {

    int addOrderDetails(OrderDetails orderDetails);

    int deleteOrderDetails(String orderId);

    List<OrderDetails> getOrderDetailsByOrderId(String orderId);
}
