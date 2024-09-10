package com.libr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libr.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
