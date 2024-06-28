package com.week2.lms.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.week2.lms.Entity.Course;
import org.springframework.http.ResponseEntity;
import com.week2.lms.Service.SubjectServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {
    @Autowired
    private SubjectServiceImpl courseService;

    @GetMapping
    public List<Course> getAllSubjects() {
        return courseService.getAllSubjects();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getSubjectById(@PathVariable Long id) {
        Course subject = courseService.getSubjectById(id);
        return ResponseEntity.ok(subject);
    }

    @PostMapping
    public ResponseEntity<Course> createSubject(@RequestBody Course subject) {
        Course createdSubject = courseService.createSubject(subject);
        return ResponseEntity.status(201).body(createdSubject);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateSubject(@PathVariable Long id, @RequestBody Course subjectDetails) {
        Course updatedSubject = courseService.updateSubject(id, subjectDetails);
        return ResponseEntity.ok(updatedSubject);
    }
}
