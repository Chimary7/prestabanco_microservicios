package com.example.SimulatorService.Controller;

import com.example.SimulatorService.Service.SimulatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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

    @GetMapping("/costtotal")
    public ResponseEntity<Integer> CalculateCostTotal(@RequestParam Double Month,
                                                      @RequestParam Double annualInterest,
                                                      @RequestParam Integer years) {
        Integer MonthCostTotal = simulatorService.CostTotal(Month, annualInterest, years);
        return ResponseEntity.ok(MonthCostTotal);
    }

    @GetMapping("/cuotaingreso")
    public ResponseEntity<Double> CalculateCuotaIngreso(@RequestParam Double cuotaMensual,
                                                        @RequestParam Double ingreso) {
        Double Relation = simulatorService.RelacionCuotaIngreso(cuotaMensual, ingreso);
        return ResponseEntity.ok(Relation);
    }

    @GetMapping("/deudaingreso")
    public ResponseEntity<Double> CalculateDeudaIngreso(@RequestParam Double cuotaMensual,
                                                        @RequestParam Integer MontoDeudas,
                                                        @RequestParam Integer ingreso) {
        Double Relation = simulatorService.RelacionDeudaIngreso(cuotaMensual, MontoDeudas, ingreso);
        return ResponseEntity.ok(Relation);
    }

    @GetMapping("/edadsolicitante")
    public ResponseEntity<Boolean> edadsolicitante(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthdate, @RequestParam Integer TimeLoan){
        Boolean decisive = simulatorService.yearSolicited(birthdate, TimeLoan);
        return ResponseEntity.ok(decisive);
    }

    @GetMapping("/minsaving")
    public ResponseEntity<Boolean> minsaving(@RequestParam Integer MonthPay, @RequestParam Integer MonthSaving){
        Boolean decisive = simulatorService.minPaySaving(MonthPay,MonthSaving);
        return ResponseEntity.ok(decisive);
    }

    @GetMapping("/relationmonthsavingyears")
    public ResponseEntity<Boolean> relationMonthSavingYears(@RequestParam Integer MonthPay,
                                                            @RequestParam Integer MonthSaving,
                                                            @RequestParam Integer Years){
        Boolean decisive = simulatorService.RelationMonthSavingYears(MonthPay,MonthSaving,Years);
        return ResponseEntity.ok(decisive);
    }
}
