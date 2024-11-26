package com.example.LoantypeService.repository;

import com.example.LoantypeService.Entity.LoanType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanTypeRepository extends JpaRepository<LoanType,Long> {
    public LoanType findByNameLoan(String nameLoan);

    public LoanType findById(long id);
}
