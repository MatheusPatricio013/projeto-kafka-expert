package com.example.kafkaexpert.port.out;

import com.example.kafkaexpert.domain.User;

public interface UserEventPublisher {
    void publish(User user);
}
