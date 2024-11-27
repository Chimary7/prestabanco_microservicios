package com.example.SimulatorService.Controller;

import com.example.SimulatorService.Service.SimulatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/simulator")
public class SimulatorController {
    @Autowired
    SimulatorService simulatorService;

    @GetMapping("/")
    public ResponseEntity<Integer> CalculateSimulator(@RequestParam Double CapitalMonth,
                                                      @RequestParam Double annualInterest,
                                                      @RequestParam Integer years) {
        Integer monthlyPayment = simulatorService.SimulatorCalculate(CapitalMonth, annualInterest, years);
        return ResponseEntity.ok(monthlyPayment);
    }
}
