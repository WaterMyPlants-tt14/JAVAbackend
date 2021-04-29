package com.lambdaschool.foundation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "userplants")
public class Plant extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long user_plant_id;

    private String plant_nickname;

    private int water_day;

    private String plant_location;

    private String notes;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties(value = "plants", allowSetters = true)
    private User user;

    @ManyToOne
    @JoinColumn(name = "species_id")
    private Species species;

    public Plant() {
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
    }

    public String getPlant_location() {
        return plant_location;
    }

    public void setPlant_location(String plantLocation) {
        this.plant_location = plantLocation;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }
}
