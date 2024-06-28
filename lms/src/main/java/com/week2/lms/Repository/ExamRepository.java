package com.week2.lms.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.week2.lms.Entity.Examination;
import org.springframework.data.jpa.repository.Query;


public interface ExamRepository extends JpaRepository<Examination, Long> {

}