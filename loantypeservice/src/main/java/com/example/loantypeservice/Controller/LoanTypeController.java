package com.example.loantypeservice.Controller;

import com.example.loantypeservice.Entity.Loantype;
import com.example.loantypeservice.Service.LoanTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loanType")
public class LoanTypeController {
    @Autowired
    LoanTypeService loanTypeService;

    @GetMapping("/")
    public ResponseEntity<List<Loantype>> ListLoanType(){
        List<Loantype> loanTypes = loanTypeService.getAllLoanType();
        return ResponseEntity.ok(loanTypes);
    }

    @GetMapping("/loan")
    public ResponseEntity<Loantype> GetLoanTypeById(@RequestParam long id){
        System.out.println("id: " + id);
        Loantype loanType = loanTypeService.getLoanTypeById(id);
        return ResponseEntity.ok(loanType);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Loantype> GetLoanTypeByName(@PathVariable String name){
        Loantype loanType = loanTypeService.getLoanTypebyName(name);
        return ResponseEntity.ok(loanType);
    }

    @PostMapping("/")
    public ResponseEntity<Loantype> SaveLoanType(@RequestBody Loantype loanType){
        Loantype loanTypeNew = loanTypeService.saveLoanType(loanType);
        return ResponseEntity.ok(loanTypeNew);
    }

    @PutMapping("/")
    public ResponseEntity<Loantype> UpdateLoanType (@RequestBody Loantype loanType){
        Loantype newLoanType = loanTypeService.updateLoanType(loanType);
        return ResponseEntity.ok(newLoanType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> DeleteLoanTypeId(@PathVariable Long id) throws Exception{
        var isdeleted = loanTypeService.deleteLoanType(id);
        return ResponseEntity.noContent().build();
    }
}
