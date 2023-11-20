package com.exacto.cliAuthentication.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exacto.cliAuthentication.entity.AuditContactInfo;
import com.exacto.cliAuthentication.entity.ValidContactInfo;
import com.exacto.cliAuthentication.repo.AuditContactRepo;
import com.exacto.cliAuthentication.repo.ValidNumRepo;

@Service
public class ContactInfoService {
	
	    @Autowired
	    private ValidNumRepo validRepo;
	    
	    @Autowired
	    private AuditContactRepo auditContactRepo;
	    
	    
	  
	    public ContactInfoService(ValidNumRepo validRepo , AuditContactRepo auditContactRepo) {
	        this.validRepo = validRepo;
	        this.auditContactRepo=auditContactRepo;
	    }

	    public List<ValidContactInfo> getAllValidContacts() {
	        return validRepo.findAll();
	    }

	    public Optional<ValidContactInfo> getValidContactById(Long id) {
	        return validRepo.findById(id);
	    }

	    public ValidContactInfo saveValidContact(ValidContactInfo contact) {
	        return validRepo.save(contact);
	    }
	    
	    public boolean getValidDetailsByPhoneNo(String customerPhoneNum) {
	    	Optional<ValidContactInfo> contact = validRepo.findByPhoneNum(customerPhoneNum);
	        return contact.isPresent();
	    }
	    
	    public boolean getValidDetailsByDisplayNo(String displayNum) {
	    	Optional<ValidContactInfo> contact = validRepo.findByPhoneNum(displayNum);
	        return contact.isPresent();
	    }
	    
	    public List<AuditContactInfo> getAllContacts() {
	        return auditContactRepo.findAll();
	    }

	    public Optional<AuditContactInfo> getContactById(Long id) {
	        return auditContactRepo.findById(id);
	    }

	    public AuditContactInfo saveInvalidContact(AuditContactInfo contact) {
	        return auditContactRepo.save(contact);
	    }
	    
	    public List<AuditContactInfo> getAuditDetailsByPhoneNo(String phoneNumber) {
	        return auditContactRepo.findByPhoneNum(phoneNumber);
	    }
	    
	    public List<AuditContactInfo> getAuditDetailsByStatus(String status) {
	        return auditContactRepo.findByStatus(status);
	    }

	    public List<AuditContactInfo> getAuditDetailsByName(String name) {
	        return auditContactRepo.findByPhoneName(name);
	    }

	    public List<AuditContactInfo> getAuditDetailsBetweenDate(Date startDate, Date endDate) {
	        return auditContactRepo.findByDateBetween(startDate, endDate);
	    }

	    public void updateAuditContact(AuditContactInfo updatedContact) {
	        AuditContactInfo existingContact = auditContactRepo.findById(updatedContact.getId()).orElse(null);
	        if (existingContact != null) {
	            // Update the fields of the existing contact with the new values
	            existingContact.setPhoneName(updatedContact.getPhoneName());
	            existingContact.setPhoneNum(updatedContact.getPhoneNum());
	            // Update other fields as needed
	            auditContactRepo.save(existingContact);
	        }
	    }

	
	   
		public void deleteAuditContactById(Long id) {
			// TODO Auto-generated method stub
			auditContactRepo.deleteById(id);
			
		}
		
		public void addCallDetails(AuditContactInfo contactInfo) {
		    String displayNumber = contactInfo.getDisplayNum();
		    Optional<ValidContactInfo> contact = validRepo.findByDisplayNum(displayNumber);
		    if (contact.isPresent()) {
		        contactInfo.setStatus("valid");
		    } else {
		        contactInfo.setStatus("invalid");
		    }
		    auditContactRepo.save(contactInfo);
		}
	    }


	    
