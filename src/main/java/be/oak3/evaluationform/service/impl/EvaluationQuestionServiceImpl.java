package be.oak3.evaluationform.service.impl;

import be.oak3.evaluationform.model.EvaluationQuestion;
import be.oak3.evaluationform.repository.EvaluationQuestionJPARepository;
import be.oak3.evaluationform.service.EvaluationQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationQuestionServiceImpl implements EvaluationQuestionService {

    private final EvaluationQuestionJPARepository evaluationQuestionJPARepository;

    @Autowired
    public EvaluationQuestionServiceImpl(EvaluationQuestionJPARepository evaluationQuestionJPARepository) {
        this.evaluationQuestionJPARepository = evaluationQuestionJPARepository;
    }

    @Override
    public int addEvaluationQuestion(EvaluationQuestion evaluationQuestion) {
        EvaluationQuestion eq = evaluationQuestionJPARepository.saveAndFlush(evaluationQuestion);
        return eq != null ? 1 : 0;
    }

    @Override
    public int updateEvaluationQuestion(EvaluationQuestion evaluationQuestion) {
        EvaluationQuestion updatedQuestion = null;
        if (evaluationQuestionJPARepository.exists(evaluationQuestion.getId())) {
            updatedQuestion = evaluationQuestionJPARepository.saveAndFlush(evaluationQuestion);
        }
        return updatedQuestion != null ? 1 : 0;
    }

    @Override
    public int deleteEvaluationQuestion(EvaluationQuestion evaluationQuestion) {
        if (evaluationQuestionJPARepository.exists(evaluationQuestion.getId())) {
            evaluationQuestionJPARepository.delete(evaluationQuestion);
        }
        return evaluationQuestionJPARepository.exists(evaluationQuestion.getId()) ? 0 : 1;
    }

    @Override
    public List<EvaluationQuestion> findAll() {
        return evaluationQuestionJPARepository.findAll();
    }


    @Override
    public EvaluationQuestion findOne(int id) {
        return evaluationQuestionJPARepository.findOne(id);
    }
}
