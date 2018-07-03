package com.opas.trade.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.opas.trade.domain.Trade;

@Repository
interface TradeRepository extends JpaRepository<Trade, Long> {

}
