package com.twitchcollector.manager.channel.domain;

import java.time.Instant;

public class Channel {

    private final String userId;
    private final String userLogin;
    private final String username;
    private final Instant timeOfDiscovery;

    public Channel(String userId, String userLogin, String username, Instant timeOfDiscovery) {
        this.userId = userId;
        this.userLogin = userLogin;
        this.username = username;
        this.timeOfDiscovery = timeOfDiscovery;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getUsername() {
        return username;
    }

    public Instant getTimeOfDiscovery() {
        return timeOfDiscovery;
    }
}
