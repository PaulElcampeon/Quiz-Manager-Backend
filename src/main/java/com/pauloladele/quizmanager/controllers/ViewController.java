package com.pauloladele.quizmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {

    @RequestMapping(value = {"/", "/home", "/quizzes", "/login","/create"}, method = RequestMethod.GET)
    public String homePage(){
        return "index.html";
    }

}
