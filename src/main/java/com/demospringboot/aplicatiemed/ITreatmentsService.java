package com.demospringboot.aplicatiemed;

import com.demospringboot.aplicatiemed.model.Treatments;
import java.util.List;
import java.util.Optional;

public interface ITreatmentsService {

    List<Treatments> readAllTreatments();

    Optional<Treatments> getTreatmentsById();

    Treatments addTreatments(Treatments treatments);

    Treatments addTreatment(Treatments treatment);

    Treatments editTreatment(Treatments treatment);

    void updateTreatment(int id, Treatments treatment);


    void deleteTreatment(int id);


}
