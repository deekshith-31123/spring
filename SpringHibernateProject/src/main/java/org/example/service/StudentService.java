package org.example.service;

import org.example.model.Student;
import java.util.List;

public interface StudentService {
    void createStudent(Student student);
    Student getStudent(int id);
    List<Student> getAllStudents();
    void updateStudent(Student student);
    void deleteStudent(int id);
}
