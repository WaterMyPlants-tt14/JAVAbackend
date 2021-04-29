package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Species;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SpeciesService {
    Species save(Species species);

    List<Species> findAll();
}
