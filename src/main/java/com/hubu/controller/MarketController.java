package com.hubu.controller;

import com.hubu.pojo.Market;
import com.hubu.service.MarketService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/market", produces = {"application/json;charset=UTF-8"})
@CrossOrigin
public class MarketController {

    @Resource
    private MarketService marketService;

    @PostMapping("/addToMarket")
    public String addToMarket(Market market){
        int i = marketService.addToMarket(market);
        return "添加至购物车成功!";
    }

    @PostMapping("/deleteFromMarket")
    public String deleteFromMarket(String marketId, String bookId){
        int i = marketService.deleteFromMarket(marketId, bookId);
        return "成功从购物车移除!";
    }

    @PostMapping("/getMarketTotalNumber")
    public int getMarketTotalNumber(String marketId){
        return marketService.getMarketTotalNumber(marketId);
    }

    @PostMapping("/getMarketListByMarketId")
    public List<Market> getMarketListByMarketId(String marketId){
        return marketService.getMarketListByMarketId(marketId);
    }

    @PostMapping("/getMarketListByMarketIdAndBookId")
    public List<Market> getMarketListByMarketIdAndBookId(String marketId, String bookId){
        return marketService.getMarketListByMarketIdAndBookId(marketId, bookId);
    }

    @PostMapping("/updateMarket")
    public int updateMarket(String marketId, String bookId, int number){
        return marketService.updateMarket(marketId, bookId, number);
    }
}
