package com.twitchcollector.manager.callback.assembler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twitchcollector.manager.callback.dto.ChallengeReceivedV1;
import com.twitchcollector.manager.callback.dto.Event;
import com.twitchcollector.manager.callback.dto.NotificationReceivedV1;
import com.twitchcollector.manager.callback.dto.RevocationReceivedV1;
import org.springframework.stereotype.Component;

@Component
public class Marshaller {

    private final ObjectMapper objectMapper;

    public Marshaller(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Event unmarshalEvent(String eventJson) {
        try {
            return objectMapper.readValue(eventJson, Event.class);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public NotificationReceivedV1 unmarshalNotificationReceivedV1(Object data) {
        try {
            return objectMapper.readValue(objectMapper.writeValueAsString(data), NotificationReceivedV1.class);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public RevocationReceivedV1 unmarshalRevocationReceivedV1(Object data) {
        try {
            return objectMapper.readValue(objectMapper.writeValueAsString(data), RevocationReceivedV1.class);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public ChallengeReceivedV1 unmarshalChallengeReceivedV1(Object data) {
        try {
            return objectMapper.readValue(objectMapper.writeValueAsString(data), ChallengeReceivedV1.class);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }
}
