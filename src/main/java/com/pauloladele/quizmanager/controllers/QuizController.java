package com.pauloladele.quizmanager.controllers;

import com.pauloladele.quizmanager.models.quiz.*;
import com.pauloladele.quizmanager.services.interfaces.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<?> getQuizzes() throws Exception {

        return new ResponseEntity<>(quizService.getAllQuizzes(), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> createQuiz(@RequestBody Quiz quiz) throws Exception {

        quizService.createQuiz(quiz);

        return new ResponseEntity<>(new CreateQuizResponse(true), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteQuiz(@RequestBody DeleteQuizRequest deleteQuizRequest) throws Exception {

        quizService.deleteQuiz(deleteQuizRequest.getQuizId());

        return new ResponseEntity<>(new DeleteQuizResponse(true), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> updateQuiz(@RequestBody Quiz quiz) throws Exception {

        quizService.updateQuiz(quiz);

        return new ResponseEntity<>(new UpdateQuizResponse(true), HttpStatus.ACCEPTED);
    }
}
