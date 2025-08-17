package org.example.service;

import org.example.model.Student;
import org.example.repository.StudentDao;
import org.springframework.stereotype.Service;

import java.util.List;


public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void createStudent(Student student) {
        studentDao.save(student);
    }

    @Override
    public Student getStudent(int id) {
        return studentDao.findById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.update(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentDao.delete(id);
    }
}
