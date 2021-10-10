package com.twitchcollector.manager.twitch;

import com.twitchcollector.manager.twitch.assembler.StreamsAssembler;
import com.twitchcollector.manager.twitch.client.TwitchApiClient;
import com.twitchcollector.manager.twitch.domain.Streams;
import com.twitchcollector.manager.twitch.domain.constant.Language;
import org.springframework.stereotype.Service;

@Service
public class TwitchService {

    private final TwitchApiClient twitchApiClient;
    private final StreamsAssembler streamsAssembler;

    public TwitchService(TwitchApiClient twitchApiClient, StreamsAssembler streamsAssembler) {
        this.twitchApiClient = twitchApiClient;
        this.streamsAssembler = streamsAssembler;
    }

    public Streams getTopStreams(Language language) {
        return streamsAssembler.assemble(twitchApiClient.getTopStreams(language));
    }
}
