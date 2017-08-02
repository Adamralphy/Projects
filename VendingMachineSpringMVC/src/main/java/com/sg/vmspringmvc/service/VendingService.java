/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vmspringmvc.service;

import com.sg.vmspringmvc.dao.VendingDaoException;
import com.sg.vmspringmvc.model.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface VendingService {

    void validateAmount(String amountInserted, int choice) throws VendingServiceException, VendingDaoException;

    void validateInventory(int choice) throws VendingServiceException, VendingDaoException;

    List<Item> getAllItems() throws VendingDaoException;

    public BigDecimal getChange(BigDecimal amountInserted, int choice) throws VendingDaoException;

    Item getItem(int id) throws VendingDaoException;

    Item updateItem(int id, Item item) throws VendingDaoException;
    
    int getID();
    
    void setID(int id);
    
    void addDollar();
    
    void addQuarter();
    
    void addDime();
    
    void addNickel();
    
    BigDecimal getAmount();
    
    public void resetAmount();

}
