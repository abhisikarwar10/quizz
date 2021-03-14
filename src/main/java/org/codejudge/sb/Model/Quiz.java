package org.codejudge.sb.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="quiz")
@Transactional
public class Quiz implements Serializable {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    @javax.persistence.Id
    @GeneratedValue
    @Column(name="quiz_id")
    private Long id;
    private String name;

    private String description;

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.PERSIST)
    private List<Question> questions = new ArrayList<Question>();;


    @Override
    public String toString() {
        return "Quiz{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +

                '}';
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
