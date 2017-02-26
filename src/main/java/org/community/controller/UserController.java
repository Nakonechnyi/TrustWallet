package org.community.controller;

import org.community.domain.Registration;
import org.community.domain.User;
import org.community.exception.PersonAlreadyRegisteredException;
import org.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by a.nakonechnyi on 26.02.2017.
 */
@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public HttpEntity<?> registration(@RequestBody @Validated User registration){
        try {
            userService.register(registration);
        } catch (PersonAlreadyRegisteredException e) {
            return ResponseEntity.badRequest().body("<a href='/index'>Login already exists</a> "); //TODO
        }
        return ResponseEntity.ok("<a href='/api'>Successful registration! To API...</a>");
    }

}
