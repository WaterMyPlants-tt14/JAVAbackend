package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Plant;
import com.lambdaschool.foundation.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "plantService")
public class PlantServiceImpl implements PlantService {
    @Autowired
    private PlantRepository plantRepository;

    @Override
    public Plant save(Plant plant) {
        return plantRepository.save(plant);
    }
}
