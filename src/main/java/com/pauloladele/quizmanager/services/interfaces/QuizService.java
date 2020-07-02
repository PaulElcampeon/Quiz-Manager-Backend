package com.pauloladele.quizmanager.services.interfaces;

import com.pauloladele.quizmanager.models.quiz.Quiz;

import java.util.List;

public interface QuizService {

    Quiz getQuiz(String quizId);

    List<Quiz> getAllQuizzes();

    void deleteQuiz(String quizId);

    void updateQuiz(Quiz quiz);

    void createQuiz(Quiz quiz);
}
