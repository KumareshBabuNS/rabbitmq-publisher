package com.gpch.publisher.service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class PublisherServiceImpl implements PublisherService {

	public void publish(String host, String queue, String message) throws IOException, TimeoutException, InterruptedException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(host);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(queue, false, false, false, null);
		channel.basicPublish("", queue, null, message.getBytes());
		channel.close();
		connection.close();
	}

}
