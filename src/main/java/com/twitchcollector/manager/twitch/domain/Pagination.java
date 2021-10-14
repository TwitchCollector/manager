package com.twitchcollector.manager.twitch.domain;

import java.util.Optional;

public class Pagination {

    private final String cursor;

    public Pagination(String cursor) {
        this.cursor = cursor;
    }

    public Optional<String> getCursor() {
        return Optional.ofNullable(cursor);
    }
}
