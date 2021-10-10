package com.twitchcollector.manager.callback.consumer;

import com.twitchcollector.manager.callback.assembler.Marshaller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CallbackConsumer {

    private static final Logger logger = LoggerFactory.getLogger(CallbackConsumer.class);

    private final Marshaller marshaller;

    public CallbackConsumer(Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    public void consumeEvent(String eventJson) {
        final var event = marshaller.unmarshalEvent(eventJson);
        final var metadata = event.getMetadata();
        final var eventType = metadata.getEventType();
        final var version = metadata.getVersion();
        if ("NOTIFICATION_RECEIVED".equals(eventType) && "1".equals(version)) {
            final var notificationReceived = marshaller.unmarshalNotificationReceivedV1(event.getData());
        } else if ("REVOCATION_RECEIVED".equals(eventType) && "1".equals(version)) {
            final var revocationReceived = marshaller.unmarshalRevocationReceivedV1(event.getData());
        } else if ("CHALLENGE_RECEIVED".equals(eventType) && "1".equals(version)) {
            final var challengeReceived = marshaller.unmarshalChallengeReceivedV1(event.getData());
        } else {
            logger.warn("Unknown event with eventId: {}, eventType: {} and version: {}", metadata.getEventId(), eventType, version);
        }
    }
}
