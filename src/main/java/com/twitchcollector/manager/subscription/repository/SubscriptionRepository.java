package com.twitchcollector.manager.subscription.repository;

import com.twitchcollector.manager.subscription.domain.Subscription;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class SubscriptionRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public SubscriptionRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveSubscription(Subscription subscription) {
        jdbcTemplate.update("INSERT INTO subscription (id, type, version, status, cost, transport_method, transport_callback, created_at, target_channel) " +
                        "VALUES (:id, :type, :version, :status, :cost, :transport_method, :transport_callback, :created_at, :target_channel)",
                new MapSqlParameterSource()
                        .addValue("id", subscription.getId())
                        .addValue("type", subscription.getType())
                        .addValue("version", subscription.getVersion())
                        .addValue("status", subscription.getStatus())
                        .addValue("cost", subscription.getCost())
                        .addValue("transport_method", subscription.getTransportMethod())
                        .addValue("transport_callback", subscription.getTransportCallback())
                        .addValue("created_at", subscription.getCreatedAt().toString())
                        .addValue("target_channel", subscription.getTargetChannel()));
    }

    public void saveSecret(String secret, UUID subscriptionId) {
        jdbcTemplate.update("INSERT INTO subscription_secret (secret, subscription_id) VALUES (:secret, :subscription_id)",
                new MapSqlParameterSource().addValue("secret", secret).addValue("subscription_id", subscriptionId));
    }
}
