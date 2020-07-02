package com.pauloladele.quizmanager.services;

import com.pauloladele.quizmanager.models.AuthenticationRequest;
import com.pauloladele.quizmanager.models.AuthenticationResponse;
import com.pauloladele.quizmanager.models.CreateUserRequest;
import com.pauloladele.quizmanager.models.User;
import com.pauloladele.quizmanager.repositories.UserRepository;
import com.pauloladele.quizmanager.services.interfaces.UserService;
import com.pauloladele.quizmanager.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean createUserLvRestricted(CreateUserRequest createUserRequest) throws Exception {
        repository.insert(new User(createUserRequest.getUsername(), passwordEncoder.encode(createUserRequest.getPassword()), "RESTRICTED"));

        return true;
    }

    @Override
    public boolean createUserLvView(CreateUserRequest createUserRequest) throws Exception {
        repository.insert(new User(createUserRequest.getUsername(), passwordEncoder.encode(createUserRequest.getPassword()), "VIEW"));

        return true;
    }

    @Override
    public boolean createUserLvEdit(CreateUserRequest createUserRequest) throws Exception {
        repository.insert(new User(createUserRequest.getUsername(), passwordEncoder.encode(createUserRequest.getPassword()), "EDIT"));

        return true;
    }

    @Override
    public AuthenticationResponse authenticateUser(AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        User user = repository.findById(authenticationRequest.getUsername()).get();

        int levelOfRestriction = 0;

        if (user.getRoles().contains("RESTRICTED")) levelOfRestriction = 1;
        if (user.getRoles().contains("VIEW")) levelOfRestriction = 2;
        if (user.getRoles().contains("EDIT")) levelOfRestriction = 3;

        final String jwt = jwtUtil.generateToken(userDetails);

        return new AuthenticationResponse(jwt, levelOfRestriction);
    }

    @Override
    public boolean checkIfUsernameExists(String username) {
        return repository.existsById(username);
    }

    @Override
    public void removeUser(String userId) {
        repository.deleteById(userId);
    }
}
