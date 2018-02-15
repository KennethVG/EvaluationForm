package be.oak3.evaluationform.repository;


import be.oak3.evaluationform.model.Category;
import be.oak3.evaluationform.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionJPARepository extends JpaRepository<Question,Integer> {

    List<Question> findByCategory(Category category);
}
