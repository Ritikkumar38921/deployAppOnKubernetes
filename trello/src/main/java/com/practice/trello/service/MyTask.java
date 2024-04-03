package com.practice.trello.service;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyTask {

	@Scheduled(cron = "${com.practice.trello.schuler}")
	public void test() {
		System.out.println("Scheduler Run , " + new Date());
	}

}
