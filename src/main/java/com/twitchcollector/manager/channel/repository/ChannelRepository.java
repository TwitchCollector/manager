package com.twitchcollector.manager.channel.repository;

import com.twitchcollector.manager.channel.domain.Channel;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Optional;

@Repository
public class ChannelRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ChannelRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveChannel(Channel channel) {
        jdbcTemplate.update("INSERT INTO channel (user_id, user_login, username, time_of_discovery) VALUES (:user_id, :user_login, :username, :time_of_discovery)",
                new MapSqlParameterSource()
                        .addValue("user_id", channel.getUserId())
                        .addValue("user_login", channel.getUserLogin())
                        .addValue("username", channel.getUsername())
                        .addValue("time_of_discovery", channel.getTimeOfDiscovery().toString()));
    }

    public Optional<Channel> getChannel(String userId) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(
                    "SELECT user_id, user_login, username, time_of_discovery FROM channel WHERE user_id = :user_id",
                    new MapSqlParameterSource("user_id", userId),
                    (resultSet, rowNum) -> new Channel(resultSet.getString("user_id"), resultSet.getString("user_login"), resultSet.getString("username"), Instant.parse(resultSet.getString("time_of_discovery")))));
        } catch (IncorrectResultSizeDataAccessException ex) {
            return Optional.empty();
        }
    }

    public void updateUserLogin(String userLogin, String userId) {
        jdbcTemplate.update("UPDATE channel SET user_login = :user_login WHERE user_id = :user_id", new MapSqlParameterSource().addValue("user_login", userLogin).addValue("user_id", userId));
    }

    public void updateUsername(String username, String userId) {
        jdbcTemplate.update("UPDATE channel SET username = :username WHERE user_id = :user_id", new MapSqlParameterSource().addValue("username", username).addValue("user_id", userId));
    }
}
