package com.example.demo.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Utilities {

     public static List<HashMap<String, String>> convertToHashMap(List<Object[]> data,List<String> keys)
     {
         List<HashMap<String, String>> mapData = new ArrayList<>();
         if(!data.isEmpty())
         {
             for(Object[] t:data)
             {
                 HashMap<String, String> rec = new HashMap<>();
                 int length=0;
                 for(String key:keys)
                 {
                     String value = String.valueOf(t[length]);
                     if("null".equalsIgnoreCase(value))
                     {
                         value="";
                     }
                     rec.put(key, value);
                     length++;
                 }
                 mapData.add(rec);
             }
         }
         return mapData;
     }

}