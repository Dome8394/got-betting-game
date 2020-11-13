package com.dominik.gameofthrones;

import com.dominik.gameofthrones.entities.Fraction;
import com.dominik.gameofthrones.entities.Houses;
import com.dominik.gameofthrones.services.FractionImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        FractionImpl FractionImpl = new FractionImpl();
        Fraction house1 = new Fraction();
        Fraction house2 = new Fraction();

        house1.setName(Houses.BARATHEON);
        house1.swearLoyaltyTo(Houses.BARATHEON);
        house2.setName(Houses.LANNISTER);
        house2.swearLoyaltyTo(Houses.LANNISTER);

        house1.setArmy(400);
        house2.setArmy(100);

        System.out.println(FractionImpl.attack(house1, house2));
        System.out.println(FractionImpl.join(house1, house2));
        System.out.println(FractionImpl.join(house2, house1));
        System.out.println(house1.getFeudalLordOf() + " " + house1.getName());
        System.out.println(house2.getFeudalLordOf() + " " + house2.getName());
    }
}
