package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.exceptions.ResourceNotFoundException;
import com.lambdaschool.foundation.models.Plant;
import com.lambdaschool.foundation.models.Species;
import com.lambdaschool.foundation.models.User;
import com.lambdaschool.foundation.repository.PlantRepository;
import com.lambdaschool.foundation.repository.SpeciesRepository;
import com.lambdaschool.foundation.views.PlantSetter;
import com.lambdaschool.foundation.views.PlantView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "plantService")
public class PlantServiceImpl implements PlantService {
    @Autowired
    private PlantRepository plantRepository;

    @Autowired
    private SpeciesRepository speciesRepository;

    @Override
    public Plant save(Plant plant) {
        return plantRepository.save(plant);
    }

    @Override
    public Plant save(PlantSetter plantSetter, User user) {
        Plant plant = new Plant();
        plant.setUser(user);
        plant.setPlant_nickname(plantSetter.getPlant_nickname());
        plant.setPlant_location(plantSetter.getPlant_location());
        plant.setWater_day(plantSetter.getWater_day());
        plant.setNotes(plantSetter.getNotes());
        Species species = speciesRepository.findById(plantSetter.getSpecies_id())
                .orElseThrow(() -> new ResourceNotFoundException("species " + plantSetter.getSpecies_id() + " not found"));
        plant.setSpecies(species);
        return plantRepository.save(plant);
    }

    @Override
    public Plant update(PlantSetter plantSetter, User user) {
        Plant plant = plantRepository.findById(plantSetter.getUser_plant_id())
                .orElseThrow(() -> new ResourceNotFoundException("plant " + plantSetter.getUser_plant_id() + " not found"));
        if (plant.getUser().getUser_id() != user.getUser_id()) {
            throw(new ResourceNotFoundException("plant " + plantSetter.getUser_plant_id() + " not found"));
        }
        if (plantSetter.getPlant_nickname() != null) {
            plant.setPlant_nickname(plantSetter.getPlant_nickname());
        }
        if (plantSetter.getPlant_location() != null) {
            plant.setPlant_location(plantSetter.getPlant_location());
        }
        if (plantSetter.water_dayHasValue) {
            plant.setWater_day(plantSetter.getWater_day());
        }
        if (plantSetter.getNotes() != null) {
            plant.setNotes(plantSetter.getNotes());
        }
        return plantRepository.save(plant);
    }

    @Override
    public List<PlantView> findAllMyPlants(long id) {
//        List<Plant> plants = new ArrayList<>();
//        plantRepository.findAll().iterator().forEachRemaining(plants::add);
//        return plants;
        return plantRepository.findAllMyPlants(id);
    }

    @Override
    public PlantView getPlantView(Plant plant) {
        return plantRepository.getPlantView(plant.getUser_plant_id());
    }

    @Override
    public void delete(PlantSetter plantSetter, User user) {
        Plant plant = plantRepository.findById(plantSetter.getUser_plant_id())
                .orElseThrow(() -> new ResourceNotFoundException("plant " + plantSetter.getUser_plant_id() + " not found"));
        if (plant.getUser().getUser_id() != user.getUser_id()) {
            throw(new ResourceNotFoundException("plant " + plantSetter.getUser_plant_id() + " not found"));
        }
        plantRepository.delete(plant);
    }
}
