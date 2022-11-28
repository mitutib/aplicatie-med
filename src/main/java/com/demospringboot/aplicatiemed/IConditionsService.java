package com.demospringboot.aplicatiemed;

import com.demospringboot.aplicatiemed.model.Conditions;

import java.util.List;

public interface IConditionsService {

    List<Conditions> readAllConditions();

    public Conditions addCondition(Conditions condition);

    public Conditions editConditions(Conditions condition);

    public void updateCondition(int id, Conditions condition);

    public void deleteConditionById(int id);
    public void deleteCondition(int id);


}
