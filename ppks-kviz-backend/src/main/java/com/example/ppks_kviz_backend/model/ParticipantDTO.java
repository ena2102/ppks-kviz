package com.example.ppks_kviz_backend.model;

public class ParticipantDTO {

    private Long id;
    private String name;
    private int quizPin;
    private int score;

    public ParticipantDTO(Long id, String name, int quizPin, int score) {
        this.id = id;
        this.name = name;
        this.quizPin = quizPin;
        this.score = score;
    }

    public ParticipantDTO(Long id, String name, int quizPin) {
        this.id = id;
        this.name = name;
        this.quizPin = quizPin;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuizPin() {
        return quizPin;
    }

    public int getScore() {
        return score;
    }

}