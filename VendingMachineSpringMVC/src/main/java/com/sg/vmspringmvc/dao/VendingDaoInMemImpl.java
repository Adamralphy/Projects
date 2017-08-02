/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vmspringmvc.dao;

import com.sg.vmspringmvc.model.Item;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apprentice
 */
public class VendingDaoInMemImpl implements VendingDao {

    public static final String DELIMITER = ",";
    public static final String INVENTORY_FILE = "items.txt";

    private Map<Integer, Item> items = new HashMap<>();

    @Override
    public Item updateItem(int id, Item item) throws VendingDaoException{
        Item currentItem = items.replace(id, item);
        writeInventory();
        return item;
    }

    @Override
    public List<Item> getAllItems() throws VendingDaoException {
        loadInventory();
        return new ArrayList<Item>(items.values());
    }

    @Override
    public Item getItem(int id) throws VendingDaoException {
        loadInventory();
        return items.get(id);
    }

    //List<VItem> item = new ArrayList<VItem>();
    private void loadInventory() throws VendingDaoException {

        Scanner scanner = null;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(getClass().getClassLoader().getResource(INVENTORY_FILE).getFile())));
        } catch (FileNotFoundException ex) {
        throw new VendingDaoException("-_- could not load vending machine data into memory.", ex);
        }

        String currentLine;

        String[] currentTokens;

        new ArrayList<>();

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Item currentItem = new Item(Integer.parseInt(currentTokens[0]));
            currentItem.setItemName(currentTokens[1]);
            currentItem.setItemPrice(new BigDecimal(currentTokens[2]));
            currentItem.setItemQuantity(Integer.parseInt(currentTokens[3]));
               
            items.put(currentItem.getId(), currentItem);
        }
        scanner.close();
    }

    private void writeInventory() throws VendingDaoException {

        PrintWriter out = null;

        try {
            out = new PrintWriter(new FileWriter(getClass().getClassLoader().getResource(INVENTORY_FILE).getFile()));
        } catch (IOException ex) {
            throw new VendingDaoException("-_- could not write vending machine data into memory.", ex);
        }

        List<Item> itemList = this.getAllItems();
        for (Item currentItem : itemList) {
            out.println(currentItem.getId() + DELIMITER
                    + currentItem.getItemName() + DELIMITER
                    + currentItem.getItemPrice() + DELIMITER
                    + currentItem.getItemQuantity());
            out.flush();
        }
        out.close();

    }

}
