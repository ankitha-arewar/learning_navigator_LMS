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
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    private String courseName;

    @ManyToMany(mappedBy = "courseSubjects")
    private List<Student> enrolledStudents;

    @OneToOne(mappedBy = "courseSubject", cascade = CascadeType.ALL)
    private Examination exam;

}

