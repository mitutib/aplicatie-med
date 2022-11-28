package com.demospringboot.aplicatiemed.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="conditions")

public class Conditions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="condition_name")
    private String name;
    @Column(name="condition_description")
    private String description;
//    @ManyToOne
//    @JoinColumn(name="patient_id", nullable=false)
//    Patient patient;

    @ManyToMany
    @JoinTable(
            name = "PACIENTS_CONDITIONS",
            joinColumns = @JoinColumn(name = "CONDITIONS_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID")
    )
    List<Patient> patients;





}
