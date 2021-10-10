package com.twitchcollector.manager.twitch.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class TwitchApiClientConfig {

    @Bean
    public WebClient twitchApiWebClient(TwitchApiClientProps props) {
        return WebClient.builder()
                .baseUrl(props.getBaseUrl())
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + props.getClientSecret())
                .defaultHeader("Client-Id", props.getClientId())
                .build();
    }
}
