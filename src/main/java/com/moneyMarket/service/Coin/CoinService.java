package com.moneyMarket.service.Coin;

import com.moneyMarket.entity.Coin;
import com.moneyMarket.entity.Market;

import java.util.List;

public interface CoinService {
    Coin store(Coin coin);

    List<Coin> coinList();

    List<Coin> findCoinByName(String name);

    List<Coin> findCoinByMarket(long id);
}
