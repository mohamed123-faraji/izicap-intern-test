package com.example.izicapinterntest.model;

public class Question {

    private String question;
    private String reponse;

    public Question() {

    }

    public Question(String reponse, String question) {
        this.reponse = reponse;
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }
}
