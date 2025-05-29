package com.example.ppks_kviz_backend.model;

public class QuizStartedMessage {

    private int pin;

    public QuizStartedMessage() {}

    public QuizStartedMessage(int pin) {
        this.pin = pin;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
