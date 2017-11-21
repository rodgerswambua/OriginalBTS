/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wambua.org.services;

import com.wambua.org.views.BussBookingView;

/**
 *
 * @author wcb family
 */
public class BusBookingService {

    /**
     * Service class that opens bus booking view for user to proceed with the booking process.
     * SRP - Single Responsibility Principle
     * Unit Test
     * Law of Separation of Concerns
     * @param deperturePoint String
     * @param busName String
     * @param destination String
     * @param depertureDate String
     */
    public static void openBookingView(String deperturePoint, String busName, String destination, String depertureDate) {
        BussBookingView bussBookingService = new BussBookingView(deperturePoint, destination, busName, depertureDate);
        bussBookingService.setLocationRelativeTo(null);
        bussBookingService.setVisible(true);
    }
}
