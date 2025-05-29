package com.example.ppks_kviz_backend.repository;

import com.example.ppks_kviz_backend.model.Participant;
import com.example.ppks_kviz_backend.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

    List<Participant> findByQuiz(Quiz quiz);
}