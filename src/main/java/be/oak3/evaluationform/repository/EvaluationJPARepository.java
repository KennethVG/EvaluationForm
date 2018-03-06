package be.oak3.evaluationform.repository;

import be.oak3.evaluationform.model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationJPARepository extends JpaRepository<Evaluation, Integer> {

    Evaluation findDistinctFirstByOrderByDateDesc();
}
