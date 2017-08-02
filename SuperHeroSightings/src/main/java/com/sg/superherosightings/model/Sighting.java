/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author apprentice
 */
public class Sighting implements Comparable<Sighting> {

    private int sightingID;
    private LocalDate sightDate;
    Hero hero = new Hero();
    Location Location = new Location();

    public int getSightingID() {
        return sightingID;
    }

    public void setSightingID(int heroLocationID) {
        this.sightingID = heroLocationID;
    }

    public LocalDate getSightDate() {
        return sightDate;
    }

    public void setSightDate(LocalDate sightDate) {
        this.sightDate = sightDate;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Location getLocation() {
        return Location;
    }

    public void setLocation(Location Location) {
        this.Location = Location;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.sightingID;
        hash = 79 * hash + Objects.hashCode(this.sightDate);
        hash = 79 * hash + Objects.hashCode(this.hero);
        hash = 79 * hash + Objects.hashCode(this.Location);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sighting other = (Sighting) obj;
        if (this.sightingID != other.sightingID) {
            return false;
        }
        if (!Objects.equals(this.sightDate, other.sightDate)) {
            return false;
        }
        if (!Objects.equals(this.hero, other.hero)) {
            return false;
        }
        if (!Objects.equals(this.Location, other.Location)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Sighting s) {
        return getSightDate().compareTo(s.getSightDate());
    }

}
