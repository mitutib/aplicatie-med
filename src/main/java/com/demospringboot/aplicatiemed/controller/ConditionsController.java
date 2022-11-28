package com.demospringboot.aplicatiemed.controller;

import com.demospringboot.aplicatiemed.model.Conditions;
import com.demospringboot.aplicatiemed.model.Patient;
import com.demospringboot.aplicatiemed.model.Treatments;
import com.demospringboot.aplicatiemed.service.ConditionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/conditions/")
public class ConditionsController {

    private final ConditionsService conditionsService;


    @GetMapping("/allConditions")
    public List<Conditions> getAllConditions() {
        return conditionsService.readAllConditions();
    }

    @PostMapping("/addNewCondition")
    public Conditions createCondition(@RequestBody Conditions condition) {
        return conditionsService.addCondition(condition);
    }

//    @PutMapping
//    public Conditions editCondition(@RequestBody  Conditions condition){
//        return conditionsService.editConditions(condition);

    @PutMapping(path = "{id}")

    public void updatePatient(@PathVariable int id, @RequestBody Conditions conditions) {
        conditionsService.updateCondition(id, conditions);
    }


    @DeleteMapping(path = "/deleteCondition/{id}")
    public void deleteCondition(@PathVariable int id) {
        conditionsService.deleteCondition(id);


    }
}
