/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wambua.org.utils;

import java.util.ArrayList;
import java.util.List;
/**
 * @author wcb family
 */
public class DataProcessingUtils {
    public static List<String> getUniqueList(List<String> unorderedList){
        List<String> uniqueList = new ArrayList<>();
        unorderedList.forEach( e -> {
            if(uniqueList.contains(e)){
                //skip element
            }else{
                uniqueList.add(e);
            }
        });
        System.err.println(uniqueList);
        return uniqueList;
    }
}
