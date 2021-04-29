package com.lambdaschool.foundation.repository;

import com.lambdaschool.foundation.models.Species;
import org.springframework.data.repository.CrudRepository;

public interface SpeciesRepository extends CrudRepository<Species, Long> {
}
