package com.week2.lms.Controller;



import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import com.week2.lms.Service.StudentServiceImpl;
import org.springframework.web.bind.annotation.*;
import com.week2.lms.Entity.Student;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentsService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentsService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentsService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentsService.createStudent(student);
        return ResponseEntity.status(201).body(createdStudent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        Student updatedStudent = studentsService.updateStudent(id, studentDetails);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentsService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/register-exam/{studentId}/{examId}")
    public ResponseEntity<Student> registerForExam(@PathVariable Long studentId, @PathVariable Long examId) {
        Student student = studentsService.registerForExam(studentId, examId);
        return ResponseEntity.ok(student);
    }
}
