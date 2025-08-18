package org.example;

import org.example.config.AppConfig;
import org.example.model.Student;
import org.example.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        StudentService studentService = context.getBean(StudentService.class);

//        Student s1 = new Student();
//        s1.setName("John");
//        s1.setCity("Hyderabad");
//
//        studentService.createStudent(s1);
//        Student s2 = new Student();
//
//        s2.setName("Alice");
//        s2.setCity("London");
//        studentService.createStudent(s2);
        Student fetched = studentService.getStudent(1);
        System.out.println(fetched.getName() + ", " + fetched.getCity());
        List<Student> allStudents = studentService.getAllStudents();
        //studentService.deleteStudent(2);
        for (Student s : allStudents) {
            System.out.println("ID: " + s.getId() + ", Name: " + s.getName() + ", City: " + s.getCity());
        }
    }
}
