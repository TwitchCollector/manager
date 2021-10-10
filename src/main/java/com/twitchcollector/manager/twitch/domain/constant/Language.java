package com.twitchcollector.manager.twitch.domain.constant;

public enum Language {
    NORWEGIAN("no");

    private final String code;

    Language(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
