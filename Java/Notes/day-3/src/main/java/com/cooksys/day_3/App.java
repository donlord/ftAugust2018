package com.cooksys.day_3;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Apple> basket = new ArrayList<Apple>(10);
        basket.add(new Apple("red", "ripe"));
        
        Apple golden = new Apple("golden", "moldy");
        
        for (int i = 0; i < 100; i++) {
        	basket.add(new Apple("red", "juicy ripe"));
        }
        
        basket.add(golden);
        
        System.out.println(basket);
        
//        System.out.println(Arrays.toString(basket.toArray()));
//        System.out.println(basket.get(39));
//        
//        System.out.println(basket.contains(golden));
//        System.out.println(basket.indexOf(golden));
        
        Set<Apple> basket2 = new HashSet<Apple>();
        basket2.add(new Apple("red", "ripe"));
        basket2.add(golden);
        
        for (int i = 0; i < 100; i++) {
        	basket2.add(new Apple("red", "juicy ripe"));
        }
        
        System.out.println(basket2);
        
        Map<Integer, List<Tenant>> hotel = new HashMap<Integer, List<Tenant>>();
        
        List<Tenant> l = new ArrayList<Tenant>();
        
        hotel.put(5010, new ArrayList<Tenant>());
        
        hotel.get(5010).add(new Tenant());
        
        hotel.put(5010, l);
        
        System.out.println(hotel.get(5010));
        
        
        
    }
}
