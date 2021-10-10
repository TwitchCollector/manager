package com.twitchcollector.manager.twitch.client.resource;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaginationResource {

    private final String cursor;

    public PaginationResource(@JsonProperty("cursor") String cursor) {
        this.cursor = cursor;
    }

    public String getCursor() {
        return cursor;
    }
}
