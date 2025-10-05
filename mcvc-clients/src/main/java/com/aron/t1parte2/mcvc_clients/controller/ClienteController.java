package com.aron.t1parte2.mcvc_clients.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aron.t1parte2.mcvc_clients.model.Clientes;
import com.aron.t1parte2.mcvc_clients.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Clientes>> list(){

        return ResponseEntity.ok(clienteService.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Clientes> detail(@PathVariable Long id){

        Optional<Clientes> optional = clienteService.findById(id);

        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.notFound().build();
            
        }

        

    }

}
