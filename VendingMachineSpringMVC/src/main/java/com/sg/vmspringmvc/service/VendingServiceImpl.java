/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vmspringmvc.service;

import com.sg.vmspringmvc.dao.VendingDao;
import com.sg.vmspringmvc.dao.VendingDaoException;
import com.sg.vmspringmvc.model.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class VendingServiceImpl implements VendingService {

    private VendingDao dao;

    public VendingServiceImpl(VendingDao dao) {
        this.dao = dao;
    }

    @Override
    public Item getItem(int id) throws VendingDaoException {
        return dao.getItem(id);
    }

    @Override
    public Item updateItem(int id, Item item) throws VendingDaoException {
        Item updatedItem = dao.updateItem(id, item);
        //auditDao.writeAuditEntry("item: " + itemName + " updated");
        return updatedItem;
    }

    @Override
    public List<Item> getAllItems() throws VendingDaoException {
        return dao.getAllItems();
    }

    @Override
    public BigDecimal getChange(BigDecimal amountInserted, int choice) throws VendingDaoException {
        Item item = getItem(choice);
        BigDecimal price = item.getItemPrice();
        //BigDecimal amt = new BigDecimal(amountInserted);
        BigDecimal sum = amountInserted.subtract(price);

        return sum;

    }

    @Override
    public void validateInventory(int choice) throws VendingServiceException, VendingDaoException {

        if (dao.getItem(choice).getItemQuantity() < 1) {
            throw new VendingServiceException("Sorry, we're all out of that item :(");
        }

    }

    @Override
    public void validateAmount(String amountInserted, int choice) throws VendingServiceException, VendingDaoException {
        Item item = getItem(choice);
        BigDecimal itemP = item.getItemPrice();
        int itemQ = item.getItemQuantity();
        BigDecimal amt = new BigDecimal(amountInserted);

        int comp = amt.compareTo(itemP);

        if (comp == -1) {
            throw new VendingServiceException("You did not enter enough money :(");
        } else {
            itemQ--;
            item.setItemQuantity(itemQ);
        }

    }

    private BigDecimal amount = BigDecimal.ZERO;
    private int itemID;

    @Override
    public void addDollar() {
        amount = amount.add(BigDecimal.ONE);
    }

    @Override
    public void addQuarter() {
        BigDecimal twentyFive = new BigDecimal(".25");
        amount = amount.add(twentyFive);
    }

    @Override
    public void addDime() {
        BigDecimal ten = new BigDecimal(".10");
        amount = amount.add(ten);
    }

    @Override
    public void addNickel() {
        BigDecimal five = new BigDecimal(".05");
        amount = amount.add(five);
    }
    @Override
    public void resetAmount() {
        amount = BigDecimal.ZERO;
    }
    
    @Override
    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public int getID() {
        return itemID;
    }

    @Override
    public void setID(int id) {
        this.itemID = id;
    }

}
