package com.lambdaschool.foundation.controllers;

import com.lambdaschool.foundation.models.Plant;
import com.lambdaschool.foundation.models.User;
import com.lambdaschool.foundation.services.PlantService;
import com.lambdaschool.foundation.services.UserService;
import com.lambdaschool.foundation.views.PlantSetter;
import com.lambdaschool.foundation.views.PlantView;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userplants")
public class PlantController {
    @Autowired
    PlantService plantService;

    @Autowired
    UserService userService;


    @GetMapping(produces = "application/json")
    public ResponseEntity<List<PlantView>> getAllMyPlants(Authentication authentication) {
        User client = userService.findByName(authentication.getName());
        List<PlantView> plants = plantService.findAllMyPlants(client.getUser_id());
        return new ResponseEntity<>(plants, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<PlantView>> addPlant(Authentication authentication,
                                                    @RequestBody PlantSetter plantSetter) {
        User client = userService.findByName(authentication.getName());
        plantService.save(plantSetter, client);
        List<PlantView> plants = plantService.findAllMyPlants(client.getUser_id());
        return new ResponseEntity<>(plants, HttpStatus.OK);
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<PlantView> updatePlant(Authentication authentication,
                                                 @RequestBody PlantSetter plantSetter) {
        User client = userService.findByName(authentication.getName());
        Plant updatedPlant = plantService.update(plantSetter, client);
        PlantView view = plantService.getPlantView(updatedPlant);
        return new ResponseEntity<>(view, HttpStatus.OK);
    }
}
