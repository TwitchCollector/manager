package com.twitchcollector.manager.scheduled;

import com.twitchcollector.manager.channel.ChannelService;
import com.twitchcollector.manager.channel.domain.Channel;
import com.twitchcollector.manager.twitch.TwitchService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.function.Supplier;

import static com.twitchcollector.manager.twitch.domain.constant.Language.NORWEGIAN;

@Component
public class UpdateChannelsScheduled {

    private final TwitchService twitchService;
    private final ChannelService channelService;
    private final Supplier<Instant> instantSupplier;

    public UpdateChannelsScheduled(TwitchService twitchService, ChannelService channelService, Supplier<Instant> instantSupplier) {
        this.twitchService = twitchService;
        this.channelService = channelService;
        this.instantSupplier = instantSupplier;
    }

    @Scheduled(fixedDelay = 600000L)
    public void updateChannels() {
        twitchService.getTopStreams(NORWEGIAN).getData().forEach(stream ->
                channelService.getChannel(stream.getUserId()).ifPresentOrElse(
                        channel -> {
                            final var userId = channel.getUserId();
                            final var newUserLogin = stream.getUserLogin();
                            final var newUsername = stream.getUsername();
                            if (!channel.getUserLogin().equals(newUserLogin)) {
                                channelService.updateUserLogin(newUserLogin, userId);
                                channelService.updateUsername(newUsername, userId);
                            } else if (!channel.getUsername().equals(newUsername)) {
                                channelService.updateUsername(newUsername, userId);
                            }
                        },
                        () -> channelService.saveChannel(new Channel(stream.getUserId(), stream.getUserLogin(), stream.getUsername(), instantSupplier.get()))));
    }
}
