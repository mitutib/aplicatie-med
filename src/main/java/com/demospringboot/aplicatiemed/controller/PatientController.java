package com.demospringboot.aplicatiemed.controller;

import com.demospringboot.aplicatiemed.model.Patient;
import com.demospringboot.aplicatiemed.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/patient/")
public class PatientController {

    public final PatientService patientService;

    @GetMapping("/allPatients")
    public List<Patient> getAllPatients() {
        return patientService.readAllPatients();

    }


    @GetMapping(path = "{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable int id) {
        Patient patientDB = patientService.getPatientById(id).orElseThrow(()
                -> new IllegalStateException(String.format("Patient with id %s doesn t exist", id)));

        return new ResponseEntity<>(patientDB, HttpStatus.OK);

    }

    @GetMapping("/getAllPatients/{name}")
    public ResponseEntity<List<Patient>> getPatientByName(@PathVariable String name) {
        List<Patient> patientList = patientService.findAllPatientsByName(name);

        if (patientList.size() == 0) {
            throw new IllegalStateException(String.format("Patient with name %s does not exist", name));

        }
        return new ResponseEntity<>(patientList, HttpStatus.OK);

    }


    @PostMapping
    public Patient createPatients(@RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }

    @PutMapping
    public Patient editPatient(@RequestBody Patient patient) {
        return patientService.editPatient(patient);
    }

    @PostMapping("/addNewPatient")
    public void createPatient(@RequestBody Patient patient) {

        patientService.createPatient(patient);
    }

    @PutMapping(path = "{id}")
    public void updatePatient(@PathVariable int id, @RequestBody Patient patient) {
        patientService.updatePatient(id, patient);
    }

    @DeleteMapping(path = "{id}")
    public void deletePatient(@PathVariable int id) {
        patientService.deletePatient(id);


    }


}
