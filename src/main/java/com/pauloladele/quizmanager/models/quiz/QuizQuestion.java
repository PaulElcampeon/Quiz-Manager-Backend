package com.pauloladele.quizmanager.models.quiz;

import lombok.Data;

import java.util.List;

@Data
public class QuizQuestion {

    private String question;
    private List<QuizAnswer> answers;

}
