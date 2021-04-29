package com.lambdaschool.foundation.controllers;

import com.lambdaschool.foundation.models.Plant;
import com.lambdaschool.foundation.models.User;
import com.lambdaschool.foundation.services.PlantService;
import com.lambdaschool.foundation.services.UserService;
import com.lambdaschool.foundation.views.PlantView;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/userplants")
public class PlantController {
    @Autowired
    PlantService plantService;

    @Autowired
    UserService userService;


//    @ApiOperation(value = "returns the currently authenticated user",
//            response = User.class)
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<PlantView>> getAllMyPlants(Authentication authentication) {
        User client = userService.findByName(authentication.getName());
        List<PlantView> plants = plantService.findAllMyPlants(client.getUser_id());
        return new ResponseEntity<>(plants, HttpStatus.OK);
    }
}
