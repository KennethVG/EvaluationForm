package be.oak3.evaluationform.service;


import be.oak3.evaluationform.model.EvaluationQuestion;

import java.util.List;

public interface EvaluationQuestionService {


    int addEvaluationQuestion(EvaluationQuestion evaluationQuestion);
    int updateEvaluationQuestion(EvaluationQuestion evaluationQuestion);
    int deleteEvaluationQuestion(EvaluationQuestion evaluationQuestion);

    List<EvaluationQuestion> findAll();

    EvaluationQuestion findOne(int id);
}
