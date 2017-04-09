package com.edugame.level;

import java.util.ArrayList;
import java.util.List;

public class Level {
	private String name;
    private String question;
    private int number;
    private List<String> answers;
    private int rightAnswer ;

    public Level() {
        answers = new ArrayList<>();
    }

    public Level(String name, String Question, int RightAnswer) {
        this.name = name;
        this.question = Question;
        this.rightAnswer = RightAnswer;
        answers= new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String Question) {
        this.question = Question;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(String Ans) {
        this.answers.add(Ans);
    }

    public int getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(int RightAnswer) {
        this.rightAnswer = RightAnswer;
    }
}
