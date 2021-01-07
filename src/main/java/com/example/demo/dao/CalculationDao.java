package com.example.demo.dao;

import com.example.demo.model.Calculation;

import java.util.List;


public interface CalculationDao {

    List<Integer> logCalculation(String user, Integer total, List<Integer> values, List<Integer> result);

    default List<Integer> createCalculation(Calculation calculation) {
        String user = calculation.getUser();
        Integer total = calculation.getTotal();
        List<Integer> values = calculation.getValues();
        List<Integer> result = calculation.getResult();

        return logCalculation(user, total, values, result);
    }

    List<Calculation> showCalculationHistory();

}
