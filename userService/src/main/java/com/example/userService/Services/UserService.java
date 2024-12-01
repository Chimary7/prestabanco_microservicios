package com.example.userService.Services;

import com.example.userService.Entities.Users;
import com.example.userService.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public boolean isAdult(Date birthdate){
        LocalDate birthLocalDate = birthdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return Period.between(birthLocalDate,LocalDate.now()).getYears() >= 18;
    }

    public ArrayList<Users> getAllUserNotRegister(){
        return (ArrayList<Users>) userRepository.findByRegister(false);
    }

    public ArrayList<Users> getAllUserRegister(){
        return (ArrayList<Users>) userRepository.findByRegister(true);
    }

    public Users getUserByRut(String rut){
        if (rut == null){
            throw new IllegalArgumentException("Por favor ingrese un RUT");
        }

        Users user = userRepository.findByRut(rut);
        if(user != null && user.getRegister() != false){
            return user;
        } else {
            throw new IllegalArgumentException("El usuario no existe o no esta confirmado su registro");
        }
    }

    public Users saveUser(Users user){
        Objects.requireNonNull(user.getRut(),"Por favor ingrese un RUT");
        Objects.requireNonNull(user.getName(),"Por favor ingrese su nombre");
        Objects.requireNonNull(user.getLastname(),"Por favor ingrese su apellido");
        Objects.requireNonNull(user.getBirthdate(),"Por favor ingrese su fecha de nacimiento");

        if (!isAdult(user.getBirthdate())){
            throw new IllegalArgumentException("el usuario debe al menos 18 años");
        }

        return userRepository.save(user);
    }

    public Users updateUser(Users user){
        Objects.requireNonNull(user.getRut(), "Por favor ingrese un RUT");
        Objects.requireNonNull(user.getName(), "Por favor ingrese su nombre");
        Objects.requireNonNull(user.getLastname(), "por favor ingrese su apellido");
        Objects.requireNonNull(user.getBirthdate(), "por favor ingrese su fecha de nacimiento");

        if (!isAdult(user.getBirthdate())){
            throw new IllegalArgumentException("el usuario debe tener al menos 18 años");
        }

        return userRepository.save(user);
    }

    public boolean deleteUser(Long id) throws Exception{
        try{
            userRepository.deleteById(id);
            return true;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
