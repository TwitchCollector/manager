package com.twitchcollector.manager.twitch.client.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("twitch-api")
public class TwitchApiClientProps {

    /**
     * Base URL to the Twitch API
     */
    private String baseUrl;


    /**
     * Client ID for accessing the Twitch API
     */
    private String clientId;

    /**
     * Client secret for accessing the Twitch API
     */
    private String clientSecret;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }
}
