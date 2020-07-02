package com.pauloladele.quizmanager.controllers;

import com.pauloladele.quizmanager.models.AuthenticationRequest;
import com.pauloladele.quizmanager.models.AuthenticationResponse;
import com.pauloladele.quizmanager.models.TokenAuthenticationRequest;
import com.pauloladele.quizmanager.models.TokenAuthenticationResponse;
import com.pauloladele.quizmanager.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> authenticateUser(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        AuthenticationResponse resp = userService.authenticateUser(authenticationRequest);

        return new ResponseEntity<>(resp, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/token/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> authenticateToken(@RequestBody TokenAuthenticationRequest authenticationRequest, Principal principal) throws Exception {

        return new ResponseEntity<>(new TokenAuthenticationResponse(true), HttpStatus.ACCEPTED);
    }
}
