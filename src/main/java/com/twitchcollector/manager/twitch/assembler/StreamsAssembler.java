package com.twitchcollector.manager.twitch.assembler;

import com.twitchcollector.manager.twitch.client.resource.PaginationResource;
import com.twitchcollector.manager.twitch.client.resource.StreamResource;
import com.twitchcollector.manager.twitch.client.resource.StreamsResource;
import com.twitchcollector.manager.twitch.domain.Pagination;
import com.twitchcollector.manager.twitch.domain.Stream;
import com.twitchcollector.manager.twitch.domain.Streams;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
public class StreamsAssembler {

    public Streams assemble(StreamsResource streamsResource) {
        return new Streams(assemble(streamsResource.getData()), assemble(streamsResource.getPagination()));
    }

    public List<Stream> assemble(List<StreamResource> streamResourceList) {
        return streamResourceList.stream().map(this::assemble).toList();
    }

    public Stream assemble(StreamResource streamResource) {
        return new Stream(
                streamResource.getId(),
                streamResource.getUserId(),
                streamResource.getUserLogin(),
                streamResource.getUsername(),
                streamResource.getGameId(),
                streamResource.getGameName(),
                streamResource.getType(),
                streamResource.getTitle(),
                streamResource.getViewerCount(),
                Instant.parse(streamResource.getStartedAt()),
                streamResource.getLanguage(),
                streamResource.getThumbnailUrl(),
                streamResource.getTagIds(),
                streamResource.getIsMature());
    }

    private Pagination assemble(PaginationResource paginationResource) {
        return new Pagination(paginationResource.getCursor());
    }
}
