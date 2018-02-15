package be.oak3.evaluationform.service;


import be.oak3.evaluationform.model.Category;
import be.oak3.evaluationform.model.Question;

import java.util.List;

public interface QuestionService {

    int addQuestion(Question question);

    int updateQuestion(Question question);

    int deleteQuestion(Question question);

    List<Question> findAll();

    List<Question> findByCategory(Category category);
}
