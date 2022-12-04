package com.demospringboot.aplicatiemed.controller;

import com.demospringboot.aplicatiemed.model.Treatments;
import com.demospringboot.aplicatiemed.service.TreatmentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/treatments")
public class TreatmentController {

    public final TreatmentsService treatmentsService;
//    private Treatments treatment;

    @GetMapping("/allTreatments")
    public List<Treatments> getAllTreatments() {
        return treatmentsService.readAllTreatments();

    }

    @PostMapping("/addNewTreatment")
    public Treatments createTreatment(@RequestBody Treatments treatment) {
        return treatmentsService.addTreatment(treatment);
    }

    @PutMapping
    public Treatments editTreatment(@RequestBody Treatments treatment) {
        return treatmentsService.editTreatment(treatment);
    }

    @PutMapping(path = "{id}")
    public void updateTreatment(@PathVariable int id, @RequestBody Treatments treatment) {
        treatmentsService.updateTreatment(id, treatment);


    }

    @DeleteMapping(path = "/deleteTreatment/{id}")
    public void deleteTreatment(@PathVariable int id) {
        treatmentsService.deleteTreatment(id);


    }


}
