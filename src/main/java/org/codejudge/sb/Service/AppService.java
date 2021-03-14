package org.codejudge.sb.Service;


import org.codejudge.sb.Exception.DataNotFoundException;
import org.codejudge.sb.Exception.DatabaseException;
import org.codejudge.sb.Model.Question;
import org.codejudge.sb.Model.QuestionDTO;
import org.codejudge.sb.Model.Quiz;
import org.codejudge.sb.Repository.AppRepo;
import org.codejudge.sb.Repository.QuestionRepo;
import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppService {

    @Autowired
    AppRepo appRepo;

    @Autowired
    QuestionRepo questionRepo;

    public Quiz find(Long id) throws DatabaseException, DataNotFoundException {
        Quiz quiz = appRepo.findOne(id);
        if(quiz==null){
            throw new DatabaseException("Database Error");
        }else if(quiz.getName()==""){
            throw new DataNotFoundException("Data not found");
        }
        return quiz;
    }
    public Quiz save(Quiz quiz) throws DatabaseException, DataNotFoundException {

        appRepo.save(quiz);
        if(quiz==null){
            throw new DatabaseException("Database Error");
        }else if(quiz.getName()==""){
            throw new DataNotFoundException("Data not found");
        }
        return quiz;
    }

    public Question findQuestion(Long question_id) throws DatabaseException, DataNotFoundException {
        Question question = questionRepo.findOne(question_id);

        if(question==null){
            throw new DatabaseException("Database Error");
        }else if(question.getName()==""){
            throw new DataNotFoundException("Data not found");
        }question.getQuiz().setQuestions(null);
        return question;
    }

    public Question saveQuestion(Question question) throws DatabaseException, DataNotFoundException {
        try {
            if(appRepo.findOne(question.getQuiz().getId())==null){
                throw new DataNotFoundException("failure");
            }
            questionRepo.save(question);
        }
        catch(Exception e){
            throw e;
        }
        return question;
    }

    public List<Question> findQuestions(Long quiz_id) throws DataNotFoundException {
        List<Question> questions=null;
//        List<QuestionDTO> questionDTOS = new ArrayList<QuestionDTO>();
        try{
            Quiz quiz = new Quiz();
            quiz.setId(quiz_id);
            questions = questionRepo.findAllByQuiz(quiz);
            for(Question q:questions){
                q.getQuiz().setQuestions(null);
            }
//            for(Question q:questions){
//                QuestionDTO questionDTO = new QuestionDTO();
//                questionDTO.setName(q.getName());
//                questionDTO.setCorrect_option(q.getCorrect_option());
//                questionDTO.setId(q.getId());
//                questionDTO.setPoints(q.getPoints());
//                questionDTO.setOptions(q.getOptions());
//                questionDTO.setQuiz(q.getQuiz().getId());
//                questionDTOS.add(questionDTO);
//
//            }
     }

        catch(Exception e){
            throw e;
        }
        return questions;
    }
}