package com.example.kafkaexpert.application;

import com.example.kafkaexpert.domain.User;
import com.example.kafkaexpert.port.in.ProcessUserUseCase;
import com.example.kafkaexpert.port.out.UserEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class UserProcessingService implements ProcessUserUseCase {
    private final UserEventPublisher userEventPublisher;

    public UserProcessingService(UserEventPublisher userEventPublisher) {
        this.userEventPublisher = userEventPublisher;
    }

    @Override
    public void process(User user) {
        User processed = new User(
                user.getId(),
                user.getName().trim().toUpperCase(),
                user.getEmail().trim().toLowerCase()
        );
        userEventPublisher.publish(processed);
    }
}
