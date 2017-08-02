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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author apprentice
 */
public class HeroDaoDBImplTest {

    HeroDao dao;

    @Inject
    public HeroDaoDBImplTest() {

    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean("daoDBImpl", HeroDaoDBImpl.class);

        List<Hero> heroList = dao.getAllHeros();
        for (Hero hero : heroList) {
            dao.deleteHero(hero.getHeroID());
        }

        List<Location> locationList = dao.getAllLocations();
        for (Location location : locationList) {
            dao.deleteLocation(location.getLocationID());
        }

        List<Organization> organizationList = dao.getAllOrganizations();
        for (Organization organization : organizationList) {
            dao.deleteOrganization(organization.getOrganizationID());
        }

        List<Power> powerList = dao.getAllPowers();
        for (Power power : powerList) {
            dao.deletePower(power.getPowerID());
        }

        List<Sighting> sightingList = dao.getAllSightings();
        for (Sighting sighting : sightingList) {
            dao.deleteSighting(sighting.getSightingID());
        }

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of herosByLocation method, of class HeroDaoDBImpl.
     */
    @Test
    public void testHerosByLocation() {
        Hero hero = new Hero();
        hero.setHeroName("Bert");
        hero.sethDescription("No taller non-man on Earth.");
        hero.setIsGoodHero(true);
        dao.createHero(hero);

        Hero hero1 = new Hero();
        hero1.setHeroName("Bert");
        hero1.sethDescription("No taller non-man on Earth.");
        hero1.setIsGoodHero(true);
        dao.createHero(hero1);

        Location location = new Location();
        location.setLocationName("AppleBee's");
        location.setlDescription("Local Neighborhood Bar and Grill");
        location.setAddress("1075 freeport st Elk River, MN 55330");
        location.setLatitude(new BigDecimal("55.15"));
        location.setLongitude(new BigDecimal("12.34"));
        dao.createLocation(location);

        Sighting sighting = new Sighting();
        sighting.setHero(hero);
        sighting.setLocation(location);
        sighting.setSightDate(LocalDate.now());
        dao.createSighting(sighting);

        Sighting sighting1 = new Sighting();
        sighting1.setHero(hero1);
        sighting1.setLocation(location);
        sighting1.setSightDate(LocalDate.now());
        dao.createSighting(sighting1);

        assertEquals(2, dao.herosByLocation(location).size());

    }

    /**
     * Test of locationsByHero method, of class HeroDaoDBImpl.
     */
    @Test
    public void testLocationsByHero() {
        Hero hero = new Hero();
        hero.setHeroName("Bert");
        hero.sethDescription("No taller non-man on Earth.");
        hero.setIsGoodHero(true);
        dao.createHero(hero);

        Location location = new Location();
        location.setLocationName("AppleBee's");
        location.setlDescription("Local Neighborhood Bar and Grill");
        location.setAddress("1075 freeport st Elk River, MN 55330");
        location.setLatitude(new BigDecimal("55.15"));
        location.setLongitude(new BigDecimal("12.34"));
        dao.createLocation(location);

        Location location1 = new Location();
        location1.setLocationName("AppleBee's");
        location1.setlDescription("Local Neighborhood Bar and Grill");
        location1.setAddress("1075 freeport st Elk River, MN 55330");
        location1.setLatitude(new BigDecimal("55.15"));
        location1.setLongitude(new BigDecimal("12.34"));
        dao.createLocation(location1);

        Sighting sighting = new Sighting();
        sighting.setHero(hero);
        sighting.setLocation(location);
        sighting.setSightDate(LocalDate.now());
        dao.createSighting(sighting);

        Sighting sighting1 = new Sighting();
        sighting1.setHero(hero);
        sighting1.setLocation(location1);
        sighting1.setSightDate(LocalDate.now());
        dao.createSighting(sighting1);

        assertEquals(2, dao.locationsByHero(hero).size());
    }

    /**
     * Test of sightingsByDate method, of class HeroDaoDBImpl.
     */
    @Test
    public void testSightingsByDate() {
        Hero hero = new Hero();
        hero.setHeroName("Bert");
        hero.sethDescription("No taller non-man on Earth.");
        hero.setIsGoodHero(true);
        dao.createHero(hero);

        Location location = new Location();
        location.setLocationName("AppleBee's");
        location.setlDescription("Local Neighborhood Bar and Grill");
        location.setAddress("1075 freeport st Elk River, MN 55330");
        location.setLatitude(new BigDecimal("55.15"));
        location.setLongitude(new BigDecimal("12.34"));
        dao.createLocation(location);

        Location location1 = new Location();
        location1.setLocationName("AppleBee's");
        location1.setlDescription("Local Neighborhood Bar and Grill");
        location1.setAddress("1075 freeport st Elk River, MN 55330");
        location1.setLatitude(new BigDecimal("55.15"));
        location1.setLongitude(new BigDecimal("12.34"));
        dao.createLocation(location1);

        LocalDate ld = LocalDate.now();

        Sighting sighting = new Sighting();
        sighting.setHero(hero);
        sighting.setLocation(location);
        sighting.setSightDate(ld);
        dao.createSighting(sighting);

        Sighting sighting1 = new Sighting();
        sighting1.setHero(hero);
        sighting1.setLocation(location1);
        sighting1.setSightDate(ld);
        dao.createSighting(sighting1);

        int numSightings = dao.sightingsByDate(ld).size();
        assertEquals(2, numSightings);
    }

    /**
     * Test of herosByOrganization method, of class HeroDaoDBImpl.
     */
    @Test
    public void testHerosByOrganization() {
        Hero hero = new Hero();
        hero.setHeroName("Bert");
        hero.sethDescription("No taller non-man on Earth.");
        hero.setIsGoodHero(true);
        dao.createHero(hero);

        Hero hero1 = new Hero();
        hero1.setHeroName("Bert");
        hero1.sethDescription("No taller non-man on Earth.");
        hero1.setIsGoodHero(true);
        dao.createHero(hero1);

        List<Organization> o = new ArrayList<>();

        Organization organization = new Organization();
        organization.setOrgName("E.V.I.L.");
        organization.setoDescription("Every Villain is Lemons");
        organization.setAddress("bikini bottom");
        organization.setPhoneNumber("6549873214");
        dao.createOrganization(organization);

        o.add(organization);
        hero.setOrganizations(o);
        hero1.setOrganizations(o);
        dao.createHeroOrganizations(hero);
        dao.createHeroOrganizations(hero1);
        assertEquals(2, dao.herosByOrganization(organization).size());

    }

    /**
     * Test of organizationsByHero method, of class HeroDaoDBImpl.
     */
    @Test
    public void testOrganizationsByHero() {
        Hero hero = new Hero();
        hero.setHeroName("Bert");
        hero.sethDescription("No taller non-man on Earth.");
        hero.setIsGoodHero(true);
        dao.createHero(hero);
        
        Organization organization = new Organization();
        organization.setOrgName("E.V.I.L.");
        organization.setoDescription("Every Villain is Lemons");
        organization.setAddress("bikini bottom");
        organization.setPhoneNumber("6549873214");
        dao.createOrganization(organization);
        
        Organization organization1 = new Organization();
        organization1.setOrgName("E.V.I.L.");
        organization1.setoDescription("Every Villain is Lemons");
        organization1.setAddress("bikini bottom");
        organization1.setPhoneNumber("6549873214");
        dao.createOrganization(organization1);
        
        List<Organization> o = new ArrayList<>();
        o.add(organization);
        o.add(organization1);
        hero.setOrganizations(o);
        dao.createHeroOrganizations(hero);
        assertEquals(2,dao.organizationsByHero(hero).size());
    }

    /**
     * Test of createHero method, of class HeroDaoDBImpl.
     */
    @Test
    public void testCreateHero() {
        Hero hero = new Hero();
        hero.setHeroName("Bert");
        hero.sethDescription("No taller non-man on Earth.");
        hero.setIsGoodHero(true);
        dao.createHero(hero);
        assertEquals(hero, dao.getHero(hero.getHeroID()));
    }

    /**
     * Test of createLocation method, of class HeroDaoDBImpl.
     */
    @Test
    public void testCreateLocation() {
        Location location = new Location();
        location.setLocationName("AppleBee's");
        location.setlDescription("Local Neighborhood Bar and Grill");
        location.setAddress("1075 freeport st Elk River, MN 55330");
        location.setLatitude(new BigDecimal("55.15"));
        location.setLongitude(new BigDecimal("12.34"));
        dao.createLocation(location);
        Location l = dao.getLocation(location.getLocationID());
        assertEquals(location, l);
    }

    /**
     * Test of createOrganization method, of class HeroDaoDBImpl.
     */
    @Test
    public void testCreateOrganization() {
        Organization organization = new Organization();
        organization.setOrgName("E.V.I.L.");
        organization.setoDescription("Every Villain is Lemons");
        organization.setAddress("bikini bottom");
        organization.setPhoneNumber("6549873214");
        dao.createOrganization(organization);
        assertEquals(organization, dao.getOrganization(organization.getOrganizationID()));
    }

    /**
     * Test of createPower method, of class HeroDaoDBImpl.
     */
    @Test
    public void testCreatePower() {
        Power power = new Power();
        power.setpDescription("Bubble Ray");
        dao.createPower(power);
        assertEquals(power, dao.getPower(power.getPowerID()));

    }

    /**
     * Test of createSighting method, of class HeroDaoDBImpl.
     */
    @Test
    public void testCreateSighting() {

        Hero hero = new Hero();
        hero.setHeroName("Bert");
        hero.sethDescription("No taller non-man on Earth.");
        hero.setIsGoodHero(true);
        dao.createHero(hero);

        Location location = new Location();
        location.setLocationName("AppleBee's");
        location.setlDescription("Local Neighborhood Bar and Grill");
        location.setAddress("1075 freeport st Elk River, MN 55330");
        location.setLatitude(new BigDecimal("55.15"));
        location.setLongitude(new BigDecimal("12.34"));
        dao.createLocation(location);

        Sighting sighting = new Sighting();
        sighting.setHero(hero);
        sighting.setLocation(location);
        sighting.setSightDate(LocalDate.now());
        dao.createSighting(sighting);
        java.sql.Date.valueOf(LocalDate.now());
        Sighting s = dao.getSighting(sighting.getSightingID());
        assertEquals(sighting, s);
    }

    /**
     * Test of updateHero method, of class HeroDaoDBImpl.
     */
    @Test
    public void testUpdateHero() {
        Hero hero = new Hero();
        hero.setHeroName("Bert");
        hero.sethDescription("No taller non-man on Earth.");
        hero.setIsGoodHero(true);
        dao.createHero(hero);

        hero.setHeroName("The Quickster");
        dao.updateHero(hero);
        assertEquals(hero, dao.getHero(hero.getHeroID()));

    }

    /**
     * Test of updateLocation method, of class HeroDaoDBImpl.
     */
    @Test
    public void testUpdateLocation() {
        Location location = new Location();
        location.setLocationName("AppleBee's");
        location.setlDescription("Local Neighborhood Bar and Grill");
        location.setAddress("1075 freeport st Elk River, MN 55330");
        location.setLatitude(new BigDecimal("55.15"));
        location.setLongitude(new BigDecimal("12.34"));
        dao.createLocation(location);

        location.setAddress("9970 sunwood Drive Ramsey, MN 55303");
        dao.updateLocation(location);
        assertEquals(location, dao.getLocation(location.getLocationID()));

    }

    /**
     * Test of updateOrganization method, of class HeroDaoDBImpl.
     */
    @Test
    public void testUpdateOrganization() {
        Organization organization = new Organization();
        organization.setOrgName("E.V.I.L.");
        organization.setoDescription("Every Villain is Lemons");
        organization.setAddress("bikini bottom");
        organization.setPhoneNumber("6549873214");
        dao.createOrganization(organization);

        organization.setOrgName("I.J.L.S.A.");
        dao.updateOrganization(organization);
        assertEquals(organization, dao.getOrganization(organization.getOrganizationID()));
    }

    /**
     * Test of updatePower method, of class HeroDaoDBImpl.
     */
    @Test
    public void testUpdatePower() {
        Power power = new Power();
        power.setpDescription("Bubble Ray");
        dao.createPower(power);

        power.setpDescription("Run Fast!");
        dao.updatePower(power);
        assertEquals(power, dao.getPower(power.getPowerID()));
    }

    /**
     * Test of updateSighting method, of class HeroDaoDBImpl.
     */
    @Test
    public void testUpdateSighting() {
        Hero hero = new Hero();
        hero.setHeroName("Bert");
        hero.sethDescription("No taller non-man on Earth.");
        hero.setIsGoodHero(true);
        dao.createHero(hero);

        Location location = new Location();
        location.setLocationName("AppleBee's");
        location.setlDescription("Local Neighborhood Bar and Grill");
        location.setAddress("1075 freeport st Elk River, MN 55330");
        location.setLatitude(new BigDecimal("55.15"));
        location.setLongitude(new BigDecimal("12.34"));
        dao.createLocation(location);

        Location location1 = new Location();
        location1.setLocationName("AppleBerps");
        location1.setlDescription("burgers and fries, guys");
        location1.setAddress("1075 newport st Elk River, MN 55330");
        location1.setLatitude(new BigDecimal("55.15"));
        location1.setLongitude(new BigDecimal("12.32"));
        dao.createLocation(location1);

        Sighting sighting = new Sighting();
        sighting.setHero(hero);
        sighting.setLocation(location);
        sighting.setSightDate(LocalDate.now());
        dao.createSighting(sighting);
        Sighting s = dao.getSighting(sighting.getSightingID());

        sighting.setLocation(location1);
        dao.updateSighting(sighting);
        assertEquals(sighting, dao.getSighting(sighting.getSightingID()));

    }

    /**
     * Test of deleteHero method, of class HeroDaoDBImpl.
     */
    @Test
    public void testDeleteHero() {
        Hero hero = new Hero();
        hero.setHeroName("Bert");
        hero.sethDescription("No taller non-man on Earth.");
        hero.setIsGoodHero(true);
        dao.createHero(hero);

        dao.deleteHero(hero.getHeroID());
        assertEquals(0, dao.getAllHeros().size());
    }

    /**
     * Test of deleteLocation method, of class HeroDaoDBImpl.
     */
    @Test
    public void testDeleteLocation() {
        Location location = new Location();
        location.setLocationName("AppleBee's");
        location.setlDescription("Local Neighborhood Bar and Grill");
        location.setAddress("1075 freeport st Elk River, MN 55330");
        location.setLatitude(new BigDecimal("55.15"));
        location.setLongitude(new BigDecimal("12.34"));
        dao.createLocation(location);

        dao.deleteLocation(location.getLocationID());
        assertEquals(0, dao.getAllLocations().size());
    }

    /**
     * Test of deleteOrganization method, of class HeroDaoDBImpl.
     */
    @Test
    public void testDeleteOrganization() {
        Organization organization = new Organization();
        organization.setOrgName("E.V.I.L.");
        organization.setoDescription("Every Villain is Lemons");
        organization.setAddress("bikini bottom");
        organization.setPhoneNumber("6549873214");
        dao.createOrganization(organization);

        dao.deleteOrganization(organization.getOrganizationID());
        assertEquals(0, dao.getAllOrganizations().size());
        //associate with hero
    }

    /**
     * Test of deletePower method, of class HeroDaoDBImpl.
     */
    @Test
    public void testDeletePower() {
        Power power = new Power();
        power.setpDescription("Bubble Ray");
        dao.createPower(power);

        dao.deletePower(power.getPowerID());
        assertEquals(0, dao.getAllPowers().size());
    }

    /**
     * Test of deleteSighting method, of class HeroDaoDBImpl.
     */
    @Test
    public void testDeleteSighting() {
        Hero hero = new Hero();
        hero.setHeroName("Bert");
        hero.sethDescription("No taller non-man on Earth.");
        hero.setIsGoodHero(true);
        dao.createHero(hero);

        Location location = new Location();
        location.setLocationName("AppleBee's");
        location.setlDescription("Local Neighborhood Bar and Grill");
        location.setAddress("1075 freeport st Elk River, MN 55330");
        location.setLatitude(new BigDecimal("55.15"));
        location.setLongitude(new BigDecimal("12.34"));
        dao.createLocation(location);

        Sighting sighting = new Sighting();
        sighting.setHero(hero);
        sighting.setLocation(location);
        sighting.setSightDate(LocalDate.now());
        dao.createSighting(sighting);
        java.sql.Date.valueOf(LocalDate.now());
        Sighting s = dao.getSighting(sighting.getSightingID());

        dao.deleteSighting(sighting.getSightingID());
        assertEquals(0, dao.getAllSightings().size());
    }

}
