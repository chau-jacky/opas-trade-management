package com.opas.trade.services;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.opas.trade.domain.Trade;

@Component("tradeService")
class TradeServiceImpl implements TradeService {

	private final TradeRepository tradeRepository;

	public TradeServiceImpl(TradeRepository tradeRepository) {
		this.tradeRepository = tradeRepository;
	}

	@Override
	@Transactional(readOnly = false)
	public Trade save(Trade trade) {
		return tradeRepository.save(trade);
	}

}
