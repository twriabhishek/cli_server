package com.exacto.cliAuthentication.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exacto.cliAuthentication.entity.AuditContactInfo;

@Repository
public interface AuditContactRepo extends JpaRepository<AuditContactInfo, Long> {

	List<AuditContactInfo> findByPhoneNum(String phoneNumber);

	List<AuditContactInfo> findByPhoneName(String name);

	List<AuditContactInfo> findByDateBetween(Date startDate, Date endDate);

	public List<AuditContactInfo> findByStatus(String status);
	

}
