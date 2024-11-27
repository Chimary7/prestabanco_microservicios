package com.example.creditService.entity;

import com.example.creditService.util.CreditStatus;
import com.example.creditService.util.SavingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "credit")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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

    @Enumerated(EnumType.STRING)
    private CreditStatus creditStatus = CreditStatus.EN_REVISION_INICIAL;
}
