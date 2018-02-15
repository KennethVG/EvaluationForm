package be.oak3.evaluationform.service;

import be.oak3.evaluationform.model.Course;

import java.util.List;

public interface CourseService {

    int addCourse(Course course);

    int deleteCourse(Course course);

    int updateCourse(Course course);

    List<Course> findAll();

    Course findOne(int id);

}
