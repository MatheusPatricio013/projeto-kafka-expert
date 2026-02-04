package com.example.kafkaexpert.application;

import com.example.kafkaexpert.domain.User;
import com.example.kafkaexpert.port.out.UserEventPublisher;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class UserProcessingServiceTest {

    @Test
    void processNormalizesUserDataBeforePublishing() {
        UserEventPublisher publisher = mock(UserEventPublisher.class);
        UserProcessingService service = new UserProcessingService(publisher);

        User input = new User("123", "  Maria Silva ", " Maria@Example.COM ");

        service.process(input);

        verify(publisher).publish(argThat(user ->
                user.getId().equals("123")
                        && user.getName().equals("MARIA SILVA")
                        && user.getEmail().equals("maria@example.com")
        ));
    }
}
