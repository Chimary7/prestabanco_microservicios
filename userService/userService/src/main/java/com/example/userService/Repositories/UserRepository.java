package com.example.userService.Repositories;

import com.example.userService.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users,Long> {
    public Users findByRut(String Rut);

    public List<Users> findByRegister(Boolean register);

    public Users findById(long id);
}
