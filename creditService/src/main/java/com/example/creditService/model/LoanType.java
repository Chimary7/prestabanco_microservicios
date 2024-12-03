package com.example.creditService.model;

import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanType {
    private String nameLoan;
    private Integer MaxTime;
    private Double minInterest;
    private Double maxInterest;
    private Double maxFinanPorcent;
    @ElementCollection
    private List<String> requirements;
}
