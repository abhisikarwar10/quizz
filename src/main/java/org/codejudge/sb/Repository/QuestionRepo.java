package org.codejudge.sb.Repository;

import org.codejudge.sb.Model.Question;
import org.codejudge.sb.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo  extends JpaRepository<Question,Long> {

    List<Question> findAllByQuiz(Quiz quiz_id);
}

