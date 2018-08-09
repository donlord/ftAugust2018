package com.cooksys.day_2;

import com.cooksys.day_2.composition.ParkingLot;
import com.cooksys.day_2.composition.SpaceShip;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
//        Instrument i1 = new Instrument(10);
//        Instrument i2 = i1;
        
//        System.out.println(i2);
        
        Wind flute = new Wind(40);
        Percusion drum = new Percusion();
        
//        System.out.println(wind.numKeys);
        
//        System.out.println(flute.numKeys);
//        System.out.println(flute);
        flute.play(drum);
        
        ParkingLot cooksys = new ParkingLot();
        
        System.out.println(cooksys.getSpace().getNumber());
        
        SpaceShip PlanetExpress = new SpaceShip();
        
        PlanetExpress.left(50);
    }
}
