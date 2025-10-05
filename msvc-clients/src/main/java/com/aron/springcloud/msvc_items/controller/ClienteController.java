package com.aron.springcloud.msvc_items.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aron.springcloud.msvc_items.model.Cliente;
import com.aron.springcloud.msvc_items.service.ClienteService;

@RestController
@RequestMapping("/api/items")
public class ClienteController {

    @Autowired
    private ClienteService itemService;

    @GetMapping
    public ResponseEntity<List<Cliente>> list(){

        return ResponseEntity.ok(itemService.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> detail(@PathVariable Long id){
        
        Optional<Cliente> optional = itemService.findById(id);

        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.notFound().build();
            
        }

        

    }

}
