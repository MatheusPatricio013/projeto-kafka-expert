package com.example.kafkaexpert.application;

import com.example.kafkaexpert.adapter.out.mapper.UserEventMapper;
import com.example.kafkaexpert.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserEventMapperTest {

    @Test
    void convertsFromAndToJson() {
        UserEventMapper mapper = new UserEventMapper(new ObjectMapper());
        String json = "{\"id\":\"1\",\"name\":\"Ana\",\"email\":\"ana@example.com\"}";

        User user = mapper.fromJson(json);
        String serialized = mapper.toJson(user);

        assertThat(user.getId()).isEqualTo("1");
        assertThat(serialized).contains("\"id\":\"1\"");
    }

    @Test
    void throwsExceptionForInvalidJson() {
        UserEventMapper mapper = new UserEventMapper(new ObjectMapper());

        assertThatThrownBy(() -> mapper.fromJson("invalid"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
