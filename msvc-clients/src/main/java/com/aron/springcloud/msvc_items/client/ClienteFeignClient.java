package com.aron.springcloud.msvc_items.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.aron.springcloud.msvc_items.model.User;

@FeignClient(name = "msvc-users")
public interface ClienteFeignClient {

    @GetMapping("/api/users")
    public ResponseEntity<List<User>> list();

    @GetMapping("/api/users/{id}")
    public ResponseEntity<User> detail(@PathVariable Long id);

}
