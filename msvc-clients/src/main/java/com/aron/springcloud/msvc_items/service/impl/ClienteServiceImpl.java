package com.aron.springcloud.msvc_items.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aron.springcloud.msvc_items.client.ClienteFeignClient;
import com.aron.springcloud.msvc_items.model.Cliente;
import com.aron.springcloud.msvc_items.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteFeignClient productFeignClient;

    @Override
    public List<Cliente> findAll() {
        return productFeignClient.list().getBody().stream().map(user ->{
            String usuario = user.nombres() + user.apellidos();
            return new Cliente(user, usuario, "contrasenia" + new Random().nextInt(10));
        }).collect(Collectors.toList());
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        var user = productFeignClient.detail(id).getBody();
        String usuario = user.nombres() + user.apellidos();
        return Optional.of(new Cliente(user, usuario, "contrasenia" + new Random().nextInt(10)));
    }
}