/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.model;

import java.util.Objects;

/**
 *
 * @author apprentice
 */
public class Power {
    private int powerID;
    private String pDescription;
    
    public void setPowerID(int powerID) {
        this.powerID = powerID;
    }
    
    public int getPowerID() {
        return powerID;
    }

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.powerID;
        hash = 53 * hash + Objects.hashCode(this.pDescription);
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
        final Power other = (Power) obj;
        if (this.powerID != other.powerID) {
            return false;
        }
        if (!Objects.equals(this.pDescription, other.pDescription)) {
            return false;
        }
        return true;
    }
    
    
}
