package com.twitchcollector.manager.callback.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Supplier;

@Component
public class CallbackListener {

    private static final Logger logger = LoggerFactory.getLogger(CallbackListener.class);

    private final CallbackConsumer callbackConsumer;
    private final KafkaProps kafkaProps;
    private final Supplier<Instant> instantSupplier;

    public CallbackListener(CallbackConsumer callbackConsumer, KafkaProps kafkaProps, Supplier<Instant> instantSupplier) {
        this.callbackConsumer = callbackConsumer;
        this.kafkaProps = kafkaProps;
        this.instantSupplier = instantSupplier;
    }

    @KafkaListener(topics = "${kafka.callback-topic-name}")
    public void listen(ConsumerRecord<String, String> record, Acknowledgment acknowledgment) {
        final var key = record.key();
        final var value = record.value();
        final var offset = record.offset();
        final var partition = record.partition();
        try {
            logger.info("Processing record with key: {} and offset: {} from partition: {}", key, offset, partition);
            callbackConsumer.consumeEvent(value);
            logger.info("Processed record with key: {} and offset: {} from partition: {}", key, offset, partition);
            acknowledgment.acknowledge();
        } catch (Throwable throwable) {
            try {
                final var eventAge = Duration.between(Instant.parse(new JSONObject(value).getJSONObject("metadata").getString("created")), instantSupplier.get()).getSeconds();
                if (eventAge <= kafkaProps.getNackMaxSeconds()) {
                    logger.error("Failed to process {}/{} seconds old record with key: {} and offset: {} from partition: {}, trying again in 5 seconds", eventAge, kafkaProps.getNackMaxSeconds(), key, offset, partition);
                    acknowledgment.nack(5000);
                    return;
                }
                logger.error("Failed to process {}/{} seconds old record with key: {} and offset: {} from partition: {}, skipping", eventAge, kafkaProps.getNackMaxSeconds(), key, offset, partition);
                acknowledgment.acknowledge();
            } catch (Throwable eventAgeThrowable) {
                logger.error("Failed to determine age of probably malformed record with key: {} and offset: {} from partition: {}, skipping", key, offset, partition, eventAgeThrowable);
                acknowledgment.acknowledge();
            }
        }
    }
}
