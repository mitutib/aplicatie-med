package com.demospringboot.aplicatiemed;

import com.demospringboot.aplicatiemed.model.Patient;

import java.util.List;
import java.util.Optional;

public interface IPatientService {

    List<Patient> readAllPatients();

    void createPatient(Patient patient);

    void updatePatient(int id, Patient patient);

    void deletePatient(int id);

    Optional<Patient> getPatientById(int id);

    List<Patient> getPatientByName(String name);


}
