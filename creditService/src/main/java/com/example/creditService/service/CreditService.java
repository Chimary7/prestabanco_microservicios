package com.example.creditService.service;

import com.example.creditService.entity.credit;
import com.example.creditService.model.Users;
import com.example.creditService.repository.creditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Optional;

import static com.example.creditService.util.CreditStatus.APROBADA;

@Service
public class CreditService {
    @Autowired
    private creditRepository creditrepository;

    @Autowired
    RestTemplate restTemplate;

    public ArrayList<credit> getAllCreditProcess(){
        return (ArrayList<credit>) creditrepository.findByProcessCredit(true);
    }

    public ArrayList<credit> getAllCredit(){
        return (ArrayList<credit>) creditrepository.findAll();
    }

    public ArrayList<credit> getCreditByRut(String rutClient){
        if (rutClient == null){
            throw new IllegalArgumentException("por favor ingrese un rut");
        }

        Users user = restTemplate.getForObject("http://localhost:8080/user/" + rutClient, Users.class);

        if (user == null){
            throw new IllegalArgumentException("el usuario no esta registrado");
        }

        return (ArrayList<credit>) creditrepository.findByRutClient(rutClient);
    }

    public Optional<credit> getCreditProcessByRut(String rutClient){
        if (rutClient == null){
            throw new IllegalArgumentException("por favor ingrese un rut");
        }
        Users user = restTemplate.getForObject("http://localhost:8001/user/" + rutClient, Users.class);
        if (user == null){
            throw new IllegalArgumentException("el usuario no esta registrado");
        }
        return creditrepository.findByRutClientAndProcessCredit(rutClient,true);
    }

    public Optional<credit> getCreditById(long id){
        return  creditrepository.findById(id);
    }

    public credit saveCredit(credit credit){

        if (credit.getRutClient() == null || credit.getRutClient().isEmpty()) {
            throw new IllegalArgumentException("Por favor ingrese el RUT");
        }

        Optional<credit> creditOptional = creditrepository.findByRutClientAndProcessCredit(credit.getRutClient(),true);
        if (creditOptional.isPresent()){
            throw new IllegalArgumentException("No puede solicitar otro prestamo ya que ya tiene uno en proceso");
        }

        if (credit.getIdLoanType() == null || credit.getIdLoanType() == 0){
            throw new IllegalArgumentException("por favor seleccione un tipo de credito");
        }

        if (credit.getIdLoanType() == 1 || credit.getIdLoanType() == 2) {
            creditOptional = creditrepository.findByRutClientAndIdLoanType(credit.getRutClient(), 1);
            if (creditOptional.isPresent() && creditOptional.get().getCreditStatus() == APROBADA) {
                throw new IllegalArgumentException("No puede pedir el presente prestamo ya que solo se puede pedir una vez");
            } else {
                creditOptional = creditrepository.findByRutClientAndIdLoanType(credit.getRutClient(), 2);
                if (creditOptional.isPresent() && creditOptional.get().getCreditStatus() == APROBADA) {
                    throw new IllegalArgumentException("No puede pedir el presente prestamo ya que solo se puede pedir una vez");
                }
            }
        }

        Users user = restTemplate.getForObject("http://localhost:8001/user/" + credit.getRutClient(), Users.class);

        if (user == null){
            throw new IllegalArgumentException("No esta registrado este rut de usuario, por favor registrese primero antes de solicitar un prestamo");
        } else if (!user.getRegister()) {
            throw new IllegalArgumentException("Su registro aun no ha sido confirmado, por favor intente de nuevo mas tarde");
        }



        return creditrepository.save(credit);
    }

    public credit updateCredit(credit credit){

        if (credit.getRutClient() == null || credit.getRutClient().isEmpty()) {
            throw new IllegalArgumentException("Por favor ingrese el RUT");
        }

        Users user = restTemplate.getForObject("http://localhost:8001/user/" + credit.getRutClient(), Users.class);

        if (user == null){
            throw new IllegalArgumentException("No esta registrado este rut de usuario, por favor registrese primero antes de solicitar un prestamo");
        } else if (!user.getRegister()) {
            throw new IllegalArgumentException("Su registro aun no ha sido confirmado, por favor intente de nuevo mas tarde");
        }

        return creditrepository.save(credit);
    }

    public boolean deleteCredit(Long id) throws Exception{
        try{
            creditrepository.deleteById(id);
            return true;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
