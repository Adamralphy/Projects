/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vmspringmvc.dao;

import com.sg.vmspringmvc.model.Item;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface VendingDao {
    List<Item> getAllItems() throws VendingDaoException;

    Item updateItem(int id, Item item) throws VendingDaoException;
    
    Item getItem(int id) throws VendingDaoException;
    
    
}
