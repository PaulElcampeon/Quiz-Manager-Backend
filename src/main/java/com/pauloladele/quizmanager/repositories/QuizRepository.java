package com.pauloladele.quizmanager.repositories;

import com.pauloladele.quizmanager.models.quiz.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends MongoRepository<Quiz, String> {
}
