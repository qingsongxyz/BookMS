package com.hubu.service.impl;
import com.hubu.mapper.MarketMapper;
import com.hubu.pojo.Market;
import com.hubu.service.MarketService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
import java.util.regex.MatchResult;

@Service
public class MarketServiceImpl implements MarketService {

    @Resource
    private MarketMapper marketMapper;


    @Override
    public int addToMarket(Market market) {
        return marketMapper.insert(market);
    }

    @Override
    public int deleteFromMarket(String marketId, String bookId) {
        Example example = new Example(Market.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("marketId", marketId).andEqualTo("bookId", bookId);
        return marketMapper.deleteByExample(example);
    }

    @Override
    public int getMarketTotalNumber(String marketId) {
        Example example = new Example(Market.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("marketId", marketId);
        List<Market> markets = marketMapper.selectByExample(example);
        return markets.size();
    }

    @Override
    public List<Market> getMarketListByMarketId(String marketId) {
        Example example = new Example(Market.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("marketId", marketId);
        return marketMapper.selectByExample(example);
    }

    @Override
    public List<Market> getMarketListByMarketIdAndBookId(String marketId, String bookId) {
        Example example = new Example(Market.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("marketId", marketId).andEqualTo("bookId", bookId);
        return marketMapper.selectByExample(example);
    }

    @Override
    public int updateMarket(String marketId, String bookId, int number) {
        Example example = new Example(Market.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("marketId", marketId).andEqualTo("bookId", bookId);
        Market market = new Market();
        market.setNumber(number);
        return marketMapper.updateByExampleSelective(market, example);
    }
}
