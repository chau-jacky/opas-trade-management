package com.opas.trade.config;

import java.util.Arrays;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfiguration {

	static final Logger LOG = LoggerFactory.getLogger(MessagingConfiguration.class);

	private static final String DEFAULT_BROKER_URL = "tcp://104.197.230.229:61616";
	// private static final String OPAS_TRADE_QUEUE = "opas-trade-receive-queue";

	@Bean
	public ActiveMQConnectionFactory connectionFactory() {
		System.out.println("in MessagingConfiguration.connectionFactory()");

		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
		connectionFactory.setTrustedPackages(Arrays.asList("com.opas"));
		return connectionFactory;
	}

	/* For Point-to-Point */
	// @Bean
	// public JmsTemplate jmsStringTemplate() {
	// System.out.println("in MessagingConfiguration.jmsStringTemplate()");
	//
	// JmsTemplate template = new JmsTemplate();
	// template.setConnectionFactory(connectionFactory());
	// template.setDefaultDestinationName(OPAS_TRADE_QUEUE);
	// return template;
	// }

}