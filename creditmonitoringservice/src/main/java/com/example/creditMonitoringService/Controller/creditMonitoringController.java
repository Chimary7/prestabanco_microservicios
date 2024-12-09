package com.example.creditMonitoringService.Controller;

import com.example.creditMonitoringService.Modal.credit;
import com.example.creditMonitoringService.Service.creditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/creditMonitoring")
public class creditMonitoringController {
    @Autowired
    private creditService creditservice;

    @PutMapping("/save")
    public ResponseEntity<credit> updateCredit(@RequestBody credit credit){
        credit credit1 = creditservice.updateCredit(credit);
        return ResponseEntity.ok(credit1);
    }

}
