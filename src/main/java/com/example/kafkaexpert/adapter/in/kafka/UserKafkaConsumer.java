package com.example.kafkaexpert.adapter.in.kafka;

import com.example.kafkaexpert.adapter.out.mapper.UserEventMapper;
import com.example.kafkaexpert.port.in.ProcessUserUseCase;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserKafkaConsumer {
    private final ProcessUserUseCase processUserUseCase;
    private final UserEventMapper mapper;

    public UserKafkaConsumer(ProcessUserUseCase processUserUseCase, UserEventMapper mapper) {
        this.processUserUseCase = processUserUseCase;
        this.mapper = mapper;
    }

    @KafkaListener(topics = "${app.kafka.input-topic}", groupId = "${app.kafka.group-id}")
    public void consume(String message) {
        processUserUseCase.process(mapper.fromJson(message));
    }
}
