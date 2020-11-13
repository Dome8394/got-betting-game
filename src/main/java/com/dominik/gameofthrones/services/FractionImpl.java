package com.dominik.gameofthrones.services;

import com.dominik.gameofthrones.entities.Fraction;
import com.dominik.gameofthrones.interfaces.IFraction;

public class FractionImpl implements IFraction {

    @Override
    public boolean attack(Fraction h1, Fraction h2) {

        if (isReadyForWar(h1, h2)) {

            if (h1.getArmy() > h2.getArmy()) {
                countDefeatedSoldiers(h1, h2);
                return true;
            }

            // if (h1.getArmy() == h2.getArmy()) {
            // int chooseRandomWinner = 0;
            // chooseRandomWinner = (int) Math.random() * 2;

            // if (chooseRandomWinner == 1) {
            // countDefeatedSoldiers(h1, h2);
            // return true;
            // }

            // countDefeatedSoldiers(h2, h1);
            // return false;
            // }
        }

        countDefeatedSoldiers(h2, h1);

        return false;
    }

    @Override
    public boolean join(Fraction h1, Fraction h2) {

        if (isReadyForWar(h1, h2) && verifyLoyalty(h1, h2)) {
            h2.setArmy(h1.getArmy() + h2.getArmy());
            h1.swearLoyaltyTo(h2.getName());
            return true;
        }

        return false;
    }

    @Override
    public int recruitArmy(Fraction Fraction) {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * Verifies if both Fractions are ready for war, i.e., if both Fractions are
     * still alive are still have an army
     * 
     * @param FractionOneAlive
     * @param FractionTwoAlive
     * @return true if both are alive, false otherwise
     */
    private boolean isReadyForWar(Fraction h1, Fraction h2) {

        if (h1.isAlive() && h2.isAlive()) {
            if (h1.getArmy() != 0 && h2.getArmy() != 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if house h1 is already loyal to house 2 and if house 2 is loyal to
     * house 1.
     * 
     * @param h1
     * @param h2
     * @return true if house 1 is not loyal to house 2 and house 2 is not loyal to
     *         house 1, false otherwise
     */
    public boolean verifyLoyalty(Fraction h1, Fraction h2) {

        if (h1.isLoyalTo() == h1.getName()) {
            if (h1.isLoyalTo() != h2.getName() && h2.isLoyalTo() != h1.getName()) {
                return true;
            }
        }

        return false;
    }

    /**
     * Calculates the number of defeated soldiers based on the winner
     * 
     * @param h1
     * @param h2
     */
    private void countDefeatedSoldiers(Fraction h1, Fraction h2) {

        int countDefeatedSoldiersH1 = 0;
        int countDefeatedSoldiersH2 = 0;

        countDefeatedSoldiersH1 = h1.getArmy() * 1 / 3;
        countDefeatedSoldiersH2 = h2.getArmy() * 2 / 3;
        h1.setArmy(h1.getArmy() - countDefeatedSoldiersH1);
        h2.setArmy(h2.getArmy() - countDefeatedSoldiersH2);

    }

}
