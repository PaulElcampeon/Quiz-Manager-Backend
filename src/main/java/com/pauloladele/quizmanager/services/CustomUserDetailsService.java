package com.pauloladele.quizmanager.services;

import com.pauloladele.quizmanager.models.CustomUserDetails;
import com.pauloladele.quizmanager.models.User;
import com.pauloladele.quizmanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findById(username).orElseThrow(NoSuchElementException::new);
        return new CustomUserDetails(user);
    }
}
