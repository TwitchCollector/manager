package com.twitchcollector.manager.scheduled;

import com.twitchcollector.manager.channel.ChannelService;
import com.twitchcollector.manager.channel.domain.Channel;
import com.twitchcollector.manager.twitch.TwitchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.function.Supplier;

import static com.twitchcollector.manager.twitch.domain.constant.Language.NORWEGIAN;

@Component
public class UpdateChannelsScheduled {

    private static final Logger logger = LoggerFactory.getLogger(UpdateChannelsScheduled.class);

    private final TwitchService twitchService;
    private final ChannelService channelService;
    private final Supplier<Instant> instantSupplier;

    public UpdateChannelsScheduled(TwitchService twitchService, ChannelService channelService, Supplier<Instant> instantSupplier) {
        this.twitchService = twitchService;
        this.channelService = channelService;
        this.instantSupplier = instantSupplier;
    }

    @Scheduled(fixedDelay = 60000L)
    public void updateChannels() {
        twitchService.getTopStreams(NORWEGIAN).getData().forEach(stream ->
                channelService.getChannel(stream.getUserId()).ifPresentOrElse(
                        channel -> logger.debug("Ignoring already discovered channel with userId: {}", channel.getUserId()),
                        () -> channelService.saveChannel(new Channel(stream.getUserId(), stream.getUserLogin(), stream.getUsername(), instantSupplier.get()))));
    }
}
