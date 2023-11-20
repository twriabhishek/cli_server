package com.exacto.cliAuthentication.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exacto.cliAuthentication.entity.User;

public interface UserDao extends JpaRepository<User, Long>{

}
