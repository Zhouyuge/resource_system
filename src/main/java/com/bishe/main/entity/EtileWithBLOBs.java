package com.bishe.main.entity;

public class EtileWithBLOBs extends Etile {
    private String etitleQuestion;

    private String etitleAnswer;

    public String getEtitleQuestion() {
        return etitleQuestion;
    }

    public void setEtitleQuestion(String etitleQuestion) {
        this.etitleQuestion = etitleQuestion == null ? null : etitleQuestion.trim();
    }

    public String getEtitleAnswer() {
        return etitleAnswer;
    }

    public void setEtitleAnswer(String etitleAnswer) {
        this.etitleAnswer = etitleAnswer == null ? null : etitleAnswer.trim();
    }
}