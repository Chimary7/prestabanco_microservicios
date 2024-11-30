package com.example.creditMonitoringService.Modal;

import com.example.creditMonitoringService.Util.CreditStatus;
import com.example.creditMonitoringService.Util.SavingStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class credit {
    private int id;
    private String rutClient;
    private Date createdate;
    private Integer amountTotal;
    private double maxPorcentFinancy;
    private double porcentInterest;
    private Integer timePay;
    private String coment;
    private Boolean processCredit;
    private Integer idLoanType;
    private Boolean creditEvaluation;
    private Boolean savingHistory;
    @Enumerated(EnumType.STRING)
    private SavingStatus savingStatus;

    private Boolean SavingHistory;
    @Enumerated(EnumType.STRING)
    private CreditStatus creditStatus;
}
