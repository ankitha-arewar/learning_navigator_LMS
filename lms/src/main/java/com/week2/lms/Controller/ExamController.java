package com.week2.lms.Controller;


import com.week2.lms.Entity.Student;
import com.week2.lms.Exceptions.ResourceNotFoundException;
import com.week2.lms.Entity.Course;
import com.week2.lms.Service.StudentServiceImpl;
import com.week2.lms.Service.SubjectServiceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.week2.lms.Service.ExamServiceImpl;
import org.springframework.http.ResponseEntity;
import com.week2.lms.Entity.Examination;

import java.util.List;

@RestController
@RequestMapping("/api/exams")
public class ExamController {
    @Autowired
    private ExamServiceImpl examinatioService;

    @Autowired
    private SubjectServiceImpl courseService;

    @Autowired
    private StudentServiceImpl studentsService;

    @GetMapping
    public List<Examination> getAllExams() {
        return examinatioService.getAllExams();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Examination> getExamById(@PathVariable Long id) {
        Examination exam = examinatioService.getExamById(id);
        return ResponseEntity.ok(exam);
    }

    @PostMapping
    public ResponseEntity<Examination> createExam(@RequestBody Examination exam) {
        // Validate that the subject exists
        Course subject = courseService.getSubjectById(exam.getCourseSubject().getCourseId());
        exam.setCourseSubject(subject);

        Examination createdExam = examinatioService.createExam(exam);
        return ResponseEntity.status(201).body(createdExam);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Examination> updateExam(@PathVariable Long id, @RequestBody Examination examDetails) {
        // Validate that the subject exists
        Course subject = courseService.getSubjectById(examDetails.getCourseSubject().getCourseId());
        examDetails.setCourseSubject(subject);

        Examination updatedExam = examinatioService.updateExam(id, examDetails);
        return ResponseEntity.ok(updatedExam);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExam(@PathVariable Long id) {
        examinatioService.deleteExam(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{examId}/register-student/{studentId}")
    public ResponseEntity<Examination> registerStudentForExam(@PathVariable Long examId, @PathVariable Long studentId) {
        Examination exam = examinatioService.getExamById(examId);
        Student student = studentsService.getStudentById(studentId);

        // Check if the student is enrolled in the subject of the exam
        if (!student.getCourseSubjects().contains(exam.getCourseSubject())) {
            throw new ResourceNotFoundException("Student not enrolled in the subject of the exam.");
        }

        exam.getEnrolledStudents().add(student);
        student.getExaminationList().add(exam);

        examinatioService.createExam(exam); // Save the updated exam with the new student
        studentsService.createStudent(student); // Save the updated student with the new exam

        return ResponseEntity.ok(exam);
    }
}
