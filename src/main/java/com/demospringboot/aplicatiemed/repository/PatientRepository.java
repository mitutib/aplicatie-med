package com.demospringboot.aplicatiemed.repository;

import com.demospringboot.aplicatiemed.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

    List<Patient> findAllPatientsByName(String name);
    List<Patient> findAllPatientsByPhone(String phone);

    Optional<Patient> findAllPatientsByEmail(String email);





}
