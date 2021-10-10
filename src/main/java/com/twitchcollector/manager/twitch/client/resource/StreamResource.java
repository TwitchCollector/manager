package com.twitchcollector.manager.twitch.client.resource;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class StreamResource {

    private final String id;
    private final String userId;
    private final String userLogin;
    private final String username;
    private final String gameId;
    private final String gameName;
    private final String type;
    private final String title;
    private final Integer viewerCount;
    private final String startedAt;
    private final String language;
    private final String thumbnailUrl;
    private final List<String> tagIds;
    private final Boolean isMature;

    public StreamResource(@JsonProperty("id") String id,
                          @JsonProperty("user_id") String userId,
                          @JsonProperty("user_login") String userLogin,
                          @JsonProperty("user_name") String username,
                          @JsonProperty("game_id") String gameId,
                          @JsonProperty("game_name") String gameName,
                          @JsonProperty("type") String type,
                          @JsonProperty("title") String title,
                          @JsonProperty("viewer_count") Integer viewerCount,
                          @JsonProperty("started_at") String startedAt,
                          @JsonProperty("language") String language,
                          @JsonProperty("thumbnail_url") String thumbnailUrl,
                          @JsonProperty("tag_ids") List<String> tagIds,
                          @JsonProperty("is_mature") Boolean isMature) {
        this.id = id;
        this.userId = userId;
        this.userLogin = userLogin;
        this.username = username;
        this.gameId = gameId;
        this.gameName = gameName;
        this.type = type;
        this.title = title;
        this.viewerCount = viewerCount;
        this.startedAt = startedAt;
        this.language = language;
        this.thumbnailUrl = thumbnailUrl;
        this.tagIds = tagIds;
        this.isMature = isMature;
    }

    @JsonGetter("id")
    public String getId() {
        return id;
    }

    @JsonGetter("userId")
    public String getUserId() {
        return userId;
    }

    @JsonGetter("userLogin")
    public String getUserLogin() {
        return userLogin;
    }

    @JsonGetter("username")
    public String getUsername() {
        return username;
    }

    @JsonGetter("gameId")
    public String getGameId() {
        return gameId;
    }

    @JsonGetter("gameName")
    public String getGameName() {
        return gameName;
    }

    @JsonGetter("type")
    public String getType() {
        return type;
    }

    @JsonGetter("title")
    public String getTitle() {
        return title;
    }

    @JsonGetter("viewerCount")
    public Integer getViewerCount() {
        return viewerCount;
    }

    @JsonGetter("startedAt")
    public String getStartedAt() {
        return startedAt;
    }

    @JsonGetter("language")
    public String getLanguage() {
        return language;
    }

    @JsonGetter("thumbnailUrl")
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    @JsonGetter("tagIds")
    public List<String> getTagIds() {
        return tagIds;
    }

    @JsonGetter("isMature")
    public Boolean getIsMature() {
        return isMature;
    }
}
