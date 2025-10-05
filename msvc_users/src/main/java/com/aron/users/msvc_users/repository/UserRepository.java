package com.aron.users.msvc_users.repository;

import org.springframework.data.repository.CrudRepository;

import com.aron.users.msvc_users.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
