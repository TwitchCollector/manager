package com.twitchcollector.manager.twitch.domain;

import java.time.Instant;
import java.util.List;

public class Stream {

    private final String id;
    private final String userId;
    private final String userLogin;
    private final String username;
    private final String gameId;
    private final String gameName;
    private final String type;
    private final String title;
    private final Integer viewerCount;
    private final Instant startedAt;
    private final String language;
    private final String thumbnailUrl;
    private final List<String> tagIds;
    private final boolean mature;

    public Stream(String id, String userId, String userLogin, String username, String gameId, String gameName, String type, String title, Integer viewerCount, Instant startedAt, String language, String thumbnailUrl, List<String> tagIds, boolean mature) {
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
        this.mature = mature;
    }

    public String getId() {
        return id;
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

    public String getGameId() {
        return gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public Integer getViewerCount() {
        return viewerCount;
    }

    public Instant getStartedAt() {
        return startedAt;
    }

    public String getLanguage() {
        return language;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public List<String> getTagIds() {
        return tagIds;
    }

    public boolean isMature() {
        return mature;
    }
}
