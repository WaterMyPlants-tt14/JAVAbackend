package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Plant;
import com.lambdaschool.foundation.views.PlantView;

import java.util.List;

public interface PlantService {
    Plant save (Plant plant);

    List<PlantView> findAllMyPlants(long id);
}
