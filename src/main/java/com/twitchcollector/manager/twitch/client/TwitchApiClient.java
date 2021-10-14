package com.twitchcollector.manager.twitch.client;

import com.twitchcollector.manager.twitch.client.resource.StreamsResource;
import com.twitchcollector.manager.twitch.domain.constant.Language;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class TwitchApiClient {

    private final WebClient twitchApiWebClient;

    public TwitchApiClient(WebClient twitchApiWebClient) {
        this.twitchApiWebClient = twitchApiWebClient;
    }

    public StreamsResource getStreams(Language language) {
        final var response = twitchApiWebClient.get()
                .uri(uriBuilder -> uriBuilder.path("/streams").queryParam("language", language.getCode()).queryParam("first", 100).build())
                .retrieve().toEntity(StreamsResource.class).block();
        return response.getBody();
    }

    public StreamsResource getStreams(Language language, String cursor) {
        final var response = twitchApiWebClient.get()
                .uri(uriBuilder -> uriBuilder.path("/streams").queryParam("language", language.getCode()).queryParam("first", 100).queryParam("after", cursor).build())
                .retrieve().toEntity(StreamsResource.class).block();
        return response.getBody();
    }
}
