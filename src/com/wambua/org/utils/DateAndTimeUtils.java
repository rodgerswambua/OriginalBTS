/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wambua.org.utils;

import com.toedter.calendar.JDateChooser;
import java.time.LocalDate;
import java.util.Calendar;

/**
 *
 * @author wcb family
 */
public class DateAndTimeUtils {
 
    public static LocalDate parseCalendarToLocalDate(Calendar calendar){
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        
        LocalDate localDate = LocalDate.of(year,(month + 1),day);
        
        return localDate;
    }

    public static Object parseCalendarToLocalDate(JDateChooser jDateChooser1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
