package com.example.kafkaexpert.port.in;

import com.example.kafkaexpert.domain.User;

public interface ProcessUserUseCase {
    void process(User user);
}
