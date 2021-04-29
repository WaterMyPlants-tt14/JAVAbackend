package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Plant;
import com.lambdaschool.foundation.repository.PlantRepository;
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

    @Override
    public Plant save(Plant plant) {
        return plantRepository.save(plant);
    }

    @Override
    public List<PlantView> findAllMyPlants(long id) {
//        List<Plant> plants = new ArrayList<>();
//        plantRepository.findAll().iterator().forEachRemaining(plants::add);
//        return plants;
        return plantRepository.findAllMyPlants(id);
    }
}
