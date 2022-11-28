package com.demospringboot.aplicatiemed.repository;

import com.demospringboot.aplicatiemed.model.Treatments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreatmentsRepository extends JpaRepository<Treatments, Integer> {


    List<Treatments> findAllTreatmentsByName(String name);

    List<Treatments> findAllTreatmentsByNameAndDescription(String name, String description);


}


