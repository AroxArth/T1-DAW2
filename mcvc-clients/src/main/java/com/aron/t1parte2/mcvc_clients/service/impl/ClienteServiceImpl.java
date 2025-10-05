package com.aron.t1parte2.mcvc_clients.service.impl;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aron.t1parte2.mcvc_clients.client.UserFeignClient;
import com.aron.t1parte2.mcvc_clients.model.Clientes;
import com.aron.t1parte2.mcvc_clients.model.User;
import com.aron.t1parte2.mcvc_clients.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private UserFeignClient userFeignClient;

    @Override
    public List<Clientes> findAll() {
        List<User> users = userFeignClient.list().getBody();

        return users.stream().map(user -> {
            String usuario = user.nombres().toLowerCase() + "." + user.apellidos().toLowerCase();

            String contraseña = generateRandomPassword(8);

            return new Clientes(user, usuario, contraseña);
        }).collect(Collectors.toList());
    }

    @Override
    public Optional<Clientes> findById(Long id) {

        User user = userFeignClient.detail(id).getBody();

        String usuario = user.nombres().toLowerCase() + "." + user.apellidos().toLowerCase();

        String contraseña = generateRandomPassword(8);

        Clientes cliente = new Clientes(user, usuario, contraseña);

        return Optional.of(cliente);
    }

    private String generateRandomPassword(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            password.append(chars.charAt(index));
        }
        
        return password.toString();
    }
}
