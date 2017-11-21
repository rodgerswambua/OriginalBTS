/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wambua.org.utils;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wcb family
 */
public class DataProcessingUtilsTest {
    
    @Test
    public void getUniqueList() {
        List<String> duplicate = new ArrayList<>();
        duplicate.add("sam");
        duplicate.add("sam");
        
        List<String> unique = new ArrayList<>();
        unique.add("sam");
        assertArrayEquals(unique.toArray(), DataProcessingUtils.getUniqueList(duplicate).toArray());
    }
   
   
}
