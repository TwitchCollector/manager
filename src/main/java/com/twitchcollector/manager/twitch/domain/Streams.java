package com.twitchcollector.manager.twitch.domain;

import java.util.List;

public class Streams {

    private final List<Stream> data;
    private final Pagination pagination;

    public Streams(List<Stream> data, Pagination pagination) {
        this.data = data;
        this.pagination = pagination;
    }

    public List<Stream> getData() {
        return data;
    }

    public Pagination getPagination() {
        return pagination;
    }
}
