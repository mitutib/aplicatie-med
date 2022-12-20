package com.demospringboot.aplicatiemed.service;

import com.demospringboot.aplicatiemed.IPatientService;
import com.demospringboot.aplicatiemed.model.Patient;
import com.demospringboot.aplicatiemed.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements IPatientService {
//    @Autowired

    public final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    public Optional<Patient> getPatientById(int id) {
        return patientRepository.findById(id);
    }

    public List<Patient> getPatientByName(String name) {
        return patientRepository.findAllPatientsByName(name);
    }


    public List<Patient> readAllPatients() {
        return patientRepository.findAll();

    }

    public List<Patient> findAllPatientsByName(String name) {
        return patientRepository.findAllPatientsByName((name));
    }

    public Patient addPatient(Patient patient) {

        return patientRepository.save(patient);
    }

    public Patient editPatient(Patient patient) {

        return patientRepository.save(patient);
    }

    public void createPatient(Patient patient) {

        Optional<Patient> pacientOptional = patientRepository.findAllPatientsByEmail(patient.getEmail());
        if (pacientOptional.isPresent()) {
            throw new IllegalStateException(String.format("Email address %s already exists", patient.getEmail()));
        }
        validateEmail(patient.getEmail());
        patientRepository.save(patient);

    }


    public void updatePatient(int id, Patient patient) {
        Patient patientToUpdate = patientRepository.findById(id).orElseThrow(() -> new IllegalStateException(String.format("Patient with id %s doesn't exist", id)));
        validateEmail(patient.getEmail());
        patientToUpdate.setName(patient.getName());
        patientToUpdate.setAddress(patient.getAddress());
        patientToUpdate.setEmail(patient.getEmail());

        patientRepository.save(patientToUpdate);

    }

    private void validateEmail(String email) {

        Optional<Patient> patientOptional = patientRepository.findAllPatientsByEmail(email);
        if (patientOptional.isPresent()) {
            throw new IllegalStateException(String.format("Email address %s already exists", email));
        }
    }


    public void deletePatient(int id) {
        boolean patientExists = patientRepository.existsById(id);
        if (!patientExists) {
            throw new IllegalStateException(String.format("Patient with id %s doesn t exist", id));

        }

        patientRepository.deleteById(id);
    }
}
