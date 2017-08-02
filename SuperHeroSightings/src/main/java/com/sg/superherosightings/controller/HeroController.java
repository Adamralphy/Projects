/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.model.Hero;
import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.Power;
import com.sg.superherosightings.model.Sighting;
import com.sg.superherosightings.model.dao.HeroDaoDBImpl;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author apprentice
 */
@Controller
public class HeroController {

    HeroDaoDBImpl dao;
    public static final String DELIMITER = ",";
    String[] currentTokens;
    String[] currentTokens1;
    int[] currentIntTokens;
    int[] currentIntTokens1;

    @Inject
    public HeroController(HeroDaoDBImpl dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/displayHerosPage", method = RequestMethod.GET)
    public String displayHerosPage(Model model) {
        List<Hero> heroList = dao.getAllHeros();
        List<Organization> orgList = dao.getAllOrganizations();
        List<Power> powerList = dao.getAllPowers();
        model.addAttribute("heros", heroList);
        model.addAttribute("organizations", orgList);
        model.addAttribute("powers", powerList);
        return "createHero";
    }

    @RequestMapping(value = "/addHero", method = RequestMethod.POST)
    public String addHero(HttpServletRequest request) {
        List<Organization> orgList = new ArrayList<>();
        List<Power> powerList = new ArrayList<>();
        Hero hero = new Hero();
        hero.setHeroName(request.getParameter("name"));
        hero.sethDescription(request.getParameter("description"));
        String isGoodString = request.getParameter("isGood");
        boolean isGood = Boolean.parseBoolean(isGoodString);
        hero.setIsGoodHero(isGood);
        String organizationString = request.getParameter("organization");
        String powerString = request.getParameter("power");
        currentTokens = organizationString.split(DELIMITER);
        for (int i = 0; i < currentTokens.length - 1; i++) {
            Integer orgID = Integer.parseInt(currentTokens[i]);
            orgList.add(dao.getOrganization(orgID));
        }
        currentTokens1 = powerString.split(DELIMITER);
        for (int i = 0; i < currentTokens1.length; i++) {
            Integer powerID = Integer.parseInt(currentTokens1[i]);
            powerList.add(dao.getPower(powerID));
        }
        hero.setOrganizations(orgList);
        hero.setPowers(powerList);

        dao.createHero(hero);
        return "redirect:displayHerosPage";
    }

    @RequestMapping(value = "/editHero", method = RequestMethod.POST)
    public String editHero(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Hero hero = dao.getHero(id);
        List<Organization> orgList = new ArrayList<>();
        List<Power> powerList = new ArrayList<>();
        String organizationString = request.getParameter("organization");
        String powerString = request.getParameter("power");
        String name = request.getParameter("name");
        String desc = request.getParameter("description");
        String isGoodString = request.getParameter("isGood");
        boolean isGood = Boolean.parseBoolean(isGoodString);

        if (name != null) {
            hero.setHeroName(name);
        }
        if (desc != null) {
            hero.sethDescription(desc);
        }
        if (isGoodString != null) {
            hero.setIsGoodHero(isGood);
        }
        if (organizationString != null) {
            currentTokens = organizationString.split(DELIMITER);
            for (int i = 0; i < currentTokens.length - 1; i++) {
                Integer orgID = Integer.parseInt(currentTokens[i]);
                orgList.add(dao.getOrganization(orgID));
                hero.setOrganizations(orgList);
            }
        }
        if (powerString != null) {
            currentTokens1 = powerString.split(DELIMITER);
            for (int i = 0; i < currentTokens1.length; i++) {
                Integer powerID = Integer.parseInt(currentTokens1[i]);
                powerList.add(dao.getPower(powerID));
                hero.setPowers(powerList);
            }
        }

        dao.updateHero(hero);
        return "redirect:displayHerosPage";
    }

    @RequestMapping(value = "/deleteHero", method = RequestMethod.POST)
    public String deleteHero(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("hero"));
        dao.deleteHero(id);
        return "redirect:displayHerosPage";
    }

    @RequestMapping(value = "/hero/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Hero getHero(@PathVariable("id") int id) {
        return dao.getHero(id);
    }

    @RequestMapping(value = "/displayOrganizationsPage", method = RequestMethod.GET)
    public String displayOrganizationsPage(Model model) {
        List<Organization> orgList = dao.getAllOrganizations();
        model.addAttribute("organizations", orgList);
        return "createOrganization";
    }

    @RequestMapping(value = "/addOrganization", method = RequestMethod.POST)
    public String addOrganization(HttpServletRequest request) {
        Organization organization = new Organization();
        organization.setOrgName(request.getParameter("name"));
        organization.setoDescription(request.getParameter("description"));
        organization.setAddress(request.getParameter("address"));
        organization.setPhoneNumber(request.getParameter("phoneNumber"));
        dao.createOrganization(organization);
        return "redirect:displayOrganizationsPage";
    }

    @RequestMapping(value = "/editOrganization", method = RequestMethod.POST)
    public String editOrganization(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Organization organization = dao.getOrganization(id);
        String name = request.getParameter("name");
        String desc = request.getParameter("description");
        String address = request.getParameter("address");
        String phone = request.getParameter("phoneNumber");
        if (name != null) {
            organization.setOrgName(name);
        }
        if (desc != null) {
            organization.setoDescription(desc);
        }
        if (address != null) {
            organization.setAddress(address);
        }
        if (phone != null) {
            organization.setPhoneNumber(phone);
        }
        dao.updateOrganization(organization);
        return "redirect:displayOrganizationsPage";
    }

    @RequestMapping(value = "/deleteOrganization", method = RequestMethod.POST)
    public String deleteOrganization(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("organization"));
        dao.deleteOrganization(id);
        return "redirect:displayOrganizationsPage";
    }

    @RequestMapping(value = "/organization/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Organization getOrganization(@PathVariable("id") int id) {
        return dao.getOrganization(id);
    }

    @RequestMapping(value = "/displayPowersPage", method = RequestMethod.GET)
    public String displayPowersPage(Model model) {
        List<Power> powerList = dao.getAllPowers();
        model.addAttribute("powers", powerList);
        return "createPower";
    }

    @RequestMapping(value = "/addPower", method = RequestMethod.POST)
    public String addPower(HttpServletRequest request) {
        Power power = new Power();
        power.setpDescription(request.getParameter("description"));
        dao.createPower(power);
        return "redirect:displayPowersPage";
    }

    @RequestMapping(value = "/editPower", method = RequestMethod.POST)
    public String editPower(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Power power = dao.getPower(id);
        String desc = request.getParameter("description");

        if (desc != null) {
            power.setpDescription(desc);
        }

        dao.updatePower(power);
        return "redirect:displayPowersPage";
    }

    @RequestMapping(value = "/deletePower", method = RequestMethod.POST)
    public String deletePower(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("power"));
        dao.deletePower(id);
        return "redirect:displayPowersPage";
    }

    @RequestMapping(value = "/power/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Power getPower(@PathVariable("id") int id) {
        return dao.getPower(id);
    }

    @RequestMapping(value = "/displayLocationsPage", method = RequestMethod.GET)
    public String displayLocationsPage(Model model) {
        List<Location> locationList = dao.getAllLocations();
        model.addAttribute("locations", locationList);
        return "createLocation";
    }

    @RequestMapping(value = "/addLocation", method = RequestMethod.POST)
    public String addLocation(HttpServletRequest request) {
        Location location = new Location();
        location.setLocationName(request.getParameter("name"));
        location.setlDescription(request.getParameter("description"));
        location.setAddress(request.getParameter("address"));
        location.setLongitude(new BigDecimal(request.getParameter("longitude")));
        location.setLatitude(new BigDecimal(request.getParameter("latitude")));
        dao.createLocation(location);
        return "redirect:displayLocationsPage";
    }

    @RequestMapping(value = "/editLocation", method = RequestMethod.POST)
    public String editLocation(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Location location = dao.getLocation(id);
        String name = request.getParameter("name");
        String desc = request.getParameter("description");
        String address = request.getParameter("address");
        String longitude = request.getParameter("longitude");
        String latitude = request.getParameter("latitude");
        if (name != null) {
            location.setLocationName(name);
        }
        if (desc != null) {
            location.setlDescription(desc);
        }
        if (address != null) {
            location.setAddress(address);
        }
        if (longitude != null) {
            location.setLongitude(new BigDecimal(longitude));
        }
        if (latitude != null) {
            location.setLatitude(new BigDecimal(latitude));
        }
        dao.updateLocation(location);
        return "redirect:displayLocationsPage";
    }

    @RequestMapping(value = "/deleteLocation", method = RequestMethod.POST)
    public String deleteLocation(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("location"));
        dao.deleteLocation(id);
        return "redirect:displayLocationsPage";
    }

    @RequestMapping(value = "/location/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Location getLocation(@PathVariable("id") int id) {
        return dao.getLocation(id);
    }

    @RequestMapping(value = "/displaySightingsPage", method = RequestMethod.GET)
    public String displaySightingsPage(Model model) {
        List<Sighting> sightingList = dao.getAllSightings();
        List<Hero> heroList = dao.getAllHeros();
        List<Location> locationList = dao.getAllLocations();
        model.addAttribute("sightings", sightingList);
        model.addAttribute("heros", heroList);
        model.addAttribute("locations",locationList);
        return "createSighting";
    }

    @RequestMapping(value = "/addSighting", method = RequestMethod.POST)
    public String addSighting(HttpServletRequest request) {
        Sighting sighting = new Sighting();

        Hero hero = dao.getHero(Integer.parseInt(request.getParameter("hero")));
        Location location = dao.getLocation(Integer.parseInt(request.getParameter("location")));

        sighting.setHero(hero);
        sighting.setLocation(location);
        sighting.setSightDate(LocalDate.now());
        dao.createSighting(sighting);
        return "redirect:/displaySightingsPage";
    }
    
    @RequestMapping(value = "/editSighting", method = RequestMethod.POST)
    public String editSighting(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Sighting sighting = dao.getSighting(id);
        String heroString = request.getParameter("hero");
        String locationString = request.getParameter("location");
        
        if (heroString != null) {
            sighting.setHero(dao.getHero(Integer.parseInt(heroString)));
        }
        if (locationString != null) {
            sighting.setLocation(dao.getLocation(Integer.parseInt(locationString)));
        }
       
        dao.updateSighting(sighting);
         return "redirect:/displaySightingsPage";
    }

    @RequestMapping(value = "/deleteSighting", method = RequestMethod.POST)
    public String deleteSighting(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("sighting"));
        dao.deleteSighting(id);
         return "redirect:/displaySightingsPage";
    }

    @RequestMapping(value = "/sighting/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Sighting getSighting(@PathVariable("id") int id) {
        return dao.getSighting(id);
    }
    
    @RequestMapping(value="displayIndexPage", method = RequestMethod.GET)
    public String displayIndexPage(Model model) {
        List<Sighting> sightingList = dao.getAllSightings();
        Collections.sort(sightingList);
        List<Sighting> lastTen = new ArrayList<>();
        int count = 10;
        int size = sightingList.size();
        if(size<10) {
            count = size;
        }
        
        for(int i = 0;i < count; i++) {
          lastTen.add(sightingList.get(i));  
        }
        model.addAttribute("lastTen",lastTen);
        return "index";
    }

}
