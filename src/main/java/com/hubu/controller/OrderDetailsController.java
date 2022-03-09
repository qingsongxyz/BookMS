package com.hubu.controller;

import com.hubu.pojo.OrderDetails;
import com.hubu.service.OrderDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/orderDetails")
@CrossOrigin
public class OrderDetailsController {

    @Resource
    private OrderDetailsService orderDetailsService;

    @PostMapping("/addOrderDetails")
    public int addOrderDetails(OrderDetails orderDetails){
        return orderDetailsService.addOrderDetails(orderDetails);
    }

    @PostMapping("/deleteOrderDetails")
    public int deleteOrderDetails(String orderId){
        return orderDetailsService.deleteOrderDetails(orderId);
    }

    @PostMapping("/getOrderDetailsByOrderId")
    public List<OrderDetails> getOrderDetailsByOrderId(String orderId){
        return orderDetailsService.getOrderDetailsByOrderId(orderId);
    }
}
