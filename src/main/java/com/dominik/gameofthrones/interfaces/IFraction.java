package com.dominik.gameofthrones.interfaces;

import com.dominik.gameofthrones.entities.Fraction;

public interface IFraction {
    
    /**
     * Fraction f1 attacks Fraction f2. A Fraction wins if either one has a bigger
     * army than the other. 
     * @param f1
     * @param f2
     * @return true if Fraction f1 wins, false otherwise
     */
    public boolean attack(Fraction f1, Fraction f2);

    /**
     * Fraction f1 joins Fraction f2. Then, Fraction f2 gains full army support
     * of Fraction f1. Fraction f1 may then be declared as a feudal lord of Fraction f2.
     * @param f1
     * @param f2
     * @return true if Fraction f2 is still alive, false otherwise
     */
    public boolean join(Fraction f1, Fraction f2);

    /**
     * A Fraction can recruit an army as long as the size of the army
     * is not 0. Otherwise, a Fraction will be flagged as eliminated.
     * 
     * @return number of soldiers recruited
     */
    public int recruitArmy();
}
