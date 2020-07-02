package com.pauloladele.quizmanager.services.interfaces;

import com.pauloladele.quizmanager.models.AuthenticationRequest;
import com.pauloladele.quizmanager.models.AuthenticationResponse;
import com.pauloladele.quizmanager.models.CreateUserRequest;

public interface UserService {

    boolean createUserLvRestricted(CreateUserRequest createUserRequest) throws Exception;

    boolean createUserLvView(CreateUserRequest createUserRequest) throws Exception;

    boolean createUserLvEdit(CreateUserRequest createUserRequest) throws Exception;

    AuthenticationResponse authenticateUser(AuthenticationRequest loginMessage) throws Exception;

    boolean checkIfUsernameExists(String username);

    void removeUser(String useId);

}
