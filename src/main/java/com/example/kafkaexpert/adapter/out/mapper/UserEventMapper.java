package com.example.kafkaexpert.adapter.out.mapper;

import com.example.kafkaexpert.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class UserEventMapper {
    private final ObjectMapper objectMapper;

    public UserEventMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public User fromJson(String json) {
        try {
            return objectMapper.readValue(json, User.class);
        } catch (JsonProcessingException ex) {
            throw new IllegalArgumentException("Invalid user json", ex);
        }
    }

    public String toJson(User user) {
        try {
            return objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException ex) {
            throw new IllegalStateException("Failed to serialize user", ex);
        }
    }
}
