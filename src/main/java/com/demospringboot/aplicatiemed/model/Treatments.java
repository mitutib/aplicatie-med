package com.demospringboot.aplicatiemed.model;

import lombok.Data;

import javax.persistence.*;

//@Getter
//@Setter
//@AllArgsConstructor
@Data
@Entity
@Table(name = "treatments")
public class Treatments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "surgical_treatment")
    private String name;

    @Column(name = "functional_treatment")
    private String description;

//    @ManyToOne
//    @JoinColumn(name="patient_id", nullable=false)
//    Patient patient;

//    @ManyToMany(fetch = FetchType.LAZY,
//            mappedBy = "conditions")
//    List<Conditions> conditions;


}
