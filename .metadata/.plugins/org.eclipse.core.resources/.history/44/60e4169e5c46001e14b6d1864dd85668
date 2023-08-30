package com.example.FSD4RestAPI;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
	@Autowired
    private UserService userService; // Assuming you have a UserService to handle user operations

    @PostMapping("/createUser")
    public ResponseEntity<Map<String, String>> createUser(@RequestBody AppUser  userDTO) {
        try {

            userService.createUser(userDTO); // Assuming createUser method in your service

            Map<String, String> response = new HashMap<>();
            response.put("status", "success");
            response.put("message", "User created successfully");  
            return ResponseEntity.status(HttpStatus.OK).body(response);
           
        } catch (Exception e) {
        	Map<String, String> response = new HashMap<>();
            response.put("status", "error");
            response.put("message", "Error during login");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            //return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating user");
        }
    }
    
    @PostMapping("/checkUser/{email}")
    public ResponseEntity<Map<String, String>>checkLogin(@RequestBody AppUser  user) {
        try {
        	AppUser  foundUser = userService.findByEmail(user.getEmail());

            if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
            	 Map<String, String> response = new HashMap<>();
                 response.put("status", "success");
                 response.put("message", "Login successful");  
                 return ResponseEntity.status(HttpStatus.OK).body(response);
            } else {
            	 Map<String, String> response = new HashMap<>();
                 response.put("status", "error");
                 response.put("message", "Invalid credentials");
                 return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }
        } catch (Exception e) {
        	 Map<String, String> response = new HashMap<>();
             response.put("status", "error");
             response.put("message", "Error during login");
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

}
