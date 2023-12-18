package com.ronaimate.sec07;

import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ronaimate.sec07.externalservice.Client;

public class Lec03AccessResponseUsingFuture {

	private static final Logger log = LoggerFactory.getLogger(Lec03AccessResponseUsingFuture.class);

	public static void main(String[] args) throws Exception {
		try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {

			var product1 = executor.submit(() -> Client.getProduct(1));
			var product2 = executor.submit(() -> Client.getProduct(2));
			var product3 = executor.submit(() -> Client.getProduct(3));

			log.info("product-1: {}", product1.get());
			log.info("product-2: {}", product2.get());
			log.info("product-3: {}", product3.get());
		}

	}

}
