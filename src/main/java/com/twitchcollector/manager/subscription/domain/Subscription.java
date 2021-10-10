package com.twitchcollector.manager.subscription.domain;

import java.time.Instant;
import java.util.UUID;

public class Subscription {

    private final UUID id;
    private final String type;
    private final String version;
    private final String status;
    private final Integer cost;
    private final String transportMethod;
    private final String transportCallback;
    private final Instant createdAt;
    private final String targetChannel;

    public Subscription(UUID id, String type, String version, String status, Integer cost, String transportMethod, String transportCallback, Instant createdAt, String targetChannel) {
        this.id = id;
        this.type = type;
        this.version = version;
        this.status = status;
        this.cost = cost;
        this.transportMethod = transportMethod;
        this.transportCallback = transportCallback;
        this.createdAt = createdAt;
        this.targetChannel = targetChannel;
    }

    public UUID getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getVersion() {
        return version;
    }

    public String getStatus() {
        return status;
    }

    public Integer getCost() {
        return cost;
    }

    public String getTransportMethod() {
        return transportMethod;
    }

    public String getTransportCallback() {
        return transportCallback;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public String getTargetChannel() {
        return targetChannel;
    }
}
