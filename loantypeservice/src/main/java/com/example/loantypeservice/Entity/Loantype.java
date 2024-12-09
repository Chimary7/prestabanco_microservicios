package com.example.loantypeservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "loantype")
@AllArgsConstructor
@NoArgsConstructor
public class Loantype {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String nameLoan;

    private Integer MaxTime;

    private Double minInterest;

    private Double maxInterest;

    private Double maxFinanPorcent;

    @ElementCollection
    private List<String> requirements;
}
