package be.oak3.evaluationform.service.impl;


import be.oak3.evaluationform.model.Evaluation;
import be.oak3.evaluationform.repository.EvaluationJPARepository;
import be.oak3.evaluationform.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationServiceImpl implements EvaluationService {

    private final EvaluationJPARepository evaluationJPARepository;

    @Autowired
    public EvaluationServiceImpl(EvaluationJPARepository evaluationJPARepository) {
        this.evaluationJPARepository = evaluationJPARepository;
    }

    @Override
    public int addEvaluation(Evaluation evaluation) {
        Evaluation newEvaluation = evaluationJPARepository.saveAndFlush(evaluation);
        return newEvaluation == null ? 0 : 1;
    }

    @Override
    public int updateEvaluation(Evaluation evaluation) {
        Evaluation updateEvaluation = null;
        if (evaluationJPARepository.exists(evaluation.getId())) {
            updateEvaluation = evaluationJPARepository.saveAndFlush(evaluation);
        }
        return updateEvaluation == null ? 0 : 1;
    }

    @Override
    public int deleteEvaluation(Evaluation evaluation) {
        if (evaluationJPARepository.exists(evaluation.getId())) {
            evaluationJPARepository.delete(evaluation.getId());
        }
        return evaluationJPARepository.exists(evaluation.getId()) ? 0 : 1;
    }

    @Override
    public List<Evaluation> findAll() {
        return evaluationJPARepository.findAll();
    }

    @Override
    public Evaluation findOne(int id) {
        return evaluationJPARepository.findOne(id);
    }

    @Override
    public Evaluation findDistinctFirstByOrderByDateDesc() {
        return evaluationJPARepository.findDistinctFirstByOrderByDateDesc();
    }
}
