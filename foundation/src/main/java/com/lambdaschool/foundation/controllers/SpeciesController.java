package com.lambdaschool.foundation.controllers;

import com.lambdaschool.foundation.models.Species;
import com.lambdaschool.foundation.services.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/species")
public class SpeciesController {
    @Autowired
    SpeciesService speciesService;

    @GetMapping(produces = "application/json")
    ResponseEntity<List<Species>> getAllSpecies (Authentication authentication) {
        return new ResponseEntity<>(speciesService.findAll(), HttpStatus.OK);
    }
}
