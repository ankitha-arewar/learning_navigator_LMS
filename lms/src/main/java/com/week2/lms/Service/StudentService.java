package com.week2.lms.Service;


import com.week2.lms.Entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student createStudent(Student student);
    Student updateStudent(Long id, Student studentDetails);
    void deleteStudent(Long id);
    Student registerForExam(Long studentId, Long examId);

}
