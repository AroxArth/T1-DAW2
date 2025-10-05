package com.aron.springcloud.msvc_items.service;

import java.util.List;
import java.util.Optional;

import com.aron.springcloud.msvc_items.model.Cliente;

public interface ClienteService {

    List<Cliente> findAll();

    Optional<Cliente> findById(Long id);
    
}
