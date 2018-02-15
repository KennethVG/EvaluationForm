package be.oak3.evaluationform.repository;

import be.oak3.evaluationform.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicJPARepository extends JpaRepository<Topic, Integer> {
}
