package com.pauloladele.quizmanager;

import com.pauloladele.quizmanager.models.CreateUserRequest;
import com.pauloladele.quizmanager.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class QuizmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizmanagerApplication.class, args);
	}
//
//	@Autowired
//	private UserService userService;
//
//	@PostConstruct
//	public void init() throws Exception {
//		userService.removeUser("Restricted");
//		userService.removeUser("View");
//		userService.removeUser("Edit");
//
//		userService.createUserLvEdit(new CreateUserRequest("Edit", "Edit", "Edit", "Edit"));
//		userService.createUserLvView(new CreateUserRequest("View", "View", "View", "View"));
//		userService.createUserLvRestricted(new CreateUserRequest("Restricted", "Restricted", "Restricted", "Restricted"));
//	}
}
