package com.lambdaschool.foundation.models;

import javax.persistence.*;

@Entity
@Table(name="species")
public class Species extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long species_id;

    @Column(nullable = false)
    private String plant_name;

    @Column(nullable = false)
    private String plant_scientific_name;

    private String plant_image;

    @Column(nullable = false)
    private String water_schedule;

    public Species() {
    }

    public long getSpecies_id() {
        return species_id;
    }

    public void setSpecies_id(long species_id) {
        this.species_id = species_id;
    }

    public String getPlant_name() {
        return plant_name;
    }

    public void setPlant_name(String plant_name) {
        this.plant_name = plant_name;
    }

    public String getPlant_scientific_name() {
        return plant_scientific_name;
    }

    public void setPlant_scientific_name(String plant_scientific_name) {
        this.plant_scientific_name = plant_scientific_name;
    }

    public String getPlant_image() {
        return plant_image;
    }

    public void setPlant_image(String plant_image) {
        this.plant_image = plant_image;
    }

    public String getWater_schedule() {
        return water_schedule;
    }

    public void setWater_schedule(String water_id) {
        this.water_schedule = water_id;
    }
}
