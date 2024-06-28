package com.week2.lms.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.week2.lms.Entity.Student;



public interface StudentRepository extends JpaRepository<Student, Long> {
}
