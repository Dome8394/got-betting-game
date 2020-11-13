package com.dominik.gameofthrones.services;

import com.dominik.gameofthrones.entities.Fraction;
import com.dominik.gameofthrones.interfaces.IFraction;

public class FractionImpl implements IFraction {

    @Override
    public boolean attack(Fraction f1, Fraction f2) {

        if (isReadyForWar(f1, f2)) {

            if (f1.getArmy() > f2.getArmy()) {
                countDefeatedSoldiers(f1, f2);
                return true;
            }
        }

        countDefeatedSoldiers(f2, f1);

        return false;
    }

    @Override
    public boolean join(Fraction f1, Fraction f2) {

        if (isReadyForWar(f1, f2) && verifyLoyalty(f1, f2)) {
            f2.setArmy(f1.getArmy() + f2.getArmy());
            f1.swearLoyaltyTo(f2.getName());
            return true;
        }

        return false;
    }

    @Override
    public int recruitArmy() {
        return 50;
    }

    /**
     * If both Fractions are alive and have an army size larger than 0 they are
     * considered to be ready for war actions, i.e., attacking.
     * 
     * @param FractionOneAlive
     * @param FractionTwoAlive
     * @return true if both are alive, false otherwise
     */
    private boolean isReadyForWar(Fraction f1, Fraction f2) {

        if (f1.isAlive() && f2.isAlive()) {
            if (f1.getArmy() != 0 && f2.getArmy() != 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if house f1 is already loyal to house 2 and if house 2 is loyal to
     * house 1.
     * 
     * @param f1
     * @param f2
     * @return true if house 1 is not loyal to house 2 and house 2 is not loyal to
     *         house 1, false otherwise
     */
    public boolean verifyLoyalty(Fraction f1, Fraction f2) {

        if (f1.isLoyalTo() == f1.getName()) {
            if (f1.isLoyalTo() != f2.getName() && f2.isLoyalTo() != f1.getName()) {
                return true;
            }
        }

        return false;
    }

    /**
     * Calculates the number of defeated soldiers based on the winner
     * 
     * @param f1
     * @param f2
     */
    private void countDefeatedSoldiers(Fraction f1, Fraction f2) {

        int defeatedSoldiersF1 = 0;
        int defeatedSoldiersF2 = 0;

        defeatedSoldiersF1 = f1.getArmy() * 1 / 3;
        defeatedSoldiersF2 = f2.getArmy() * 2 / 3;
        f1.setArmy(f1.getArmy() - defeatedSoldiersF1);
        f2.setArmy(f2.getArmy() - defeatedSoldiersF2);

    }

}
