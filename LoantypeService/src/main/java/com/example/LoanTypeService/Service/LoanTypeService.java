package com.example.LoanTypeService.Service;

import com.example.LoanTypeService.Entity.Loantype;
import com.example.LoanTypeService.Repository.LoanTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LoanTypeService {
    @Autowired
    private LoanTypeRepository loanTypeRepository;

    public ArrayList<Loantype> getAllLoanType(){
        return new ArrayList<>(loanTypeRepository.findAll());
    }

    public Loantype getLoanTypebyName(String nameLoan){
        return loanTypeRepository.findByNameLoan(nameLoan);
    }

    public Loantype getLoanTypeById(long idLoan){
        return loanTypeRepository.findById(idLoan);
    }

    public Loantype saveLoanType(Loantype loanType){
        if (loanType.getNameLoan() == null || loanType.getNameLoan().isEmpty()){
            throw new IllegalArgumentException("por favor ingrese un nombre del prestamo");
        }

        if (loanType.getRequirements() == null || loanType.getRequirements().isEmpty()){
            throw new IllegalArgumentException("por favor ingrese los requerimientos necesarios");
        }

        if (loanType.getMaxTime() <= 0){
            throw new IllegalArgumentException("por favor ingrese el año de duracion del prestamo");
        }

        if (loanType.getMaxInterest() <= 0.0 ){
            throw new IllegalArgumentException("por favor ingrese el interes maximo del prestamo");
        }

        if (loanType.getMinInterest() <= 0.0){
            throw new IllegalArgumentException("por favor ingrese el interes minimo del prestamo");
        }

        if (loanType.getMaxFinanPorcent() <= 0.0){
            throw new IllegalArgumentException("porfavor ingrese el porcentaje maximo de financiamiento mayor a 0");
        }

        return loanTypeRepository.save(loanType);
    }

    public Loantype updateLoanType(Loantype loanType){
        if (loanType.getNameLoan() == null || loanType.getNameLoan().isEmpty()){
            throw new IllegalArgumentException("por favor ingrese un nombre del prestamo");
        }

        if (loanType.getRequirements() == null || loanType.getRequirements().isEmpty()){
            throw new IllegalArgumentException("por favor ingrese los requerimientos necesarios");
        }

        if (loanType.getMaxTime() <= 0){
            throw new IllegalArgumentException("por favor ingrese el año de duracion del prestamo");
        }

        if (loanType.getMaxInterest() <= 0.0 ){
            throw new IllegalArgumentException("por favor ingrese el interes maximo del prestamo");
        }

        if (loanType.getMinInterest() <= 0.0){
            throw new IllegalArgumentException("por favor ingrese el interes minimo del prestamo");
        }

        if (loanType.getMaxFinanPorcent() <= 0.0){
            throw new IllegalArgumentException("porfavor ingrese el porcentaje maximo de financiamiento mayor a 0");
        }
        return loanTypeRepository.save(loanType);
    }

    public boolean deleteLoanType(Long id) throws Exception{
        try{
            loanTypeRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
