package com.nkwasniak.carExchange.database.repository;

import com.nkwasniak.carExchange.database.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
