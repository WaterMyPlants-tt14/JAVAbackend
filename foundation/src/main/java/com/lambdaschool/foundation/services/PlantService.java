package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Plant;
import com.lambdaschool.foundation.models.User;
import com.lambdaschool.foundation.views.PlantSetter;
import com.lambdaschool.foundation.views.PlantView;

import java.util.List;

public interface PlantService {
    Plant save (Plant plant);
    Plant save (PlantSetter plantSetter, User user);
    Plant update (PlantSetter plantSetter, User user);

    List<PlantView> findAllMyPlants(long id);

    PlantView getPlantView(Plant updatedPlant);

    void delete(PlantSetter plantSetter, User user);
}
