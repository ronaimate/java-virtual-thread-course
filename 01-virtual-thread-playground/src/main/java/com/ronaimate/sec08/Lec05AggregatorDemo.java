package com.ronaimate.sec08;

import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ronaimate.sec08.aggregator.AggregatorService;

/*
    Aggregate and error handling
 */
public class Lec05AggregatorDemo {

	private static final Logger log = LoggerFactory.getLogger(Lec05AggregatorDemo.class);

	public static void main(String[] args) throws Exception {
		// beans / singletons
		var executor = Executors.newVirtualThreadPerTaskExecutor();
		var aggregator = new AggregatorService(executor);

		log.info("product={}", aggregator.getProductDto(51));
	}

}