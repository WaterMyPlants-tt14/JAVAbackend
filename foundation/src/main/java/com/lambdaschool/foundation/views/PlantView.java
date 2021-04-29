package com.lambdaschool.foundation.views;

import org.springframework.beans.factory.annotation.Value;

public interface PlantView {
    String getUser_plant_id();
    String getPlant_nickname();
    String getPlant_location();
    String getWater_day();
    String getNotes();
    String getSpecies_Id();
    String getPlant_name();
    String getPlant_scientific_name();
    String getWater_schedule();
    String getPlant_image();
}
