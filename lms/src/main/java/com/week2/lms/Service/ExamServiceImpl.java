package com.week2.lms.Service;
import java.util.List;
import com.week2.lms.Exceptions.ResourceNotFoundException;
import com.week2.lms.Entity.Examination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.week2.lms.Repository.ExamRepository;


@Service
public class ExamServiceImpl implements  ExamService {

    @Autowired
    private ExamRepository examinationRepository;

    @Override
    public List<Examination> getAllExams() {
        return examinationRepository.findAll();
    }

    @Override
    public Examination createExam(Examination exam) {
        return examinationRepository.save(exam);
    }

    @Override
    public Examination getExamById(Long id) {
        return examinationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Examination not found with id " + id));
    }

    @Override
    public Examination updateExam(Long id, Examination examDetails) {
        Examination exam = getExamById(id);
        exam.setCourseSubject(examDetails.getCourseSubject());
        return examinationRepository.save(exam);
    }

    @Override
    public void deleteExam(Long id) {
        Examination exam = getExamById(id);
        examinationRepository.delete(exam);
    }
}

