package be.oak3.evaluationform.service.impl;

import be.oak3.evaluationform.model.Category;
import be.oak3.evaluationform.model.Question;
import be.oak3.evaluationform.repository.QuestionJPARepository;
import be.oak3.evaluationform.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionJPARepository questionJPARepository;

    @Autowired
    public QuestionServiceImpl(QuestionJPARepository questionJPARepository) {
        this.questionJPARepository = questionJPARepository;
    }

    @Override
    public int addQuestion(Question question) {
        Question q = questionJPARepository.saveAndFlush(question);
        return  q!= null ? 1 : 0;
    }

    @Override
    public int updateQuestion(Question question) {
        Question updatedQuestion = null;
        if(questionJPARepository.exists(question.getId())){
            updatedQuestion = questionJPARepository.saveAndFlush(question);
        }
        return updatedQuestion!= null ? 1:0;
    }


    @Override
    public int deleteQuestion(Question question) {
        if(questionJPARepository.exists(question.getId())){
            questionJPARepository.delete(question);
        }
        return  questionJPARepository.exists(question.getId())? 0 : 1;
    }


    @Override
    public List<Question> findAll() {
        return questionJPARepository.findAll();
    }

    @Query
    public List<Question> findByCategory(Category category){
        return questionJPARepository.findByCategory(category);
    }
}


