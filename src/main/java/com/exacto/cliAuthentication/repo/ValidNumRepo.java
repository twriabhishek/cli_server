package com.exacto.cliAuthentication.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.exacto.cliAuthentication.entity.ValidContactInfo;


@Repository
public interface ValidNumRepo extends JpaRepository<ValidContactInfo, Long> {

	Optional<ValidContactInfo> findByPhoneNum(String customerPhoneNum);
	Optional<ValidContactInfo> findByDisplayNum(String displayNum);
	
}
