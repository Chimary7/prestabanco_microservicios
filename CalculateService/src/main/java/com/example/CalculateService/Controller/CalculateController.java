package com.example.CalculateService.Controller;

import com.example.CalculateService.Service.CalculateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculate")
public class CalculateController {
    CalculateService calculateService;

    @GetMapping("/costtotal")
    public ResponseEntity<Integer> CalculateCostTotal(@RequestParam Double Month,
                                                      @RequestParam Double annualInterest,
                                                      @RequestParam Integer years) {
        Integer MonthCostTotal = calculateService.CostTotal(Month, annualInterest, years);
        return ResponseEntity.ok(MonthCostTotal);
    }
}
