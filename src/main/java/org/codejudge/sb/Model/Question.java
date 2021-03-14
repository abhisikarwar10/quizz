package org.codejudge.sb.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="question")
@Transactional
public class Question implements Serializable {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @javax.persistence.Id
    @GeneratedValue
    @Column(name="question_id")
    private Long id;

    String name;

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    @ManyToOne(targetEntity = Quiz.class)
    @JoinColumn(name="quiz_id", referencedColumnName = "quiz_id")

    private Quiz quiz;


    @JsonProperty("quiz")
    private void unpackNested(Long quiz_id) {
        this.quiz = new Quiz();
        quiz.setId(quiz_id);
    }

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

//     Long quiz;

    Integer  points;

}
