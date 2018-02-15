package be.oak3.evaluationform.service;

import be.oak3.evaluationform.model.Instructor;

import java.util.List;

public interface InstructorService {

    int addInstructor(Instructor instructor);

    int deleteInstructor(Instructor instructor);

    int updateInstructor(Instructor instructor);

    List<Instructor> findAll();

    Instructor findOne(int id);
}
