package com.twitchcollector.manager.twitch.client.resource;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class StreamsResource {

    private final List<StreamResource> data;
    private final PaginationResource pagination;

    public StreamsResource(@JsonProperty("data") List<StreamResource> data, @JsonProperty("pagination") PaginationResource pagination) {
        this.data = data;
        this.pagination = pagination;
    }

    public List<StreamResource> getData() {
        return data;
    }

    public PaginationResource getPagination() {
        return pagination;
    }
}
