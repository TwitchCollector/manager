CREATE TABLE channel
(
    user_id           VARCHAR PRIMARY KEY,
    user_login        VARCHAR UNIQUE NOT NULL,
    username          VARCHAR UNIQUE NOT NULL,
    time_of_discovery VARCHAR        NOT NULL
);

CREATE TABLE subscription
(
    id                 UUID PRIMARY KEY,
    type               VARCHAR NOT NULL,
    version            VARCHAR NOT NULL,
    status             VARCHAR NOT NULL,
    cost               INT     NOT NULL,
    transport_method   VARCHAR NOT NULL,
    transport_callback VARCHAR NOT NULL,
    created_at         VARCHAR NOT NULL,
    target_channel     VARCHAR  NOT NULL REFERENCES channel (user_id)
);

CREATE INDEX idx_subscription_target_channel ON subscription (target_channel);

CREATE TABLE subscription_secret
(
    secret          VARCHAR NOT NULL,
    subscription_id UUID    NOT NULL REFERENCES subscription (id)
);

CREATE INDEX idx_subscription_secret_subscription_id ON subscription_secret (subscription_id);
