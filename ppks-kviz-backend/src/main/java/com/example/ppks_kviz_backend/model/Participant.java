package com.example.ppks_kviz_backend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long participantId;

    private String name;
    private int score = 0;

    @ManyToOne
    @JoinColumn(name = "quizId")
    private Quiz quiz;

    @OneToMany(mappedBy = "participant", cascade = CascadeType.ALL)
    private List<Answer> answers;

    public Participant() {
    }

    public Participant(Long participantId, String name, int score, Quiz quiz, List<Answer> answers) {
        this.participantId = participantId;
        this.name = name;
        this.score = score;
        this.quiz = quiz;
        this.answers = answers;
    }

    public Long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Long participantId) {
        this.participantId = participantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}