/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wambua.org.utils;

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
}
