package be.oak3.evaluationform.repository;

import be.oak3.evaluationform.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentJPARepository extends JpaRepository<Student,Integer> {


    Student findDistinctFirstByOrderByIdDesc();

}
