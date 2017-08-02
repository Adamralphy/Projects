/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vmspringmvc.model;

import java.math.BigDecimal;

/**
 *
 * @author apprentice
 */
public class Change {

    private int dollarCoin;
    private int quarter;
    private int dime;
    private int nickel;

    public int getDollarCoin() {
        return dollarCoin;
    }

    public int getQuarter() {
        return quarter;
    }

    public int getDime() {
        return dime;
    }

    public int getNickel() {
        return nickel;
    }

    public void calculateChange(BigDecimal change) {
        dollarCoin = 0;
        quarter = 0;
        dime = 0;
        nickel = 0;
        BigDecimal oneHunnit = new BigDecimal("100");
        BigDecimal twentyFive = new BigDecimal("25");
        BigDecimal five = new BigDecimal("5");

        BigDecimal sum = change.multiply(oneHunnit);

        for (; sum.compareTo(oneHunnit) == 1 || sum.compareTo(oneHunnit) == 0; sum = sum.subtract(oneHunnit)) {
            dollarCoin++;
        }
        for (; (sum.compareTo(twentyFive) == 1) || (sum.compareTo(twentyFive) == 0); sum = sum.subtract(twentyFive)) {
            quarter++;
        }
        for (; (sum.compareTo(BigDecimal.TEN) == 1) || (sum.compareTo(BigDecimal.TEN) == 0); sum = sum.subtract(BigDecimal.TEN)) {
            dime++;
        }
        for (; (sum.compareTo(five) == 1) || (sum.compareTo(five) == 0); sum = sum.subtract(five)) {
            nickel++;
        }

    }

}
