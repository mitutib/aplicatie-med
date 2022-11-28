package com.demospringboot.aplicatiemed;

import com.demospringboot.aplicatiemed.model.Conditions;

import java.util.List;

public interface IConditionsService {

    List<Conditions> readAllConditions();

    Conditions addCondition(Conditions condition);

    Conditions editConditions(Conditions condition);

    void updateCondition(int id, Conditions condition);

    void deleteConditionById(int id);

    void deleteCondition(int id);


}
