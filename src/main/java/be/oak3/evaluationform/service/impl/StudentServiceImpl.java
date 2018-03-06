package be.oak3.evaluationform.service.impl;


import be.oak3.evaluationform.model.Student;
import be.oak3.evaluationform.repository.StudentJPARepository;
import be.oak3.evaluationform.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentJPARepository studentJPARepository;

    @Autowired
    public StudentServiceImpl(StudentJPARepository studentJPARepository) {
        this.studentJPARepository = studentJPARepository;
    }

    @Override
    public int addStudent(Student student) {
        Student s = studentJPARepository.saveAndFlush(student);
        return s != null ? 1 : 0;
    }

    @Override
    public int deleteStudent(Student student) {
        if (studentJPARepository.exists(student.getId())) {
            studentJPARepository.delete(student);
        }
        return studentJPARepository.exists(student.getId()) ? 0 : 1;
    }

    @Override
    public int updateStudent(Student student) {
        Student updatedStudent = null;
        if (studentJPARepository.exists(student.getId())) {
            updatedStudent = studentJPARepository.saveAndFlush(student);
        }
        return updatedStudent == null ? 0 : 1;
    }

    @Override
    public List<Student> findAll() {
        return studentJPARepository.findAll();
    }

    @Override
    public Student findOne(int id) {
        return studentJPARepository.findOne(id);
    }

    @Override
    public Student findDistinctFirstByOrderByIdDesc() {
        return studentJPARepository.findDistinctFirstByOrderByIdDesc();
    }


}
