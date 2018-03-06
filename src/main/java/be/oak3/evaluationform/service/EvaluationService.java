package be.oak3.evaluationform.service;


import be.oak3.evaluationform.model.Evaluation;

import java.util.List;

public interface EvaluationService {

    int addEvaluation(Evaluation evaluation);
    int updateEvaluation(Evaluation evaluation);
    int deleteEvaluation(Evaluation evaluation);

    List<Evaluation> findAll();

    Evaluation findOne(int id);

    Evaluation findDistinctFirstByOrderByDateDesc();
}
