package com.week2.lms.Service;

import com.week2.lms.Entity.Examination;

import java.util.List;
public interface ExamService {
    List<Examination> getAllExams();
    Examination getExamById(Long id);
    Examination createExam(Examination exam);
    Examination updateExam(Long id, Examination examDetails);
    void deleteExam(Long id);

}
