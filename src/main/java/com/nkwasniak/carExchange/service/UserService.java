package com.nkwasniak.carExchange.service;

import com.nkwasniak.carExchange.database.entity.User;

public interface UserService {
    void saveUser(User user);
    void deleteByUserId(Long userId);
    User findByUserId(Long UserId);
}
