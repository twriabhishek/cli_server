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
@Table(name = "valid_contact_info")
public class ValidContactInfo {


		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(name="customer_phone_number")
	    private String phoneNum;
	    
	    @Column(name="display_num")
	    private String displayNum;
	    
	    @Column(name="customer_phone_name")
	    private String customerPhoneName;
	    
	    @Column(name = "date") 
	    @Temporal(TemporalType.TIMESTAMP)
		@CreationTimestamp
		@DateTimeFormat(pattern = "dd-MM-yyyy")
		private Date date;
	    
	    @Column(name="queue_device_identifier")
	    private String queueDeviceIdentifier;
	    
	    @Column(name="deflect_num")
	    private String deflectNum;
	    
}
