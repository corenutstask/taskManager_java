package com.corenuts.entity;

import lombok.Data;

import java.sql.Date;

import javax.persistence.*;

@Data
@Entity
@Table(name = "completedassingment")
public class CompletedAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assingement_completed_id")
    private Integer assingement_completed_id;

    @ManyToOne
    @JoinColumn(name = "assignment_id", referencedColumnName = "batch_assignment_id")
    private BatchAssignment assignment_id;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private StudentDetails student_id;

    @Column(name = "status")
    private String status;

    @Column(name = "submission_date")
    private Date submission_date;
}

