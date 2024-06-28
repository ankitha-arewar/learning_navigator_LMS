package com.week2.lms.Service;

import com.week2.lms.Entity.Student;
import com.week2.lms.Exceptions.ResourceNotFoundException;
import com.week2.lms.Entity.Examination;
import org.springframework.beans.factory.annotation.Autowired;
import com.week2.lms.Entity.Course;
import com.week2.lms.Repository.StudentRepository;
import com.week2.lms.Repository.ExamRepository;
import java.util.List;
import com.week2.lms.Repository.SubjectRepository;
import org.springframework.stereotype.Service;



@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentsRepository;

    @Autowired
    private ExamRepository examinationRepository;

    @Autowired
    private SubjectRepository courseRepository;

    @Override
    public Student createStudent(Student student) {
        return studentsRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
    }

    @Override
    public List<Student> getAllStudents(){
        return studentsRepository.findAll();
    }

    @Override
    public Student updateStudent(Long id, Student studentDetails) {
        Student student = getStudentById(id);
        student.setStudentName(studentDetails.getStudentName());
        student.setCourseSubjects(studentDetails.getCourseSubjects());
        student.setExaminationList(studentDetails.getExaminationList());
        return studentsRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        studentsRepository.delete(student);
    }

    @Override
    public Student registerForExam(Long studentId, Long examId) {
        Student student = getStudentById(studentId);
        Examination exam = examinationRepository.findById(examId)
                .orElseThrow(() -> new ResourceNotFoundException("Examination not found with id " + examId));
        Course subject = exam.getCourseSubject();
        if (!student.getCourseSubjects().contains(subject)) {
            throw new IllegalArgumentException("Student must be enrolled in the subject before registering for the exam");
        }
        student.getExaminationList().add(exam);
        return studentsRepository.save(student);
    }

}
