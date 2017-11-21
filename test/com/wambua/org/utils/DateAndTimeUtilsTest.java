/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wambua.org.utils;

import java.time.LocalDate;
import java.util.Calendar;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author wcb family
 */
public class DateAndTimeUtilsTest {
    Calendar calendar = Calendar.getInstance();
    LocalDate today = LocalDate.now();
    @Test
    public void parseCalendarToLocalDateTest(){
        Assert.assertEquals(today, DateAndTimeUtils.parseCalendarToLocalDate(calendar));
    }
    
}
