package com.exacto.cliAuthentication.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "audit_contact_info")
public class AuditContactInfo {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="phone_number")
    private String phoneNum;
    
    @Column(name="display_number")
    private String displayNum;
    
    @Column(name="phone_name")
    private String phoneName;
    
    @Column(name="status")
    private String status;
    
    @Column(name="date")
    @Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date date;
    
    @Column(name="monitorCrossRefID")
    private String monitorCrossRefID;
    
    @Column(name="callId")
    private String callId;
    
    @Column(name="queue_deviceIdentifier")
    private String queueDeviceIdentifier;

}
