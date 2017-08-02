/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.model;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author apprentice
 */
public class Hero {
    private int heroID;
    private String heroName;
    private String hDescription;
    private boolean isGoodHero;
    private List<Organization> organizations;
    private List<Power> powers;
    

    public int getHeroID() {
        return heroID;
    }
    
    public void setHeroID(int heroID) {
        this.heroID = heroID;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String gethDescription() {
        return hDescription;
    }

    public void sethDescription(String hDescription) {
        this.hDescription = hDescription;
    }

    public boolean getIsGoodHero() {
        return isGoodHero;
    }

    public void setIsGoodHero(boolean isGoodHero) {
        this.isGoodHero = isGoodHero;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }

    public List<Power> getPowers() {
        return powers;
    }

    public void setPowers(List<Power> powers) {
        this.powers = powers;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.heroID;
        hash = 89 * hash + Objects.hashCode(this.heroName);
        hash = 89 * hash + Objects.hashCode(this.hDescription);
        hash = 89 * hash + (this.isGoodHero ? 1 : 0);
        hash = 89 * hash + Objects.hashCode(this.organizations);
        hash = 89 * hash + Objects.hashCode(this.powers);
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
        final Hero other = (Hero) obj;
        if (this.heroID != other.heroID) {
            return false;
        }
        if (this.isGoodHero != other.isGoodHero) {
            return false;
        }
        if (!Objects.equals(this.heroName, other.heroName)) {
            return false;
        }
        if (!Objects.equals(this.hDescription, other.hDescription)) {
            return false;
        }
        if (!Objects.equals(this.organizations, other.organizations)) {
            return false;
        }
        if (!Objects.equals(this.powers, other.powers)) {
            return false;
        }
        return true;
    }
    
   
    
    
    
}
