package com.example.kafkaexpert.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class User {
    private final String id;
    private final String name;
    private final String email;

    @JsonCreator
    public User(
            @JsonProperty(\"id\") String id,
            @JsonProperty(\"name\") String name,
            @JsonProperty(\"email\") String email
    ) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.email = Objects.requireNonNull(email, "email must not be null");
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
