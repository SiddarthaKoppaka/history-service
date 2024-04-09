package com.siddartha.historyservice.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;

import com.google.gson.Gson;
import com.siddartha.historyservice.model.PrimesRecord;
import com.siddartha.historyservice.repo.PrimesHistoryRepository;

public class MQReceiver {

	private PrimesHistoryRepository primesHistoryRepository;
	
	@RabbitListener(queues ={"primes"})
	public void receiveMessage(@Payload String message) {
		System.out.println(message);
		Gson gson = new Gson();
		PrimesRecord primesRecord = gson.fromJson(message, PrimesRecord.class);
		primesHistoryRepository.save(primesRecord);
	}
}

