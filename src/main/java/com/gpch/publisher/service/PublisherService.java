package com.gpch.publisher.service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public interface PublisherService {
	public void publish(String exchange, String routingKey, String message) throws IOException, TimeoutException, InterruptedException;
}
