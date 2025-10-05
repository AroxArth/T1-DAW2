package com.aron.t1parte2.mcvc_clients.service;

import java.util.List;
import java.util.Optional;

import com.aron.t1parte2.mcvc_clients.model.Clientes;

public interface ClienteService {

    List<Clientes> findAll();

    Optional<Clientes> findById(Long id);

}
