package com.example.demo.api;

import com.example.demo.model.Calculation;
import com.example.demo.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CalculationController {

    private final CalculationService calculationService;

    @Autowired
    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @PostMapping(value = "api/v1/calculation")
    public ResponseEntity<List<Integer>> calculateUnspecified(@RequestBody Calculation calculation){
        calculationService.calculateForUnspecified(calculation);
        return ResponseEntity.ok(calculation.getResult());
    }

    @PostMapping(value = "api/v1/calculation/{user}")
    public ResponseEntity<List<Integer>> calculateSpecified(@PathVariable(name = "user") String user, @RequestBody Calculation calculation){
        calculationService.calculateForSpecified(user, calculation);
        return ResponseEntity.ok(calculation.getResult());
    }

    @GetMapping(value = "api/v1/history")
    public List<Calculation> showCalculationHistory(){
        return calculationService.showCalculationHistory();
    }
}
