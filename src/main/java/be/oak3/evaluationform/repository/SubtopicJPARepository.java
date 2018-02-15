package be.oak3.evaluationform.repository;

import be.oak3.evaluationform.model.Subtopic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubtopicJPARepository extends JpaRepository<Subtopic, Integer> {

    //@Query(value = "select sub from subtopic sub where sub.id = :topicid")
    List<Subtopic> findSubtopicsByTopicId(int topicId);
}
