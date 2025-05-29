package com.example.ppks_kviz_backend.model;

import java.time.LocalDateTime;

public class AnswerDTO {

    private long participantId;
    private int quizPin;
    private int questionIndex;
    private String selectedOption;
    private Long questionId;
    private LocalDateTime submittedAt;

    public long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(long participantId) {
        this.participantId = participantId;
    }

    public int getQuizPin() {
        return quizPin;
    }

    public void setQuizPin(int quizPin) {
        this.quizPin = quizPin;
    }

    public int getQuestionIndex() {
        return questionIndex;
    }

    public void setQuestionIndex(int questionIndex) {
        this.questionIndex = questionIndex;
    }

    public String getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }
}
