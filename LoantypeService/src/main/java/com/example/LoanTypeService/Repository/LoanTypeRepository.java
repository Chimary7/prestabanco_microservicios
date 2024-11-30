package com.example.LoanTypeService.Repository;

import com.example.LoanTypeService.Entity.Loantype;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanTypeRepository extends JpaRepository<Loantype,Long> {

    public Loantype findByNameLoan(String nameLoan);

    public Loantype findById(long id);
}
