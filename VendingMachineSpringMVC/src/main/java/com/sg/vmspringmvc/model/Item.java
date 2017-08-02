/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vmspringmvc.model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author apprentice
 */
public class Item {

    private int id;
    private String itemName;
    private BigDecimal itemPrice;
    private int itemQuantity;    

    public Item(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.itemName);
        hash = 31 * hash + Objects.hashCode(this.itemPrice);
        hash = 31 * hash + this.itemQuantity;
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
        final Item other = (Item) obj;
        if (this.itemQuantity != other.itemQuantity) {
            return false;
        }
        if (!Objects.equals(this.itemName, other.itemName)) {
            return false;
        }
        if (!Objects.equals(this.itemPrice, other.itemPrice)) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "Name: " + itemName;
//    }
}
