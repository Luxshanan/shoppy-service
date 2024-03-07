package com.lcorp.shoppyservice.controller;

import com.lcorp.shoppyservice.model.User;
import com.lcorp.shoppyservice.payload.response.MessageResponse;
import com.lcorp.shoppyservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path ="api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?>  createUser(@RequestBody User user){

        if (userService.checkExistingUser(user)) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("User already exists under given mail"));
        }
        User newUser =userService.createUser(user);

        return new ResponseEntity<User>(newUser, new HttpHeaders(), HttpStatus.CREATED);
    }
}
