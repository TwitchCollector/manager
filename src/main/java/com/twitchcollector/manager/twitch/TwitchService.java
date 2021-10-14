package com.twitchcollector.manager.twitch;

import com.twitchcollector.manager.twitch.assembler.StreamsAssembler;
import com.twitchcollector.manager.twitch.client.TwitchApiClient;
import com.twitchcollector.manager.twitch.domain.Streams;
import com.twitchcollector.manager.twitch.domain.constant.Language;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TwitchService {

    private static final Logger logger = LoggerFactory.getLogger(TwitchService.class);

    private final TwitchApiClient twitchApiClient;
    private final StreamsAssembler streamsAssembler;

    public TwitchService(TwitchApiClient twitchApiClient, StreamsAssembler streamsAssembler) {
        this.twitchApiClient = twitchApiClient;
        this.streamsAssembler = streamsAssembler;
    }

    public Streams getStreams(Language language) {
        logger.debug("Fetching streams for language: {} from Twitch", language.name());
        final var streams = streamsAssembler.assemble(twitchApiClient.getStreams(language));
        logger.info("Fetched '{}' streams for language: {} from Twitch", streams.getData().size(), language.name());
        return streams;
    }

    public Streams getStreams(Language language, String cursor) {
        logger.debug("Fetching streams after cursor for language: {} from Twitch", language.name());
        final var streams = streamsAssembler.assemble(twitchApiClient.getStreams(language, cursor));
        logger.info("Fetched '{}' streams after cursor for language: {} from Twitch", streams.getData().size(), language.name());
        return streams;
    }
}
