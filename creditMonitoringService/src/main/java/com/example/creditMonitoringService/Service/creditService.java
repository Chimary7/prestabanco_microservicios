package com.example.creditMonitoringService.Service;

import com.example.creditMonitoringService.Modal.Users;
import com.example.creditMonitoringService.Modal.credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class creditService {
    @Autowired
    RestTemplate restTemplate;
    public credit updateCredit(credit upcredit){

        if (upcredit.getRutClient() == null || upcredit.getRutClient().isEmpty()) {
            throw new IllegalArgumentException("Por favor ingrese el RUT");
        }

        Users user = restTemplate.getForObject("http://localhost:8001/user/" + upcredit.getRutClient(), Users.class);

        if (user == null){
            throw new IllegalArgumentException("No esta registrado este rut de usuario, por favor registrese primero antes de solicitar un prestamo");
        } else if (!user.getRegister()) {
            throw new IllegalArgumentException("Su registro aun no ha sido confirmado, por favor intente de nuevo mas tarde");
        }

        return restTemplate.putForObject("http://localhost:8002/credit/", upcredit, credit.class);
    }
}
