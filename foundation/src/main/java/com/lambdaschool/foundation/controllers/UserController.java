package com.lambdaschool.foundation.controllers;

import com.lambdaschool.foundation.models.User;
import com.lambdaschool.foundation.services.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * The entry point for clients to access user data
 */
@RestController
@RequestMapping("/api/users")
public class UserController
{
    @Autowired
    UserService userService;

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<?> getCurrentUserInfo(Authentication authentication)
    {
        User u = userService.findByName(authentication.getName());
        return new ResponseEntity<>(u,
            HttpStatus.OK);
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<User> updateUser(Authentication authentication,
                                           @RequestBody User userUpdate) {
        User user = userService.findByName(authentication.getName());
        User newUser = userService.updateUser(user, userUpdate);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }
}