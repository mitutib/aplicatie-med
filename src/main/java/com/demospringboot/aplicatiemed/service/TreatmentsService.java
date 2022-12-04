package com.demospringboot.aplicatiemed.service;

import com.demospringboot.aplicatiemed.ITreatmentsService;
import com.demospringboot.aplicatiemed.model.Treatments;
import com.demospringboot.aplicatiemed.repository.TreatmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TreatmentsService implements ITreatmentsService {

    //DI @Autowired
    @Autowired
    TreatmentsRepository treatmentsRepository;

    //READ all products from DB
    public List<Treatments> readAllTreatments() {
        return treatmentsRepository.findAll();

    }

    @Override
    public Optional<Treatments> getTreatmentsById() {
        return Optional.empty();
    }


    public List<Treatments> findAllTreatmentsByName(String name) {
        return treatmentsRepository.findAllTreatmentsByName(name);
    }

    public List<Treatments> getAllTreatmentsByNameAndDescription(String name, String description) {
        return treatmentsRepository.findAllTreatmentsByNameAndDescription(name, description);
    }

    public Optional<Treatments> getTreatmentById(int id) {
        return treatmentsRepository.findById(id);

    }

    public Treatments addTreatment(Treatments treatment) {

        return treatmentsRepository.save(treatment);
    }

    public Treatments editTreatment(Treatments treatment) {

        return treatmentsRepository.save(treatment);
    }

    public void updateTreatment(int id, Treatments treatment) {
        Treatments treatmentToUpdate = treatmentsRepository.findById(id).orElseThrow(() -> new IllegalStateException(String.format("Treatment with id %s doesn t exist", id)));
        treatmentToUpdate.setName(treatment.getName());
        treatmentToUpdate.setDescription(treatment.getDescription());
        treatmentsRepository.save(treatmentToUpdate);


    }

    public void deleteTreatment(int id) {
        boolean treatmentExists = treatmentsRepository.existsById(id);
        if (!treatmentExists) {
            throw new IllegalStateException(String.format("Treatment with id %s doesn t exist", id));

        }

        treatmentsRepository.deleteById(id);
    }


}
