package com.moneyMarket.repository;

import com.moneyMarket.entity.Coin;
import com.moneyMarket.entity.Market;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketRepository extends JpaRepository<Market, Long> {
}
