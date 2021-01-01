package com.nkwasniak.carExchange.model;

import com.nkwasniak.carExchange.database.entity.User;

public interface UserInfoDAO {
    User getActiveUser(String userName);
}
