package org.codejudge.sb.controller;

import io.swagger.annotations.ApiOperation;
import org.codejudge.sb.Exception.DataNotFoundException;
import org.codejudge.sb.Exception.DatabaseException;
import org.codejudge.sb.Model.Error;
import org.codejudge.sb.Model.Question;
import org.codejudge.sb.Model.QuestionDTO;
import org.codejudge.sb.Model.Quiz;
import org.codejudge.sb.Service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class AppController {

    @Autowired
    AppService appService;

    @ApiOperation("This is the hello world api")
    @GetMapping("/api/quiz/{quiz_id}")
    public ResponseEntity<?> find(@PathVariable Long quiz_id) throws DatabaseException {
        Quiz quiz=null;
        try{
            quiz = appService.find(quiz_id);}
        catch(DatabaseException e){
            return new ResponseEntity("",HttpStatus.NOT_FOUND );

        }catch(DataNotFoundException e){

            Error error = new Error();
            error.setStatus("failure");
            error.setReason(e.getMessage());
            return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Quiz>(quiz, HttpStatus.OK);
    }

    @PostMapping("/api/quiz")
    public ResponseEntity<?> save(@RequestBody Quiz quiz) throws DatabaseException {
        Quiz retQuiz=null;
        try{
        if(quiz.getName() == null|| quiz.getDescription()== null){
            throw new DataNotFoundException("failure");
        }

            retQuiz = appService.save(quiz);}
           catch(DataNotFoundException e){

            Error error = new Error();
            error.setStatus("failure");
            error.setReason(e.getMessage());
            return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Quiz>(retQuiz, HttpStatus.CREATED);
    }



    @ApiOperation("This is the hello world api")
    @GetMapping("/api/questions/{question_id}")
    public ResponseEntity<?> findQuestion(@PathVariable Long question_id) throws DatabaseException {
        Question question=null;
        try{
            question = appService.findQuestion(question_id);}
        catch(DatabaseException e){
            return new ResponseEntity("",HttpStatus.NOT_FOUND );

        }catch(DataNotFoundException e){

            Error error = new Error();
            error.setStatus("failure");
            error.setReason(e.getMessage());
            return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Question>(question, HttpStatus.OK);
    }


    @PostMapping("/api/questions")
    public ResponseEntity<?> saveQuestion(@RequestBody Question question) throws DatabaseException {
        Question retQuestion=null;
        try{
            if(question.getName() == null||question.getOptions()==null|| question.getCorrect_option()== null|| question.getQuiz()== null|| question.getPoints()== null){
                throw new DataNotFoundException("failure");
            }

            retQuestion = appService.saveQuestion(question);}
            catch(DataNotFoundException e){

            Error error = new Error();
            error.setStatus("failure");
            error.setReason(e.getMessage());
            return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Question>(retQuestion, HttpStatus.CREATED);
    }

    @ApiOperation("This is the hello world api")
    @GetMapping("/api/quiz-questions/{quiz_id}")
    public ResponseEntity<?> findQuestions(@PathVariable Long quiz_id) throws DatabaseException {
        List<Question> questions=null;
        try{
            questions = appService.findQuestions(quiz_id);


        }
        catch(Exception e){

            return new ResponseEntity("",HttpStatus.NOT_FOUND );
        }
        return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
    }

}
