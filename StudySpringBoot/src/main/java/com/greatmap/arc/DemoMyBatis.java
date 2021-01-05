package com.greatmap.arc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DemoMyBatis {

    public static void main(String[] args) {
        
        Double v1 = 3.1d;
        Double v2 = 3d;
        
        System.out.println(v1.compareTo(v2));

        System.out.println(String.valueOf(Double.MIN_VALUE));
        System.out.println(Double.valueOf(String.valueOf(Double.MIN_VALUE)));

        Map<String, List<Integer>> map = new HashMap<>();
        map.put("1", new ArrayList<>());
        map.put("2", new ArrayList<>());
        map.put("3", new ArrayList<>());
        
        map.get("1").add(1);
        map.get("1").add(2);
        map.get("1").add(3);
        map.get("2").add(11);
        map.get("2").add(12);
        map.get("3").add(31);
        
        List<Integer> ls = new ArrayList<>();
        ls.add(1);
        
        ls.clear();
        map.forEach((key, value) -> {
            ls.addAll(value);
        });
        
        System.out.println(ls.toString());
    }
    
}
