package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Species;
import com.lambdaschool.foundation.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "speciesService")
public class SpeciesServiceImpl implements SpeciesService {
    @Autowired
    private SpeciesRepository speciesRepository;

    public Species save(Species species) {
        return speciesRepository.save(species);
    }

    @Override
    public List<Species> findAll() {
         List<Species> list = new ArrayList<>();
         speciesRepository.findAll().iterator().forEachRemaining(list::add);
         return list;
    }
}
