package com.week2.lms.Service;

import com.week2.lms.Entity.Course;

import java.util.List;

public interface SubjectService {
    List<Course> getAllSubjects();
    Course getSubjectById(Long id);
    Course createSubject(Course subject);
    Course updateSubject(Long id, Course subjectDetails);
    void deleteSubject(Long id);
}