package com.example.followCreditService.modal;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.Date;

public class Credit {
    private String rutClient;

    private Date createdate = new Date();

    private Integer amountTotal;

    private double maxPorcentFinancy;

    private double porcentInterest;

    private Integer timePay;

    private String coment;

    private Boolean processCredit = true;

    private Integer idLoanType = 0;

    private Boolean creditEvaluation = false;

    @Enumerated(EnumType.STRING)
    private SavingStatus savingStatus;

    private Boolean savingHistory = false;

    private CreditStatus creditStatus;
}
