package com.example.ppks_kviz_backend.model;

public class ParticipantJoinRequest {
    private String name;
    private int sessionPin;

    public String getName() {
        return name;
    }

    public int getSessionPin() {
        return sessionPin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSessionPin(int sessionPin) {
        this.sessionPin = sessionPin;
    }
}
