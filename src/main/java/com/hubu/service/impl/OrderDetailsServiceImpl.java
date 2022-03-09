package com.hubu.service.impl;

import com.hubu.mapper.OrderDetailsMapper;
import com.hubu.pojo.OrderDetails;
import com.hubu.service.OrderDetailsService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

    @Resource
    private OrderDetailsMapper orderDetailsMapper;


    @Override
    public int addOrderDetails(OrderDetails orderDetails) {
        return orderDetailsMapper.insert(orderDetails);
    }

    @Override
    public int deleteOrderDetails(String orderId) {
        Example example = new Example(OrderDetails.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orderId", orderId);
        return orderDetailsMapper.deleteByExample(example);
    }

    @Override
    public List<OrderDetails> getOrderDetailsByOrderId(String orderId) {
        Example example = new Example(OrderDetails.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orderId", orderId);
        return orderDetailsMapper.selectByExample(example);
    }
}
