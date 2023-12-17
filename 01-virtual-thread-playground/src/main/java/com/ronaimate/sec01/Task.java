package com.ronaimate.sec01;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Task {

	private static final Logger log = LoggerFactory.getLogger(Task.class);

	public static void ioIntensive(int i) {

		try {
			log.info("starting I/O task {}. Thread Info: {}", i, Thread.currentThread());
			Thread.sleep(Duration.ofSeconds(10));
			log.info("ending I/O task {}. Thread Info: {}", i, Thread.currentThread());
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

	}

}