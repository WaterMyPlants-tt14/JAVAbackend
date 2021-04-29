package com.lambdaschool.foundation.repository;

import com.lambdaschool.foundation.models.Plant;
import com.lambdaschool.foundation.views.PlantView;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlantRepository extends CrudRepository<Plant, Long> {
    @Query(value =
            "SELECT p.user_plant_id, " +
                    " p.plant_nickname, " +
                    " p.plant_location, " +
                    " p.water_day, " +
                    " p.notes, " +
                    " p.species_id, " +
                    " s.plant_name, " +
                    " s.plant_scientific_name," +
                    " s.water_schedule, " +
                    " s.plant_image, " +
            " FROM userplants p, species s " +
            " WHERE p.user_id=?1 " +
            " AND (p.species_id = s.species_id) ",
            nativeQuery = true)
    List<PlantView> findAllMyPlants(long id);

    @Query(value =
            "SELECT p.user_plant_id, " +
                    " p.plant_nickname, " +
                    " p.plant_location, " +
                    " p.water_day, " +
                    " p.notes, " +
                    " p.species_id, " +
                    " s.plant_name, " +
                    " s.plant_scientific_name," +
                    " s.water_schedule, " +
                    " s.plant_image, " +
                    " FROM userplants p, species s " +
                    " WHERE p.user_plant_id=?1 " +
                    " AND (p.species_id = s.species_id) ",
            nativeQuery = true)
    PlantView getPlantView(long user_plant_id);
}
