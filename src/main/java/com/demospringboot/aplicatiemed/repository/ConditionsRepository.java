package com.demospringboot.aplicatiemed.repository;

import com.demospringboot.aplicatiemed.model.Conditions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConditionsRepository extends JpaRepository<Conditions, Integer> {

    List<Conditions> findAllConditionsByName(String name);

    List<Conditions> findAllConditionsByNameAndDescription(String name, String description);


}
