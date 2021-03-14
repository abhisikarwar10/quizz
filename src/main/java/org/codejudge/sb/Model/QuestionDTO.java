package org.codejudge.sb.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import javax.persistence.*;
import java.io.Serializable;

public class QuestionDTO implements Serializable{
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    private Long id;

    String name;







//    public String getQuiz() {
//        return quiz;
//    }
//
//    public void setQuiz(String quiz) {
//        this.quiz = quiz;
//    }
//
//    private String quiz;



    @Override
    public String toString() {
        return "Question{" +
                "name='" + name + '\'' +
                ", options='" + options + '\'' +
                ", correct_option='" + correct_option + '\'' +
//                ", quiz='" + quiz + '\'' +
                ", points='" + points + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public Integer getCorrect_option() {
        return correct_option;
    }

    public void setCorrect_option(Integer correct_option) {
        this.correct_option = correct_option;
    }

//    public Long getQuiz() {
//        return quiz;
//    }
//
//    public void setQuiz(Long quiz) {
//        this.quiz = quiz;
//    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    String  options;
    Integer  correct_option;

    public Long getQuiz() {
        return quiz;
    }

    public void setQuiz(Long quiz) {
        this.quiz = quiz;
    }

    Long quiz;

    Integer  points;

}
