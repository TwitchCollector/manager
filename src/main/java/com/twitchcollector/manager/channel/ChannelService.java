package com.twitchcollector.manager.channel;

import com.twitchcollector.manager.channel.domain.Channel;
import com.twitchcollector.manager.channel.repository.ChannelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChannelService {

    private static final Logger logger = LoggerFactory.getLogger(ChannelService.class);

    private final ChannelRepository channelRepository;

    public ChannelService(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    public void saveChannel(Channel channel) {
        logger.debug("Saving channel with userId: {}", channel.getUserId());
        channelRepository.saveChannel(channel);
        logger.info("Saved channel with userId: {}", channel.getUserId());
    }

    public Optional<Channel> getChannel(String userId) {
        return channelRepository.getChannel(userId);
    }

    public void updateUserLogin(String userLogin, String userId) {
        logger.debug("Updating userLogin to: {} for channel with userId: {}", userLogin, userId);
        channelRepository.updateUserLogin(userLogin, userId);
        logger.info("Updated userLogin to: {} for channel with userId: {}", userLogin, userId);
    }

    public void updateUsername(String username, String userId) {
        logger.debug("Updating username to: {} for channel with userId: {}", username, userId);
        channelRepository.updateUsername(username, userId);
        logger.info("Updated username to: {} for channel with userId: {}", username, userId);
    }
}
