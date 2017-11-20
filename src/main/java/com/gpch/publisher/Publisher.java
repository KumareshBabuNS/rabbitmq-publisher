package com.gpch.publisher;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;

import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;

public class Publisher {
	private final static String QUEUE_NAME = "hello";

	public static void main(String[] argv) throws java.io.IOException, TimeoutException, InterruptedException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		for (int i = 0; i <5; i++) {
			String message = "Hello World! id: " + i;
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
			System.out.println(" [x] Sent '" + message + "'");
			Thread.sleep(5000);
		}
		channel.close();
		connection.close();
	}
}
