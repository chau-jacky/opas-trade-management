package com.opas.trade.services;

import java.io.StringReader;

import javax.jms.JMSException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import com.opas.trade.domain.Trade;

@Component
public class TradeMessageReceiver {

	static final Logger LOG = LoggerFactory.getLogger(TradeMessageReceiver.class);
	private static final String OPAS_TRADE_QUEUE = "opas-trade-receive-queue";
	
	@Autowired
	private TradeService tradeService;
	@Autowired
	private BookService bookService;


	@JmsListener(destination = OPAS_TRADE_QUEUE)
	public void receiveMessage(final Message<String> message) throws JMSException, InterruptedException {
		System.out.println("in StringMessageReceiver.receiveMessage()");

		System.out.println("----------------------------------------------------");
		MessageHeaders headers = message.getHeaders();
		System.out.println("Header id : " + headers.getId());
		System.out.println("Trade Message Application : headers received : " + headers);
		String order = message.getPayload();
		System.out.println("Trade Message Application : XML Message received : " + order);
		
		StringReader reader = new StringReader(order);
		try {
			JAXBContext context = JAXBContext.newInstance(Trade.class);
		    Trade trade =  (Trade) context.createUnmarshaller().unmarshal(reader);			
			System.out.println("Trade Message Application : Trade Object converted : " + trade);
			bookService.save(trade.getBook());
			tradeService.save(trade);
		} catch (JAXBException jaxbe) {
			System.out.println(jaxbe);
		}
		
		System.out.println("----------------------------------------------------");
		
	}

}
