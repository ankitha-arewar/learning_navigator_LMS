package com.week2.lms.Entity;
import java.util.List;

import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private String studentName;

    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courseSubjects;

    @ManyToMany
    @JoinTable(
            name = "student_examination",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "examination_id")
    )
    private List<Examination> examinationList;
}

