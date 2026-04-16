package com.pik.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.pik.database.entities.User;
import com.pik.database.repository.UserRepository;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsService(UserRepository repository) {
        userRepository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("username not found " + username));

        List<SimpleGrantedAuthority> autorities = new ArrayList<>();

        autorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));

        if (user.getCanBlog()) {
            autorities.add(new SimpleGrantedAuthority("CAN_BLOG"));
        }

        return org.springframework.security.core.userdetails.User.builder().username(user.getUsername())
                .password(user.getPasswordHash()).authorities(autorities).build();
    }
}
