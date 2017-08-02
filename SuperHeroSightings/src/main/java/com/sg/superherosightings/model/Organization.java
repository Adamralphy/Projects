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
public class Organization {

    private int organizationID;
    private String orgName;
    private String oDescription;
    private String address;
    private String phoneNumber;

    public void setOrganizationID(int organizationID) {
        this.organizationID = organizationID;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getoDescription() {
        return oDescription;
    }

    public void setoDescription(String oDescription) {
        this.oDescription = oDescription;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.organizationID;
        hash = 79 * hash + Objects.hashCode(this.orgName);
        hash = 79 * hash + Objects.hashCode(this.oDescription);
        hash = 79 * hash + Objects.hashCode(this.address);
        hash = 79 * hash + Objects.hashCode(this.phoneNumber);
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
        final Organization other = (Organization) obj;
        if (this.organizationID != other.organizationID) {
            return false;
        }
        if (!Objects.equals(this.orgName, other.orgName)) {
            return false;
        }
        if (!Objects.equals(this.oDescription, other.oDescription)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.phoneNumber, other.phoneNumber)) {
            return false;
        }
        return true;
    }

    
    
}
