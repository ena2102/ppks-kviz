package com.example.ppks_kviz_backend.repository;

import com.example.ppks_kviz_backend.model.Question;
import com.example.ppks_kviz_backend.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    Question findByQuestionId(long id);

    List<Question> findByQuiz(Quiz quiz);

}