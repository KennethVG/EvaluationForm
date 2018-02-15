package be.oak3.evaluationform.repository;

import be.oak3.evaluationform.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseJPARepository extends JpaRepository<Course,Integer> {


}
