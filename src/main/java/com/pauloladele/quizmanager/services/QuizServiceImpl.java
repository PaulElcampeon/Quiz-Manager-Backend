package com.pauloladele.quizmanager.services;

import com.pauloladele.quizmanager.models.quiz.Quiz;
import com.pauloladele.quizmanager.repositories.QuizRepository;
import com.pauloladele.quizmanager.services.interfaces.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository repository;

    @Override
    public Quiz getQuiz(String quizId) {
        return repository.findById(quizId).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Quiz> getAllQuizzes() {
        return repository.findAll();
    }

    @Override
    public void deleteQuiz(String quizId) {
        repository.deleteById(quizId);
    }

    @Override
    public void updateQuiz(Quiz quiz) {
        repository.save(quiz);
    }

    @Override
    public void createQuiz(Quiz quiz) {
        repository.save(quiz);
    }
}
