package com.demospringboot.aplicatiemed.service;

import com.demospringboot.aplicatiemed.IConditionsService;
import com.demospringboot.aplicatiemed.model.Conditions;
import com.demospringboot.aplicatiemed.model.Patient;
import com.demospringboot.aplicatiemed.model.Treatments;
import com.demospringboot.aplicatiemed.repository.ConditionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConditionsService implements IConditionsService {

    @Autowired
    ConditionsRepository conditionsRepository;

    public List<Conditions> readAllConditions() {
        return conditionsRepository.findAll();

    }

    public List<Conditions> findAllConditionsByName(String name) {
        return conditionsRepository.findAllConditionsByName(name);

    }

    public Conditions addCondition(Conditions condition) {

        return conditionsRepository.save(condition);
    }

    public Conditions editConditions(Conditions condition) {

        return conditionsRepository.save(condition);
    }


    public void updateCondition(int id, Conditions condition){
        Conditions conditionToUpdate=conditionsRepository.findById(id).orElseThrow(()->
                new IllegalStateException(String.format("Condition with id %s doesn't exist", id)));
        conditionToUpdate.setName(condition.getName());
        conditionToUpdate.setDescription(condition.getDescription());


        conditionsRepository.save(conditionToUpdate);

    }

    @Override
    public void deleteConditionById(int id) {

    }


    public void deleteCondition(int id) {
        boolean conditionExists = conditionsRepository.existsById(id);
        if (!conditionExists) {throw new IllegalStateException(String.format("Condition with id %s doesn t exist", id));

        }

        conditionsRepository.deleteById(id);
    }



}
