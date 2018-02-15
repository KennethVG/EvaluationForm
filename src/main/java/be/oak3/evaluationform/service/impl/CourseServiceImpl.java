package be.oak3.evaluationform.service.impl;

import be.oak3.evaluationform.model.Course;
import be.oak3.evaluationform.repository.CourseJPARepository;
import be.oak3.evaluationform.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseJPARepository courseJPARepository;

    @Autowired
    public CourseServiceImpl(CourseJPARepository courseJPARepository) {
        this.courseJPARepository = courseJPARepository;
    }

    @Override
    public int addCourse(Course course) {
        Course c = courseJPARepository.saveAndFlush(course);
        return c != null ? 1 : 0;
    }

    @Override
    public int deleteCourse(Course course) {
        if (courseJPARepository.exists(course.getId())) {
            courseJPARepository.delete(course);
        }
        return courseJPARepository.exists(course.getId()) ? 0 : 1;
    }

    @Override
    public int updateCourse(Course course) {
        Course updatedCourse = null;
        if (courseJPARepository.exists(course.getId())) {
            updatedCourse = courseJPARepository.saveAndFlush(course);
        }
        return updatedCourse == null ? 0 : 1;
    }

    @Override
    public List<Course> findAll() {
        return courseJPARepository.findAll();
    }

    @Override
    public Course findOne(int id) {
        return courseJPARepository.findOne(id);
    }
}
