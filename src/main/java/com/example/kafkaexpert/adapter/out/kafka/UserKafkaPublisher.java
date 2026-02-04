package com.example.kafkaexpert.adapter.out.kafka;

import com.example.kafkaexpert.adapter.out.mapper.UserEventMapper;
import com.example.kafkaexpert.domain.User;
import com.example.kafkaexpert.port.out.UserEventPublisher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserKafkaPublisher implements UserEventPublisher {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final UserEventMapper mapper;
    private final String outputTopic;

    public UserKafkaPublisher(
            KafkaTemplate<String, String> kafkaTemplate,
            UserEventMapper mapper,
            @Value("${app.kafka.output-topic}") String outputTopic
    ) {
        this.kafkaTemplate = kafkaTemplate;
        this.mapper = mapper;
        this.outputTopic = outputTopic;
    }

    @Override
    public void publish(User user) {
        kafkaTemplate.send(outputTopic, user.getId(), mapper.toJson(user));
    }
}
