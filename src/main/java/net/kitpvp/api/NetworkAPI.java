package net.kitpvp.api;

import net.kitpvp.api.user.User;
import net.kitpvp.api.user.UserFactory;

import java.util.UUID;

public interface NetworkAPI {

    UserFactory<? extends User> getUserFactory();

    default User getUser(UUID playerId) {
        return getUserFactory().getUser(playerId);
    }
}
