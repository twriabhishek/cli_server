package com.exacto.cliAuthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exacto.cliAuthentication.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
