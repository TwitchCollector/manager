package com.twitchcollector.manager.subscription;

import com.twitchcollector.manager.subscription.domain.Subscription;
import com.twitchcollector.manager.subscription.repository.SubscriptionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SubscriptionService {

    private static final Logger logger = LoggerFactory.getLogger(SubscriptionService.class);

    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public void saveSubscription(Subscription subscription) {
        logger.debug("Saving subscription with id: {}", subscription.getId());
        subscriptionRepository.saveSubscription(subscription);
        logger.info("Saved subscription with id: {}", subscription.getId());
    }

    public void saveSecret(String secret, UUID subscriptionId) {
        subscriptionRepository.saveSecret(secret, subscriptionId);
    }
}
