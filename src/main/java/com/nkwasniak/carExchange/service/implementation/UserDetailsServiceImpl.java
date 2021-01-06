package com.nkwasniak.carExchange.service.implementation;

import com.nkwasniak.carExchange.database.entity.User;
import com.nkwasniak.carExchange.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    public static Long activeUserId;
    public static Map<Long, UserDetails> users = new HashMap<>();

    @Autowired
    private UserRepository userRepository;

    // LOAD ACTIVE USER
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User userInfo = userRepository.findByUsername(userName);
        GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getRole());
        org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(userInfo.getUsername(), userInfo.getPassword(), Arrays.asList(authority));
        activeUserId = userInfo.getId();
        UserDetails userDetails = user;
        users.put(userInfo.getId(), user);
        return userDetails;
    }

    // CREATE NEW USER
    public void createUser(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User newUser = User.builder()
                .withName(user.getName())
                .withUsername(user.getUsername())
                .withPassword(encoder.encode(user.getPassword()))
                .withForRentList(user.getForRentList())
                .withPhone(user.getPhone())
                .withEmail(user.getEmail())
                .withRole("USER")
                .build();

        userRepository.save(newUser);
    }
}
