package com.aron.users.msvc_users.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aron.users.msvc_users.entity.User;
import com.aron.users.msvc_users.service.UserService;



@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> list(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> detail(@PathVariable Long id){
        Optional<User> optional = userService.findById(id);
        if(optional.isPresent()){
            return ResponseEntity.ok(optional.get());
        } else{
            return ResponseEntity.notFound().build();
        }
    }

}
