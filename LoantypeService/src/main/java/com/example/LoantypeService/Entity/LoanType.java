package com.example.LoantypeService.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "loan_type")
@AllArgsConstructor
@NoArgsConstructor
public class LoanType {
    @Id
    @Column(nullable = false,unique = true)
    private long id;

    private String nameLoan;

    private Integer maxTime;

    private Double minInterest;

    private Double maxInterest;

    private Double maxFinanPorcent;

    @ElementCollection
    private List<String> requirements;

}
