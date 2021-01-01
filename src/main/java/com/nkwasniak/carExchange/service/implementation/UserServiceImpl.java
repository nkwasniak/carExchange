package com.nkwasniak.carExchange.service.implementation;

import com.nkwasniak.carExchange.database.entity.User;
import com.nkwasniak.carExchange.database.repository.UserRepository;
import com.nkwasniak.carExchange.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.nkwasniak.carExchange.service.implementation.UserDetailsServiceImpl.activeUserId;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        User editUser = userRepository.findById(activeUserId).get();
        editUser.setName(user.getName());
        editUser.setUsername(user.getUsername());
        editUser.setPhone(user.getPhone());
        editUser.setEmail(user.getEmail());

        userRepository.save(editUser);
    }

    @Override
    public void deleteByUserId(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User findByUserId(Long UserId) {
        return userRepository.findById(activeUserId).get();
    }
}
