package com.example.loantypeservice.Repository;

import com.example.loantypeservice.Entity.Loantype;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanTypeRepository extends JpaRepository<Loantype,Long> {

    public Loantype findByNameLoan(String nameLoan);

    public Loantype findById(long id);
}
