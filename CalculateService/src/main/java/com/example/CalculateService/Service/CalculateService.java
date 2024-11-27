package com.example.CalculateService.Service;

import org.springframework.stereotype.Service;

@Service
public class CalculateService {
    public Integer CostTotal(Double Month, Double AnnualInterest, Integer years){
        if (Month <= 0.0 || AnnualInterest <= 0.0 || years <= 0) {
            throw new IllegalArgumentException("por favor ingrese valores en los parametros que sea distinto o mayor que 0");
        }
        double MonthlyInterest = (AnnualInterest / 12) / 100;
        int totalPaymentsMonth = years * 12;

        double MonthlyPayments = (Month * MonthlyInterest * Math.pow(1 + MonthlyInterest, totalPaymentsMonth))
                /
                (Math.pow(1 + MonthlyInterest, totalPaymentsMonth) - 1);

        double seguro = Month * (0.03 / 100);

        double seguroIncendio = 20000;

        double comisionAdmin = Month * 0.01;

        double Monthmasseguros = MonthlyPayments + seguro + seguroIncendio;

        double MonthTotalCost = (Monthmasseguros * totalPaymentsMonth) + comisionAdmin;

        return (int) Math.round(MonthTotalCost);
    }
}
