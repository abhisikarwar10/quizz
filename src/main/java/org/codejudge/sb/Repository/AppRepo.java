package org.codejudge.sb.Repository;

import org.codejudge.sb.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRepo extends JpaRepository<Quiz,Long> {
}
