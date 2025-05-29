package com.example.ppks_kviz_backend.repository;

import com.example.ppks_kviz_backend.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QuizRepository extends JpaRepository<Quiz, Long> {
    Quiz findByPin(int pin);
    boolean existsByPin(int pin);
}
