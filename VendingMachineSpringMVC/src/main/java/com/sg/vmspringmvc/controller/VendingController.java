/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vmspringmvc.controller;

import com.sg.vmspringmvc.dao.VendingDaoException;
import com.sg.vmspringmvc.model.Change;
import com.sg.vmspringmvc.model.Item;
import com.sg.vmspringmvc.service.VendingService;
import com.sg.vmspringmvc.service.VendingServiceException;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class VendingController {

    VendingService service;
    Change change = new Change();
    String changeString = "";
    String message = "";

    @Inject
    public VendingController(VendingService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayItems(Model model) throws VendingDaoException {
        List<Item> itemList = service.getAllItems();
        model.addAttribute("itemList", itemList);
        int itemId = service.getID();
        Item item = service.getItem(itemId);
        model.addAttribute("item", item);
        BigDecimal amount = service.getAmount();
        model.addAttribute("amount", amount);
        model.addAttribute("change", changeString);
        model.addAttribute("message",message);
        return "index";
    }

    @RequestMapping(value = "/selectItem", method = RequestMethod.POST)
    public String selectItem(Integer itemID) {
        service.setID(itemID);
        changeString = "";
        message="";
        return "redirect:/";
    }

    @RequestMapping(value = "/updateItem", method = RequestMethod.POST)
    public String updateItem() {
        return "redirect:/";
    }

    @RequestMapping(value = "/returnChange", method = RequestMethod.POST)
    public String returnChange() throws VendingDaoException {
        change.calculateChange(service.getAmount());
        service.resetAmount();
        changeString = "D: " + change.getDollarCoin()
                + "  Q: " + change.getQuarter()
                + "  d: " + change.getDime()
                + "  N: " + change.getNickel();
        message="";
        service.setID(0);
        return "redirect:/";
    }

    @RequestMapping(value = "/vend", method = RequestMethod.POST)
    public String vend() throws VendingDaoException, VendingServiceException {
        Item item = service.getItem(service.getID());
        if (item.getItemQuantity() >= 1) {
            item.setItemQuantity(item.getItemQuantity() - 1);
            service.updateItem(item.getId(), item);
            if (service.getAmount().compareTo(item.getItemPrice()) == 1 || service.getAmount().compareTo(item.getItemPrice()) == 0) {
                change.calculateChange(service.getChange(service.getAmount(), service.getID()));
                changeString = "D: " + change.getDollarCoin()
                        + "  Q: " + change.getQuarter()
                        + "  d: " + change.getDime()
                        + "  N: " + change.getNickel();
                service.resetAmount();
                message="Thank You!!";
            } else {
                BigDecimal a = item.getItemPrice().subtract(service.getAmount()) ;
                message="ERROR, please enter $" + a;
            }
        } else {
            message = "ERROR, item has depleted";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/addDollar", method = RequestMethod.POST)
    public String addDollar() {
        service.addDollar();
        changeString = "";
        message = "";
        return "redirect:/";
    }

    @RequestMapping(value = "/addQuarter", method = RequestMethod.POST)
    public String addQuarter() {
        service.addQuarter();
        changeString = "";
        message = "";
        return "redirect:/";
    }

    @RequestMapping(value = "/addDime", method = RequestMethod.POST)
    public String addDime() {
        service.addDime();
        changeString = "";
        message = "";
        return "redirect:/";
    }

    @RequestMapping(value = "/addNickel", method = RequestMethod.POST)
    public String addNickel() {
        service.addNickel();
        changeString = "";
        message = "";
        return "redirect:/";
    }

}
