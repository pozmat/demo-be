package com.example.demo.service;

import com.example.demo.dao.CalculationDao;
import com.example.demo.model.Calculation;
import com.example.demo.util.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CalculationService {

    private final CalculationDao calculationDao;
    private final Calculator calculator;

    @Autowired
    public CalculationService(@Qualifier("postgres") CalculationDao calculationDao, @Lazy Calculator calculator) {
        this.calculationDao = calculationDao;
        this.calculator = calculator;
    }

    public List<Integer> calculateForSpecified(String user, Calculation calculation){
        List<Integer> result = calculator.calculate(calculation);
        calculation.setUser(user);
        calculation.setResult(result);
        return calculationDao.createCalculation(calculation);
    }

    public List<Integer> calculateForUnspecified(Calculation calculation){
        UUID id = UUID.randomUUID();
        String user = id.toString();
        List<Integer> result = calculator.calculate(calculation);
        calculation.setUser(user);
        calculation.setResult(result);
        return  calculationDao.createCalculation(calculation);
    }

    public List<Calculation> showCalculationHistory(){
        return calculationDao.showCalculationHistory();
    }
}
