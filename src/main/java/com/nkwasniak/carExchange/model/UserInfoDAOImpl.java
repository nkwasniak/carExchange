package com.nkwasniak.carExchange.model;

import com.nkwasniak.carExchange.database.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserInfoDAOImpl implements UserInfoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public User getActiveUser(String username) {
        User user = new User();
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username ");
        query.setParameter("username", username);
        List<User> results = query.getResultList();
        if (!results.isEmpty()) {
            user = (User) results.get(0);
        }
        return user;
    }
}
