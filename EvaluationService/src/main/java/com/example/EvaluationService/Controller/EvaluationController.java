package com.example.EvaluationService.Controller;

import com.example.EvaluationService.Service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/evaluation")
public class EvaluationController {

    @Autowired
    EvaluationService evaluationService;

    @GetMapping("/cuotaingreso")
    public ResponseEntity<Double> CalculateCuotaIngreso(@RequestParam Double cuotaMensual,
                                                        @RequestParam Double ingreso) {
        Double Relation = evaluationService.RelacionCuotaIngreso(cuotaMensual, ingreso);
        return ResponseEntity.ok(Relation);
    }

    @GetMapping("/deudaingreso")
    public ResponseEntity<Double> CalculateDeudaIngreso(@RequestParam Double cuotaMensual,
                                                        @RequestParam Integer MontoDeudas,
                                                        @RequestParam Integer ingreso) {
        Double Relation = evaluationService.RelacionDeudaIngreso(cuotaMensual, MontoDeudas, ingreso);
        return ResponseEntity.ok(Relation);
    }

    @GetMapping("/edadsolicitante")
    public ResponseEntity<Boolean> edadsolicitante(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthdate, @RequestParam Integer TimeLoan){
        Boolean decisive = evaluationService.yearSolicited(birthdate, TimeLoan);
        return ResponseEntity.ok(decisive);
    }

    @GetMapping("/minsaving")
    public ResponseEntity<Boolean> minsaving(@RequestParam Integer MonthPay, @RequestParam Integer MonthSaving){
        Boolean decisive = evaluationService.minPaySaving(MonthPay,MonthSaving);
        return ResponseEntity.ok(decisive);
    }

    @GetMapping("/relationmonthsavingyears")
    public ResponseEntity<Boolean> relationMonthSavingYears(@RequestParam Integer MonthPay,
                                                            @RequestParam Integer MonthSaving,
                                                            @RequestParam Integer Years){
        Boolean decisive = evaluationService.RelationMonthSavingYears(MonthPay,MonthSaving,Years);
        return ResponseEntity.ok(decisive);
    }
}
