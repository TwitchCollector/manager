package com.twitchcollector.manager.twitch.domain;

public class Pagination {

    private final String cursor;

    public Pagination(String cursor) {
        this.cursor = cursor;
    }

    public String getCursor() {
        return cursor;
    }
}
