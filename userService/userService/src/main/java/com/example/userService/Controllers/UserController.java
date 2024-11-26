package com.example.userService.Controllers;

import com.example.userService.Entities.Users;
import com.example.userService.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/register")
    public ResponseEntity<List<Users>> ListUserNotRegister(){
        List<Users> users = userService.getAllUserNotRegister();
        return ResponseEntity.ok(users);
    }

    @GetMapping
    public ResponseEntity<List<Users>> ListUsers(){
        ArrayList<Users> users = userService.getAllUserRegister();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{rut}")
    public ResponseEntity<Users> getUserByRut(@PathVariable String rut){
        Users User = userService.getUserByRut(rut);
        return ResponseEntity.ok(User);
    }

    @PostMapping
    public ResponseEntity<Users> SaveUser(@RequestBody Users user){
        Users newUser = userService.updateUser(user);
        return ResponseEntity.ok(newUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> DeleteUserId(@PathVariable Long id) throws Exception{
        var isdeleted = userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
