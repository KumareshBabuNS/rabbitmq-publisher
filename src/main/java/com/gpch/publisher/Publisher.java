package com.gpch.publisher;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.gpch.publisher.service.PublisherService;
import com.gpch.publisher.service.PublisherServiceImpl;

public class Publisher {
	
	private static final String QUEUE = "hello";
	private static final String HOST = "localhost";

	public static void main(String[] args) throws InterruptedException, IOException, TimeoutException {
		PublisherService publisherService = new PublisherServiceImpl();
		for (int i = 1; i <= 10; i++) {
			publisherService.publish(HOST, QUEUE, "New message with id: " + i);
			Thread.sleep(5000);
		}
	}
}
