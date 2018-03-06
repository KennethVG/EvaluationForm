package be.oak3.evaluationform.service;

import be.oak3.evaluationform.model.Student;

import java.util.List;

public interface StudentService {

    int addStudent(Student student);

    int deleteStudent(Student student);

    int updateStudent(Student student);

    List<Student> findAll();

    Student findOne(int id);

    Student findDistinctFirstByOrderByIdDesc();

}
