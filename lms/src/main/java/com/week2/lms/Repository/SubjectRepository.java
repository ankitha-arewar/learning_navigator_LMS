package com.week2.lms.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.week2.lms.Entity.Course;



public interface SubjectRepository extends JpaRepository<Course, Long> {
}