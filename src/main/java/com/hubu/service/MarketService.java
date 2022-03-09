package com.hubu.service;

import com.hubu.pojo.Market;

import java.util.List;

public interface MarketService {

    int addToMarket(Market market);

    int deleteFromMarket(String marketId, String bookId);

    int getMarketTotalNumber(String marketId);

    List<Market> getMarketListByMarketId(String marketId);

    List<Market> getMarketListByMarketIdAndBookId(String marketId, String bookId);

    int updateMarket(String marketId, String bookId, int number);
}
