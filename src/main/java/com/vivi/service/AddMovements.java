package com.sergiu.service;


import com.sergiu.model.Movements;

import java.util.Date;

/**
 *
 * @author vivi
 */
public class AddMovements {

     public static Movements setMovements(String operation, long id, double money) {

        Movements movs = new Movements();
        Date date = new Date();
        movs.setDate(date.toString());

        switch (operation) {
            case "Registr":
                movs.setAction("Account creation");
                break;
            case "Upload_Transfer":
                movs.setAction("Transfer: Shipping $" + money + " on account N " + id);
                break;
            case "Received Transfer":
                movs.setAction("Transfer: Received $" + money + " " + "Account N " + id);
                break;
            default:
                movs.setAction("Unknown");
                break;
        }

        return that;
    }

}
