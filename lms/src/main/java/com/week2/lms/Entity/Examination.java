package com.week2.lms.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Examination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examId;

    @ManyToMany(mappedBy = "examinationList")
    private List<Student> enrolledStudents;

    @OneToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Course courseSubject;



}

