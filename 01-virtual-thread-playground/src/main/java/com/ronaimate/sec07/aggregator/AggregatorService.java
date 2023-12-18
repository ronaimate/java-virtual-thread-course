package com.ronaimate.sec07.aggregator;

import java.util.concurrent.ExecutorService;

import com.ronaimate.sec07.externalservice.Client;

public class AggregatorService {

	private final ExecutorService executorService;

	public AggregatorService(ExecutorService executorService) {
		this.executorService = executorService;
	}

	public ProductDto getProductDto(int id) throws Exception {
		var product = executorService.submit(() -> Client.getProduct(id));
		var rating = executorService.submit(() -> Client.getRating(id));
		return new ProductDto(id, product.get(), rating.get());
	}

}