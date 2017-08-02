/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.model.dao;

import com.sg.superherosightings.model.Hero;
import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.Power;
import com.sg.superherosightings.model.Sighting;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface HeroDao {
    List<Hero> herosByLocation(Location location);
    List<Location>locationsByHero(Hero hero);
    List<Sighting>sightingsByDate(LocalDate SightDate);
    List<Hero>herosByOrganization(Organization organization);
    List<Organization>organizationsByHero(Hero hero);
    
    Hero createHero(Hero hero);
    Location createLocation(Location location);
    Organization createOrganization(Organization organization);
    Power createPower(Power power);
    Sighting createSighting(Sighting sighting);
    public void createHeroOrganizations(Hero hero);
    
    Hero getHero(int heroID);
    Location getLocation(int locationID);
    Organization getOrganization(int organizationID);
    Power getPower(int powerID);
    Sighting getSighting(int sightingID);
            
    Hero updateHero(Hero hero);
    Location updateLocation(Location location);
    Organization updateOrganization(Organization organization);
    Power updatePower(Power power);
    Sighting updateSighting(Sighting sighting);
            
    Hero deleteHero(int heroID);
    Location deleteLocation(int locationID);
    Organization deleteOrganization(int organizationID);
    Power deletePower(int powerID);
    Sighting deleteSighting(int sightingID);
    
    List<Hero> getAllHeros();
    List<Location> getAllLocations();
    List<Organization> getAllOrganizations();
    List<Power> getAllPowers();
    List<Sighting> getAllSightings();
    
    
    
}
