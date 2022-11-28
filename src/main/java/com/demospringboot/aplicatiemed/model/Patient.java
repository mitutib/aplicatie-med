package com.demospringboot.aplicatiemed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "patient")

public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "patient_name")
    private String name;
    @Column(name = "patient_address")
    private String address;
    @Column(name = "patient_email")
    private String email;
    @Column(name = "patient_phone")
    private String phone;


    @JsonIgnore
    @ManyToMany(fetch=FetchType.LAZY, mappedBy ="patients"
    )
    List<Conditions> conditions;



}
