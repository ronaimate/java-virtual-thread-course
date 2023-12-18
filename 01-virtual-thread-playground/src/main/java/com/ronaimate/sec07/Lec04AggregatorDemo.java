package com.ronaimate.sec07;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ronaimate.sec07.aggregator.AggregatorService;
import com.ronaimate.sec07.aggregator.ProductDto;

public class Lec04AggregatorDemo {

	private static final Logger log = LoggerFactory.getLogger(Lec04AggregatorDemo.class);

	public static void main(String[] args) throws Exception {

		// beans / singleton
		var executor = Executors.newThreadPerTaskExecutor(Thread.ofVirtual().name("vins", 1).factory());
		var aggregator = new AggregatorService(executor);

		var futures = IntStream.rangeClosed(1, 50)
				.mapToObj(id -> executor.submit(() -> aggregator.getProductDto(id)))
				.toList();

		var list = futures.stream().map(Lec04AggregatorDemo::toProductDto).toList();

		log.info("list: {}", list);


	}

	private static ProductDto toProductDto(Future<ProductDto> future) {
		try {
			return future.get();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
