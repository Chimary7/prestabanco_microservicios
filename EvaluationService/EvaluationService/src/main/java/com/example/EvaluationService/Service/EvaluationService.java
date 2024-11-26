package com.example.EvaluationService.Service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@Service
public class EvaluationService {
    public double RelacionCuotaIngreso(Double cuotaMensual, Double ingreso){
        if (cuotaMensual <= 0.0){
            throw new IllegalArgumentException("por favor ingrese la cuota mensual");
        }

        if (ingreso <= 0.0){
            return 0.0;
        }

        return (cuotaMensual/ingreso) * 100;
    }

    public double RelacionDeudaIngreso(Double cuotaMensual, Integer MontoDeudas, Integer ingreso){
        if (cuotaMensual <= 0.0 || ingreso <= 0.0) {
            throw new IllegalArgumentException("por favor ingrese un valor en mayor a cero en la cuota mensial o ingreso");
        }

        double DeudaTotal = cuotaMensual + MontoDeudas;

        return (DeudaTotal/ ingreso) * 100;
    }

    public Boolean yearSolicited(Date birthdate, Integer TimeLoan) {
        if (birthdate == null) {
            throw new IllegalArgumentException("Por favor ingrese la fecha de nacimiento.");
        }

        if (TimeLoan == null) {
            throw new IllegalArgumentException("Por favor, ingrese el tiempo del préstamo.");
        }

        LocalDate birthLocalDate = birthdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int currentAge = Period.between(birthLocalDate, LocalDate.now()).getYears();
        int AgeJubi = 75;
        int marge = 5;
        int maxAge = AgeJubi - marge;

        // Calculate the age when the loan term ends
        int ageAtLoanEnd = currentAge + TimeLoan;

        // Return true if the age at loan term end is less than the max allowable age
        return ageAtLoanEnd < maxAge;
    }

    public Boolean minPaySaving(Integer MonthPay, Integer MonthSaving){
        if (MonthPay <= 0 || MonthSaving == null){
            throw new IllegalArgumentException("por favor, ingrese el monto del prestamo o el monto de la cuenta de ahorro");
        }

        double minMonth = MonthPay * 0.1;

        return minMonth < MonthSaving;
    }

    public Boolean RelationMonthSavingYears(Integer MonthPay, Integer MonthSaving, Integer Years){
        if (MonthPay <= 0|| Years <= 0 || MonthSaving == null){
            throw new IllegalArgumentException("por favor, ingrese el monto de la cuenta de ahorro o el monto del prestamos o los años de antiguedad");
        }

        if (Years < 2){
            double minMonth = MonthPay * 0.2;

            return minMonth < MonthSaving;
        } else {
            double minMonth = MonthPay * 0.1;

            return minMonth < MonthSaving;
        }
    }
}
