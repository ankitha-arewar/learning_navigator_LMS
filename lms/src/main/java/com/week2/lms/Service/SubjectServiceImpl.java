package com.week2.lms.Service;

import com.week2.lms.Repository.SubjectRepository;
import com.week2.lms.Entity.Course;
import com.week2.lms.Exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;





@Service
public class SubjectServiceImpl implements  SubjectService{

    @Autowired
    private SubjectRepository courseRepository;

    @Override
    public Course createSubject(Course subject) {
        return courseRepository.save(subject);
    }

    @Override
    public Course getSubjectById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));
    }

    @Override
    public List<Course> getAllSubjects(){
        return courseRepository.findAll();
    }

    @Override
    public Course updateSubject(Long id, Course subjectDetails) {
        Course subject = getSubjectById(id);
        subject.setCourseName(subjectDetails.getCourseName());
        return courseRepository.save(subject);
    }

    @Override
    public void deleteSubject(Long id) {
        Course subject = getSubjectById(id);
        courseRepository.delete(subject);
    }

}
