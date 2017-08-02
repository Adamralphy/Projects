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
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import javax.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author apprentice
 */
public class HeroDaoDBImpl implements HeroDao {

    //private static final String SELECT_HEROS_BY_LOCATION = "SELECT * FROM heroLocation WHERE locationID = ?";
    //private static final String SELECT_LOCATIONS_BY_HERO = "SELECT * FROM heroLocation WHERE heroID = ?";
    //private static final String SELECT_SIGHTINGS_BY_DATE = "SELECT * FROM heroLocation WHERE sightDate = ?";
    //private static final String SELECT_HEROS_BY_ORGANIZATION = "SELECT * FROM heroOrganization WHERE organizationID = ?";
    //private static final String SELECT_ORGANIZATIONS_BY_HERO = "SELECT * FROM heroOrganization WHERE heroID = ?";
    private static final String SELECT_HEROS_BY_LOCATION = "SELECT hero.* FROM sighting"
            + " JOIN hero ON hero.heroID = sighting.heroID"
            + " WHERE locationID = ?";

    private static final String SELECT_LOCATIONS_BY_HERO = "SELECT location.* FROM sighting"
            + " JOIN location ON location.locationID = sighting.locationID"
            + " WHERE sighting.heroID = ?";

    private static final String SELECT_SIGHTINGS_BY_DATE = "SELECT * FROM sighting"
            + " JOIN location ON location.locationID = sighting.locationID"
            + " JOIN hero ON hero.heroID = sighting.heroID"
            + " WHERE sightDate = ?";

    private static final String SELECT_HEROS_BY_ORGANIZATION = "SELECT hero.* FROM heroOrganization"
            + " JOIN hero ON hero.heroID = heroOrganization.heroID"
            + " WHERE organizationID = ?";

    private static final String SELECT_ORGANIZATIONS_BY_HERO = "SELECT organization.* FROM heroOrganization"
            + " JOIN organization ON organization.organizationID = heroOrganization.organizationID"
            + " WHERE heroID = ?";

    private static final String INSERT_HERO = "INSERT INTO hero(heroName, description, isGoodHero)"
            + " VALUES (?,?,?)";
    private static final String INSERT_LOCATION = "INSERT INTO location(locationName, description, address, latitude, longitude)"
            + " VALUES (?,?,?,?,?)";
    private static final String INSERT_POWER = "INSERT INTO superPower(description)"
            + " VALUES (?)";
    private static final String INSERT_ORGANIZATION = "INSERT INTO organization(orgName, description, address, phoneNumber)"
            + " VALUES (?,?,?,?)";
    private static final String INSERT_SIGHTING = "INSERT INTO sighting(sightDate, heroID, locationID)"
            + " VALUES (?,?,?)";
    private static final String INSERT_HERO_ORGANIZATION = "INSERT INTO heroOrganization (heroID, organizationID)"
            + " VALUES (?,?)";
    private static final String INSERT_HERO_POWER = "INSERT INTO heroPowers (heroID, powerID)"
            + " VALUES (?,?)";

    private static final String SELECT_HERO = "SELECT * FROM hero WHERE heroID = ?";
    private static final String SELECT_LOCATION = "SELECT * FROM location WHERE locationID = ?";
    private static final String SELECT_POWER = "SELECT * FROM superPower WHERE powerID = ?";
    private static final String SELECT_ORGANIZATION = "SELECT * FROM organization WHERE organizationID = ?";
    private static final String SELECT_SIGHTING = "SELECT * FROM sighting"
            + " JOIN location ON location.locationID = sighting.locationID"
            + " JOIN hero ON hero.heroID = sighting.heroID"
            + " WHERE sightingID = ?";

    private static final String UPDATE_HERO = "UPDATE hero SET heroName = ?, description = ?, isGoodHero = ?"
            + " WHERE heroID = ?";
    private static final String UPDATE_LOCATION = "UPDATE location SET locationName = ?, description = ?, address = ?, latitude = ?, longitude = ?"
            + " WHERE locationID = ?";
    private static final String UPDATE_POWER = "UPDATE superPower SET description = ?"
            + " WHERE powerID = ?";
    private static final String UPDATE_ORGANIZATION = "UPDATE organization SET orgName = ?,description = ?, address = ?, phoneNumber = ?"
            + " WHERE organizationID = ?";
    private static final String UPDATE_SIGHTING = "UPDATE sighting SET sightDate = ?, heroID = ?, locationID = ?"
            + " WHERE sightingID = ?";

    private static final String DELETE_HERO = "DELETE FROM hero WHERE heroID = ?";
    private static final String DELETE_LOCATION = "DELETE FROM location WHERE locationID = ?";
    private static final String DELETE_ORGANIZATION = "DELETE FROM organization WHERE organizationID = ?";
    private static final String DELETE_POWER = "DELETE FROM superPower WHERE powerID = ?";
    private static final String DELETE_SIGHTING = "DELETE FROM sighting WHERE sightingID = ?";

    private static final String DELETE_HERO_FROM_SIGHTING = "DELETE FROM sighting WHERE heroID = ?";
    private static final String DELETE_LOCATION_FROM_SIGHTING = "DELETE FROM sighting WHERE locationID = ?";
    private static final String DELETE_HERO_FROM_HERO_ORGANIZATION = "DELETE FROM heroOrganization WHERE heroID = ?";
    private static final String DELETE_ORGANIZATION_FROM_HERO_ORGANIZATION = "DELETE FROM heroOrganization WHERE organizationID = ?";
    private static final String DELETE_HERO_HERO_POWER = "DELETE FROM heroPowers WHERE heroID = ?";
    private static final String DELETE_POWER_HERO_POWER = "DELETE FROM heroPowers WHERE powerID = ?";

    private static final String GET_ALL_HEROS = "SELECT * FROM hero";
    private static final String GET_ALL_LOCATIONS = "SELECT * FROM location";
    private static final String GET_ALL_ORGANIZATIONS = "SELECT * FROM organization";
    private static final String GET_ALL_POWERS = "SELECT * FROM superPower";
    private static final String GET_ALL_SIGHTINGS = "SELECT * FROM sighting"
            + " JOIN location ON location.locationID = sighting.locationID"
            + " JOIN hero ON hero.heroID = sighting.heroID";

    JdbcTemplate jdbcTemplate;

    @Inject
    public HeroDaoDBImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Hero> herosByLocation(Location location) {
        return jdbcTemplate.query(SELECT_HEROS_BY_LOCATION, new HeroMapper(), location.getLocationID());
    }

    @Override
    public List<Location> locationsByHero(Hero hero) {
        return jdbcTemplate.query(SELECT_LOCATIONS_BY_HERO, new LocationMapper(), hero.getHeroID());
    }

    @Override
    public List<Sighting> sightingsByDate(LocalDate sightDate) {
        return jdbcTemplate.query(SELECT_SIGHTINGS_BY_DATE, new SightingMapper(), java.sql.Date.valueOf(sightDate));
    }

    @Override
    public List<Hero> herosByOrganization(Organization organization) {
        return jdbcTemplate.query(SELECT_HEROS_BY_ORGANIZATION, new HeroMapper(), organization.getOrganizationID());
    }

    @Override
    public List<Organization> organizationsByHero(Hero hero) {
        return jdbcTemplate.query(SELECT_ORGANIZATIONS_BY_HERO, new OrganizationMapper(), hero.getHeroID());
    }

    @Override
    public Hero createHero(Hero hero) {
        jdbcTemplate.update(INSERT_HERO, hero.getHeroName(), hero.gethDescription(), hero.getIsGoodHero());
        int heroID = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        hero.setHeroID(heroID);
        createHeroPowers(hero);
        createHeroOrganizations(hero);
        return hero;
    }

    @Override
    public Location createLocation(Location location) {
        jdbcTemplate.update(INSERT_LOCATION, location.getLocationName(), location.getlDescription(), location.getAddress(), location.getLatitude(), location.getLongitude());
        int locationID = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        location.setLocationID(locationID);
        return location;
    }

    @Override
    public Organization createOrganization(Organization organization) {
        jdbcTemplate.update(INSERT_ORGANIZATION, organization.getOrgName(), organization.getoDescription(), organization.getAddress(), organization.getPhoneNumber());
        int organizationID = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        organization.setOrganizationID(organizationID);
        return organization;
    }

    @Override
    public Power createPower(Power power) {
        jdbcTemplate.update(INSERT_POWER, power.getpDescription());
        int powerID = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        power.setPowerID(powerID);
        return power;
    }

    @Override
    public Sighting createSighting(Sighting sighting) {

        jdbcTemplate.update(INSERT_SIGHTING, java.sql.Date.valueOf(sighting.getSightDate()), sighting.getHero().getHeroID(), sighting.getLocation().getLocationID());
        int sightingID = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        sighting.setSightingID(sightingID);
        return sighting;
    }

    public void createHeroOrganizations(Hero hero) {
        int heroID = hero.getHeroID();
        if (hero.getOrganizations() != null) {
            for (Organization currentOrganization : hero.getOrganizations()) {
                jdbcTemplate.update(INSERT_HERO_ORGANIZATION, heroID, currentOrganization.getOrganizationID());
            }
        }
    }

    public void createHeroPowers(Hero hero) {
        int heroID = hero.getHeroID();
        if (hero.getPowers() != null) {
            for (Power currentPower : hero.getPowers()) {
                jdbcTemplate.update(INSERT_HERO_POWER, heroID, currentPower.getPowerID());
            }
        }
    }

    @Override
    public Hero getHero(int heroID) {
        return jdbcTemplate.queryForObject(SELECT_HERO, new HeroMapper(), heroID);
    }

    @Override
    public Location getLocation(int locationID) {
        return jdbcTemplate.queryForObject(SELECT_LOCATION, new LocationMapper(), locationID);
    }

    @Override
    public Organization getOrganization(int organizationID) {
        return jdbcTemplate.queryForObject(SELECT_ORGANIZATION, new OrganizationMapper(), organizationID);
    }

    @Override
    public Power getPower(int powerID) {
        return jdbcTemplate.queryForObject(SELECT_POWER, new PowerMapper(), powerID);
    }

    @Override
    public Sighting getSighting(int sightingID) {
        return jdbcTemplate.queryForObject(SELECT_SIGHTING, new SightingMapper(), sightingID);
    }

    @Override
    public Hero updateHero(Hero hero) {
        jdbcTemplate.update(UPDATE_HERO, hero.getHeroName(), hero.gethDescription(), hero.getIsGoodHero(), hero.getHeroID());
        createHeroPowers(hero);
        return getHero(hero.getHeroID());
    }

    @Override
    public Location updateLocation(Location location) {
        jdbcTemplate.update(UPDATE_LOCATION, location.getLocationName(), location.getlDescription(),
                location.getAddress(), location.getLatitude(), location.getLongitude(), location.getLocationID());
        return getLocation(location.getLocationID());
    }

    @Override
    public Organization updateOrganization(Organization organization) {
        jdbcTemplate.update(UPDATE_ORGANIZATION, organization.getOrgName(), organization.getoDescription(),
                organization.getAddress(), organization.getPhoneNumber(), organization.getOrganizationID());
        return getOrganization(organization.getOrganizationID());
    }

    @Override
    public Power updatePower(Power power) {
        jdbcTemplate.update(UPDATE_POWER, power.getpDescription(), power.getPowerID());
        return getPower(power.getPowerID());
    }

    @Override
    public Sighting updateSighting(Sighting sighting) {
        jdbcTemplate.update(UPDATE_SIGHTING, java.sql.Date.valueOf(sighting.getSightDate()), sighting.getHero().getHeroID(), sighting.getLocation().getLocationID(), sighting.getSightingID());
        return getSighting(sighting.getSightingID());
    }

    @Override
    public Hero deleteHero(int heroID) {
        Hero hero = getHero(heroID);
        jdbcTemplate.update(DELETE_HERO_HERO_POWER, heroID);
        jdbcTemplate.update(DELETE_HERO_FROM_HERO_ORGANIZATION, heroID);
        jdbcTemplate.update(DELETE_HERO_FROM_SIGHTING, heroID);
        jdbcTemplate.update(DELETE_HERO, heroID);
        return hero;
    }

    @Override
    public Location deleteLocation(int locationID) {
        Location location = getLocation(locationID);
        jdbcTemplate.update(DELETE_LOCATION_FROM_SIGHTING, locationID);
        jdbcTemplate.update(DELETE_LOCATION, locationID);
        return location;
    }

    @Override
    public Organization deleteOrganization(int organizationID) {
        Organization organization = getOrganization(organizationID);
        jdbcTemplate.update(DELETE_ORGANIZATION_FROM_HERO_ORGANIZATION, organizationID);
        jdbcTemplate.update(DELETE_ORGANIZATION, organizationID);
        return organization;
    }

    @Override
    public Power deletePower(int powerID) {
        Power power = getPower(powerID);
        jdbcTemplate.update(DELETE_POWER_HERO_POWER, powerID);
        jdbcTemplate.update(DELETE_POWER, powerID);
        return power;
    }

    @Override
    public Sighting deleteSighting(int sightingID) {
        Sighting sighting = getSighting(sightingID);
        jdbcTemplate.update(DELETE_SIGHTING, sightingID);
        return sighting;
    }

    @Override
    public List<Hero> getAllHeros() {
        HeroMapper mapper = new HeroMapper();
        return jdbcTemplate.query(GET_ALL_HEROS, mapper);
    }

    @Override
    public List<Location> getAllLocations() {
        LocationMapper mapper = new LocationMapper();
        return jdbcTemplate.query(GET_ALL_LOCATIONS, mapper);
    }

    @Override
    public List<Organization> getAllOrganizations() {
        OrganizationMapper mapper = new OrganizationMapper();
        return jdbcTemplate.query(GET_ALL_ORGANIZATIONS, mapper);
    }

    @Override
    public List<Power> getAllPowers() {
        PowerMapper mapper = new PowerMapper();
        return jdbcTemplate.query(GET_ALL_POWERS, mapper);
    }

    @Override
    public List<Sighting> getAllSightings() {
        SightingMapper mapper = new SightingMapper();
        return jdbcTemplate.query(GET_ALL_SIGHTINGS, mapper);
    }

    private static final class HeroMapper implements RowMapper<Hero> {

        @Override
        public Hero mapRow(ResultSet rs, int i) throws SQLException {
            Hero hero = new Hero();
            hero.setHeroID(rs.getInt("heroID"));
            hero.setHeroName(rs.getString("heroName"));
            hero.sethDescription(rs.getString("description"));
            hero.setIsGoodHero(rs.getBoolean("isGoodHero"));
            return hero;
        }

    }

    private static final class LocationMapper implements RowMapper<Location> {

        @Override
        public Location mapRow(ResultSet rs, int i) throws SQLException {
            Location location = new Location();
            location.setLocationID(rs.getInt("locationID"));
            location.setLocationName(rs.getString("locationName"));
            location.setlDescription(rs.getString("description"));
            location.setAddress(rs.getString("address"));
            location.setLatitude(BigDecimal.valueOf(rs.getDouble("latitude")));
            location.setLongitude(BigDecimal.valueOf(rs.getDouble("longitude")));
            return location;
        }

    }

    private static final class OrganizationMapper implements RowMapper<Organization> {

        @Override
        public Organization mapRow(ResultSet rs, int i) throws SQLException {
            Organization organization = new Organization();
            organization.setOrganizationID(rs.getInt("organizationID"));
            organization.setOrgName(rs.getString("orgName"));
            organization.setoDescription(rs.getString("description"));
            organization.setAddress(rs.getString("address"));
            organization.setPhoneNumber(rs.getString("phoneNumber"));
            return organization;
        }

    }

    private static final class PowerMapper implements RowMapper<Power> {

        @Override
        public Power mapRow(ResultSet rs, int i) throws SQLException {
            Power power = new Power();
            power.setPowerID(rs.getInt("powerID"));
            power.setpDescription(rs.getString("description"));
            return power;
        }

    }

    private static final class SightingMapper implements RowMapper<Sighting> {

        @Override
        public Sighting mapRow(ResultSet rs, int i) throws SQLException {
            Hero hero = new Hero();
            Location location = new Location();
            Sighting sighting = new Sighting();

            hero.setHeroID(rs.getInt("heroID"));
            hero.setHeroName(rs.getString("heroName"));
            hero.sethDescription(rs.getString("hero.description"));
            hero.setIsGoodHero(rs.getBoolean("isGoodHero"));

            location.setLocationID(rs.getInt("locationID"));
            location.setLocationName(rs.getString("locationName"));
            location.setlDescription(rs.getString("location.description"));
            location.setAddress(rs.getString("address"));
            location.setLatitude(BigDecimal.valueOf(rs.getDouble("latitude")));
            location.setLongitude(BigDecimal.valueOf(rs.getDouble("longitude")));

            sighting.setSightingID(rs.getInt("sightingID"));
            sighting.setSightDate(rs.getDate("sightDate").toLocalDate());
            sighting.setHero(hero);
            sighting.setLocation(location);
            return sighting;
        }

    }
}
