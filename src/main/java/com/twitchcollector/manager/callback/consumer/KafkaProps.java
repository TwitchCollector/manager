package com.twitchcollector.manager.callback.consumer;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("kafka")
public class KafkaProps {

    /**
     * Name of the callback topic
     */
    private String callbackTopicName;

    /**
     * The maximum age of failing events the application will attempt to process
     */
    private int nackMaxSeconds;

    public String getCallbackTopicName() {
        return callbackTopicName;
    }

    public void setCallbackTopicName(String callbackTopicName) {
        this.callbackTopicName = callbackTopicName;
    }

    public int getNackMaxSeconds() {
        return nackMaxSeconds;
    }

    public void setNackMaxSeconds(int nackMaxSeconds) {
        this.nackMaxSeconds = nackMaxSeconds;
    }
}
