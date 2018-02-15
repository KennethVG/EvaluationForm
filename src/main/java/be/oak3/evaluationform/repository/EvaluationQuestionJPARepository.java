package be.oak3.evaluationform.repository;


import be.oak3.evaluationform.model.EvaluationQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationQuestionJPARepository extends JpaRepository<EvaluationQuestion,Integer> {
}
