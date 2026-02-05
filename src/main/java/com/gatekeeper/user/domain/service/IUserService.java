package com.gatekeeper.user.domain.service;

import com.gatekeeper.user.domain.model.User;

public interface IUserService {
    User createNewUser(User user);
}
