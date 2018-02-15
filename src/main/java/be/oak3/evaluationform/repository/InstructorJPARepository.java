package be.oak3.evaluationform.repository;

import be.oak3.evaluationform.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorJPARepository extends JpaRepository<Instructor,Integer> {


}
