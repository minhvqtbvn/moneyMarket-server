package com.moneyMarket.service.Market;

import com.moneyMarket.entity.Market;

import java.util.List;

public interface MarketService {
    Market store(Market market);

    List<Market> marketList();
}
