package com.gpch.publisher.service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class PublisherServiceImpl implements PublisherService {
	
	private static final String HOST = "localhost";
	private static final String USER = "guest";
	private static final String PASSWORD = "admin";

	public void publish(String exchange, String routingKey, String message) throws IOException, TimeoutException, InterruptedException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(HOST);
		factory.setUsername(USER);
		factory.setPassword(PASSWORD);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.basicPublish(exchange, routingKey, null, message.getBytes());
		channel.close();
		connection.close();
	}

}
