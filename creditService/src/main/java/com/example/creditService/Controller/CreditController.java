package com.example.creditService.Controller;

import com.example.creditService.entity.credit;
import com.example.creditService.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/credit")
public class CreditController {
    @Autowired
    private CreditService creditservice;

    @GetMapping("/")
    public ResponseEntity<List<credit>> ListCreditNotFinish(){
        List<credit> credits = creditservice.getAllCreditProcess();
        return ResponseEntity.ok(credits);
    }

    @GetMapping("/all")
    public ResponseEntity<List<credit>> ListAllCredit(){
        List<credit> credits = creditservice.getAllCredit();
        return ResponseEntity.ok(credits);
    }

    @GetMapping("/rut")
    public ResponseEntity<List<credit>> getCreditByrutClient(@RequestParam String rutClient){
        List<credit> credits = creditservice.getCreditByRut(rutClient);
        return ResponseEntity.ok(credits);
    }

    @GetMapping("/process")
    public ResponseEntity<Optional<credit>> getCreditProccesByRut(@RequestParam String rut){
        Optional<credit> credit = creditservice.getCreditProcessByRut(rut);
        return ResponseEntity.ok(credit);
    }

    @GetMapping("/idcredit")
    public ResponseEntity<Optional<credit>> getCreditById(@RequestParam long id){
        Optional<credit> Credit = creditservice.getCreditById(id);
        return ResponseEntity.ok(Credit);
    }

    @PostMapping("/")
    public ResponseEntity<credit> saveCredit(@RequestBody credit creditNew){
        credit credit1 = creditservice.saveCredit(creditNew);
        return ResponseEntity.ok(creditNew);
    }

    @PutMapping("/")
    public ResponseEntity<credit> updateCredit(@RequestBody credit creditUpdate){
        credit credit1 = creditservice.updateCredit(creditUpdate);
        return ResponseEntity.ok(credit1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> DeleteCreditId(@PathVariable Long id) throws Exception{
        var isdeleted = creditservice.deleteCredit(id);
        return ResponseEntity.noContent().build();
    }
}
