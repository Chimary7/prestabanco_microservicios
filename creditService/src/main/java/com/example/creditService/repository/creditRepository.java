package com.example.creditService.repository;

import com.example.creditService.entity.credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface creditRepository extends JpaRepository<credit,Long> {
    public List<credit> findByRutClient(String rutClient);

    public List<credit> findByProcessCredit(Boolean process);

    public credit findById(int id);

    public Optional<credit> findByRutClientAndProcessCredit(String rutClient, Boolean process);

    public Optional<credit> findByRutClientAndIdLoanType(String rutClient, Integer idLoan);
}
