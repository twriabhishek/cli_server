package com.exacto.cliAuthentication;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exacto.cliAuthentication.entity.AuditContactInfo;
import com.exacto.cliAuthentication.entity.User;
import com.exacto.cliAuthentication.service.ContactInfoService;
import com.exacto.cliAuthentication.service.UserService;


@RestController
@CrossOrigin(origins="http://localhost:3000")
public class UserWebSocketController {
    @Autowired
    private ContactInfoService userservice;
    
    @Autowired
    private SimpMessagingTemplate messagingTemplate;


    @MessageMapping("/hello")
    @SendTo("/topic/auditContacts")
    public List<AuditContactInfo> handleConnection() throws InterruptedException {
        // Replace this with your actual logic to fetch and send user data
        List<AuditContactInfo> users = userservice.getAllContacts();
        return users;
    }
    
    @PostMapping("/app/add")
	public ResponseEntity<String> addUser(@RequestBody AuditContactInfo user) {
		userservice.addCallDetails(user);
        messagingTemplate.convertAndSend("/topic/auditContacts", userservice.getAllContacts());
        // Return a success response
        return new ResponseEntity<>("User added successfully", HttpStatus.OK);
	}   


    // @PutMapping("/app/update")
	// public  ResponseEntity<String>  updateUser(@RequestBody User user) {
	// 	userservice.updateUser(user);
    //     messagingTemplate.convertAndSend("/topic/users", userservice.getUsers());
    //     // Return a success response
    //     return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
	// }

	// @DeleteMapping("/app/delete/{userId}")
	// public ResponseEntity<String>  deleteUser(@PathVariable String userId) {
	//     userservice.deleteUser(Long.parseLong(userId));
    //     messagingTemplate.convertAndSend("/topic/users", userservice.getUsers());
    //     // Return a success response
    //     return new ResponseEntity<>("User Deleted successfully", HttpStatus.OK);
	// } 

}

