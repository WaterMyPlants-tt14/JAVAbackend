package com.lambdaschool.foundation.views;

import com.lambdaschool.foundation.exceptions.ResourceNotFoundException;
import com.lambdaschool.foundation.models.Plant;
import com.lambdaschool.foundation.models.Species;

public class PlantSetter {
    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    private long user_id;

    private long user_plant_id;

    private String plant_nickname;

    private int water_day;
    public boolean water_dayHasValue = false;

    private String plant_location;

    private String notes;

    private long species_id;

    public PlantSetter() {
    }

    public long getUser_plant_id() {
        return user_plant_id;
    }

    public void setUser_plant_id(long user_plant_id) {
        this.user_plant_id = user_plant_id;
    }

    public String getPlant_nickname() {
        return plant_nickname;
    }

    public void setPlant_nickname(String plant_nickname) {
        this.plant_nickname = plant_nickname;
    }

    public int getWater_day() {
        return water_day;
    }

    public void setWater_day(int water_day) {
        this.water_day = water_day;
        this.water_dayHasValue = true;
    }

    public String getPlant_location() {
        return plant_location;
    }

    public void setPlant_location(String plant_location) {
        this.plant_location = plant_location;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public long getSpecies_id() {
        return species_id;
    }

    public void setSpecies_id(long species_id) {
        this.species_id = species_id;
    }
}
