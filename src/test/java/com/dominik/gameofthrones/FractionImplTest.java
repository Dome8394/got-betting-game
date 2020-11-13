package com.dominik.gameofthrones;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.dominik.gameofthrones.entities.Fraction;
import com.dominik.gameofthrones.entities.Houses;
import com.dominik.gameofthrones.services.FractionImpl;

import org.junit.Before;
import org.junit.Test;

public class FractionImplTest {

    private FractionImpl houseImpl = new FractionImpl();
    private Fraction house1 = new Fraction();
    private Fraction house2 = new Fraction();

    @Before
    public void setup() {
        house1.setName(Houses.TARGARYEN);
        house2.setName(Houses.BARATHEON);

        house1.swearLoyaltyTo(Houses.TARGARYEN);
        house2.swearLoyaltyTo(Houses.BARATHEON);
    }

    @Test
    public void attack_houseOneWins_basic() {

        house1.setArmy(200);
        house2.setArmy(100);

        int defeatedSoldiersHouse1 = house1.getArmy() - (house1.getArmy() * 1 / 3);
        int defeatedSoldiersHouse2 = house2.getArmy() - (house2.getArmy() * 2 / 3);

        // can probably be removed
        assertEquals(200, house1.getArmy());
        assertEquals(100, house2.getArmy());

        assertEquals(true, houseImpl.attack(house1, house2));

        assertEquals(defeatedSoldiersHouse1, house1.getArmy());
        assertEquals(defeatedSoldiersHouse2, house2.getArmy());

    }

    @Test
    public void attack_houseTwoWins_basic() {
        house1.setArmy(100);
        house2.setArmy(200);

        int defeatedSoldiersHouse1 = house1.getArmy() - (house1.getArmy() * 2 / 3);
        int defeatedSoldiersHouse2 = house2.getArmy() - (house2.getArmy() * 1 / 3);

        assertEquals(false, houseImpl.attack(house1, house2));

        assertEquals(defeatedSoldiersHouse1, house1.getArmy());
        assertEquals(defeatedSoldiersHouse2, house2.getArmy());
    }

    /**
     * Conditions:
     * <li>both houses are alive
     * <li>
     * <li>none of both is feudal lord of another house
     * <li>
     */
    @Test
    public void verifyLoyalty_basic() {
        assertTrue(houseImpl.verifyLoyalty(house1, house2));
    }

    @Test
    public void verifyLoyalty_HouseOneLoyaltyToOtherHouse() {
        
        house1.swearLoyaltyTo(Houses.STARK);

        assertFalse(houseImpl.verifyLoyalty(house1, house2));
    }

    @Test
    public void verifyLoyalty_HouseOneAlreadyLoyalToHouseTwo() {
        
        house1.swearLoyaltyTo(Houses.BARATHEON);

        assertFalse(houseImpl.verifyLoyalty(house1, house2));
    }

    @Test
    public void join_basic() {
        
        house1.setArmy(200);
        house2.setArmy(100);

        int expectedArmySizeHouseTwo = 300;

        assertTrue(houseImpl.join(house1, house2));
        assertEquals(expectedArmySizeHouseTwo, house2.getArmy());

    }
}
