/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vmspringmvc.service;

/**
 *
 * @author apprentice
 */
public class VendingServiceException extends Exception {

    public VendingServiceException(String message) {
        super(message);
    }

    public VendingServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}
