package com.hubu.controller;

import com.hubu.pojo.OrderList;
import com.hubu.service.OrderListService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/order", produces = {"application/json;charset=UTF-8"})
@CrossOrigin
public class OrderListController {

    @Resource
    private OrderListService orderListService;

    @PostMapping("/createOrder")
    public String createOrder(@RequestBody OrderList orderList){
        System.out.println(orderList);
        int order = orderListService.createOrder(orderList);
        return "支付成功,订单已生成可在个人中心查看!";
    }

    @PostMapping("/deleteOrder")
    public String deleteOrder(String orderId){
        int order = orderListService.deleteOrder(orderId);
        return "订单删除成功!";
    }

    @PostMapping("/getTotalNumber")
    public int getTotalNumber(String marketId){
        return orderListService.getTotalNumber(marketId);
    }

    @PostMapping("/getOrderListByMarketId/{pageNum}/{pageSize}")
    public List<OrderList> getOrderListByMarketId(String marketId, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return orderListService.getOrderListByMarketId(marketId, pageNum, pageSize);
    }
}
