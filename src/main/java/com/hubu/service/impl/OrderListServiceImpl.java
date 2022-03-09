package com.hubu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hubu.mapper.OrderListMapper;
import com.hubu.pojo.OrderList;
import com.hubu.service.OrderListService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderListServiceImpl implements OrderListService {

    @Resource
    private OrderListMapper orderListMapper;


    @Override
    public int createOrder(OrderList orderList) {
        return orderListMapper.insert(orderList);
    }

    @Override
    public int deleteOrder(String orderId) {
        return orderListMapper.deleteByPrimaryKey(orderId);
    }

    @Override
    public int getTotalNumber(String marketId) {
        Example example = new Example(OrderList.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("marketId", marketId);
        return orderListMapper.selectByExample(example).size();
    }

    @Override
    public List<OrderList> getOrderListByMarketId(String marketId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(OrderList.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("marketId", marketId);
        return orderListMapper.selectByExample(example);
    }
}
